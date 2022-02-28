package cz.muni.fi.pb162.project.geometry;

/**
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

    /**
     * method for returning coordinates
      * @return formatted coordinates
     */
    @Override
    public String toString() {
        return "[" + x + ", " + y + "]";
    }

    public Vertex2D createMiddle(Vertex2D vertex) {
        double newX = (vertex.getX()+this.x)/2;
        double newY = (vertex.getY()+this.y)/2;
        return new Vertex2D(newX, newY);
    }
}
