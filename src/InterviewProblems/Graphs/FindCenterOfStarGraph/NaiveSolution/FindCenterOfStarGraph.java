package InterviewProblems.Graphs.FindCenterOfStarGraph.NaiveSolution;

import java.util.HashMap;
import java.util.Map;

public class FindCenterOfStarGraph {

    // Let V be the number of vertices in the graph.
    //
    // Time: O(V)
    // --> O(V) to determine the degree of all V - 1 vertices
    // --> O(V) to find the maximum value of the vertex label for all V - 1 vertices.
    // --> O(V) to determine the center vertex of the star graph among V - 1 vertices.
    // Space: O(V)
    // --> We must store the degrees of all V vertices in a hashmap.

    public static void main(String[] args) {
        FindCenterOfStarGraph findCenterOfStarGraph = new FindCenterOfStarGraph();

        // Input: edges = [[1, 2], [2, 3]]
        // Output: 2
        // Explanation: As shown in the figure above, node 2 is connected to
        // every other node, so 2 is the center.
        int[][] edges1 = {{1, 2}, {2, 3}};
        int center1 = findCenterOfStarGraph.findCenter(edges1);
        System.out.println(center1);  // 2

        // Input: edges = [[1, 2], [2, 3], [4, 2]]
        // Output: 2
        // Explanation: As shown in the figure above, node 2 is connected to
        // every other node, so 2 is the center.
        int[][] edges2 = {{1, 2}, {2, 3}, {4, 2}};
        int center2 = findCenterOfStarGraph.findCenter(edges2);
        System.out.println(center2);  // 2

        // Input: edges = [[1, 2], [5, 1], [1, 3], [1, 4]]
        // Output: 1
        // Explanation: As shown in the figure above, node 1 is connected to
        // every other node, so 1 is the center.
        int[][] edges3 = {{1, 2}, {5, 1}, {1, 3}, {1, 4}};
        int center3 = findCenterOfStarGraph.findCenter(edges3);
        System.out.println(center3);  // 1
    }

    /**
     * There is an undirected star graph consisting of n nodes labeled from 1 to n.
     * A star graph is a graph where there is one center node and exactly n - 1 edges
     * that connect the center node with every other node.
     *
     * You are given a 2D integer array edges where each edges[i] = [ui, vi]
     * indicates that there is an edge between the nodes ui and vi. Return the center of the given star graph.
     *
     * Preconditions:
     * - 3 <= n <= 10 ^ 5
     * - edges.length == n - 1
     * - edges[i].length == 2
     * - 1 <= ui, vi <= n
     * - ui != vi
     * - The given edges represent a valid star graph. (undirected graph)
     */
    public int findCenter(int[][] edges) {
        // find degree n - 1 node by counting the number of edges that connect to it.
        Map<Integer, Integer> verticesToCounts = countVertexEdges(edges);
        int maxVertex = getMaxVertex(verticesToCounts);
        return getCenterOfGraph(verticesToCounts, maxVertex);
    }

    private Map<Integer, Integer> countVertexEdges(int[][] edges) {
        Map<Integer, Integer> verticesToCounts = new HashMap<>();
        for (int[] edge : edges) {
            // This is an undirected graph.
            int vertex1 = edge[0];
            int vertex2 = edge[1];
            verticesToCounts.put(vertex1, verticesToCounts.getOrDefault(vertex1, 0) + 1);
            verticesToCounts.put(vertex2, verticesToCounts.getOrDefault(vertex2, 0) + 1);
        }
        return verticesToCounts;
    }

    private int getMaxVertex(Map<Integer, Integer> verticesToCounts) {
        int maxVertex = -1;
        for (int vertexLabel : verticesToCounts.values()) {
            if (vertexLabel > maxVertex) {
                maxVertex = vertexLabel;
            }
        }
        return maxVertex;
    }

    private int getCenterOfGraph(Map<Integer, Integer> verticesToCounts, int maxVertex) {
        for (int vertexLabel : verticesToCounts.keySet()) {
            if (verticesToCounts.get(vertexLabel) == maxVertex) {
                return vertexLabel;
            }
        }
        return -1;  // This should never happen.
    }
}
