package main.java.Impl.leetcode.year2019;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class IsGraphBipartie {
    /*
    785. Is Graph Bipartite?
    Given an undirected graph, return true if and only if it is bipartite.

    Recall that a graph is bipartite if we can split it's set of nodes into two independent subsets A and B such that every edge in the graph has one node in A and another node in B.

    The graph is given in the following form: graph[i] is a list of indexes j for which the edge between nodes i and j exists.  Each node is an integer between 0 and graph.length - 1.  There are no self edges or parallel edges: graph[i] does not contain i, and it doesn't contain any element twice.

    Example 1:
    Input: [[1,3], [0,2], [1,3], [0,2]]
    Output: true
    Explanation:
    The graph looks like this:
    0----1
    |    |
    |    |
    3----2
    We can divide the vertices into two groups: {0, 2} and {1, 3}.
    Example 2:
    Input: [[1,2,3], [0,2], [0,1,3], [0,2]]
    Output: false
    Explanation:
    The graph looks like this:
    0----1
    | \  |
    |  \ |
    3----2
    We cannot find a way to divide the set of nodes into two independent subsets.
     */
    int[] visitedData;

    public boolean isBipartite(int[][] graph) {
        Map<Integer, List<Integer>> data = new HashMap<>();
        for (int i = 0; i < graph.length; i++) {
            List<Integer> l = data.getOrDefault(i, new ArrayList<>());
            for (int j = 0; j < graph[i].length; j++) {
                l.add(graph[i][j]);
            }
            data.put(i, l);
        }
        visitedData = new int[data.size()];
        for (int i = 0; i < visitedData.length; i++) {
            if(visitedData[i] == 0) {
                if(!performBFS(i, data)) return false;
            }
        }
        return true;
    }

    private boolean performBFS(int rootNode, Map<Integer, List<Integer>> data) {
        Queue<Integer> q = new LinkedList<>();
        q.add(rootNode); // traverse from first element
        int lastElement = -1;
        visitedData[rootNode] = lastElement; // we will group into 2 groups: -1 n -2
        while(!q.isEmpty()) {
            int size = q.size();
            lastElement = lastElement == -1 ? -2 : -1;
            for (int i = 0; i < size; i++) {
                Integer poll = q.poll();
                List<Integer> childs = data.getOrDefault(poll, new ArrayList<>());
                for (int c = 0; c < childs.size(); c++) {
                    int childElement = childs.get(c);
                    if(visitedData[childElement] == lastElement) continue;
                    if (visitedData[childElement] != 0) return false;
                    visitedData[childElement] = lastElement;
                    q.add(childElement);
                }
            }
        }
        return true;
    }

}
