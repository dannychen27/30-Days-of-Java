package InterviewProblems.Graphs.FindCenterOfStarGraph.OptimalSolution;

public class FindCenterOfStarGraph {

    // Let V be the number of vertices in the graph.
    //
    // Time: O(1)
    // --> We only need to check at most 2 edges to determine the center of the star graph.
    // Space: O(1)
    // --> We don't require additional data structures.

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
        // The center is the only node that has more than one edge.
        // The center is also connected to all other nodes.
        // Any two edges must have a common node, which is the center.

        // Therefore, we only need to check the first 2 edges
        // to determine the center of this star graph.
        if (edges[0][0] == edges[1][0] || edges[0][0] == edges[1][1]) {
            return edges[0][0];
        } else {  // edges[0][1] == edges[1][0] || edges[0][1] == edges[1][1]
            return edges[0][1];
        }
    }
}
