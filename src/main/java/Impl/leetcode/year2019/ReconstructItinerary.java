package main.java.Impl.leetcode.year2019;

import java.util.*;

public class ReconstructItinerary {
    /*
    332. Reconstruct Itinerary

    Given a list of airline tickets represented by pairs of departure and arrival airports [from, to], reconstruct the itinerary in order. All of the tickets belong to a man who departs from JFK. Thus, the itinerary must begin with JFK.

    Note:

    If there are multiple valid itineraries, you should return the itinerary that has the smallest lexical order when read as a single string. For example, the itinerary ["JFK", "LGA"] has a smaller lexical order than ["JFK", "LGB"].
    All airports are represented by three capital letters (IATA code).
    You may assume all tickets form at least one valid itinerary.
    Example 1:

    Input: [["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
    Output: ["JFK", "MUC", "LHR", "SFO", "SJC"]
    Example 2:

    Input: [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
    Output: ["JFK","ATL","JFK","SFO","ATL","SFO"]
    Explanation: Another possible reconstruction is ["JFK","SFO","ATL","JFK","ATL","SFO"].
                 But it is larger in lexical order.
     */
    LinkedList<String> result;

    public List<String> findItinerary(List<List<String>> tickets) {
        Graph graph = new Graph();

        for (List<String> ticket : tickets) {
            graph.addTrips(ticket);
        }
        graph.sortValues();
        result = new LinkedList<>();
        dfs(graph, "JFK");
        return result;


    }

    Map<Character, Character> TRADITIONAL_CHINESE_TO_SIMPLIFIED__CHINESE_CHAR_MAP = new HashMap<>();

    private void convert(String input) {

        List<String> resultTokens = new ArrayList<>();
        boolean convertedToSimplified = false;
        StringBuilder sb = new StringBuilder();
        for (char c : input.toCharArray()) {
            if (TRADITIONAL_CHINESE_TO_SIMPLIFIED__CHINESE_CHAR_MAP.containsKey(c)) {
                convertedToSimplified = true;
                sb.append(TRADITIONAL_CHINESE_TO_SIMPLIFIED__CHINESE_CHAR_MAP.get(c));
                continue;
            }
            sb.append(c);
        }
        if (convertedToSimplified) {
            resultTokens.add(input);
        }
    }

    private void dfs(Graph graph, String curr) {
        LinkedList<String> list = graph.getDestinations(curr);
        if (list != null) {
            while(!list.isEmpty()) {
                String dest = list.pollFirst();
                dfs(graph, dest);
            }
        }
        result.addFirst(curr);
    }

    private class Graph {
        Map<String, LinkedList<String>> data;

        Graph() {
            data = new HashMap<>();
        }

        void addTrips(List<String> ticket) {
            LinkedList<String> subList = data.getOrDefault(ticket.get(0), new LinkedList<>());
            subList.add(ticket.get(1));
            data.put(ticket.get(0), subList);

        }

        void sortValues() {
            data.forEach((key, value) -> Collections.sort(value));
        }

        LinkedList<String> getDestinations(String source) {
            return data.get(source);
        }
    }


}
