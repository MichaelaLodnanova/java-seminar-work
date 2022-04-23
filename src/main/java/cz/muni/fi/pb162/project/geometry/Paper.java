package cz.muni.fi.pb162.project.geometry;

import cz.muni.fi.pb162.project.exception.EmptyDrawableException;
import cz.muni.fi.pb162.project.exception.MissingVerticesException;
import cz.muni.fi.pb162.project.exception.TransparentColorException;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Class Paper simulates paper on which colored polygons can
 * be drawn.
 * @author Michaela Lodnanova
 */
public class Paper extends RuntimeException
        implements Drawable, PolygonFactory {
    private Color defaultColor;
    private Set<ColoredPolygon> drawnPolygons;

    /**
     * Constructor creates a new object as a set
     */
    public Paper() {
        this.drawnPolygons = new HashSet<>();
        this.defaultColor = Color.BLACK;
    }

    /**
     * Second constructor copies the collection of drawn polygons,
     * creates an object created of all drawn polygons
     *
     * @param object input of constructor
     */
    public Paper(Drawable object){
        this();
        drawnPolygons.addAll(object.getAllDrawnPolygons());
    }

    @Override
    public void changeColor(Color color) {
        defaultColor = color;
    }

    @Override
    public void drawPolygon(Polygon polygon) throws TransparentColorException {
        if (defaultColor != Color.WHITE) {
            drawnPolygons.add(new ColoredPolygon(polygon, defaultColor));
        } else {
            throw new TransparentColorException("draw with white color");
        }
    }

    @Override
    public void erasePolygon(ColoredPolygon polygon) {
        drawnPolygons.remove(polygon);
    }

    @Override
    public void eraseAll() throws EmptyDrawableException {
        if (drawnPolygons.isEmpty()){
            throw new EmptyDrawableException("clean paper");
        }
        drawnPolygons.clear();
    }

    @Override
    public Collection<ColoredPolygon> getAllDrawnPolygons(){
        return Collections.unmodifiableCollection(drawnPolygons);
    }

    @Override
    public int uniqueVerticesAmount() {
        Set<Vertex2D> uniqueVertices = new HashSet<>();
        for (ColoredPolygon polygon : drawnPolygons) {
            for (int i = 0; i < polygon.getPolygon().getNumVertices(); i++) {
                uniqueVertices.add(polygon.getPolygon().getVertex(i));
            }
        }
        return uniqueVertices.size();
    }

    @Override
    public Polygon tryToCreatePolygon(List<Vertex2D> vertices) throws MissingVerticesException {
        if (vertices == null) {
            throw new NullPointerException("input field is null");
        }

        try {
            return new CollectionPolygon(vertices);
        } catch (IllegalArgumentException exception) {
            return new CollectionPolygon(vertices.stream().filter(Objects::nonNull).collect(Collectors.toList()));
        }
    }

    @Override
    public void tryToDrawPolygons(List<List<Vertex2D>> collectionPolygons) throws EmptyDrawableException {
        int drawnCounter = 0;
        Throwable exception = null;
        for ( List<Vertex2D> listPolygons : collectionPolygons){
            try {
                Polygon newPolygon = tryToCreatePolygon(listPolygons);
                drawPolygon(newPolygon);
                drawnCounter++;
            } catch (TransparentColorException exception1){
                changeColor(Color.BLACK);
                exception = exception1;
            } catch (MissingVerticesException | NullPointerException exception2){
                exception = exception2;
            }
        }
        if (drawnCounter == 0){
            throw new EmptyDrawableException("No drawn polygons", exception);
        }
    }

    /**
     * Method returns all polygons with color - color (input parameter)
     * @param color input color to be checked
     * @return Collection of Polygons
     */
    public Collection<Polygon> getPolygonsWithColor(Color color){
        return drawnPolygons.stream().filter(x -> x.getColor().equals(color))
                .map(ColoredPolygon::getPolygon)
                .collect(Collectors.toList());
    }

}
