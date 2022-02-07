package InterviewProblems.Graphs.BreadthFirstSearch;

import DataStructures.CustomDataStructures.Graph.GraphVertex;
import DataStructures.CustomDataStructures.Graph.UndirectedGraph.AdjacencyListImplementation.UndirectedGraph;
import DataStructures.CustomDataStructures.Graph.UndirectedGraph.AdjacencyListImplementation.Vertex;
import DataStructures.CustomDataStructures.Queue.Queue;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import static DataStructures.CustomDataStructures.Graph.UndirectedGraph.AdjacencyListImplementation.UndirectedGraph.EDGE_DISTANCE;

class BreadthFirstSearch {

    // BFS source code: https://mcsapps.utm.utoronto.ca/slidechat/5f49771dd89c8059833766fc/24
    // source: https://www.youtube.com/watch?v=0XgVhsMOcQM&list=PLI1t_8YX-ApvMthLj56t1Rf-Buio5Y8KL&index=4&t=53s

    // time: Theta(|V| + |E|)
    // space: Theta(|V| + |E|)

    List<GraphVertex> breadthFirstSearch(UndirectedGraph graph, Vertex sourceVertex) {
        Map<GraphVertex, String> verticesToColors = new HashMap<>();
        Map<GraphVertex, Integer> verticesToDistances = new HashMap<>();
        for (GraphVertex vertex : graph.getVertices()) {
            verticesToColors.put(vertex, "white");
            verticesToDistances.put(vertex, Integer.MAX_VALUE);
        }

        Queue<GraphVertex> verticesToVisit = new Queue<>();
        verticesToVisit.enqueue(sourceVertex);
        verticesToColors.replace(sourceVertex, "gray");
        verticesToDistances.replace(sourceVertex, 0);

        List<GraphVertex> verticesVisited = new LinkedList<>();
        while (!verticesToVisit.isEmpty()) {
            GraphVertex currentVertex = verticesToVisit.dequeue();
            verticesVisited.add(currentVertex);
            for (GraphVertex neighbor : ((Vertex) currentVertex).getNeighbors()) {
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
