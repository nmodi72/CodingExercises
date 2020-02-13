package main.java.Impl.concept.Tree;

import main.java.model.TreeNode;

/**
 * Created by nirmodi on 1/29/17.
 */
public class InvertTree {

    public static TreeNode invertTree(TreeNode root) {
        if(root != null) {
            helper(root);
        }
        return root;
    }
    public static void helper(TreeNode root) {
        if(root == null){
            return;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        if(root.left != null) {
            helper(root.left);
        }
        if(root.right != null) {
            helper((root.right));
        }
    }



    public static void main(String[] args){

        System.out.print(4 & 3);
        TreeNode treeNode1 = new TreeNode(4);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(7);
        TreeNode treeNode4 = new TreeNode(1);
        TreeNode treeNode5 = new TreeNode(3);
        TreeNode treeNode6 = new TreeNode(6);
        TreeNode treeNode7 = new TreeNode(9);

        treeNode2.left = treeNode4;
        treeNode2.right = treeNode5;
        treeNode3.left = treeNode6;
        treeNode3.right = treeNode7;

        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;

        TreeNode treeNode = invertTree(treeNode1);
    }
}
