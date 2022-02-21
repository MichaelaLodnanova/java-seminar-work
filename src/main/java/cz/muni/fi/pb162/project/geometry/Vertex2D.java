package cz.muni.fi.pb162.project.geometry;

/**
 * @author Michaela Lodnanova
 */
public class Vertex2D {
    private double x = 0.0;
    private double y = 0.0;

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
    public String getInfo() {
        return "[" + x + ", " + y + "]";
    }

    /**
     * method for sum of coordinates
     * @return sum of x and y
     */
    public double sumCoordinates() {
        return x + y;
    }

    /**
     * adding vertex, moving coordinates
     * @param vertex
     */
    public void move(Vertex2D vertex) {
        x += vertex.x;
        y += vertex.y;
    }
}
