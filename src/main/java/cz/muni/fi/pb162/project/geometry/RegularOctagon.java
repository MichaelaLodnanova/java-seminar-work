package cz.muni.fi.pb162.project.geometry;

/**
 * Class represents polygon with eight edges
 * @author Michaela Lodnanova
 */
public class RegularOctagon extends GeneralRegularPolygon{
    public RegularOctagon(Vertex2D center, double radius) {
        super(center, 8, radius);
    }
}
