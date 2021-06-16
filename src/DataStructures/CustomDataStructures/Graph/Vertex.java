package DataStructures.CustomDataStructures.Graph;

import java.util.LinkedList;
import java.util.List;

public class Vertex {

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

    public String toString() {
        return String.valueOf(value);
    }
}
