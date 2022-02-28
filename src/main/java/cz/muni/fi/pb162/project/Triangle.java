package cz.muni.fi.pb162.project;

import cz.muni.fi.pb162.project.geometry.Vertex2D;

/**
 * @author Michaela Lodnanova
 */
public class Triangle {
    private Vertex2D[] verticesArray = new Vertex2D[3];
    private Triangle[] trianglesArray = new Triangle[3];
    public Triangle(Vertex2D a, Vertex2D b, Vertex2D c) {
        verticesArray[0] = a;
        verticesArray[1] = b;
        verticesArray[2] = c;
    }
    public Vertex2D getVertex(int index) {
        if (index < 0 || index > 2)
            return null;
        return verticesArray[index];
    }
    public void setVertex(int index, Vertex2D vertex) {
        if (index < 0 || index > 2)
            return;
        verticesArray[index] = vertex;
    }
    @Override
    public String toString() {
        return "Triangle: vertices=" + verticesArray[0] +
                " " + verticesArray[1] +
                " " + verticesArray[2];
    }

    /**
     * this function devides a triangle into three smaller ones
     * it stores the vertices of smaller triangles in an array
     * @return true if smaller triangles are stored in the array
     * otherwise returns false
     */
    public boolean divide() {
        if (trianglesArray[2] != null)
            return false;
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
        for (int i = 0; i < 3; i++) {
            if (trianglesArray[i] == null)
                return false;
        }
        return true;
    }

    /**
     * function is supposed to find a triangle vertices in an array
     * in index position
     * @param index is a position in an array of smaller triangles
     * @return null if index is out of range otherwise return object triangle
     */
    public Triangle getSubTriangle(int index) {
        if (index < 0 || index > 2)
            return null;
        return trianglesArray[index];
    }

}
