package InterviewProblems.GraphProblems.DepthFirstSearch;

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

    List<Vertex> depthFirstSearch(UndirectedGraph graph) {
        Map<Vertex, String> verticesToColors = new HashMap<>();
        Map<Vertex, Vertex> verticesToPredecessors = new HashMap<>();
        for (Vertex vertex : graph.getVertices()) {
            verticesToColors.put(vertex, "white");
            verticesToPredecessors.put(vertex, null);
        }

        List<Vertex> verticesVisited = new LinkedList<>();
        for (Vertex vertex : graph.getVertices()) {
            if (verticesToColors.get(vertex).equals("white")) {
                depthFirstSearch(vertex, verticesVisited, verticesToColors, verticesToPredecessors);
            }
        }
        return verticesVisited;
    }

    private void depthFirstSearch(Vertex vertex, List<Vertex> verticesVisited,
                                  Map<Vertex, String> verticesToColors,
                                  Map<Vertex, Vertex> verticesToPredecessors) {
        verticesVisited.add(vertex);
        verticesToColors.replace(vertex, "gray");
        for (Vertex neighbor : vertex.getNeighbors()) {
            if (verticesToColors.get(neighbor).equals("white")) {
                verticesToPredecessors.replace(neighbor, vertex);
                depthFirstSearch(neighbor, verticesVisited, verticesToColors, verticesToPredecessors);
            }
            verticesToColors.replace(vertex, "black");
        }
    }
}
