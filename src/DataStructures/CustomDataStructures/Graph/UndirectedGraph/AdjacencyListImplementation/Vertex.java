package DataStructures.CustomDataStructures.Graph.UndirectedGraph.AdjacencyListImplementation;

import DataStructures.CustomDataStructures.Graph.GraphVertex;

import java.util.LinkedList;
import java.util.List;

public class Vertex implements GraphVertex {

    private int value;
    private List<Vertex> neighbors;

    public Vertex(int newValue) {
        value = newValue;
        neighbors = new LinkedList<>();
    }

    public List<Vertex> getNeighbors() {
        return neighbors;
    }

    void addNeighbour(Vertex otherVertex) {
        neighbors.add(otherVertex);
    }

    void removeNeighbour(Vertex otherVertex) {
        neighbors.remove(otherVertex);
    }

    public String toString() {
        return String.valueOf(value);
    }
}
