package main.java.Impl.leetcode.year2019;

public class ConstructBSTFromPreOrder {

    int id = 0;
    public TreeNode bstFromPreorder(int[] preorder) {

        return dfs(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private TreeNode dfs(int[] preorder, int low, int high) {
        if (id == preorder.length) return null;
        int curr = preorder[id];
        if(curr < low || curr > high) return null;

        id++;
        TreeNode node = new TreeNode(curr);
        node.left = dfs(preorder, low, curr);
        node.right = dfs(preorder, curr, high);
        return node;
    }

    public class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode() {}
     TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
     }
 }
}
