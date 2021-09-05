package DataStructures.CustomDataStructures.Graph.UndirectedGraph.AdjacencyMatrixWith2DArrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

class UndirectedGraph {

    private int[][] adjacencyMatrix;
    private Map<Vertex, Integer> verticesToIndices;
    private int numVertices = 0;
    private int capacity = 3;
    public static int EDGE_DISTANCE = 1;

    /**
     * Create a new graph.
     */
    public UndirectedGraph() {
        adjacencyMatrix = new int[capacity][capacity];
        for (int[] row : adjacencyMatrix) {
            Arrays.fill(row, -1);
        }
        verticesToIndices = new HashMap<>();
    }

    /**
     * Return true iff this graph has no vertices.
     */
    public boolean isEmpty() {
        return numVertices == 0;
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
        setRowEntries(indexOfNewVertex,0);
        setColumnEntries(indexOfNewVertex,0);
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
        setEntry(vertex2, vertex1, 1);
    }

    /**
     * Remove an edge between the given adjacencyMatrix.
     *
     * Precondition: vertex1 and vertex2 are existing adjacencyMatrix in this graph.
     */
    public void removeEdge(Vertex vertex1, Vertex vertex2) {
        setEntry(vertex1, vertex2, 0);
        setEntry(vertex2, vertex1, 0);
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
        List<Vertex> vertices = getVertices();
        for (Vertex startVertex : vertices) {
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
        return graphString.toString();
    }

    private void ensureLargeEnoughCapacity() {
        if (numVertices < capacity) {
            // The adjacency matrix isn't big enough to expand.
            // We want to grow when load factor = 1.
            return;
        }

        expandColumns();
        expandRows();
        capacity *= 2;
    }

    private void ensureSmallEnoughCapacity() {
        if (capacity < 4) {
            // The matrix is too small to shrink.
            // Shrinking the matrix any further will simply make it permanently disappear.
            return;
        }

        if (numVertices > capacity / 4) {
            // The matrix isn't small enough to shrink.
            // We want to shrink when load factor = 1 / 4.
            return;
        }

        shrinkRows();
        shrinkColumns();
        capacity /= 4;
    }

    private void expandRows() {
        adjacencyMatrix = Arrays.copyOf(adjacencyMatrix, capacity * 2);
        for (int rowNum = capacity; rowNum < 2 * capacity; rowNum++) {
            adjacencyMatrix[rowNum] = new int[capacity * 2];
            Arrays.fill(adjacencyMatrix[rowNum], -1);
        }
    }

    private void expandColumns() {
        for (int rowNum = 0; rowNum < capacity; rowNum++) {
            adjacencyMatrix[rowNum] = Arrays.copyOf(adjacencyMatrix[rowNum], capacity * 2);
            Arrays.fill(adjacencyMatrix[rowNum], capacity, 2 * capacity, -1);
        }
    }

    private void shrinkColumns() {
        for (int rowNum = 0; rowNum < adjacencyMatrix.length; rowNum++) {
            adjacencyMatrix[rowNum] = Arrays.copyOf(adjacencyMatrix[rowNum], capacity / 4);
        }
    }

    private void shrinkRows() {
        adjacencyMatrix = Arrays.copyOf(adjacencyMatrix, capacity / 4);
    }

    private void setRowEntries(int columnNumToFill, int newValue) {
        for (int columnNum = 0; columnNum < numVertices; columnNum++) {
            adjacencyMatrix[columnNumToFill][columnNum] = newValue;
        }
    }

    private void setColumnEntries(int rowNumToFill, int newValue) {
        for (int rowNum = 0; rowNum < numVertices; rowNum++) {
            adjacencyMatrix[rowNum][rowNumToFill] = newValue;
        }
    }

    private void removeGaps(int indexOfOldVertex) {
        int firstEmptyRowIndex = removeRowGaps(indexOfOldVertex);
        removeColumnGaps(indexOfOldVertex, firstEmptyRowIndex);
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
