package cz.muni.fi.pb162.project.utils;

import cz.muni.fi.pb162.project.geometry.Measurable;
import cz.muni.fi.pb162.project.geometry.Triangle;

/**
 * Gauger class allows us to measure objects and print
 * information about their height and width
 * @author Michaela Lodnanova
 */
public class Gauger {

    /**
     * this method  takes any measurable object and prints
     * its width and height values.
     * @param object implementing the measurable interface
     */
    public static void printMeasurement(Measurable object){
        System.out.println("Width: " + object.getWidth());
        System.out.println("Height: " + object.getHeight());
    }

    /**
     * method doing the same thing as the first one, however,
     * this one works only for a triangle object and uses the
     * first method itself.
     * @param triangle is an object with three vertices
     */
    public static void printMeasurement(Triangle triangle) {
        System.out.println(triangle);
        printMeasurement((Measurable) triangle);
    }
}

