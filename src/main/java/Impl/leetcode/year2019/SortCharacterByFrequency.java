package main.java.Impl.leetcode.year2019;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class SortCharacterByFrequency {

    public static String frequencySort(String str) {
        // fill map with count
        Map<Character, Integer> map = new HashMap<>();
        for (char c : str.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        // let's create Priority queue and insert all characters
        PriorityQueue<Character> priorityQueue =
                new PriorityQueue<>((a, b) -> map.get(b) - map.get(a));
        priorityQueue.addAll(map.keySet());

        // now generate string based on frequency
        StringBuilder sb = new StringBuilder();
        while (!priorityQueue.isEmpty()) {
            char curr = priorityQueue.remove();
            for (int i = 0; i < map.get(curr); i++) {
                sb.append(curr);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String input = "tree";
        System.out.println("Input is:" + input);
        System.out.println("Result is:" + frequencySort(input));
    }
}
