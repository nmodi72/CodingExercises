package main.java.Impl.leetcode.year2019;

import java.util.ArrayList;
import java.util.List;

import main.java.model.TreeNode;

public class BinaryTreePath {
    /*
    257. Binary Tree Paths

    Given a binary tree, return all root-to-leaf paths.

    Note: A leaf is a node with no children.

    Example:

    Input:

       1
     /   \
    2     3
     \
      5

    Output: ["1->2->5", "1->3"]

    Explanation: All root-to-leaf paths are: 1->2->5, 1->3
     */
    List<String> result = new ArrayList<>();
    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) return result;
        findPath(root, root.val + "");
        return result;

    }

    private void findPath(TreeNode node, String str) {
        if (node.left == null && node.right == null) {
            result.add(str);
            return;
        }
        if (node.left != null) {
            findPath(node.left, str + "->" + node.left.val);
        }
        if (node.right != null) {
            findPath(node.right, str + "->" + node.right.val);
        }
    }
}
