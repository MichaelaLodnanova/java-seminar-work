package cz.muni.fi.pb162.project.utils;

import cz.muni.fi.pb162.project.geometry.Polygon;
import cz.muni.fi.pb162.project.geometry.Vertex2D;

/**
 * SimpleMath class represent static methods that are supposed
 * to help other classes to calculate and return values of
 * minimum/maximum X/Y coordinates of n-gon.
 * @author Michaela Lodnanova
 */
public class SimpleMath {

    /**
     * method for finding minimum x coordinate
     * @param polygon is an object with n vertices
     * @return polygon's minimum x coordinate
     */
    public static double minX(Polygon polygon) {
        Vertex2D min = polygon.getVertex(0);
        int verticesNumber = polygon.getNumVertices();
        for (int i = 1; i < verticesNumber; i++) {
            if (polygon.getVertex(i).getX() < min.getX()) {
                min = polygon.getVertex(i);
            }
        }
        return min.getX();
    }

    /**
     * method for finding minimum y coordinate
     * @param polygon is an object with n vertices
     * @return polygon's minimum y coordinate
     */
    public static double minY(Polygon polygon) {
        double minY = polygon.getVertex(0).getY();
        int verticesNumber = polygon.getNumVertices();
        for (int i = 1; i < verticesNumber; i++) {
            if (polygon.getVertex(i).getY() < minY) {
                minY = polygon.getVertex(i).getY();
            }
        }
        return minY;
    }

    /**
     * method for finding maximum x coordinate
     * @param polygon is an object with n vertices
     * @return polygon's maximum x coordinate
     */
    public static double maxX(Polygon polygon) {
        Vertex2D max = polygon.getVertex(0);
        int verticesNumber = polygon.getNumVertices();
        for (int i = 1; i < verticesNumber; i++) {
            if (polygon.getVertex(i).getX() > max.getX()) {
                max = polygon.getVertex(i);
            }
        }
        return max.getX();
    }

    /**
     * method for finding maximum y coordinate
     * @param polygon is an object with n-vertices
     * @return polygons's maximum y coordinate
     */
    public static double maxY(Polygon polygon) {
        double maxY = polygon.getVertex(0).getY();
        int verticesNumber = polygon.getNumVertices();
        for (int i = 1; i < verticesNumber; i++) {
            if (polygon.getVertex(i).getY() > maxY) {
                maxY = polygon.getVertex(i).getY();
            }
        }
        return maxY;
    }
}
