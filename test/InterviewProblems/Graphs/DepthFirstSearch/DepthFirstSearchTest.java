package InterviewProblems.Graphs.DepthFirstSearch;

import DataStructures.CustomDataStructures.Graph.UndirectedGraph.AdjacencyListImplementation.UndirectedGraph;
import DataStructures.CustomDataStructures.Graph.UndirectedGraph.AdjacencyListImplementation.Vertex;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class DepthFirstSearchTest {

    private DepthFirstSearch dfs;

    private final UndirectedGraph tree = new UndirectedGraph();

    private final Vertex vertex1 = new Vertex(1);
    private final Vertex vertex2 = new Vertex(2);
    private final Vertex vertex3 = new Vertex(3);
    private final Vertex vertex4 = new Vertex(4);
    private final Vertex vertex5 = new Vertex(5);
    private final Vertex vertex6 = new Vertex(6);
    private final Vertex vertex7 = new Vertex(7);

    @BeforeEach
    void setUp() {
        dfs = new DepthFirstSearch();
        setUpTree();
    }

    @AfterEach
    void tearDown() {

    }

    private void setUpTree() {
        tree.addVertex(vertex1);
        tree.addVertex(vertex2);
        tree.addVertex(vertex3);
        tree.addVertex(vertex4);
        tree.addVertex(vertex5);
        tree.addVertex(vertex6);
        tree.addVertex(vertex7);

        tree.addEdge(vertex1, vertex2);
        tree.addEdge(vertex1, vertex3);
        tree.addEdge(vertex2, vertex4);
        tree.addEdge(vertex2, vertex5);
        tree.addEdge(vertex3, vertex6);
        tree.addEdge(vertex3, vertex7);
    }

    @Test
    void testOnTree() {
        List<Vertex> expectedValues = Arrays.asList(vertex1, vertex2, vertex4, vertex5, vertex3, vertex6, vertex7);
        Assertions.assertEquals(expectedValues, dfs.depthFirstSearch(tree));
    }
}
