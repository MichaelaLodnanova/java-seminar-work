package cz.muni.fi.pb162.project.geometry;

/**
 * Interface for getting and setting colors of objects
 * of the defined enumeration type.
 * @author Michaela Lodnanova
 */
public interface Colored {
    /**
     * due to pipeline
     * getter function for returning the color of the object
     * @return color
     */
    Color getColor();

    /**
     * setter function for setting the color of the object
     * @param color of the object
     */
    void setColor(Color color);
}
