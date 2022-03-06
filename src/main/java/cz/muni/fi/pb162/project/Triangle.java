package cz.muni.fi.pb162.project;

import cz.muni.fi.pb162.project.geometry.Vertex2D;

/**
 * Class Triangle represents triangle with its vertices, it is
 * represented by an array of three vertices in constructor
 * @author Michaela Lodnanova
 */
public class Triangle {
    private final Vertex2D[] verticesArray = new Vertex2D[3];
    private final Triangle[] trianglesArray = new Triangle[3];

    /**
     * Creates Triangle instance made of three Vertex2D objects
     * @param v1 is first vertex representing triangle
     * @param v2 is second vertex representing triangle
     * @param v3 is third vertex representing triangle
     */
    public Triangle(Vertex2D v1, Vertex2D v2, Vertex2D v3) {
        verticesArray[0] = v1;
        verticesArray[1] = v2;
        verticesArray[2] = v3;
    }

    private boolean indexOutOfRange(int index) {
        return (index < 0 || index > 2);
    }
    /**
     * (due to pipeline) this method is supposed to get a vertex on a given index
     * @param index of vertex given
     * @return vertex on the given index
     */
    public Vertex2D getVertex(int index) {
        if (indexOutOfRange(index)){
            return null;
        }
        return verticesArray[index];
    }

    /**
     * this method sets the vertex of a triangle with a given vertex
     * @param index is index of the place in the array (verticesArray)
     * @param vertex is the vertex that should be set
     */
    public void setVertex(int index, Vertex2D vertex) {
        if (indexOutOfRange(index)) {
            return;
        }
        verticesArray[index] = vertex;
    }
    @Override
    public String toString() {
        return "Triangle: vertices=" + verticesArray[0] +
                " " + verticesArray[1] +
                " " + verticesArray[2];
    }

    /**
     * this function divides a triangle into three smaller ones
     * it stores the vertices of smaller triangles in an array
     * @return true if smaller triangles are stored in the array
     * otherwise returns false
     */
    public boolean divide() {
        if (trianglesArray[2] != null) {
            return false;
        }
        for (int i = 0; i < 3; i++) {
            Vertex2D vertex1 = new Vertex2D(verticesArray[i].getX(), verticesArray[i].getY());
            Vertex2D vertex2 = new Vertex2D(verticesArray[i].createMiddle(verticesArray[(i + 1) % 3]).getX(),
                    verticesArray[i].createMiddle(verticesArray[(i + 1) % 3]).getY());
            Vertex2D vertex3 = new Vertex2D(verticesArray[i].createMiddle(verticesArray[(i + 2) % 3]).getX(),
                    verticesArray[i].createMiddle(verticesArray[(i + 2) % 3]).getY());
            trianglesArray[i] = new Triangle(vertex1, vertex2, vertex3);
        }
        return true;
    }

    /**
     * this function is for checking if the triangle is already
     * divided
     * @return false if the array has an empty block - no smaller triangle
     * true if the triangle is divided into three smaller ones (array is full)
     */
    public boolean isDivided() {
        return (trianglesArray[2] != null);
    }

    /**
     * function is supposed to find a triangle vertices in an array
     * in index position
     * @param index is a position in an array of smaller triangles
     * @return null if index is out of range otherwise return object triangle
     */
    public Triangle getSubTriangle(int index) {
        if (indexOutOfRange(index)) {
            return null;
        }
        return trianglesArray[index];
    }

}
