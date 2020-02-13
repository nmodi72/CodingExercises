package main.java.Impl.concept.Graph;

import java.util.Iterator;
import java.util.LinkedList;

import main.java.model.GraphNode;

public class BreadthFirstSearch {

    public void breadthFirstSearchPrintNodes(GraphNode graphNode, int currentNode) {
        boolean[] visited = new boolean[graphNode.v];
        LinkedList<Integer> queue = new LinkedList<>();

        visited[currentNode] = true;
        queue.add(currentNode);
        while (!queue.isEmpty()) {
            currentNode = queue.poll();
            System.out.print(currentNode + " ");
            Iterator<Integer> i = graphNode.adj[currentNode].listIterator();
            while (i.hasNext()) {
                int n = i.next();
                if(!visited[n]) {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
    }
}
