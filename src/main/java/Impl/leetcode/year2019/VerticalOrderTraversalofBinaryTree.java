package main.java.Impl.leetcode.year2019;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import main.java.model.TreeNode;

public class VerticalOrderTraversalofBinaryTree {
    /*
    987. Vertical Order Traversal of a Binary Tree
    Given a binary tree, return the vertical order traversal of its nodes values.

    For each node at position (X, Y), its left and right children respectively will be at positions (X-1, Y-1) and (X+1, Y-1).

    Running a vertical line from X = -infinity to X = +infinity, whenever the vertical line touches some nodes, we report the values of the nodes in order from top to bottom (decreasing Y coordinates).

    If two nodes have the same position, then the value of the node that is reported first is the value that is smaller.

    Return an list of non-empty reports in order of X coordinate.  Every report will have a list of values of nodes.

    Example 1:
    Input: [3,9,20,null,null,15,7]
    Output: [[9],[3,15],[20],[7]]
    Explanation:
    Without loss of generality, we can assume the root node is at position (0, 0):
    Then, the node with value 9 occurs at position (-1, -1);
    The nodes with values 3 and 15 occur at positions (0, 0) and (0, -2);
    The node with value 20 occurs at position (1, -1);
    The node with value 7 occurs at position (2, -2).

    Example 2:
    Input: [1,2,3,4,5,6,7]
    Output: [[4],[2],[1,5,6],[3],[7]]
    Explanation:
    The node with value 5 and the node with value 6 have the same position according to the given scheme.
    However, in the report "[1,5,6]", the node value of 5 comes first since 5 is smaller than 6.
     */
    TreeMap<Integer, List<Integer>> data = new TreeMap<>();
    HashMap<Integer, Integer> yMap = new HashMap<>();

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        traverseAndCalculateCluster(root, 0, 0);
        for(Map.Entry entry : data.entrySet()){
            // sort all lists by it's y values
            List<Integer> list = (List<Integer>)entry.getValue();
            Collections.sort(list, new Comparator<Integer>(){
                public int compare(Integer i1, Integer i2) {
                    if(yMap.get(i2) == yMap.get(i1)) return i1-i2;
                    return yMap.get(i2) - yMap.get(i1);
                }
            });
            result.add(list);
        }
        return result;
    }

    void traverseAndCalculateCluster(TreeNode node, int x, int y) {
        if (node == null) return;
        List<Integer> rv = data.getOrDefault(x, new LinkedList<Integer>());
        rv.add(node.val);
        yMap.put(node.val, y);
        data.put(x, rv);
        traverseAndCalculateCluster(node.left, x-1, y-1);
        traverseAndCalculateCluster(node.right, x+1, y-1);
    }

}
