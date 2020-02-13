package main.java.Impl.TusharRoy;

import main.java.model.TreeNode;

/**
 * Created by nmodi on 9/26/18.
 */
public class LowestCommonAncestorInTree {

    TreeNode findLca(TreeNode root, TreeNode n1, TreeNode n2) {
        if (root == null) {
            return null;
        }
        if (root == n1 || root == n2) {
            return root;
        }
        TreeNode left = findLca(root.left, n1, n2);
        TreeNode right = findLca(root.right, n1, n2);
        if (left != null && right != null) {
            return root;
        }
        if (left == null && right == null) {
            return null;
        }
        return left != null ? left : right;
    }

}
