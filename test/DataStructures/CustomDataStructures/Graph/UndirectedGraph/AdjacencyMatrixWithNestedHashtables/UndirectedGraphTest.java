package DataStructures.CustomDataStructures.Graph.UndirectedGraph.AdjacencyMatrixWithNestedHashtables;

import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

class UndirectedGraphTest {

    private UndirectedGraph largeUndirectedGraph;
    private UndirectedGraph smallUndirectedGraph;

    private Vertex vertex1;
    private Vertex vertex2;
    private Vertex vertex3;
    private Vertex vertex4;
    private Vertex vertex5;
    private Vertex vertex6;
    private Vertex vertex7;
    private Vertex vertex8;
    private Vertex vertex9;

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
        Set<Vertex> expectedVertices = new HashSet<>();
        expectedVertices.addAll(Arrays.asList(vertex1, vertex2, vertex3, vertex4,
                                              vertex5, vertex6, vertex7));

        HashSet<Vertex> actualVertices = new HashSet<>();
        actualVertices.addAll(largeUndirectedGraph.getVertices());

        Assert.assertEquals(expectedVertices, actualVertices);
    }

    @Test
    void testRemoveVertex() {
        List<Vertex> expectedVertices = new LinkedList<>();
        Assert.assertEquals(expectedVertices, smallUndirectedGraph.getVertices());
    }

    @Test
    void testAddEdge() {
        Set<List<Vertex>> expectedEdges = new HashSet<>();
        List<Vertex> edge1ToEdge2 = createEdgeBetween(vertex1, vertex2);
        List<Vertex> edge2ToEdge1 = createEdgeBetween(vertex2, vertex1);

        List<Vertex> edge1ToEdge3 = createEdgeBetween(vertex1, vertex3);
        List<Vertex> edge3ToEdge1 = createEdgeBetween(vertex3, vertex1);

        List<Vertex> edge2ToEdge4 = createEdgeBetween(vertex2, vertex4);
        List<Vertex> edge4ToEdge2 = createEdgeBetween(vertex4, vertex2);

        List<Vertex> edge2ToEdge5 = createEdgeBetween(vertex2, vertex5);
        List<Vertex> edge5ToEdge2 = createEdgeBetween(vertex5, vertex2);

        List<Vertex> edge3ToEdge6 = createEdgeBetween(vertex3, vertex6);
        List<Vertex> edge6ToEdge3 = createEdgeBetween(vertex6, vertex3);

        List<Vertex> edge3ToEdge7 = createEdgeBetween(vertex3, vertex7);
        List<Vertex> edge7ToEdge3 = createEdgeBetween(vertex7, vertex3);

        expectedEdges.addAll(Arrays.asList(
                edge1ToEdge2, edge1ToEdge3, edge2ToEdge1,
                edge2ToEdge4, edge2ToEdge5, edge3ToEdge1,
                edge3ToEdge6, edge3ToEdge7, edge4ToEdge2,
                edge5ToEdge2, edge6ToEdge3, edge7ToEdge3));

        HashSet<List<Vertex>> actualEdges = new HashSet<>();
        actualEdges.addAll(largeUndirectedGraph.getEdges());

        Assert.assertEquals(expectedEdges, actualEdges);
    }

    @Test
    void testToStringForEmptyUndirectedGraph() {
        String expectedString = "";
        Assert.assertEquals(expectedString, smallUndirectedGraph.toString());
    }

    // TODO: I cannot test the toString() method for a non-empty undirected graph
    // TODO: because the adjacency hashtable order might be different each time you
    // TODO: create a new instance of an undirected graph.
    // TODO: Therefore, their string representations might differ.

    @Test
    void testRemoveEdge() {
        List<List<Vertex>> expectedEdges = new LinkedList<>();
        Assert.assertEquals(expectedEdges, smallUndirectedGraph.getEdges());
    }

    private List<Vertex> createEdgeBetween(Vertex startVertex, Vertex endVertex) {
        List<Vertex> newEdge = new LinkedList<>();
        newEdge.add(startVertex);
        newEdge.add(endVertex);
        return newEdge;
    }
}