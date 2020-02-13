package main.java.model;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * Definition for graph
 */
public class GraphNode {
    public int v;
    public LinkedList<Integer>[] adj;

    public GraphNode(int v) {
        this.v = v;
        this.adj = new LinkedList[v];
        for (int i=0; i < v; ++i)
            adj[i] = new LinkedList();
    }

    // Function to add an edge into the graph
    public void addEdge(int v,int w) {
        adj[v].add(w);
    }
}
