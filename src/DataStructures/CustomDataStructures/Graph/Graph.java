package DataStructures.CustomDataStructures.Graph;

import java.util.LinkedList;


public class Graph {

    public LinkedList<Vertex> vertices;
    public static int EDGE_DISTANCE = 1;

    public Graph() {
        vertices = new LinkedList<>();
    }

    public void addEdge(Vertex vertex1, Vertex vertex2) {
        vertex1.neighbors.add(vertex2);
        vertex2.neighbors.add(vertex1);
    }

    public void addVertex(Vertex newVertex) {
        vertices.add(newVertex);
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

        System.out.println(graph.vertices);
    }
}
