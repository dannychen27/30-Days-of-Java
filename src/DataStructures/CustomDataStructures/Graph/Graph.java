package DataStructures.CustomDataStructures.Graph;

import java.util.List;

public interface Graph {

    // basic graph operations
    void addVertex(Vertex newVertex);
    void removeVertex(Vertex oldVertex);
    void addEdge(Vertex vertex1, Vertex vertex2);  // TODO: are self-edges allowed?
    void removeEdge(Vertex vertex1, Vertex vertex2);
    List<Vertex> getVertices();
    List<List<Vertex>> getEdges();
    String toString();

    // edge and vertex queries
    // boolean isAdjacent(Vertex vertex1, Vertex vertex2);
    // List<Vertex> getNeighbors(Vertex vertex);

    // TODO: for undirected graphs only
    // int getDegree(Vertex vertex);

    // TODO: for directed graphs only
    // int getInDegree(Vertex vertex);
    // int getOutDegree(Vertex vertex);

    // TODO: for unweighted graphs, weights are either 0 or 1.
    // TODO: for weighted graphs, weights are either real numbers or infinity.

    // List<Vertex> getPath(Vertex startVertex, Vertex endVertex);
    // boolean hasPath(Vertex startVertex, Vertex endVertex);  // TODO: simple vs. complex path?
    // int getPathLength(Vertex startVertex, Vertex endVertex);
    // boolean isConnected(Vertex vertex1, Vertex vertex2); // vertex connectedness
    // boolean isConnected();  // graph connectedness
    // boolean hasCycle();
    // boolean isTree();
    // boolean isSpanningTree();
    // boolean isMinimumSpanningTree();
    // boolean isSubgraph(Graph otherGraph);
    // boolean isComplete();
}

