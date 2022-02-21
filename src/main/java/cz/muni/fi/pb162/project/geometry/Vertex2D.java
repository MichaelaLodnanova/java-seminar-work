package cz.muni.fi.pb162.project.geometry;

/**
 * @author Michaela Lodnanova
 */
public class Vertex2D {
    private double x = 0.0;
    private double y = 0.0;

    public double getX() {
        return x; // getter for x
    }

    public double getY() {
        return y; // getter for y
    }

    public void setX(double x) {
        this.x = x; // setter for x
    }

    public void setY(double y) {
        this.y = y; // setter for y
    }

    public String getInfo() {
        // returns formatted coordinate description
        return "[" + x + ", " + y + "]";
    }

    public double sumCoordinates() {
        // returning sum
        return x + y;
    }

    public void move(Vertex2D vertex) {
        // method for shifting the vertex
        x += vertex.x;
        y += vertex.y;
    }
}
