package DataStructures.CustomDataStructures.Graph.AdjacencyListImplementation;

import java.util.LinkedList;
import java.util.List;

public class Graph {

    private List<Vertex> vertices;
    public static int EDGE_DISTANCE = 1;

    public Graph() {
        vertices = new LinkedList<>();
    }

    public void addVertex(Vertex newVertex) {
        vertices.add(newVertex);
    }

    public void addEdge(Vertex vertex1, Vertex vertex2) {
        vertex1.addNeighbour(vertex2);
        vertex2.addNeighbour(vertex1);
    }

    public List<Vertex> getVertices() {
        return vertices;
    }

    public String toString() {
        StringBuilder graphString = new StringBuilder();
        for (Vertex vertex : vertices) {
            graphString.append("Vertex: ").append(vertex).append(" ");
            graphString.append("Neighbours: ").append(vertex.getNeighbors());
            graphString.append("\n");
        }
        return graphString.toString();
    }

    public static void main(String[] args) {
        Graph graph = new Graph();
        Vertex vertex1 = new Vertex(1);
        Vertex vertex2 = new Vertex(2);
        Vertex vertex3 = new Vertex(3);
        Vertex vertex4 = new Vertex(4);
        Vertex vertex5 = new Vertex(5);
        Vertex vertex6 = new Vertex(6);
        Vertex vertex7 = new Vertex(7);

        graph.addVertex(vertex1);
        graph.addVertex(vertex2);
        graph.addVertex(vertex3);
        graph.addVertex(vertex4);
        graph.addVertex(vertex5);
        graph.addVertex(vertex6);
        graph.addVertex(vertex7);

        graph.addEdge(vertex1, vertex2);
        graph.addEdge(vertex1, vertex3);
        graph.addEdge(vertex2, vertex4);
        graph.addEdge(vertex2, vertex5);
        graph.addEdge(vertex3, vertex6);
        graph.addEdge(vertex3, vertex7);

        System.out.println(graph);
        // Vertex: 1 Neighbours: [2, 3]
        // Vertex: 2 Neighbours: [1, 4, 5]
        // Vertex: 3 Neighbours: [1, 6, 7]
        // Vertex: 4 Neighbours: [2]
        // Vertex: 5 Neighbours: [2]
        // Vertex: 6 Neighbours: [3]
        // Vertex: 7 Neighbours: [3]
    }
}
