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

    // find the shortest path from a source vertex to a destination vertex

    // time: Theta(|V| + |E|)
    // space: Theta(|V| + |E|)

    Deque<GraphVertex> getShortestPath(UndirectedGraph graph, GraphVertex sourceVertex, GraphVertex destinationVertex) {
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

    private Deque<GraphVertex> buildShortestPath(GraphVertex destinationVertex, Map<GraphVertex, GraphVertex> verticesToPredecessors) {
        Deque<GraphVertex> shortestPath = new ArrayDeque<>();
        GraphVertex currentVertex = destinationVertex;
        while (currentVertex != null) {
            shortestPath.addFirst(currentVertex);
            currentVertex = verticesToPredecessors.get(currentVertex);
        }
        return shortestPath;
    }
}
