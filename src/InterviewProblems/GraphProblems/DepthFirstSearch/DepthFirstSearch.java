package InterviewProblems.GraphProblems.DepthFirstSearch;

import DataStructures.CustomDataStructures.Graph.Graph;
import DataStructures.CustomDataStructures.Graph.Vertex;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

class DepthFirstSearch {

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

        // DFS source code: https://mcsapps.utm.utoronto.ca/slidechat/5f49771dd89c8059833766fc/24
        System.out.println(depthFirstSearch(graph));  // [1, 2, 4, 5, 3, 6, 7]
    }

    private static List<Vertex> depthFirstSearch(Graph graph) {
        HashMap<Vertex, String> verticesToColors = new HashMap<>();
        HashMap<Vertex, Vertex> verticesToPredecessors = new HashMap<>();
        for (Vertex vertex : graph.vertices) {
            verticesToColors.put(vertex, "white");
            verticesToPredecessors.put(vertex, null);
        }

        List<Vertex> verticesVisited = new LinkedList<>();
        for (Vertex vertex : graph.vertices) {
            if (verticesToColors.get(vertex).equals("white")) {
                depthFirstSearch(vertex, verticesVisited, verticesToColors, verticesToPredecessors);
            }
        }
        return verticesVisited;
    }

    private static void depthFirstSearch(Vertex vertex, List<Vertex> verticesVisited,
                                         HashMap<Vertex, String> verticesToColors,
                                         HashMap<Vertex, Vertex> verticesToPredecessors) {
        verticesVisited.add(vertex);
        verticesToColors.replace(vertex, "gray");
        for (Vertex neighbor : vertex.neighbors) {
            if (verticesToColors.get(neighbor).equals("white")) {
                verticesToPredecessors.replace(neighbor, vertex);
                depthFirstSearch(neighbor, verticesVisited, verticesToColors, verticesToPredecessors);
            }
            verticesToColors.replace(vertex, "black");
        }
    }
}
