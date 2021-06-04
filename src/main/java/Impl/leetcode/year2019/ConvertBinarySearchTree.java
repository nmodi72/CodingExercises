package main.java.Impl.leetcode.year2019;

public class ConvertBinarySearchTree {

    BinaryTreeTraversal.TreeNode prev = null;
    BinaryTreeTraversal.TreeNode  firstNode = null;

    public BinaryTreeTraversal.TreeNode  treeToDoublyList(BinaryTreeTraversal.TreeNode  root) {
        if (root == null) return root;
        BinaryTreeTraversal.TreeNode  curr = root;
        inorderTraversal(curr);
        prev.right = firstNode;
        firstNode.left = prev;
        return firstNode;
    }

    void inorderTraversal(BinaryTreeTraversal.TreeNode  curr) {
        if(curr == null) return;
        inorderTraversal(curr.left);
        if (prev == null) {
            prev = curr;
            firstNode = curr;
        } else {
            prev.right = curr;
            curr.left = prev;
            prev = curr;
        }
        inorderTraversal(curr.right);

    }
}
