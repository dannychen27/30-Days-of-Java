package DataStructures.CustomDataStructures.Graph.UndirectedGraph.AdjacencyMatrixWith2DArrays;

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
