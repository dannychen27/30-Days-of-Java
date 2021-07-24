package DataStructures.CustomDataStructures.Graph.AdjacencyMatrixWith2DArrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

class Graph {

    private int[][] adjacencyMatrix;
    private Map<Vertex, Integer> verticesToIndices;
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
     * Remove the given vertex from this graph.
     *
     * Precondition: oldVertex is an existing vertex in this graph.
     */
    public void removeVertex(Vertex oldVertex) {
        int indexOfOldVertex = verticesToIndices.get(oldVertex);
        verticesToIndices.remove(oldVertex);

        adjustIndicesOfRemainingVertices(indexOfOldVertex);
        setRowEntries(indexOfOldVertex,-1);
        setColumnEntries(indexOfOldVertex,-1);
        removeGaps(indexOfOldVertex);
        numVertices--;

        ensureSmallEnoughCapacity();
    }

    /**
     * Add an edge between the given adjacencyMatrix.
     *
     * Precondition: vertex1 and vertex2 are existing adjacencyMatrix in this graph.
     */
    public void addEdge(Vertex vertex1, Vertex vertex2) {
        setEntry(vertex1, vertex2, 1);
    }

    /**
     * Remove an edge between the given adjacencyMatrix.
     *
     * Precondition: vertex1 and vertex2 are existing adjacencyMatrix in this graph.
     */
    public void removeEdge(Vertex vertex1, Vertex vertex2) {
        setEntry(vertex1, vertex2, 0);
    }

    /**
     * Return a list of all vertices of this graph.
     */
    public List<Vertex> getVertices() {
        return new ArrayList<>(verticesToIndices.keySet());
    }

