package DataStructures.CustomDataStructures.Graph.UndirectedGraph.AdjacencyMatrixWithNestedHashtables;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

class UndirectedGraph {

    private Map<Vertex, HashSet<Vertex>> verticesToNeighbors;

    /**
     * Create a new graph.
     */
    public UndirectedGraph() {
        verticesToNeighbors = new HashMap<>();
    }

    /**
     * Return true iff this graph has no vertices.
     */
    public boolean isEmpty() {
        return verticesToNeighbors.isEmpty();
    }

    /**
     * Add the given vertex to this graph.
     *
     * Precondition: newVertex is not an existing vertex in this graph.
     */
    public void addVertex(Vertex newVertex) {
        verticesToNeighbors.put(newVertex, new HashSet<>());
    }

    /**
     * Remove the given vertex from this graph.
     *
     * Precondition: oldVertex is an existing vertex in this graph.
     */
    public void removeVertex(Vertex oldVertex) {
        verticesToNeighbors.remove(oldVertex);
    }

    /**
     * Add an edge between the given vertices.
     *
     * Precondition: vertex1 and vertex2 are existing vertices in this graph.
     */
    public void addEdge(Vertex vertex1, Vertex vertex2) {
        verticesToNeighbors.get(vertex1).add(vertex2);
        verticesToNeighbors.get(vertex2).add(vertex1);
    }

    /**
     * Remove an edge between the given vertices.
     *
     * Preconditions:
     *      - vertex1 and vertex2 are existing vertices in this graph.
     *      - vertex1 and vertex2 have edges between them in this graph.
     */
    public void removeEdge(Vertex vertex1, Vertex vertex2) {
        verticesToNeighbors.get(vertex1).remove(vertex2);
        verticesToNeighbors.get(vertex2).remove(vertex1);
    }

    /**
     * Return a list of all vertices of this graph.
     */
    public List<Vertex> getVertices() {
        return new ArrayList<>(verticesToNeighbors.keySet());
    }

    /**
     * Return a list of all edges of this graph.
     */
    public List<List<Vertex>> getEdges() {
        List<List<Vertex>> edgeList = new LinkedList<>();
        for (Vertex startVertex : getVertices()) {
            for (Vertex endVertex : verticesToNeighbors.get(startVertex)) {
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
        for (Vertex vertex : getVertices()) {
            graphString.append("Vertex: ").append(vertex).append(" ");
            graphString.append("Neighbours: ").append(verticesToNeighbors.get(vertex));
            graphString.append("\n");
        }
        return graphString.toString();
    }

    private List<Vertex> createEdgeBetween(Vertex startVertex, Vertex endVertex) {
        List<Vertex> edge = new LinkedList<>();
        edge.add(startVertex);
        edge.add(endVertex);
        return edge;
    }
}
