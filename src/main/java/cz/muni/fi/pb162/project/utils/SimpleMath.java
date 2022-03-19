package cz.muni.fi.pb162.project.utils;

import cz.muni.fi.pb162.project.geometry.Triangle;
import cz.muni.fi.pb162.project.geometry.Vertex2D;

/**
 * SimpleMath class represent static methods that are supposed
 * to help other classes to calculate and return values of
 * minimum/maximum X/Y coordinates and also calculates the width
 * of a triangle
 * @author Michaela Lodnanova
 */
public class SimpleMath {

    /**
     * method for finding minimum x coordinate
     * @param triangle is an object with three vertices
     * @return triangle's minimum x coordinate
     */
    public static double minX(Triangle triangle) {
        Vertex2D min = triangle.getVertex(0);
        for (int i = 1; i <= 2; i++) {
            if (triangle.getVertex(i).getX() < min.getX()) {
                min = triangle.getVertex(i);
            }
        }
        return min.getX();
    }

    /**
     * method for finding minimum y coordinate
     * @param triangle is an object with three vertices
     * @return triangle's minimum y coordinate
     */
    public static double minY(Triangle triangle) {
        double minY = triangle.getVertex(0).getY();
        for (int i = 1; i <= 2; i++) {
            if (triangle.getVertex(i).getY() < minY) {
                minY = triangle.getVertex(i).getY();
            }
        }
        return minY;
    }

    /**
     * method for finding maximum x coordinate
     * @param triangle is an object with three vertices
     * @return triangle's maximum x coordinate
     */
    public static double maxX(Triangle triangle) {
        Vertex2D max = triangle.getVertex(0);
        for (int i = 1; i <= 2; i++) {
            if (triangle.getVertex(i).getX() > max.getX()) {
                max = triangle.getVertex(i);
            }
        }
        return max.getX();
    }

    /**
     * method for finding maximum y coordinate
     * @param triangle is an object with three vertices
     * @return triangle's maximum y coordinate
     */
    public static double maxY(Triangle triangle) {
        double maxY = triangle.getVertex(0).getY();
        for (int i = 1; i <= 2; i++) {
            if (triangle.getVertex(i).getY() > maxY) {
                maxY = triangle.getVertex(i).getY();
            }
        }
        return maxY;
    }
}
