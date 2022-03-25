package cz.muni.fi.pb162.project.geometry;

/**
 * Class represents polygon with eight edges
 * @author Michaela Lodnanova
 */
public class RegularOctagon extends GeneralRegularPolygon{
    /**
     * Constructor creates regular octagon object. With its two
     * parameters:
     * @param center of type Vertex2D with x and y coordinates
     * @param radius of polygon
     */
    public RegularOctagon(Vertex2D center, double radius) {
        super(center, 8, radius);
    }
}
