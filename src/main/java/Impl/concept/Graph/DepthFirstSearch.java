package main.java.Impl.concept.Graph;

import java.util.Iterator;
import java.util.Stack;

import main.java.model.GraphNode;

public class DepthFirstSearch {

    public void printDepthFirstSearchTraversal(GraphNode graphNode, int currentNode) {
        boolean[] visited = new boolean[graphNode.v];
        Stack<Integer> stack = new Stack<>();

        visited[currentNode] = true;
        stack.push(currentNode);

        while (!stack.isEmpty()) {
            currentNode = stack.pop();
            System.out.print(currentNode + " ");
            Iterator<Integer> i = graphNode.adj[currentNode].listIterator();
            while (i.hasNext()) {
                int n = i.next();
                visited[n] = true;
                stack.push(n);
            }
        }
    }
}
