package main.java.Impl.leetcode.year2019;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GraphValidTree {

    /*
    261. Graph Valid Tree

    Given n nodes labeled from 0 to n-1 and a list of undirected edges (each edge is a pair of nodes), write a function to check whether these edges make up a valid tree.

    Example 1:
    Input: n = 5, and edges = [[0,1], [0,2], [0,3], [1,4]]
    Output: true

    Example 2:
    Input: n = 5, and edges = [[0,1], [1,2], [2,3], [1,3], [1,4]]
    Output: false
    Note: you can assume that no duplicate edges will appear in edges. Since all edges are undirected, [0,1] is the same as [1,0] and thus will not appear together in edges.
     */
    Set<Integer> set = new HashSet<>();
    List<Integer>[] adjLists;

    public boolean validTree(int n, int[][] edges) {
        adjLists = new ArrayList[n];
        for (int i = 0; i < n; i++){
            adjLists[i] = new ArrayList<>();
        }
        for (int[] e: edges)  {
            adjLists[e[0]].add(e[1]);
            adjLists[e[1]].add(e[0]);
        }
        return dfs(0, -1) && set.size() == n;
    }

    public boolean dfs(int node, int parent) {
        if (set.contains(node)) return false;
        set.add(node);
        for (int child : adjLists[node]) {
            if (child == parent) continue;
            if(!dfs(child, node)) return false;
        }
        return true;
    }
}
