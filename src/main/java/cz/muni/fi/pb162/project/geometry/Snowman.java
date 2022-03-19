package cz.muni.fi.pb162.project.geometry;


/**
 * Class Snowman represents an object made of four circular
 * objects (squares, circles, etc.)
 * @author Michaela Lodnanova
 */
public class Snowman implements Circular{
    private static final int CONSTANT_LENGTH = 4;
    private Circular[] circulars = new Circular[CONSTANT_LENGTH];
    private double factor;
    public static final double CONSTANT_FACTOR = 0.8;

    /**
     * Constructor creates first circular object which represents
     * the lower sphere
     * @param circularObject represents our object of type circular
     * @param factor represents reduction factor. The upper parts of
     *               the snowman shrinks by this factor.
     */
    public Snowman(Circular circularObject, double factor) {
        circulars[0] = circularObject;
        if (factor > 0 && factor <= 1) {
            this.factor = factor;
        } else {
            this.factor = CONSTANT_FACTOR;
        }

        buildSnowman();
    }

    @Override
    public Vertex2D getCenter() {
        return null;
    }

    @Override
    public double getRadius() {
        return 0;
    }

    /**
     * Help function for a constructor which calculates the center of
     * a new object and its radius shrunk. This new object is added
     * to the list of circulars - circular objects.
     */
    private void buildSnowman() {
        for (int i = 1; i < circulars.length; i++) {
            double newRadius = circulars[i - 1].getRadius() * factor;
            Vertex2D oldCenter = circulars[i - 1].getCenter();
            Vertex2D newCenter = new Vertex2D(oldCenter.getX(),
                    oldCenter.getY() + circulars[i - 1].getRadius() + newRadius);
            circulars[i] = new Circle(newCenter, newRadius);
        }
    }

    /**
     * This method only returns all 'balls' of a snowman
     * @return balls - parts of snowman (lol)
     */
    public Circular[] getBalls(){
        return circulars;
    }
}
