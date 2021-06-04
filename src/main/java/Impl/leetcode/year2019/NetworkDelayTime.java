package main.java.Impl.leetcode.year2019;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class NetworkDelayTime {
    /*
    743. Network Delay Time
    There are N network nodes, labelled 1 to N.

    Given times, a list of travel times as directed edges times[i] = (u, v, w), where u is the source node, v is the target node, and w is the time it takes for a signal to travel from source to target.

    Now, we send a signal from a certain node K. How long will it take for all nodes to receive the signal? If it is impossible, return -1.

    Example 1:
    Input: times = [[2,1,1],[2,3,1],[3,4,1]], N = 4, K = 2
    Output: 2
    Note:
    N will be in the range [1, 100].
    K will be in the range [1, N].
    The length of times will be in the range [1, 6000].
    All edges times[i] = (u, v, w) will have 1 <= u, v <= N and 0 <= w <= 100.

     */
    int[] visited;

    public int networkDelayTime(int[][] times, int N, int K) {
        visited = new int[N];
        Arrays.fill(visited, -1);
        Graph graph = fillData(times);
        return bfs(graph, K);

    }

    private int bfs(Graph graph, int K) {
        if (!graph.data.containsKey(K)) return -1;

        Queue<Integer> q = new LinkedList<>();
        int dist = 0;
        q.add(K);
        visited[K-1] = dist;
        while(!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Integer poll = q.poll();
                for (Edge e : graph.getEdges(poll)){
                    int childNode = e.dest;
                    int time = e.time + visited[poll-1];
                    if ((visited[childNode-1] > 0 && time< visited[childNode-1]) || (visited[childNode-1] == -1)) {
                        visited[childNode-1] = time;
                        q.add(childNode);
                    }
                }
            }
        }

        int max = 0;
        for (int i : visited) {
            if(i == -1) return -1;
            max = Math.max(max, i);
        }
        return max;
    }

    private Graph fillData(int[][] times) {
        Graph graph = new Graph();
        for (int[] time : times) {
            graph.addEdges(time);
        }
        return graph;
    }

    class Graph {
        Map<Integer, List<Edge>> data;
        Graph() {
            data = new HashMap<>();
        }

        void addEdges(int[] time) {
            List<Edge> edges =  data.getOrDefault(time[0], new ArrayList<Edge>());
            edges.add(new Edge(time[1], time[2]));
            data.put(time[0], edges);
        }

        List<Edge> getEdges(Integer node){
            return data.getOrDefault(node, new ArrayList<Edge>());
        }

    }

    class Edge {
        Integer dest;
        Integer time;

        Edge(Integer dest, Integer time) {
            this.dest = dest;
            this.time = time;
        }
    }
}
