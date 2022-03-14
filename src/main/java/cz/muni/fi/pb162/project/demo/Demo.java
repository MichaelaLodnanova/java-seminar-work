package cz.muni.fi.pb162.project.demo;


import cz.muni.fi.pb162.project.geometry.Triangle;
import cz.muni.fi.pb162.project.geometry.Vertex2D;

/**
 * Class for running main method.
 *
 * @author Michaela Lodnanova
 */
public class Demo {

    /**
     * Runs the code.
     *
     * @param args command line arguments, will be ignored
     */
    public static void main(String[] args) {

        Vertex2D v1 = new Vertex2D(-100, 0);
        Vertex2D v2 = new Vertex2D(0, 100);
        Vertex2D v3 = new Vertex2D(100, -100);

        Triangle t = new Triangle(v1,v2, v3);

        System.out.println(t);
    }
}
