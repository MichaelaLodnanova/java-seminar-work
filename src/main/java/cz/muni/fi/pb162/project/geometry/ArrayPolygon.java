package cz.muni.fi.pb162.project.geometry;

import cz.muni.fi.pb162.project.exception.MissingVerticesException;

import java.util.Arrays;

/**
 * Class ArrayPolygon represents an object that stores coordinates
 * pf the vertices of the n-gon stored in array
 * @author Michaela Lodnanova
 */
public class ArrayPolygon extends SimplePolygon {

    private final Vertex2D[] verticesArray;

    /**
     * Constructor creates an object ArrayPolygon and takes array of
     * vertices as an input parameter. Validates the input and throws
     * exception with an error description if input is invalid.
     * @param verticesArray represents array of vertices
     */
    public ArrayPolygon(Vertex2D[] verticesArray) throws MissingVerticesException {
        super(verticesArray);
        this.verticesArray = Arrays.copyOf(verticesArray, verticesArray.length);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ArrayPolygon that = (ArrayPolygon) o;
        return Arrays.equals(verticesArray, that.verticesArray);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(verticesArray);
    }

    @Override
    public Vertex2D getVertex(int index) {
        if (index < 0){
            throw new IllegalArgumentException("invalid index input");
        }
        return verticesArray[index % verticesArray.length];
    }

    @Override
    public int getNumVertices() {
        return verticesArray.length;
    }
}
