package DataStructures.CustomDataStructures.Graph.UndirectedGraph.AdjacencyListImplementation;

import DataStructures.CustomDataStructures.Graph.Graph;
import DataStructures.CustomDataStructures.Graph.GraphVertex;

import java.util.LinkedList;
import java.util.List;

public class UndirectedGraph implements Graph {

    private List<GraphVertex> vertices;
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
    public void addVertex(GraphVertex newVertex) {
        vertices.add(newVertex);
    }

    /**
     * Remove the given vertex from this graph.
     *
     * Precondition: oldVertex is an existing vertex in this graph.
     */
    public void removeVertex(GraphVertex oldVertex) {
        vertices.remove(oldVertex);
    }

    /**
     * Add an edge between the given vertices.
     *
     * Precondition: vertex1 and vertex2 are existing vertices in this graph.
     */
    public void addEdge(GraphVertex vertex1, GraphVertex vertex2) {
        ((Vertex) vertex1).addNeighbour(vertex2);
        ((Vertex) vertex2).addNeighbour(vertex1);
    }

    /**
     * Remove an edge between the given vertices.
     *
     * Preconditions:
     *      - vertex1 and vertex2 are existing vertices in this graph.
     *      - vertex1 and vertex2 have edges between them in this graph.
     */
    public void removeEdge(GraphVertex vertex1, GraphVertex vertex2) {
        ((Vertex) vertex1).removeNeighbour(vertex2);
        ((Vertex) vertex1).removeNeighbour(vertex1);
    }

    /**
     * Return a list of all vertices of this graph.
     */
    public List<GraphVertex> getVertices() {
        return vertices;
    }

    /**
     * Return a list of all edges of this graph.
     */
    public List<List<GraphVertex>> getEdges() {
        List<List<GraphVertex>> edgeList = new LinkedList<>();
        for (GraphVertex startVertex : getVertices()) {
            for (GraphVertex endVertex : ((Vertex) startVertex).getNeighbors()) {
                List<GraphVertex> newEdge = createEdgeBetween(startVertex, endVertex);
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
        for (GraphVertex vertex : vertices) {
            graphString.append("Vertex: ").append(vertex).append(" ");
            graphString.append("Neighbours: ").append(((Vertex) vertex).getNeighbors());
            graphString.append("\n");
        }
        return graphString.toString();
    }

    private List<GraphVertex> createEdgeBetween(GraphVertex startVertex, GraphVertex endVertex) {
        List<GraphVertex> newEdge = new LinkedList<>();
        newEdge.add(startVertex);
        newEdge.add(endVertex);
        return newEdge;
    }
}
