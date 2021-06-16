package InterviewProblems.GraphProblems.BreadthFirstSearch;

import DataStructures.CustomDataStructures.Graph.Graph;
import DataStructures.CustomDataStructures.Graph.Vertex;
import DataStructures.CustomDataStructures.Queue.Queue;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import static DataStructures.CustomDataStructures.Graph.Graph.EDGE_DISTANCE;

class BreadthFirstSearch {

    public static void main(String[] args) {
        // BFS source code: https://mcsapps.utm.utoronto.ca/slidechat/5f49771dd89c8059833766fc/24
        // source: https://www.youtube.com/watch?v=0XgVhsMOcQM&list=PLI1t_8YX-ApvMthLj56t1Rf-Buio5Y8KL&index=4&t=53s

        // time: Theta(|V| + |E|)
        // space: Theta(|V| + |E|)

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

        System.out.println(breadthFirstSearch(graph, vertex1));  // [1, 2, 3, 4, 5, 6, 7]
    }

    private static List<Vertex> breadthFirstSearch(Graph graph, Vertex sourceVertex) {
        Map<Vertex, String> verticesToColors = new HashMap<>();
        Map<Vertex, Integer> verticesToDistances = new HashMap<>();
        for (Vertex vertex : graph.getVertices()) {
            verticesToColors.put(vertex, "white");
            verticesToDistances.put(vertex, Integer.MAX_VALUE);
        }

        Queue<Vertex> verticesToVisit = new Queue<>();
        verticesToVisit.enqueue(sourceVertex);
        verticesToColors.replace(sourceVertex, "gray");
        verticesToDistances.replace(sourceVertex, 0);

        List<Vertex> verticesVisited = new LinkedList<>();
        while (!verticesToVisit.isEmpty()) {
            Vertex currentVertex = verticesToVisit.dequeue();
            verticesVisited.add(currentVertex);
            for (Vertex neighbor : currentVertex.getNeighbors()) {
                if (verticesToColors.get(neighbor).equals("white")) {
                    verticesToColors.replace(neighbor, "gray");
                    verticesToDistances.replace(neighbor, verticesToDistances.get(currentVertex) + EDGE_DISTANCE);
                    verticesToVisit.enqueue(neighbor);
                }
            }
            verticesToColors.replace(currentVertex, "black");
        }
        return verticesVisited;
    }
}
