package main.java.Impl.karat;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindAncestorsGraphKarat {
/*
    you're given a parent-child pairs

    parent_child_pairs_1 = [(1, 3), (2, 3), (3, 6), (5, 6), (5, 7), (4, 5),(4, 8), (4, 9), (9, 11), (14, 4), (13, 12), (12, 9)]

        14  13
         |   |
    1   2    4   12
     \ /   / | \ /
      3   5  8  9
       \ / \     \
        6   7     11
    Write a function that takes the graph, as well as two of the individuals in our dataset, as its inputs and returns true if and only if they share at least one ancestor.
    Sample input and output:

    has_common_ancestor(parent_child_pairs_1, 3, 8) => false
    has_common_ancestor(parent_child_pairs_1, 5, 8) => true
 */
  public static boolean hasCommonAncestor(int[][] parentChildPairs, int c1, int c2){
      Map<Integer, List<Integer>> childAncestors = new HashMap<>();
      for(int[] pair : parentChildPairs){
          childAncestors.putIfAbsent(pair[1], new ArrayList<>());
          childAncestors.get(pair[1]).add(pair[0]);
      }

      List<Integer> anc1 = new ArrayList<>();
      List<Integer> anc2 = new ArrayList<>();

      dfs(childAncestors, c1, anc1);
      dfs(childAncestors, c2, anc2);

      return !Collections.disjoint(anc1, anc2);
  }

  private static void dfs(Map<Integer, List<Integer>> childAncestors, int curr, List<Integer> anc){
      List<Integer> parents = childAncestors.get(curr);

      if(parents == null || parents.size() == 0) return;
      for(Integer child : parents){
          anc.add(child);
          dfs(childAncestors, child, anc);
      }
  }

  public static void main(String[] args) {
      int[][] parent_child_pairs_1 = {{1, 3}, {2, 3}, {3, 6}, {5, 6}, {5, 7}, {4, 5},{4, 8}, {4, 9}, {9, 11}, {14, 4}, {13, 12}, {12, 9}};
      System.out.println(hasCommonAncestor(parent_child_pairs_1, 5,8));
  }
}
