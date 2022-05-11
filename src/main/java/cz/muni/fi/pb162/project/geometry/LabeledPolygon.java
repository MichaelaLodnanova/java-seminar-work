package cz.muni.fi.pb162.project.geometry;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.stream.Collectors;

/**
 * Class LabeledPolygon represents n-gon created of vertices which are sorted by
 * their naming (lexicographically ascending)
 * @author Michaela Lodnanova
 */
public final class LabeledPolygon extends SimplePolygon
        implements Labelable, Sortable, PolygonWritable{

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
        return dict.get(label);
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
        return new TreeSet<>(dict.values());
    }

    @Override
    public Collection<Vertex2D> getSortedVertices(Comparator<Vertex2D> comparator) {
        return dict.values().stream().sorted(comparator).collect(Collectors.toUnmodifiableList());

    }

    /**
     * This method finds duplicate vertices in a list
     * @return set of duplicate vertices
     */
    Collection<Vertex2D> duplicateVertices(){
        Set<Vertex2D> duplicates = new HashSet<>();
        for (Vertex2D vertex : dict.values()){
            int counter = Collections.frequency(dict.values(), vertex);
            if (counter > 1){
                duplicates.add(vertex);
            }
        }
        return duplicates;
    }

    @Override
    public void write(OutputStream os) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter
                (new OutputStreamWriter(os, StandardCharsets.UTF_8));
        for (Map.Entry<String, Vertex2D> item : dict.entrySet()){
            bufferedWriter.write(item.getValue().getX()
                    + " "
                    + item.getValue().getY()
                    + " " +item.getKey()
                    + System.lineSeparator());
        }
    }

    @Override
    public void write(File file) throws IOException {
        try(FileOutputStream fileOutputStream = new FileOutputStream(file)){
            write(fileOutputStream);
        }
    }

    /**
     * method writes a map in JSON format to the output stream
     * @param os is an output stream
     * @throws IOException for flush
     */
    public void writeJson(OutputStream os) throws IOException {
        Writer writer = new OutputStreamWriter(os);
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        writer.write(gson.toJson(dict));
        writer.flush();
    }

    /**
     * A nested utility class Builder takes care of creating the polygon
     * @author Michaela Lodnanova
     */
    public static class Builder implements Buildable, PolygonReadable{
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
            }
            vertices.put(label, vert);

            return this;
        }

        @Override
        public LabeledPolygon build() {
            return new LabeledPolygon(vertices);
        }

        @Override
        public Builder read(InputStream is) throws IOException {
            Map<String, Vertex2D> newVert = new TreeMap<>();
            String[] line;
            BufferedReader bufferedReader = new BufferedReader
                    (new InputStreamReader(is, StandardCharsets.UTF_8)); // the input is text
            while (bufferedReader.ready()) {
                line = bufferedReader.readLine().split(" ", 3);
                if (line.length != 3){
                    throw new IOException("incorrect input");
                }
                try {
                    double x = Double.parseDouble(line[0]);
                    double y = Double.parseDouble(line[1]);
                    Vertex2D vert = new Vertex2D(x, y);
                    newVert.put(line[2], vert);
                } catch (IllegalArgumentException e) {
                    throw new IOException("wrong coordinates");
                }
            }
            vertices.putAll(newVert);
            return this;
        }

        @Override
        public Builder read(File file) throws IOException {
            FileInputStream fileStream = new FileInputStream(file);
            try {
                // try to read the file stream
                read(fileStream);
            }finally {
                // close the file
                fileStream.close();
            }
            return this;
        }
    }
}
