package main.java.Impl.leetcode.year2019;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class CloneGraph {

    /**
     133. Clone Graph

     Given a reference of a node in a connected undirected graph.

     Return a deep copy (clone) of the graph.

     Each node in the graph contains a val (int) and a list (List[Node]) of its neighbors.

     class Node {
     public int val;
     public List<Node> neighbors;
     }

     Test case format:
     For simplicity sake, each node's value is the same as the node's index (1-indexed). For example, the first node with val = 1, the second node with val = 2, and so on. The graph is represented in the test case using an adjacency list.
     Adjacency list is a collection of unordered lists used to represent a finite graph. Each list describes the set of neighbors of a node in the graph.
     The given node will always be the first node with val = 1. You must return the copy of the given node as a reference to the cloned graph.

     Example 1:
     Input: adjList = [[2,4],[1,3],[2,4],[1,3]]
     Output: [[2,4],[1,3],[2,4],[1,3]]
     Explanation: There are 4 nodes in the graph.
     1st node (val = 1)'s neighbors are 2nd node (val = 2) and 4th node (val = 4).
     2nd node (val = 2)'s neighbors are 1st node (val = 1) and 3rd node (val = 3).
     3rd node (val = 3)'s neighbors are 2nd node (val = 2) and 4th node (val = 4).
     4th node (val = 4)'s neighbors are 1st node (val = 1) and 3rd node (val = 3).
     */
    public Node cloneGraph(Node node) {
        if (node == null) return node;
        Map<Integer, Node> map = new HashMap<>();
        Queue<Node> q = new LinkedList<>();
        q.add(node);
        Node newNode = new Node(node.val, new ArrayList<>());
        map.put(node.val, newNode);
        int resultNodeId = node.val;
        while(!q.isEmpty()) {
            Node curr = q.poll();
            for (int i = 0; i < curr.neighbors.size(); i++) {
                Node cNode = curr.neighbors.get(i);
                if(!map.containsKey(cNode.val)) { q.add(cNode);}
                Node dummyChildNode = map.getOrDefault(cNode.val, new Node(cNode.val, new ArrayList<>()));
                dummyChildNode.neighbors.add(map.getOrDefault(curr.val, new Node(curr.val, new ArrayList<>())));
                map.put(cNode.val, dummyChildNode);
            }
        }
        return map.get(resultNodeId);
    }

    class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }
}
