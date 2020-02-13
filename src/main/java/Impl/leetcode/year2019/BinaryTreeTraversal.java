package main.java.Impl.leetcode.year2019;

import java.util.List;
import java.util.Stack;

/**
 * This is the leetcode problem: 94. Binary Tree Inorder Traversal
 *
 * Given a binary tree, return the inorder traversal of its nodes' values.
 *
 * Example:
 *
 * Input: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * Output: [1,3,2]
 */
public class BinaryTreeTraversal {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static TreeNode createTree() {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        root.right = new TreeNode(5);
        root.right.right = new TreeNode(6);
        return root;
    }

    public static void preOrderRecursiveTraversal(TreeNode root) {
        if(root == null)
            return;
        System.out.printf("%d ", root.val);
        preOrderRecursiveTraversal(root.left);
        preOrderRecursiveTraversal(root.right);

    }

    public static void preOrderIterativeTraversal(TreeNode root) {
        if(root == null)
            return;
        Stack<TreeNode> st = new Stack<>();
        st.push(root);
        while (!st.empty()) {
            root = st.pop();
            System.out.printf("%d ", root.val);
            if (root.right != null)
                st.push(root.right);
            if (root.left != null)
                st.push(root.left);
        }
    }

    public static void inOrderRecursiveTraversal(TreeNode root) {
        if(root == null)
            return;
        inOrderRecursiveTraversal(root.left);
        System.out.printf("%d ", root.val);
        inOrderRecursiveTraversal(root.right);
    }


    public static void inOrderIterativeTraversal(TreeNode root) {
        if(root == null)
            return;
        Stack<TreeNode> st = new Stack<>();
        while (1 == 1) {
            if (root != null) {
                st.push(root);
                root = root.left;
            } else {
                if (st.empty()) {
                    break;
                }
                root = st.pop();
                System.out.printf("%d ", root.val);
                root = root.right;
            }
        }
    }

    public static void postOrderRecursiveTraversal(TreeNode root) {
        if(root == null)
            return;
        postOrderRecursiveTraversal(root.left);
        postOrderRecursiveTraversal(root.right);
        System.out.printf("%d ", root.val);

    }

    public static void postOrderIterativeTraversalWithTwoStacks(TreeNode root) {
        if(root == null)
            return;
        Stack<TreeNode> st1 = new Stack<>();
        Stack<TreeNode> st2 = new Stack<>();
        st1.push(root);
        while (!st1.isEmpty()) {
            root = st1.pop();
            st2.push(root);
            if (root.left != null) {
                st1.push(root.left);
            }
            if (root.right != null) {
                st1.push(root.right);
            }
        }
        while (!st2.isEmpty()) {
            root = st2.pop();
            System.out.printf("%d ", root.val);
        }
    }

    public static void main(String[] arr) {
        TreeNode input = createTree();
        System.out.println("Pre Order Recursive:");
        preOrderRecursiveTraversal(input);

        System.out.println("");
        System.out.println("Pre Order Iterative:");
        preOrderIterativeTraversal(input);

        System.out.println("");
        System.out.println("------------------");
        System.out.println("In Order Recursive:");
        inOrderRecursiveTraversal(input);

        System.out.println("");
        System.out.println("In Order Iterative:");
        inOrderIterativeTraversal(input);

        System.out.println("");
        System.out.println("------------------");
        System.out.println("Post Order Recursive:");
        postOrderRecursiveTraversal(input);

        System.out.println("");
        System.out.println("Post Order Iterative(Two Stacks):");
        postOrderIterativeTraversalWithTwoStacks(input);
    }


}
