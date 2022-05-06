package cz.muni.fi.pb162.project.geometry;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;

/**
 * Class LabeledPolygon represents n-gon created of vertices which are sorted by
 * their naming (lexicographically ascending)
 * @author Michaela Lodnanova
 */
public final class LabeledPolygon extends SimplePolygon
        implements Labelable, Sortable{

    private Map<String, Vertex2D> dict;

    /**
     * Constructor creates an object LabeledPolygon
     * @param dict is an input parameter of an object of type Map<String, Vertex2D>
     */
    private LabeledPolygon(Map<String, Vertex2D> dict){
        super(dict.values().toArray(new Vertex2D[0]));
        this.dict = dict;
    }

    @Override
    public Vertex2D getVertex(int index) {
        if (index < 0){
            throw new IllegalArgumentException("index out of bounds");
        }
        List<Vertex2D> vertices = new ArrayList<>(dict.values());
        return vertices.get(index%dict.size());
    }

    @Override
    public int getNumVertices() {
        return dict.size();
    }

    @Override
    public Vertex2D getVertex(String label) {
        if (label == null){
                throw new NullPointerException("null label");
        }
        for (String string : dict.keySet()){
            if (string.equals(label)){
                return dict.get(string);
            }
        }
        return null;
    }

    @Override
    public Collection<String> getLabels() {
        return dict.keySet().stream().collect(Collectors.toUnmodifiableList());
    }

    @Override
    public Collection<String> getLabels(Vertex2D vertex) {
        List<String> labels = new ArrayList<>();
        for (String label : dict.keySet()){
            if (dict.get(label).equals(vertex)){
                labels.add(label);
            }
        }
        return labels;
    }

    @Override
    public Collection<Vertex2D> getSortedVertices() {
        var sorted = dict.values().stream().sorted();
        return sorted.collect(Collectors.toUnmodifiableList());
    }

    @Override
    public Collection<Vertex2D> getSortedVertices(Comparator<Vertex2D> comparator) {
        return dict.values().stream()
                .sorted(comparator)
                .collect(Collectors.toCollection(LinkedHashSet::new));
    }

    /**
     * This method finds duplicate vertices in a list
     * @return set of duplicate vertices
     */
    Collection<Vertex2D> duplicateVertices(){
        Set<Vertex2D> duplicates = new HashSet<>();
        List<Vertex2D> all = new ArrayList<>(dict.values());
        for (Vertex2D vertex : all){
            int counter = Collections.frequency(all, vertex);
            if (counter > 1){
                duplicates.add(vertex);
            }
        }
        return duplicates;
    }

    /**
     * A nested utility class Builder takes care of creating the polygon
     * @author Michaela Lodnanova
     */
    public static class Builder implements Buildable{
        private final Map<String, Vertex2D> vertices = new TreeMap<>();

        /**
         * Method saved the vertex under the given name.
         * Method controls input parameters that cannot be null.
         * If a vertex already exists in the n-gon under the given name,
         * it is replaced by a new one.
         * @param label is a name of a vertex in n-gon
         * @param vert is a Vertex2D object with x and y coordinates
         * @return Builder object with added vertex
         */
        public Builder addVertex(String label, Vertex2D vert){
            if (vert == null){
                throw new IllegalArgumentException("input vertex is null");
            }
            if (label == null){
                throw new IllegalArgumentException("input label is null");
            }
            if (vertices.containsKey(label)){
                vertices.replace(label, vert);
            } else{
                vertices.put(label, vert);
            }
            return this;
        }

        @Override
        public LabeledPolygon build() {
            return new LabeledPolygon(vertices);
        }
    }
}
