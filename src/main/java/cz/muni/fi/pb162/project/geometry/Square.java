package cz.muni.fi.pb162.project.geometry;

/**
 * Square class represents a square as a circular shape,
 * its vertices are calculated from its center and diameter.
 * @author Michaela Lodnanova
 */
public class Square implements Circular {
    private Vertex2D center;
    private double diameter;

    /**
     * constructor creates a square type object with its
     * diameter and center.
     * @param center is Vertex2D type, represents the center
     *               of the square
     * @param diameter is a diameter of the square object.
     */
    public Square(Vertex2D center, double diameter) {
        this.center = center;
        this.diameter = diameter;
    }

    /**
     * The second constructor takes a circular object as an input
     * parameter and calls the first constructor.
     * @param circleObject is on object of type Circular.
     */
    public Square(Circular circleObject) {
        this(circleObject.getCenter(), circleObject.getRadius() * 2);
    }

    @Override
    public Vertex2D getCenter() {
        return this.center;
    }

    @Override
    public double getRadius() {
        return this.diameter/2.0;
    }

    public Vertex2D getVertex(int index) {

        switch (index) {
            case 0:
                return new Vertex2D(center.getX() - diameter/2.0,
                        center.getY());
            case 1:
                return new Vertex2D(center.getX(),
                        center.getY()-diameter/2.0);
            case 2:
                return new Vertex2D(center.getX() + diameter/2.0,
                        center.getY());
            case 3:
                return new Vertex2D(center.getX(),
                        center.getY() + diameter/2.0);
            default:
                return null;
        }
    }
    @Override
    public String toString(){
        return("Square: vertices=" + getVertex(0) + " " + getVertex(1)
        + " " + getVertex(2) + " " + getVertex(3));
    }

}
