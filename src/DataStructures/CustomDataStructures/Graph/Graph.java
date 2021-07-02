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
    // int getDegree(Vertex vertex);  // TODO; or indegree/outdegree methods for directed graphs
    // List<Vertex> getPath(Vertex startVertex, Vertex endVertex);
    // boolean hasPath(Vertex startVertex, Vertex endVertex);  // TODO: simple vs. complex path?
    // int getPathLength(Vertex startVertex, Vertex endVertex);
    // boolean isConnected(Vertex vertex1, Vertex vertex2);
    // boolean isConnected();
    // boolean hasCycle();
    // boolean isTree();
    // boolean isSpanningTree();
    // boolean isMinimumSpanningTree();
    // boolean isSubgraph(Graph otherGraph);
}

