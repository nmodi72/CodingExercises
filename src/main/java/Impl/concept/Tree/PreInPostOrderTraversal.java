package main.java.Impl.concept.Tree;


import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import main.java.model.TreeNode;

/**
 * Sample program for in-order with recursion
 */
public class PreInPostOrderTraversal {

    /**
     * Below are Pre, In and Post Order traversals with recursion
     */
    public void preOrderWithRecursion(TreeNode tree) {
        if(tree == null) {
            return;
        }
        System.out.print(tree.val + " ");
        preOrderWithRecursion(tree.left);
        preOrderWithRecursion(tree.right);
    }

    public void inOrderPrint(TreeNode tree) {
        if(tree == null) {
            return;
        }
        inOrderPrint(tree.left);
        System.out.print(tree.val + " ");
        inOrderPrint(tree.right);
    }

    public void postOrderPrint(TreeNode tree) {
        if(tree == null) {
            return;
        }
        postOrderPrint(tree.left);
        postOrderPrint(tree.right);
        System.out.print(tree.val + " ");
    }

    /**
     * Below are Pre, In and Post Order traversals without recursion(iterative approach)
     */
    public static void preOrderWithoutRecursion(TreeNode tree) {
        if (tree == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(tree);
        while (stack.size() > 0) {
            TreeNode currentNode = stack.pop();
            System.out.print(currentNode.val + " ");
            if(currentNode.right != null) {
                stack.push(currentNode.right);
            }
            if(currentNode.left != null) {
                stack.push(currentNode.left);
            }
        }
    }

    public static void inOrderWithoutRecursion(TreeNode tree) {
        if (tree == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode currentNode = tree;
        while (currentNode != null || stack.size() > 0) {
            while (currentNode != null) {
                stack.push(currentNode);
                currentNode = currentNode.left;
            }
            currentNode = stack.pop();
            System.out.print(currentNode.val + " ");
            currentNode = currentNode.right;
        }
    }

    public static void postOrderWithoutRecursion(TreeNode tree) {
        if (tree == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(tree);
        while (stack.size() > 0) {
            TreeNode currentNode = stack.pop();
            if(currentNode.left != null) {
                stack.push(currentNode.left);
            }
            System.out.print(currentNode.val + " ");
            if(currentNode.right != null) {
                stack.push(currentNode.right);
            }
        }
    }

    public static List<Integer> postOrderWithoutRecursionNewOne(TreeNode root) {
        LinkedList<Integer> output = new LinkedList();
        Deque<TreeNode> stack = new ArrayDeque();

        if (root == null) return output;

        stack.push(root);
        while (!stack.isEmpty()) {
            root = stack.pop();
            output.addFirst(root.val);
            if (root.left != null) stack.push(root.left);
            if (root.right != null) stack.push(root.right);
        }
        return output;
    }
    /**
     * Below are Pre, In and Post Order traversals with Morris Traversal
     */
    public void preOrderWithMorrisTraversal(TreeNode tree) {
        while(tree != null) {
            if (tree.left == null) {
                System.out.print(tree.val + " ");
                tree = tree.right;
            } else {
                TreeNode current = tree.left;
                while (current.right != null && current.right != tree) {
                    current = current.right;
                }
                if(current.right == tree) {
                    current.right = null;
                    tree = tree.right;
                } else {
                    System.out.print(tree.val + " ");
                    current.right = tree;
                    tree = tree.left;
                }
            }
        }
    }

    public void inOrderWithMorrisTraversal(TreeNode tree) {
        while(tree != null) {
            if (tree.left == null) {
                System.out.print(tree.val + " ");
                tree = tree.right;
            } else {
                TreeNode current = tree.left;
                while (current.right != null && current.right != tree) {
                    current = current.right;
                }
                if(current.right == null) {
                    current.right = tree;
                    tree = tree.left;
                } else {
                    current.right = null;
                    System.out.print(tree.val + " ");
                    tree = tree.right;
                }
            }
        }
    }

    public void postOrderWithMorrisTraversal(TreeNode tree) {
        while(tree != null) {
            if (tree.left == null) {
                System.out.print(tree.val + " ");
                tree = tree.right;
            } else {
                TreeNode current = tree.left;
                while (current.right != null && current.right != tree) {
                    current = current.right;
                }
                if(current.right == null) {
                    current.right = tree;
                    tree = tree.left;
                } else {
                    current.right = null;
                    System.out.print(tree.val + " ");
                    tree = tree.right;
                }
            }
        }
    }

    int height(TreeNode root)
    {
        if (root == null)
            return 0;
        else
        {
            /* compute  height of each subtree */
            int lheight = height(root.left);
            int rheight = height(root.right);

            /* use the larger one */
            if (lheight > rheight)
                return(lheight+1);
            else return(rheight+1);
        }
    }
}
