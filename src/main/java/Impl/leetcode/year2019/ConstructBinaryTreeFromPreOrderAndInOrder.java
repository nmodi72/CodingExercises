package main.java.Impl.leetcode.year2019;

public class ConstructBinaryTreeFromPreOrderAndInOrder {
    /*
    105. Construct Binary Tree from Preorder and Inorder Traversal
    For example, given

    preorder = [3,9,20,15,7]
    inorder = [9,3,15,20,7]
    Return the following binary tree:

        3
       / \
      9  20
        /  \
       15   7
     */
    int rootLookupId = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0 || inorder.length == 0) return null;
        return build(preorder, inorder, 0, inorder.length-1);
    }

    private TreeNode build(int[] preOrder, int[] inOrder, int start, int end) {
        if(start > end)
            return null;

        int rootElement = preOrder[rootLookupId++];
        TreeNode node = new TreeNode(rootElement);
        for(int i = start; i <= end; i++){
            if (rootElement == inOrder[i]) {
                node.left = build(preOrder, inOrder, start, i-1);
                node.right = build(preOrder, inOrder, i+1, end);
                break;
            }
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
