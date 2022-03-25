package cz.muni.fi.pb162.project.geometry;

/**
 * Class represents object of type GeneralRegularPolygon which describes
 * 2D regular polygon. This object has its center, number of eges, radius
 * and default color = black.
 * @author Michaela Lodnanova
 */
public class GeneralRegularPolygon implements RegularPolygon, Colored{
    public Vertex2D center;
    public int edges;
    public double radius;
    public Color color = Color.BLACK;

    /**
     * Constructor creates an object of type GeneralRegularPolygon. As its
     * parameters it takes:
     * @param center - of type Vertex2D, represented by x and y points
     * @param edges - number edges of the object
     * @param radius of the polygon
     */
    public GeneralRegularPolygon(Vertex2D center, int edges, double radius) {
        this.center = center;
        this.edges = edges;
        this.radius = radius;
    }

    @Override
    public Vertex2D getCenter() {
        return center;
    }

    @Override
    public double getRadius() {
        return radius;
    }
    @Override
    public int getNumEdges() {
        return edges;
    }

    @Override
    public Color getColor() {
        return color;
    }

    @Override
    public void setColor(Color color) {
        this.color = color;
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
    public double getEdgeLength() {
        return 2 * radius * Math.sin(Math.PI / edges);
    }

    @Override
    public Vertex2D getVertex(int index) {
        double x = center.getX() - (radius * Math.cos(index * 2 * Math.PI / edges));
        double y = center.getY() - (radius * Math.sin(index * 2 * Math.PI / edges));
        return new Vertex2D(x, y);
    }

    @Override
    public String toString() {
        return edges + "-gon: " +
                "center=" + center +
                ", radius=" + radius +
                ", color=" + color;
    }
}
