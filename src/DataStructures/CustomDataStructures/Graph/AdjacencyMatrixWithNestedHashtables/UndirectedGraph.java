package DataStructures.CustomDataStructures.Graph.AdjacencyMatrixWithNestedHashtables;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

class UndirectedGraph {

    private Map<Vertex, HashSet<Vertex>> vertices;
    public static int EDGE_DISTANCE = 1;

    /**
     * Create a new graph.
     */
    public UndirectedGraph() {
        vertices = new HashMap<>();
    }

    /**
     * Add the given vertex to this graph.
     *
     * Precondition: newVertex is not an existing vertex in this graph.
     */
    public void addVertex(Vertex newVertex) {
        vertices.put(newVertex, new HashSet<>());
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
        vertices.get(vertex1).add(vertex2);
        vertices.get(vertex2).add(vertex1);
    }

    /**
     * Remove an edge between the given vertices.
     *
     * Precondition: vertex1 and vertex2 are existing vertices in this graph.
     */
    public void removeEdge(Vertex vertex1, Vertex vertex2) {
        vertices.get(vertex1).remove(vertex2);
        vertices.get(vertex2).remove(vertex1);
    }

    /**
     * Return a list of all vertices of this graph.
     */
    public List<Vertex> getVertices() {
        return new ArrayList<>(vertices.keySet());
    }

    /**
     * Return a list of all edges of this graph.
     */
    public List<List<Vertex>> getEdges() {
        List<List<Vertex>> edgeList = new LinkedList<>();
        for (Vertex startVertex : getVertices()) {
            for (Vertex endVertex : vertices.get(startVertex)) {
                List<Vertex> edge = new LinkedList<>();
                edge.add(startVertex);
                edge.add(endVertex);
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
        for (Vertex vertex : getVertices()) {
            graphString.append("Vertex: ").append(vertex).append(" ");
            graphString.append("Neighbours: ").append(vertices.get(vertex));
            graphString.append("\n");
        }
        return graphString.toString();
    }

    public static void main(String[] args) {
        UndirectedGraph undirectedGraph = new UndirectedGraph();
        Vertex vertex1 = new Vertex(1);
        Vertex vertex2 = new Vertex(2);
        Vertex vertex3 = new Vertex(3);
        Vertex vertex4 = new Vertex(4);
        Vertex vertex5 = new Vertex(5);
        Vertex vertex6 = new Vertex(6);
        Vertex vertex7 = new Vertex(7);

        undirectedGraph.addVertex(vertex1);
        undirectedGraph.addVertex(vertex2);
        undirectedGraph.addVertex(vertex3);
        undirectedGraph.addVertex(vertex4);
        undirectedGraph.addVertex(vertex5);
        undirectedGraph.addVertex(vertex6);
        undirectedGraph.addVertex(vertex7);

        undirectedGraph.addEdge(vertex1, vertex2);
        undirectedGraph.addEdge(vertex1, vertex3);
        undirectedGraph.addEdge(vertex2, vertex4);
        undirectedGraph.addEdge(vertex2, vertex5);
        undirectedGraph.addEdge(vertex3, vertex6);
        undirectedGraph.addEdge(vertex3, vertex7);

        System.out.println(undirectedGraph.getEdges());
        // [[1, 2], [1, 3], [2, 1], [2, 4], [2, 5], [3, 1], [3, 6], [3, 7], [4, 2], [5, 2], [6, 3], [7, 3]]
        // more or less...
        System.out.println(undirectedGraph.getVertices());  // [1, 2, 3, 4, 5, 6, 7] more or less...
        System.out.println(undirectedGraph);
        // Vertex: 1 Neighbours: [2, 3]
        // Vertex: 2 Neighbours: [1, 4, 5]
        // Vertex: 3 Neighbours: [1, 6, 7]
        // Vertex: 4 Neighbours: [2]
        // Vertex: 5 Neighbours: [2]
        // Vertex: 6 Neighbours: [3]
        // Vertex: 7 Neighbours: [3]
        // more or less...

        UndirectedGraph undirectedGraph2 = new UndirectedGraph();
        Vertex vertex8 = new Vertex(8);
        Vertex vertex9 = new Vertex(9);

        undirectedGraph2.addVertex(vertex8);
        undirectedGraph2.addVertex(vertex9);

        undirectedGraph2.addEdge(vertex8, vertex9);
        undirectedGraph2.removeEdge(vertex8, vertex9);

        System.out.println(undirectedGraph2);
        // Vertex: 9 Neighbours: []
        // Vertex: 8 Neighbours: []

        undirectedGraph2.removeVertex(vertex8);
        System.out.println(undirectedGraph2);
        // Vertex: 9 Neighbours: []

        undirectedGraph2.removeVertex(vertex9);
        System.out.println(undirectedGraph2);
        // empty string
    }
}
