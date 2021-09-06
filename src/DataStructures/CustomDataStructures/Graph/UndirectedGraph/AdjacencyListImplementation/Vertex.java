package DataStructures.CustomDataStructures.Graph.UndirectedGraph.AdjacencyListImplementation;

import DataStructures.CustomDataStructures.Graph.GraphVertex;

import java.util.LinkedList;
import java.util.List;

public class Vertex implements GraphVertex {

    private int value;
    private List<GraphVertex> neighbors;

    public Vertex(int newValue) {
        value = newValue;
        neighbors = new LinkedList<>();
    }

    public List<GraphVertex> getNeighbors() {
        return neighbors;
    }

    void addNeighbour(GraphVertex otherVertex) {
        neighbors.add(otherVertex);
    }

    void removeNeighbour(GraphVertex otherVertex) {
        neighbors.remove(otherVertex);
    }

    public String toString() {
        return String.valueOf(value);
    }
}
