package DataStructures.CustomDataStructures.Graph.UndirectedGraph.AdjacencyMatrixWithNestedHashtables;

import DataStructures.CustomDataStructures.Graph.GraphVertex;

class Vertex implements GraphVertex {

    private int value;

    Vertex(int newValue) {
        value = newValue;
    }

    public String toString() {
        return String.valueOf(value);
    }
}
