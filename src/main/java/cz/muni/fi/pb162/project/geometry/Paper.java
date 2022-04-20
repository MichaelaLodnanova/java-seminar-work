package cz.muni.fi.pb162.project.geometry;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Class Paper simulates paper on which colored polygons can
 * be drawn.
 * @author Michaela Lodnanova
 */
public class Paper implements Drawable{
    private Color defaultColor = Color.BLACK;
    private Collection<ColoredPolygon> drawnPolygons;

    /**
     * Constructor creates a new object as a list
     */
    public Paper(){
        drawnPolygons = new ArrayList<>();
    }

    /**
     * Second constructor copies the collection of drawn polygons,
     * creates an object created of all drawn polygons
     * @param object input of constructor
     */
    public Paper(Drawable object){
        drawnPolygons = List.copyOf(object.getAllDrawnPolygons());
    }

    @Override
    public void changeColor(Color color) {
        defaultColor = color;
    }

    @Override
    public void drawPolygon(Polygon polygon) {
        if (drawnPolygons.stream().anyMatch(x->x.getPolygon() == polygon
                && x.getColor() == defaultColor)
                || defaultColor == Color.WHITE) {
            return;
        }
        drawnPolygons.add(new ColoredPolygon(polygon, defaultColor));
    }

    @Override
    public void erasePolygon(ColoredPolygon polygon) {
        drawnPolygons.remove(polygon);
    }

    @Override
    public void eraseAll() {
        drawnPolygons.clear();
    }

    @Override
    public Collection<ColoredPolygon> getAllDrawnPolygons() {
        return Collections.unmodifiableCollection(drawnPolygons);
    }

    @Override
    public int uniqueVerticesAmount() {
        Set<Vertex2D> uniqueVertices= new HashSet<>();
        for (ColoredPolygon polygon : drawnPolygons){
            for (int i = 0; i < polygon.getPolygon().getNumVertices(); i++){
                uniqueVertices.add(polygon.getPolygon().getVertex(i));
            }
        }
        return uniqueVertices.size();
    }
}
