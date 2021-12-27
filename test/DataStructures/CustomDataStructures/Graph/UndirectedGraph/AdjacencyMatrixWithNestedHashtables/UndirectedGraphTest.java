package DataStructures.CustomDataStructures.Graph.UndirectedGraph.AdjacencyMatrixWithNestedHashtables;

import DataStructures.CustomDataStructures.Graph.GraphVertex;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

class UndirectedGraphTest {

    private UndirectedGraph largeUndirectedGraph;
    private UndirectedGraph smallUndirectedGraph;

    private GraphVertex vertex1;
    private GraphVertex vertex2;
    private GraphVertex vertex3;
    private GraphVertex vertex4;
    private GraphVertex vertex5;
    private GraphVertex vertex6;
    private GraphVertex vertex7;
    private GraphVertex vertex8;
    private GraphVertex vertex9;

    @BeforeEach
    void setUp() {
        largeUndirectedGraph = new UndirectedGraph();
        vertex1 = new Vertex(1);
        vertex2 = new Vertex(2);
        vertex3 = new Vertex(3);
        vertex4 = new Vertex(4);
        vertex5 = new Vertex(5);
        vertex6 = new Vertex(6);
        vertex7 = new Vertex(7);

        largeUndirectedGraph.addVertex(vertex1);
        largeUndirectedGraph.addVertex(vertex2);
        largeUndirectedGraph.addVertex(vertex3);
        largeUndirectedGraph.addVertex(vertex4);
        largeUndirectedGraph.addVertex(vertex5);
        largeUndirectedGraph.addVertex(vertex6);
        largeUndirectedGraph.addVertex(vertex7);

        largeUndirectedGraph.addEdge(vertex1, vertex2);
        largeUndirectedGraph.addEdge(vertex1, vertex3);
        largeUndirectedGraph.addEdge(vertex2, vertex4);
        largeUndirectedGraph.addEdge(vertex2, vertex5);
        largeUndirectedGraph.addEdge(vertex3, vertex6);
        largeUndirectedGraph.addEdge(vertex3, vertex7);

        smallUndirectedGraph = new UndirectedGraph();

        vertex8 = new Vertex(8);
        vertex9 = new Vertex(9);

        smallUndirectedGraph.addVertex(vertex8);
        smallUndirectedGraph.addVertex(vertex9);

        smallUndirectedGraph.addEdge(vertex8, vertex9);
        smallUndirectedGraph.removeEdge(vertex8, vertex9);

        smallUndirectedGraph.removeVertex(vertex8);
        smallUndirectedGraph.removeVertex(vertex9);
    }

    @AfterEach
    void tearDown() {

    }

    @Test
    void testIsEmptyForEmptyUndirectedGraph() {
        Assert.assertTrue(smallUndirectedGraph.isEmpty());
    }

    @Test
    void testIsEmptyForNonemptyUndirectedGraph() {
        Assert.assertFalse(largeUndirectedGraph.isEmpty());
    }

    @Test
    void testAddVertex() {
        Set<GraphVertex> expectedVertices = new HashSet<>();
        expectedVertices.addAll(Arrays.asList(vertex1, vertex2, vertex3, vertex4,
                                              vertex5, vertex6, vertex7));

        HashSet<GraphVertex> actualVertices = new HashSet<>();
        actualVertices.addAll(largeUndirectedGraph.getVertices());

        Assert.assertEquals(expectedVertices, actualVertices);
    }

    @Test
    void testRemoveVertex() {
        List<GraphVertex> expectedVertices = new LinkedList<>();
        Assert.assertEquals(expectedVertices, smallUndirectedGraph.getVertices());
    }

    @Test
    void testAddEdge() {
        Set<List<GraphVertex>> expectedEdges = new HashSet<>();
        List<GraphVertex> edge1ToEdge2 = createEdgeBetween(vertex1, vertex2);
        List<GraphVertex> edge2ToEdge1 = createEdgeBetween(vertex2, vertex1);

        List<GraphVertex> edge1ToEdge3 = createEdgeBetween(vertex1, vertex3);
        List<GraphVertex> edge3ToEdge1 = createEdgeBetween(vertex3, vertex1);

        List<GraphVertex> edge2ToEdge4 = createEdgeBetween(vertex2, vertex4);
        List<GraphVertex> edge4ToEdge2 = createEdgeBetween(vertex4, vertex2);

        List<GraphVertex> edge2ToEdge5 = createEdgeBetween(vertex2, vertex5);
        List<GraphVertex> edge5ToEdge2 = createEdgeBetween(vertex5, vertex2);

        List<GraphVertex> edge3ToEdge6 = createEdgeBetween(vertex3, vertex6);
        List<GraphVertex> edge6ToEdge3 = createEdgeBetween(vertex6, vertex3);

        List<GraphVertex> edge3ToEdge7 = createEdgeBetween(vertex3, vertex7);
        List<GraphVertex> edge7ToEdge3 = createEdgeBetween(vertex7, vertex3);

        expectedEdges.addAll(Arrays.asList(
                edge1ToEdge2, edge1ToEdge3, edge2ToEdge1,
                edge2ToEdge4, edge2ToEdge5, edge3ToEdge1,
                edge3ToEdge6, edge3ToEdge7, edge4ToEdge2,
                edge5ToEdge2, edge6ToEdge3, edge7ToEdge3));

        HashSet<List<GraphVertex>> actualEdges = new HashSet<>();
        actualEdges.addAll(largeUndirectedGraph.getEdges());

        Assert.assertEquals(expectedEdges, actualEdges);
    }

    @Test
    void testRemoveEdge() {
        List<List<GraphVertex>> expectedEdges = new LinkedList<>();
        Assert.assertEquals(expectedEdges, smallUndirectedGraph.getEdges());
    }

    @Test
    void testToStringForEmptyUndirectedGraph() {
        String expectedString = "";
        Assert.assertEquals(expectedString, smallUndirectedGraph.toString());
    }

    @Test
    void testToStringForNonEmptyUndirectedGraph() {
        // TODO: I cannot test the toString() method for a non-empty undirected graph
        // TODO: because the adjacency hashtable order might be different each time you
        // TODO: create a new instance of an undirected graph.
        // TODO: Therefore, their string representations might differ.
    }

    private List<GraphVertex> createEdgeBetween(GraphVertex startVertex, GraphVertex endVertex) {
        List<GraphVertex> newEdge = new LinkedList<>();
        newEdge.add(startVertex);
        newEdge.add(endVertex);
        return newEdge;
    }
}
