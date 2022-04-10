package cz.muni.fi.pb162.project.geometry;

/**
 * Class Snowman represents an object made of three regular
 * polygon objects.
 * @author Michaela Lodnanova
 */
public class Snowman{
    public static final int CONSTANT_LENGTH = 3;
    private RegularPolygon[] polygons = new RegularPolygon[CONSTANT_LENGTH];
    private double factor;
    private static final double CONSTANT_FACTOR = 0.8;

    /**
     * Constructor creates first object which represents
     * the lower sphere
     * @param polygon represents our object of type RegularPolygon
     * @param factor represents reduction factor. The upper parts of
     *               the snowman shrinks by this factor.
     */
    public Snowman(RegularPolygon polygon, double factor) {
        polygons[0] = polygon;
        if (factor > 0 && factor <= 1) {
            this.factor = factor;
        } else {
            this.factor = CONSTANT_FACTOR;
        }

        buildSnowman();
    }
    /**
     * Help function for a constructor which calculates the center of
     * a new object and its radius shrunk. This new object is added
     * to the list of circulars - circular objects.
     */
    private void buildSnowman() {
        for (int i = 1; i < polygons.length; i++) {
            double newRadius = polygons[i - 1].getRadius() * factor;
            Vertex2D oldCenter = polygons[i - 1].getCenter();
            Vertex2D newCenter = new Vertex2D(oldCenter.getX(),
                    oldCenter.getY() + polygons[i - 1].getRadius() + newRadius);
            polygons[i] = new Circle(newCenter, newRadius);
        }
    }

    /**
     * This method only returns all 'balls' of a snowman
     * @return balls - parts of snowman (lol)
     */
    public RegularPolygon[] getBalls(){
        return polygons;
    }
}
