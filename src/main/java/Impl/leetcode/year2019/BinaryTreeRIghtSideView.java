package main.java.Impl.leetcode.year2019;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import main.java.model.TreeNode;

public class BinaryTreeRIghtSideView {

    /*
    199. Binary Tree Right Side View
    Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.

    Example:

    Input: [1,2,3,null,5,null,4]
    Output: [1, 3, 4]
    Explanation:

       1            <---
     /   \
    2     3         <---
     \     \
      5     4       <---
     */
    Map<Integer, Integer> resultSet = new HashMap<>();
    public List<Integer> rightSideView(TreeNode root) {
        traverseDfs(root, new HashSet<>(), 0);
        return new ArrayList<>(resultSet.values());
    }

    private void traverseDfs(TreeNode node, Set<TreeNode> visited, int height) {
        if(node == null) return;
        if(!resultSet.containsKey(height)) {
            resultSet.put(height, node.val);
        }
        int h = height+1;
        traverseDfs(node.right, visited, h);
        traverseDfs(node.left, visited, h);
    }
}
