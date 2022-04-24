package InterviewProblems.Graphs.FindCenterOfStarGraph.HashsetSolution;

import java.util.HashSet;
import java.util.Set;

public class FindCenterOfStarGraph {

    // Let V be the number of vertices in the graph.
    //
    // Time: O(V)
    // --> We must visit each vertex at most once.
    // Space: O(V)
    // --> We must store the labels of all V - 1 vertices.

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
        Set<Integer> set = new HashSet<>();
        for (int[] edge : edges) {
            int edge1 = edge[0];
            int edge2 = edge[1];

            if (set.contains(edge1)) {
                return edge1;
            }

            if (set.contains(edge2)) {
                return edge2;
            }

            set.add(edge1);
            set.add(edge2);
        }
        return -1;  // This should never happen.
    }
}
