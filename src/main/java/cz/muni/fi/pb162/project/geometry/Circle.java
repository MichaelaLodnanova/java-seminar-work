package cz.muni.fi.pb162.project.geometry;


/**
 * Class represents the Circle represented by two parameters -
 * center of type Vertex2D and radius of type double
 * @author Michaela Lodnanova
 */
public class Circle extends GeneralRegularPolygon implements Measurable, Circular{

    /**
     * Constructor created the Circle object with its center
     * and radius.
     * @param center is a vertex with x and y intercepts (type Vertex2D)
     * @param radius represents the length of the radius of the object.
     */
    public Circle(Vertex2D center, double radius) {
        super(center, Integer.MAX_VALUE, radius);
        color = Color.RED;
    }


    /**
     * Constructor creates a unit circle with the center at the beginning
     * of the coordinate system [0.0, 0.0] and radius 1.0
     * Calls the first constructor and passes the needed values to it.
     */
    public Circle() {
        this(new Vertex2D(0.0, 0.0), 1.0);
    }


    @Override
    public String toString() {
        return "Circle: center=" + center +
                ", radius=" + radius;
    }
    @Override
    public double getEdgeLength() {
        return 0;
    }
}
