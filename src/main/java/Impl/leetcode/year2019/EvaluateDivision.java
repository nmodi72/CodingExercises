package main.java.Impl.leetcode.year2019;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class EvaluateDivision {
    /*
    399. Evaluate Division

    Equations are given in the format A / B = k, where A and B are variables represented as strings, and k is a real number (floating point number). Given some queries, return the answers. If the answer does not exist, return -1.0.

    Example:
    Given a / b = 2.0, b / c = 3.0.
    queries are: a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ? .
    return [6.0, 0.5, -1.0, 1.0, -1.0 ].

    The input is: vector<pair<string, string>> equations, vector<double>& values, vector<pair<string, string>> queries , where equations.size() == values.size(), and the values are positive. This represents the equations. Return vector<double>.

    According to the example above:

    equations = [ ["a", "b"], ["b", "c"] ],
    values = [2.0, 3.0],
    queries = [ ["a", "c"], ["b", "a"], ["a", "e"], ["a", "a"], ["x", "x"] ].


    The input is always valid. You may assume that evaluating the queries will result in no division by zero and there is no contradiction.
     */
    Map<String, Node> data;
    double[] result;

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        data = new HashMap<>();
        for (int i = 0; i < equations.size(); i++) {
            Node nodeA = data.getOrDefault(equations.get(i).get(0), new Node(equations.get(i).get(0)));
            nodeA.addChild(equations.get(i).get(1), values[i]);

            Node nodeB = data.getOrDefault(equations.get(i).get(1), new Node(equations.get(i).get(1)));
            nodeB.addChild(equations.get(i).get(0), 1/values[i]);

            data.put(equations.get(i).get(0), nodeA);
            data.put(equations.get(i).get(1), nodeB);
        }

        // now traverse for each queries and calculate result and return;
        result = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            if (!data.containsKey(queries.get(i).get(0)) || !data.containsKey(queries.get(i).get(1))) {
                result[i] = -1.0;
                continue;
            }
            result[i] = dfs(queries.get(i).get(0), queries.get(i).get(1), new HashSet<>(), 1);
        }
        return result;
    }
    private double dfs(String curr, String dest, Set<String> visited, double sum) {
        if(curr.equals(dest)) return sum;
        visited.add(curr);

        Node node = data.get(curr);
        if (node == null || node.edges == null || node.edges.size() == 0) return 0;
        List<Edge> childs = node.edges;
        for (int i = 0; i < childs.size(); i++) {
            Edge childNode = childs.get(i);
            if(visited.contains(childNode.dest)) continue;
            double ans = dfs(childNode.dest, dest, visited, sum * childNode.factor);
            if (ans > 0) return ans;
        }
        return -1;
    }


    class Node {

        String val;
        List<Edge> edges;
        Node (String val) {
            this.val = val;
            this.edges = new ArrayList<>();
        }
        void addChild(String dest, double factor) {
            Edge e = new Edge(dest, factor);
            this.edges.add(e);
        }
    }

    class Edge {
        String dest;
        double factor;
        Edge (String dest, double factor) {
            this.dest = dest;
            this.factor = factor;
        }
    }
}
