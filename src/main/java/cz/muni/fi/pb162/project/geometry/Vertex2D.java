package cz.muni.fi.pb162.project.geometry;

/**
 * Class represents a vertex - the position of a point in 2D space.
 * It is represented by x and y intercepts.
 * @author Michaela Lodnanova
 */
public class Vertex2D {
    private double x;
    private double y;

    public Vertex2D(double xX, double yY) {
        x = xX;
        y = yY;
    }
    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "[" + x + ", " + y + "]";
    }

    /**
     * this method is used for finding a middle of two vertices - 'me' and
     * the second vertex, which is taken by the method
     * @param vertex is the second vertex
     * @return an object Vertex2D that represents the middle between two points
     */
    public Vertex2D createMiddle(Vertex2D vertex) {
        double newX = (vertex.getX()+this.x)/2;
        double newY = (vertex.getY()+this.y)/2;
        return new Vertex2D(newX, newY);
    }
}
