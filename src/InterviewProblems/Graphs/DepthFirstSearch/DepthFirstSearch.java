package InterviewProblems.Graphs.DepthFirstSearch;

import DataStructures.CustomDataStructures.Graph.GraphVertex;
import DataStructures.CustomDataStructures.Graph.UndirectedGraph.AdjacencyListImplementation.UndirectedGraph;
import DataStructures.CustomDataStructures.Graph.UndirectedGraph.AdjacencyListImplementation.Vertex;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

class DepthFirstSearch {

    // DFS source code: https://mcsapps.utm.utoronto.ca/slidechat/5f49771dd89c8059833766fc/24

    // time: Theta(|V| + |E|)
    // space: Theta(longest path in graph)

    List<GraphVertex> depthFirstSearch(UndirectedGraph graph) {
        Map<GraphVertex, String> verticesToColors = new HashMap<>();
        Map<GraphVertex, GraphVertex> verticesToPredecessors = new HashMap<>();
        for (GraphVertex vertex : graph.getVertices()) {
            verticesToColors.put(vertex, "white");
            verticesToPredecessors.put(vertex, null);
        }

        List<GraphVertex> verticesVisited = new LinkedList<>();
        for (GraphVertex vertex : graph.getVertices()) {
            if (verticesToColors.get(vertex).equals("white")) {
                depthFirstSearch(vertex, verticesVisited, verticesToColors, verticesToPredecessors);
            }
        }
        return verticesVisited;
    }

    private void depthFirstSearch(GraphVertex vertex, List<GraphVertex> verticesVisited,
                                  Map<GraphVertex, String> verticesToColors,
                                  Map<GraphVertex, GraphVertex> verticesToPredecessors) {
        verticesVisited.add(vertex);
        verticesToColors.replace(vertex, "gray");
        for (GraphVertex neighbor : ((Vertex) vertex).getNeighbors()) {
            if (verticesToColors.get(neighbor).equals("white")) {
                verticesToPredecessors.replace(neighbor, vertex);
                depthFirstSearch(neighbor, verticesVisited, verticesToColors, verticesToPredecessors);
            }
            verticesToColors.replace(vertex, "black");
        }
    }
}
