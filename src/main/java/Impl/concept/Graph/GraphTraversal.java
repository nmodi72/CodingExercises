package main.java.Impl.concept.Graph;

import java.util.LinkedList;
import java.util.List;

public class GraphTraversal {



    static class GraphTraversalGraph {
        int vertices;
        LinkedList<Integer> adjLists[];

        GraphTraversalGraph(int vertices) {
            this.vertices = vertices;
            adjLists = new LinkedList[vertices];
            for(int i = 0; i < vertices; i++) {
                adjLists[i] = new LinkedList<>();
            }
        }

        void addEdges(GraphTraversalGraph graph, int src, int dest) {
            graph.adjLists[src].add(dest);

        }
    }

}
