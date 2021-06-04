package main.java.Impl.leetcode.year2019;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class TaskPlanner {
    /*
    This question was asked in FB

     */
    int getTotalTime(Map<Integer, Node> graphData, int target) {
        // will iterate and mark visited nodes
        int max = 0;
        Queue<Node> q = new LinkedList<>();
        q.add(graphData.get(target));
        graphData.get(target).setVisited(true);
        while (!q.isEmpty()) {
            Node popElement = q.poll();
            max += popElement.getValue();
            for (Node n :popElement.getEdges()) {
                if (n.isVisited()) continue;
                q.add(n);
                n.setVisited(true);
            }
        }
        return max;
    }

    public static class Node {
        int value;
        int time;
        boolean isVisited;
        List<Node> edges = new LinkedList<>();

        Node(int value, int time, boolean isVisited) {
            this.value = value;
            this.time = time;
            this.isVisited = isVisited;
        }

        void addEdge(Node n) {
            this.edges.add(n);
        }

        int getValue() {
            return value;
        }

        List<Node> getEdges() {
            return edges;
        }

        void setVisited(boolean isVisited) {
            this.isVisited = isVisited;
        }
        boolean isVisited() {
            return isVisited;
        }
    }

    public static void main(String[] args) {
        //{1, 2, 5} - {{source, destination, time} ... }
        int[][] weights = {{1, 5}, {2, 3}, {3, 3}, {4, 4}};
        int[][] edges = {{1, 2}, {2, 3}, {1, 3}, {3, 4}, {2, 4}};
        TaskPlanner t = new TaskPlanner();
//        System.out.println(t.getTotalTime(weights, edges, 2));
    }
}
