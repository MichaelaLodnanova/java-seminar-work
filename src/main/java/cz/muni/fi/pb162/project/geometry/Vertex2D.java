package cz.muni.fi.pb162.project.geometry;

import java.util.Objects;

/**
 * Class represents a vertex - the position of a point in 2D space.
 * It is represented by x and y intercepts.
 * @author Michaela Lodnanova
 */
public final class Vertex2D implements Comparable<Vertex2D>{ // DEFINE TYPE!!!
    private final double x;
    private final double y;

    /**
     * Constructor makes 2D Vertex with x and y - intercepts
     * @param xPoint is intercept on the x-axis
     * @param yPoint is intercept on the y-axis
     */
    public Vertex2D(double xPoint, double yPoint) {
        x = xPoint;
        y = yPoint;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    @Override
    public String toString() {
        return "[" + x + ", " + y + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o){
            return true;
        }
        if (o == null || getClass() != o.getClass()){
            return false;
        }
        Vertex2D vertex2D = (Vertex2D) o;
        return Double.compare(vertex2D.getX(), getX()) == 0 && Double.compare(vertex2D.getY(), getY()) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getX(), getY());
    }

    /**
     * this method is used for finding a middle of two vertices - 'me' and
     * the second vertex, which is taken by the method
     * @param vertex is the second vertex
     * @return an object Vertex2D that represents the middle between two points
     */
    public Vertex2D createMiddle(Vertex2D vertex) {
        double newX = (vertex.getX()+x)/2;
        double newY = (vertex.getY()+y)/2;
        return new Vertex2D(newX, newY);
    }

    /**
     * Method which calculates the Euclidean distance between two vertices
     * @param vertex is another 2D point
     * @return double type distance
     */
    public double distance(Vertex2D vertex) {
        if (vertex == null){
            return -1.0;
        }
        return Math.sqrt(Math.pow(vertex.getX()-x, 2.0) + Math.pow(vertex.getY()-y, 2.0));
    }

    @Override
    public int compareTo(Vertex2D vertex2D) {
        int compareX = Double.compare(this.getX(), vertex2D.getX());
        return  compareX == 0 ? Double.compare(this.getY(), vertex2D.getY()) : compareX;
    }
}
