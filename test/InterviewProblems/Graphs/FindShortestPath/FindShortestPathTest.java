package InterviewProblems.Graphs.FindShortestPath;

import DataStructures.CustomDataStructures.Graph.GraphVertex;
import DataStructures.CustomDataStructures.Graph.UndirectedGraph.AdjacencyListImplementation.UndirectedGraph;
import DataStructures.CustomDataStructures.Graph.UndirectedGraph.AdjacencyListImplementation.Vertex;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.Deque;

public class FindShortestPathTest {

    private FindShortestPath findShortestPath;

    private UndirectedGraph graph;
    private GraphVertex vertex1, vertex2, vertex3, vertex4, vertex5, vertex6, vertex7, vertex8;

    @BeforeEach
    void setUp() {
        findShortestPath = new FindShortestPath();

        graph = new UndirectedGraph();
        vertex1 = new Vertex(1);
        vertex2 = new Vertex(2);
        vertex3 = new Vertex(3);
        vertex4 = new Vertex(4);
        vertex5 = new Vertex(5);
        vertex6 = new Vertex(6);
        vertex7 = new Vertex(7);
        vertex8 = new Vertex(8);

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
    }

    @AfterEach
    void tearDown() {

    }

    @Test
    void testFindShortestPathFindShorterPath() {
        Deque<GraphVertex> expectedPath = new ArrayDeque<>();
        expectedPath.add(vertex1);
        expectedPath.add(vertex2);
        expectedPath.add(vertex5);
        Assertions.assertTrue(
            findShortestPath.getShortestPath(graph, vertex1, vertex5).containsAll(expectedPath) &&
            expectedPath.containsAll(findShortestPath.getShortestPath(graph, vertex1, vertex5))
        );
    }

    @Test
    void setFindShortestPathLongestPossiblePath() {
        Deque<GraphVertex> expectedPath = new ArrayDeque<>();
        expectedPath.add(vertex1);
        expectedPath.add(vertex2);
        expectedPath.add(vertex4);
        expectedPath.add(vertex8);
        Assertions.assertTrue(
            findShortestPath.getShortestPath(graph, vertex1, vertex8).containsAll(expectedPath) &&
            expectedPath.containsAll(findShortestPath.getShortestPath(graph, vertex1, vertex8))
        );
    }
}
