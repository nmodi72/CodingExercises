package main.java.Impl.concept.Tree;

import main.java.model.TreeNode;

public class LevelBasedSumBFS {

    public void printEachNodes(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        int height = heightOfTree(treeNode);
        for (int i = 1; i <= height; i++) {
            System.out.println("The sum at height level " + i + " - " + printNodesPerLevel(treeNode, i));
        }
    }

    public int heightOfTree(TreeNode treeNode) {
        if(treeNode == null) {
            return 0;
        }
        int leftHeight = heightOfTree(treeNode.left);
        int rightHeight = heightOfTree(treeNode.right);
        if(leftHeight > rightHeight) {
            return (leftHeight + 1);
        } else {
            return (rightHeight + 1);
        }
    }

    public int printNodesPerLevel(TreeNode treeNode, int level) {
        if (treeNode == null) {
            return 0;
        }
        if (level == 1) {
//            System.out.print(treeNode.val + " ");
            return treeNode.val;
        } else {
            return printNodesPerLevel(treeNode.left, level - 1) + printNodesPerLevel(treeNode.right, level - 1);
        }
    }


}
