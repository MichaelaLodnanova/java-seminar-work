package cz.muni.fi.pb162.project.geometry;

import cz.muni.fi.pb162.project.utils.SimpleMath;

/**
 * Class SimplePolygon is the super class that represents an object
 * SimplePolygon. Implements only Override methods from Polygon interface
 * @author Michaela Lodnanova
 */
public abstract class SimplePolygon extends SimpleMath implements Polygon{

    @Override
    public double getHeight() {
        return SimpleMath.maxY(this) - SimpleMath.minY(this);
    }

    @Override
    public double getWidth() {
        return SimpleMath.maxX(this) - SimpleMath.minX(this);
    }

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
