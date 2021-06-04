package main.java.Impl.leetcode.year2019;

import java.util.LinkedList;
import java.util.Queue;

public class SerializeDeserialize {
    /*
    297. Serialize and Deserialize Binary Tree
    Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.

    Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized to the original tree structure.

    Example:

    You may serialize the following tree:

        1
       / \
      2   3
         / \
        4   5

    as "[1,2,3,null,null,4,5]"
    Clarification: The above format is the same as how LeetCode serializes a binary tree. You do not necessarily need to follow this format, so please be creative and come up with different approaches yourself.

Note: Do not use class member/global/static variables to store states. Your serialize and deserialize algorithms should be stateless.
     */
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "";
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        sb.append(root.val + ",");
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode pop = q.poll();
                if (pop.left != null) {
                    q.add(pop.left);
                    sb.append(pop.left.val + ",");
                } else {
                    sb.append("null,");
                }
                if (pop.right != null) {
                    q.add(pop.right);
                    sb.append(pop.right.val + ",");
                } else {
                    sb.append("null,");
                }
            }
        }
        sb.deleteCharAt(sb.length()-1);
        System.out.print(sb.toString());
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data == "") return null;
        String[] arr = data.split(",");
        if (arr.length == 0) return null;
        Queue<TreeNode> q = new LinkedList<>();
        int i = 0;
        TreeNode node = new TreeNode(Integer.valueOf(arr[i]));
        q.add(node);
        i++;
        while (!q.isEmpty()) {
            TreeNode poll = q.poll();
            poll.left = arr[i].equals("null") ? null : new TreeNode(Integer.valueOf(arr[i]));
            if (poll.left != null) q.add(poll.left);
            i++;
            if (i >= arr.length) break;
            poll.right = arr[i].equals("null") ? null : new TreeNode(Integer.valueOf(arr[i]));
            if (poll.right != null) q.add(poll.right);
            i++;
            if (i >= arr.length) break;

        }
        return node;
    }

    public class TreeNode {
     int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
}
