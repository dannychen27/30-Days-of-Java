package DataStructures.CustomDataStructures.Graph;

import java.util.List;

public interface Graph {

    // basic graph operations
    void addVertex(GraphVertex newVertex);
    void removeVertex(GraphVertex oldVertex);
    void addEdge(GraphVertex vertex1, GraphVertex vertex2);  // TODO: are self-edges allowed?
    void removeEdge(GraphVertex vertex1, GraphVertex vertex2);
    List<GraphVertex> getVertices();
    List<List<GraphVertex>> getEdges();
    String toString();

    // edge and vertex queries
    // boolean isAdjacent(GraphVertex vertex1, GraphVertex vertex2);
    // List<GraphVertex> getNeighbors(GraphVertex vertex);

    // TODO: for undirected graphs only
    // int getDegree(GraphVertex vertex);

    // TODO: for directed graphs only
    // int getInDegree(GraphVertex vertex);
    // int getOutDegree(GraphVertex vertex);

    // TODO: for unweighted graphs, weights are either 0 or 1.
    // TODO: for weighted graphs, weights are either real numbers or infinity.

    // List<GraphVertex> getPath(GraphVertex startVertex, GraphVertex endVertex);
    // boolean hasPath(GraphVertex startVertex, GraphVertex endVertex);  // TODO: simple vs. complex path?
    // int getPathLength(GraphVertex startVertex, GraphVertex endVertex);
    // boolean isConnected(GraphVertex vertex1, GraphVertex vertex2); // vertex connectedness
    // boolean isConnected();  // graph connectedness
    // boolean hasCycle();
    // boolean isTree();
    // boolean isSpanningTree();
    // boolean isMinimumSpanningTree();
    // boolean isSubgraph(Graph otherGraph);
    // boolean isComplete();
}