    /**
     * Return a list of all edges of this graph.
     */
    public List<List<Vertex>> getEdges() {
        List<List<Vertex>> edgeList = new LinkedList<>();
        for (Vertex startVertex : getVertices()) {
            int indexOfStartVertex = verticesToIndices.get(startVertex);
            for (int indexOfEndVertex = 0; indexOfEndVertex < numVertices; indexOfEndVertex++) {
                if (adjacencyMatrix[indexOfStartVertex][indexOfEndVertex] == 0) {
                    continue;
                }

                List<Vertex> edge = getEdge(startVertex, indexOfEndVertex);
                edgeList.add(edge);
            }
        }
        return edgeList;
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

        graph.addEdge(vertex1, vertex2);
        System.out.println(graph);
        graph.addEdge(vertex1, vertex3);
        System.out.println(graph);
        graph.addEdge(vertex2, vertex3);
        System.out.println(graph);

        System.out.println("Vertices: " + graph.getVertices());
        // [1, 2, 3, 4, 5, 6, 7] more or less...
        System.out.println("Edges: " + graph.getEdges() + "\n");
        // [[1, 2], [1, 3], [2, 1], [2, 3], [3, 1], [3, 2]] more or less...

        graph.removeEdge(vertex1, vertex2);
        System.out.println(graph);
        graph.removeEdge(vertex1, vertex3);
        System.out.println(graph);
        graph.removeEdge(vertex2, vertex3);
        System.out.println(graph);

        graph.removeVertex(vertex1);
        System.out.println(graph);
        graph.removeVertex(vertex2);
        System.out.println(graph);
        graph.removeVertex(vertex3);
        System.out.println(graph);
        graph.removeVertex(vertex4);
        System.out.println(graph);
        graph.removeVertex(vertex5);
        System.out.println(graph);
        graph.removeVertex(vertex6);
        System.out.println(graph);
        graph.removeVertex(vertex7);
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

    private void ensureSmallEnoughCapacity() {
        if (capacity < 4) {
            return;  // the matrix is too small to shrink; it'll simply disappear.
        }

        if (numVertices > capacity / 4) {
            return;  // the matrix isn't small enough to shrink. we want to shrink when load factor = 1/4.
        }

        // shrink rows
        adjacencyMatrix = Arrays.copyOf(adjacencyMatrix, capacity / 4);

        // shrink columns
        for (int rowNum = 0; rowNum < adjacencyMatrix.length; rowNum++) {
            adjacencyMatrix[rowNum] = Arrays.copyOf(adjacencyMatrix[rowNum], capacity / 4);
        }

        capacity /= 4;
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

    private void adjustIndicesOfRemainingVertices(int indexOfOldVertex) {
        for (Map.Entry<Vertex, Integer> entry: verticesToIndices.entrySet()) {
            if (entry.getValue() > indexOfOldVertex) {
                verticesToIndices.replace(entry.getKey(), entry.getValue(), entry.getValue() - 1);
            }
        }
    }

    private int removeRowGaps(int indexOfOldVertex) {
        swapRow(adjacencyMatrix, indexOfOldVertex, adjacencyMatrix.length - 1);
        int firstEmptyRowIndex = getFirstEmptyRowIndex(indexOfOldVertex);
        shiftRowsUp(adjacencyMatrix, indexOfOldVertex, firstEmptyRowIndex);
        return firstEmptyRowIndex;
    }

    private void removeColumnGaps(int indexOfOldVertex, int firstEmptyRowIndex) {
        int firstEmptyColumnIndex = getFirstEmptyColumnIndex(indexOfOldVertex);
        for (int rowNum = 0; rowNum < firstEmptyRowIndex; rowNum++) {
            swapColumn(adjacencyMatrix[rowNum], indexOfOldVertex, firstEmptyColumnIndex);
            shiftColumnsLeft(adjacencyMatrix[rowNum], indexOfOldVertex, firstEmptyColumnIndex);
        }
    }

    private void shiftRowsUp(int[][] array, int startingFromRowIndex, int endingAtRowIndex) {
        for (int rowIndex = startingFromRowIndex + 1; rowIndex < endingAtRowIndex; rowIndex++) {
            swapRow(array, rowIndex - 1, rowIndex);
        }
    }

    private void shiftColumnsLeft(int[] array, int startingFromColumnIndex, int endingAtColumnIndex) {
        for (int columnIndex = startingFromColumnIndex + 1; columnIndex < endingAtColumnIndex; columnIndex++) {
            swapColumn(array, columnIndex - 1, columnIndex);
        }
    }

    // return the first empty row after the indexOfOldVertex-th row.
    private int getFirstEmptyRowIndex(int indexOfOldVertex) {
        int firstEmptyRowIndex = indexOfOldVertex;
        for (int rowNum = indexOfOldVertex + 1; rowNum < adjacencyMatrix.length; rowNum++) {
            firstEmptyRowIndex++;
            if (containsAllDuplicateValues(adjacencyMatrix[rowNum], -1)) {
                break;
            }
        }
        return firstEmptyRowIndex;
    }

    // return the first empty column after the indexOfOldVertex-th column.
    private int getFirstEmptyColumnIndex(int indexOfOldVertex) {
        int firstEmptyColumnIndex = indexOfOldVertex;
        for (int columnNum = indexOfOldVertex + 1; columnNum < adjacencyMatrix.length; columnNum++) {
            firstEmptyColumnIndex++;
            if (adjacencyMatrix[indexOfOldVertex][columnNum] == -1) {
                break;
            }
        }
        return firstEmptyColumnIndex;
    }

    private void swapRow(int[][] array, int index1, int index2) {
        int[] temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

    private void swapColumn(int[] array, int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

    private boolean containsAllDuplicateValues(int[] row, int targetValue) {
        for (int entry : row) {
            if (entry != targetValue) {
                return false;
            }
        }
        return true;
    }

    private void setEntry(Vertex vertex1, Vertex vertex2, int newValue) {
        int indexOfVertex1 = verticesToIndices.get(vertex1);
        int indexOfVertex2 = verticesToIndices.get(vertex2);
        adjacencyMatrix[indexOfVertex1][indexOfVertex2] = newValue;
        adjacencyMatrix[indexOfVertex2][indexOfVertex1] = newValue;
    }

    // find vertex with this index.
    private Vertex findEndVertex(int indexOfEndVertex) {
        for (Map.Entry<Vertex, Integer> entry : verticesToIndices.entrySet()) {
            if (entry.getValue() == indexOfEndVertex) {
                return entry.getKey();
            }
        }
        return null;
    }

    // return an edge between startVertex and endVertex.
    private List<Vertex> getEdge(Vertex startVertex, int indexOfEndVertex) {
        List<Vertex> edge = new LinkedList<>();
        edge.add(startVertex);  // find corresponding vertex in verticesToIndices
        Vertex endVertex = findEndVertex(indexOfEndVertex);
        edge.add(endVertex);
        return edge;
    }
}
