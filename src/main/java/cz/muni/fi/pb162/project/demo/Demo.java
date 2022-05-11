package cz.muni.fi.pb162.project.demo;


import cz.muni.fi.pb162.project.geometry.LabeledPolygon;
import cz.muni.fi.pb162.project.geometry.PolygonReadable;
import cz.muni.fi.pb162.project.geometry.RegularOctagon;
import cz.muni.fi.pb162.project.geometry.Vertex2D;

import java.io.File;
import java.io.IOException;

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
    public static void main(String[] args) throws IOException {
        LabeledPolygon labeledPolygon = new LabeledPolygon.Builder().read(new File("polygon-ok.txt"))
                .addVertex("vrchol x", new Vertex2D(123, 456)).build();
        labeledPolygon.writeJson(System.out);
        System.out.println("Hello World!");
    }
}
