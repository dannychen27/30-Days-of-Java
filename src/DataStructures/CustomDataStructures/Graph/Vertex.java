package DataStructures.CustomDataStructures.Graph;

import java.util.LinkedList;

public class Vertex {
    public int value;
    public LinkedList<Vertex> neighbors;

    public Vertex(int newValue) {
        value = newValue;
        neighbors = new LinkedList<>();
    }

    public String toString() {
        return String.valueOf(value);
    }
}
