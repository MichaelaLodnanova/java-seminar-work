package cz.muni.fi.pb162.project.geometry;


/**
 * Class represents the Circle represented by two parameters -
 * center of type Vertex2D and radius of type double
 * @author Michaela Lodnanova
 */
public class Circle implements Measurable, Circular{
    private final Vertex2D center;
    private final double radius;

    /**
     * Constructor created the Circle object with its center
     * and radius.
     * @param center is a vertex with x and y intercepts (type Vertex2D)
     * @param radius represents the length of the radius of the object.
     */
    public Circle(Vertex2D center, double radius) {
        this.center = center;
        this.radius = radius;
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
    public double getWidth() {
        return radius * 2;
    }
    @Override
    public double getHeight() {
        return radius * 2;
    }
    @Override
    public double getRadius() {
        return radius;
    }
    @Override
    public Vertex2D getCenter() {
        return center;
    }
    @Override
    public String toString() {
        return "Circle: center=" + center +
                ", radius=" + radius;
    }
}
