package main.leetcode;

/**
 * 100. Same Tree
 * Given two binary trees, write a function to check if they are equal or not.
 * Two binary trees are considered equal if they are structurally identical and the nodes have the same value.
 *
 */
public class IsSameTree {

    public class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null){
            return true;
        } else if(p == null && q != null) {
            return false;
        } else if(p != null && q == null) {
            return false;
        }

        return (isSameTree(p.left, q.left) && isSameTree(p.right, q.right) && (p.val == q.val));
    }
}
