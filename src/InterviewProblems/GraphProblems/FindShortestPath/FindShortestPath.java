package InterviewProblems.GraphProblems.FindShortestPath;

import DataStructures.CustomDataStructures.Graph.AdjacencyListImplementation.UndirectedGraph;
import DataStructures.CustomDataStructures.Graph.AdjacencyListImplementation.Vertex;
import DataStructures.CustomDataStructures.Queue.Queue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

import static DataStructures.CustomDataStructures.Graph.AdjacencyListImplementation.UndirectedGraph.EDGE_DISTANCE;

class FindShortestPath {

    public static void main(String[] args) {
        // find the shortest path from a source vertex to a destination vertex

        // time: Theta(|V| + |E|)
        // space: Theta(|V| + |E|)

        UndirectedGraph graph = new UndirectedGraph();
        Vertex vertex1 = new Vertex(1);
        Vertex vertex2 = new Vertex(2);
        Vertex vertex3 = new Vertex(3);
        Vertex vertex4 = new Vertex(4);
        Vertex vertex5 = new Vertex(5);
        Vertex vertex6 = new Vertex(6);
        Vertex vertex7 = new Vertex(7);
        Vertex vertex8 = new Vertex(8);

        graph.addVertex(vertex1);
        graph.addVertex(vertex2);
        graph.addVertex(vertex3);
        graph.addVertex(vertex4);
        graph.addVertex(vertex5);
        graph.addVertex(vertex6);
        graph.addVertex(vertex7);
        graph.addVertex(vertex8);

        graph.addEdge(vertex1, vertex2);
        graph.addEdge(vertex1, vertex3);
        graph.addEdge(vertex2, vertex4);
        graph.addEdge(vertex2, vertex5);
        graph.addEdge(vertex3, vertex6);
        graph.addEdge(vertex3, vertex7);
        graph.addEdge(vertex4, vertex8);

        System.out.println(getShortestPath(graph, vertex1, vertex5));  // [1, 2, 5]
        System.out.println(getShortestPath(graph, vertex1, vertex8));  // [1, 2, 4, 8]
    }

    private static Deque<Vertex> getShortestPath(UndirectedGraph graph, Vertex sourceVertex, Vertex destinationVertex) {
        Map<Vertex, String> verticesToColors = new HashMap<>();
        Map<Vertex, Integer> verticesToDistances = new HashMap<>();
        Map<Vertex, Vertex> verticesToPredecessors = new HashMap<>();
        for (Vertex vertex : graph.getVertices()) {
            verticesToColors.put(vertex, "white");
            verticesToDistances.put(vertex, Integer.MAX_VALUE);
            verticesToPredecessors.put(vertex, null);
        }

        Queue<Vertex> verticesToVisit = new Queue<>();
        verticesToVisit.enqueue(sourceVertex);
        verticesToColors.replace(sourceVertex, "gray");
        verticesToDistances.replace(sourceVertex, 0);

        while (!verticesToVisit.isEmpty()) {
            Vertex currentVertex = verticesToVisit.dequeue();
            if (currentVertex == destinationVertex) {
                return buildShortestPath(destinationVertex, verticesToPredecessors);
            }

            for (Vertex neighbor : currentVertex.getNeighbors()) {
                if (verticesToColors.get(neighbor).equals("white")) {
                    verticesToColors.replace(neighbor, "gray");
                    verticesToDistances.replace(neighbor, verticesToDistances.get(currentVertex) + EDGE_DISTANCE);
                    verticesToPredecessors.replace(neighbor, currentVertex);
                    verticesToVisit.enqueue(neighbor);
                }
            }
            verticesToColors.replace(currentVertex, "black");
        }
        return null;
    }

    private static Deque<Vertex> buildShortestPath(Vertex destinationVertex,
                                                   Map<Vertex, Vertex> verticesToPredecessors) {
        Deque<Vertex> shortestPath = new ArrayDeque<>();
        Vertex currentVertex = destinationVertex;
        while (currentVertex != null) {
            shortestPath.addFirst(currentVertex);
            currentVertex = verticesToPredecessors.get(currentVertex);
        }
        return shortestPath;
    }
}
