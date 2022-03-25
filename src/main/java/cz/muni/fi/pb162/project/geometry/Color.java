package cz.muni.fi.pb162.project.geometry;

import java.util.Locale;

/**
 * Enumeration type Color defines colors that can
 * be used for 2D objects.
 * @author Michaela Lodnanova
 */
public enum Color {
    WHITE,
    BLACK,
    RED,
    GREEN,
    YELLOW,
    BLUE,
    ORANGE;

    @Override
    public String toString() {
        return this.name().toLowerCase(Locale.ROOT);
    }
}
