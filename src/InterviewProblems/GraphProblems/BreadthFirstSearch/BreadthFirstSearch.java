package InterviewProblems.GraphProblems.BreadthFirstSearch;

import DataStructures.CustomDataStructures.Graph.Graph;
import DataStructures.CustomDataStructures.Graph.Vertex;

import java.util.HashMap;
import java.util.LinkedList;

class BreadthFirstSearch {

    public static void main(String[] args) {
        // source: https://www.youtube.com/watch?v=0XgVhsMOcQM&list=PLI1t_8YX-ApvMthLj56t1Rf-Buio5Y8KL&index=4&t=53s
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

        // BFS source code: https://mcsapps.utm.utoronto.ca/slidechat/5f49771dd89c8059833766fc/24
        breadthFirstSearch(graph, vertex1);  // 1 2 3 4 5 6 7
    }

    private static void breadthFirstSearch(Graph graph, Vertex sourceVertex) {
        HashMap<Vertex, String> verticesToColors = new HashMap<>();
        HashMap<Vertex, Integer> verticesToDistances = new HashMap<>();
        for (Vertex vertex : graph.vertices) {
            verticesToColors.put(vertex, "white");
            verticesToDistances.put(vertex, Integer.MAX_VALUE);
        }

        LinkedList<Vertex> verticesToVisit = new LinkedList<>();
        verticesToVisit.add(sourceVertex);
        verticesToColors.replace(sourceVertex, "gray");
        verticesToDistances.replace(sourceVertex, 0);

        while (!verticesToVisit.isEmpty()) {
            Vertex currentVertex = verticesToVisit.poll();
            System.out.print(currentVertex + " ");
            for (Vertex neighbor : currentVertex.neighbors) {
                if (verticesToColors.get(neighbor).equals("white")) {
                    verticesToColors.replace(neighbor, "gray");
                    verticesToDistances.replace(neighbor, verticesToDistances.get(currentVertex) + 1);
                    verticesToVisit.add(neighbor);
                }
            }
            verticesToColors.replace(currentVertex, "black");
        }
        System.out.print("\n");
    }
}
