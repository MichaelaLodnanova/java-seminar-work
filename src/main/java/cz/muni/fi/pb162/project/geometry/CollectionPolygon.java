package cz.muni.fi.pb162.project.geometry;


import cz.muni.fi.pb162.project.exception.MissingVerticesException;
import cz.muni.fi.pb162.project.utils.SimpleMath;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;


/**
 * Class represents an n-gon. N-gon is represented by 2D vertices
 * which are stored in a list.
 * @author Michaela Lodnanova
 */
public class CollectionPolygon extends SimplePolygon{

    private List<Vertex2D> verticesList;

    /**
     * Constructor creates an object which stores an array of
     * vertices.
     * @param verticesList is an array of 2D vertices.
     */
    public CollectionPolygon(Vertex2D[] verticesList) throws MissingVerticesException {
        super(verticesList);
        this.verticesList = new ArrayList<>(Arrays.asList(verticesList));
    }

    /**
     * Second constructor takes a list of vertices as an input
     * parameter. This one was created for methods and tests
     * I was not able to solve without second constructor. :)
     * @param verticesList of type List filled with vertices
     */
    public CollectionPolygon(List<Vertex2D> verticesList) throws MissingVerticesException {
        this(verticesList.toArray(Vertex2D[]::new));
    }

    @Override
    public Vertex2D getVertex(int index) {
        if (index < 0){
            throw new IllegalArgumentException("index out of range");
        }
        return verticesList.get(index % verticesList.size());
    }

    @Override
    public int getNumVertices() {
        return this.verticesList.size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o){
            return true;
        }
        if (!(o instanceof CollectionPolygon)){
            return false;
        }
        CollectionPolygon that = (CollectionPolygon) o;
        return Objects.equals(verticesList, that.verticesList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(verticesList);
    }

    /**
     * A method which returns a new polygon without the leftmost
     * vertices.
     * @return exception if the new polygon no longer contains any vertices
     * after removing the leftmost vertices, new object of type
     * CollectionPolygon after removing leftmost vertices.
     */
    public CollectionPolygon withoutLeftmostVertices() throws MissingVerticesException {
        double minX = SimpleMath.minX(this);
        List<Vertex2D> newVertices = verticesList.stream()
                .filter(x -> (x.getX() != minX)).collect(Collectors.toList());
        if (newVertices.isEmpty()){
            throw new MissingVerticesException("no vertices in new array");
        } else {
            return new CollectionPolygon(newVertices);
        }
    }
}
