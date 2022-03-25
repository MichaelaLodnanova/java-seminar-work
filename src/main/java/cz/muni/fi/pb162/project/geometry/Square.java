package cz.muni.fi.pb162.project.geometry;

/**
 * Square class represents a square as a circular shape,
 * its vertices are calculated from its center and diameter.
 * @author Michaela Lodnanova
 */
public class Square extends GeneralRegularPolygon implements Circular {

    /**
     * constructor creates a square type object with its
     * diameter and center.
     * @param center is Vertex2D type, represents the center
     *               of the square
     * @param diameter is a diameter of the square object.
     */
    public Square(Vertex2D center, double diameter) {
        super(center, 4, diameter / 2.0);
    }

    /**
     * The second constructor takes a circular object as an input
     * parameter and calls the first constructor.
     * @param circleObject is on object of type Circular.
     */
    public Square(Circular circleObject) {
        this(circleObject.getCenter(), circleObject.getRadius() * 2.0);
    }


    @Override
    public String toString(){
        return("Square: vertices=" + getVertex(0) + " " + getVertex(1)
        + " " + getVertex(2) + " " + getVertex(3));
    }
}
