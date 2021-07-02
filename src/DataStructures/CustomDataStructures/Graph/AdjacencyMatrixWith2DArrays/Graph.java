package DataStructures.CustomDataStructures.Graph.AdjacencyMatrixWith2DArrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

class Graph {

    private int[][] adjacencyMatrix;
    private static Map<Vertex, Integer> verticesToIndices;
    private int numVertices = 0;
    private int capacity = 3;
    public static int EDGE_DISTANCE = 1;

    /**
     * Create a new graph.
     */
    public Graph() {
        adjacencyMatrix = new int[capacity][capacity];
        for (int[] row : adjacencyMatrix) {
            Arrays.fill(row, -1);
        }
        verticesToIndices = new HashMap<>();
    }

    /**
     * Add the given vertex to this graph.
     *
     * Precondition: newVertex is not an existing vertex in this graph.
     */
    public void addVertex(Vertex newVertex) {
        ensureLargeEnoughCapacity();

        verticesToIndices.put(newVertex, numVertices);
        int indexOfNewVertex = verticesToIndices.get(newVertex);

        numVertices++;
        fillCurrentRowWithValue(indexOfNewVertex,0);
        fillCurrentColumnWithValue(indexOfNewVertex,0);
    }

    /**
     * Return a string representation of this graph.
     */
    public String toString() {
        StringBuilder graphString = new StringBuilder();
        for (int[] row : adjacencyMatrix) {
            graphString.append(Arrays.toString(row)).append("\n");
        }
        graphString.append("verticesToIndices: ").append(verticesToIndices).append("\n");
        return graphString.toString();
    }

    public static void main(String[] args) {
        Graph graph = new Graph();
        System.out.println(graph);

        Vertex vertex1 = new Vertex(1);
        graph.addVertex(vertex1);
        System.out.println(graph);

        Vertex vertex2 = new Vertex(2);
        graph.addVertex(vertex2);
        System.out.println(graph);

        Vertex vertex3 = new Vertex(3);
        graph.addVertex(vertex3);
        System.out.println(graph);

        Vertex vertex4 = new Vertex(4);
        graph.addVertex(vertex4);
        System.out.println(graph);

        Vertex vertex5 = new Vertex(5);
        graph.addVertex(vertex5);
        System.out.println(graph);

        Vertex vertex6 = new Vertex(6);
        graph.addVertex(vertex6);
        System.out.println(graph);

        Vertex vertex7 = new Vertex(7);
        graph.addVertex(vertex7);
        System.out.println(graph);
    }

    private void ensureLargeEnoughCapacity() {
        if (numVertices < capacity) {
            return;  // the adjacency matrix isn't big enough to expand. we want to grow when load factor = 1.
        }

        // expand columns
        for (int rowNum = 0; rowNum < capacity; rowNum++) {
            adjacencyMatrix[rowNum] = Arrays.copyOf(adjacencyMatrix[rowNum], capacity * 2);
            Arrays.fill(adjacencyMatrix[rowNum], capacity, 2 * capacity, -1);
        }

        // expand rows
        adjacencyMatrix = Arrays.copyOf(adjacencyMatrix, capacity * 2);
        for (int rowNum = capacity; rowNum < 2 * capacity; rowNum++) {
            adjacencyMatrix[rowNum] = new int[capacity * 2];
            Arrays.fill(adjacencyMatrix[rowNum], -1);
        }

        capacity *= 2;
    }

    private void fillCurrentRowWithValue(int columnNumToFill, int newValue) {
        for (int columnNum = 0; columnNum < numVertices; columnNum++) {
            adjacencyMatrix[columnNumToFill][columnNum] = newValue;
        }
    }

    private void fillCurrentColumnWithValue(int rowNumToFill, int newValue) {
        for (int rowNum = 0; rowNum < numVertices; rowNum++) {
            adjacencyMatrix[rowNum][rowNumToFill] = newValue;
        }
    }
}
