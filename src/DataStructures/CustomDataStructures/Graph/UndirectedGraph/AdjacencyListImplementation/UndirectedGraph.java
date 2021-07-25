package DataStructures.CustomDataStructures.Graph.UndirectedGraph.AdjacencyListImplementation;

import java.util.LinkedList;
import java.util.List;

public class UndirectedGraph {

    private List<Vertex> vertices;
    public static int EDGE_DISTANCE = 1;

    /**
     * Create a new graph.
     */
    public UndirectedGraph() {
        vertices = new LinkedList<>();
    }

    /**
     * Return true iff this graph has no vertices.
     */
    public boolean isEmpty() {
        return vertices.isEmpty();
    }

    /**
     * Add the given vertex to this graph.
     *
     * Precondition: newVertex is not an existing vertex in this graph.
     */
    public void addVertex(Vertex newVertex) {
        vertices.add(newVertex);
    }

    /**
     * Remove the given vertex from this graph.
     *
     * Precondition: oldVertex is an existing vertex in this graph.
     */
    public void removeVertex(Vertex oldVertex) {
        vertices.remove(oldVertex);
    }

    /**
     * Add an edge between the given vertices.
     *
     * Precondition: vertex1 and vertex2 are existing vertices in this graph.
     */
    public void addEdge(Vertex vertex1, Vertex vertex2) {
        vertex1.addNeighbour(vertex2);
        vertex2.addNeighbour(vertex1);
    }

    /**
     * Remove an edge between the given vertices.
     *
     * Precondition: vertex1 and vertex2 are existing vertices in this graph.
     */
    public void removeEdge(Vertex vertex1, Vertex vertex2) {
        vertex1.removeNeighbour(vertex2);
        vertex2.removeNeighbour(vertex1);
    }

    /**
     * Return a list of all vertices of this graph.
     */
    public List<Vertex> getVertices() {
        return vertices;
    }

    /**
     * Return a list of all edges of this graph.
     */
    public List<List<Vertex>> getEdges() {
        List<List<Vertex>> edgeList = new LinkedList<>();
        for (Vertex startVertex : getVertices()) {
            for (Vertex endVertex : startVertex.getNeighbors()) {
                List<Vertex> newEdge = createEdgeBetween(startVertex, endVertex);
                edgeList.add(newEdge);
            }
        }
        return edgeList;
    }

    /**
     * Return a string representation of this graph.
     */
    public String toString() {
        StringBuilder graphString = new StringBuilder();
        for (Vertex vertex : vertices) {
            graphString.append("Vertex: ").append(vertex).append(" ");
            graphString.append("Neighbours: ").append(vertex.getNeighbors());
            graphString.append("\n");
        }
        return graphString.toString();
    }

    private List<Vertex> createEdgeBetween(Vertex startVertex, Vertex endVertex) {
        List<Vertex> newEdge = new LinkedList<>();
        newEdge.add(startVertex);
        newEdge.add(endVertex);
        return newEdge;
    }
}
