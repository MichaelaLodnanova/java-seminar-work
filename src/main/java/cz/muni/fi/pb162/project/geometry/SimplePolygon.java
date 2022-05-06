package cz.muni.fi.pb162.project.geometry;

import cz.muni.fi.pb162.project.exception.MissingVerticesException;
import cz.muni.fi.pb162.project.utils.SimpleMath;
import java.util.Arrays;
import java.util.Objects;

/**
 * Class SimplePolygon is the super class that represents an object
 * SimplePolygon. Implements only Override methods from Polygon interface
 * @author Michaela Lodnanova
 */
public abstract class SimplePolygon implements Polygon{

    /**
     * Constructor checks the correctness of the input field.
     * @param verticesArray stores an array of vertices.
     */
    public SimplePolygon(Vertex2D[] verticesArray){
        if (verticesArray == null) {
            throw new IllegalArgumentException("Input field is null");
        }
        if (verticesArray.length < 3){
            throw new MissingVerticesException("Array contains not enough vertices");
        }
        if (Arrays.stream(verticesArray).anyMatch(Objects::isNull)) {
            throw new IllegalArgumentException("Input field contains a null object");
        }
    }

    @Override
    public double getHeight() {
        return SimpleMath.maxY(this) - SimpleMath.minY(this);
    }

    @Override
    public double getWidth() {
        return SimpleMath.maxX(this) - SimpleMath.minX(this);
    }
    @Override
    public abstract Vertex2D getVertex(int index);

    @Override
    public abstract int getNumVertices();

    @Override
    public String toString() {
        int index = this.getNumVertices();
        StringBuilder result = new StringBuilder("Polygon: vertices =");
        for (int i = 0; i < index; i++) {
            result.append(' ');
            result.append(this.getVertex(i));
        }
        return result.toString();
    }
}
