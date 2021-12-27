package InterviewProblems.GraphProblems.FindShortestPath;

import DataStructures.CustomDataStructures.Graph.GraphVertex;
import DataStructures.CustomDataStructures.Graph.UndirectedGraph.AdjacencyListImplementation.UndirectedGraph;
import DataStructures.CustomDataStructures.Graph.UndirectedGraph.AdjacencyListImplementation.Vertex;
import DataStructures.CustomDataStructures.Queue.Queue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

import static DataStructures.CustomDataStructures.Graph.UndirectedGraph.AdjacencyListImplementation.UndirectedGraph.EDGE_DISTANCE;

class FindShortestPath {

    public static void main(String[] args) {
        // find the shortest path from a source vertex to a destination vertex

        // time: Theta(|V| + |E|)
        // space: Theta(|V| + |E|)

        UndirectedGraph graph = new UndirectedGraph();
        GraphVertex vertex1 = new Vertex(1);
        GraphVertex vertex2 = new Vertex(2);
        GraphVertex vertex3 = new Vertex(3);
        GraphVertex vertex4 = new Vertex(4);
        GraphVertex vertex5 = new Vertex(5);
        GraphVertex vertex6 = new Vertex(6);
        GraphVertex vertex7 = new Vertex(7);
        GraphVertex vertex8 = new Vertex(8);

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

    private static Deque<GraphVertex> getShortestPath(UndirectedGraph graph,
                                                      GraphVertex sourceVertex, GraphVertex destinationVertex) {
        Map<GraphVertex, String> verticesToColors = new HashMap<>();
        Map<GraphVertex, Integer> verticesToDistances = new HashMap<>();
        Map<GraphVertex, GraphVertex> verticesToPredecessors = new HashMap<>();
        for (GraphVertex vertex : graph.getVertices()) {
            verticesToColors.put(vertex, "white");
            verticesToDistances.put(vertex, Integer.MAX_VALUE);
            verticesToPredecessors.put(vertex, null);
        }

        Queue<GraphVertex> verticesToVisit = new Queue<>();
        verticesToVisit.enqueue(sourceVertex);
        verticesToColors.replace(sourceVertex, "gray");
        verticesToDistances.replace(sourceVertex, 0);

        while (!verticesToVisit.isEmpty()) {
            GraphVertex currentVertex = verticesToVisit.dequeue();
            if (currentVertex == destinationVertex) {
                return buildShortestPath(destinationVertex, verticesToPredecessors);
            }

            for (GraphVertex neighbor : ((Vertex) currentVertex).getNeighbors()) {
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

    private static Deque<GraphVertex> buildShortestPath(GraphVertex destinationVertex,
                                                        Map<GraphVertex, GraphVertex> verticesToPredecessors) {
        Deque<GraphVertex> shortestPath = new ArrayDeque<>();
        GraphVertex currentVertex = destinationVertex;
        while (currentVertex != null) {
            shortestPath.addFirst(currentVertex);
            currentVertex = verticesToPredecessors.get(currentVertex);
        }
        return shortestPath;
    }
}
