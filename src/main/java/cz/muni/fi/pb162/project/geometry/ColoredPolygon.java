package cz.muni.fi.pb162.project.geometry;

import java.util.Objects;

/**
 * Class ColoredPolygon takes an existing polygon and adds
 * a color to it.
 * @author Michaela Lodnanova
 */
public class ColoredPolygon {
    private Polygon polygon;
    private Color color;

    /**
     * Constructor takes a polygon and a color as an input parameter
     * and creates a colored object
     * @param polygon is an Object created of vertices
     * @param color defines a color of an object
     */
    public ColoredPolygon(Polygon polygon, Color color){
        this.polygon = polygon;
        this.color = color;
    }

    public Polygon getPolygon() {
        return polygon;
    }

    public Color getColor() {
        return color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o){
            return true;
        }
        if (!(o instanceof ColoredPolygon)){
            return false;
        }
        ColoredPolygon that = (ColoredPolygon) o;
        return Objects.equals(getPolygon(), that.getPolygon()) && getColor() == that.getColor();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPolygon(), getColor());
    }
}
