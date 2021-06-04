package main.java.Impl.leetcode.year2019;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class AmazonMergeMovieShots {
    /*
    Merge movie shots return list representing each scene
    Example 1:
    Input [a, b, c]
    output [1, 1, 1]

    Example 2:
    Input [a, b, c, a]
    output [4]

    Example 3:
    Input [a, b, a, b, c, d, a, c, a, i, h, s, j, j, k, h, q, w, e]
    output [10, 9]
     */
    List<Integer> lengthEachScene(List<Character> inputList) {
        List<int[]> intervals = new ArrayList<>();
        Map<Character, int[]> map = new LinkedHashMap<>();
        int id = 0;
        for(char c : inputList) {
//            if (!map.containsKey(c)) {
//                map.put(c, new int[]{id, id});
//            } else {
//                if (id != 0) {
//                    intervals.add(new int[]{id, map.get(c)});
//                    map.put()
//                }
//
//            }
//            id+;
        }
        return new ArrayList<>();
    }

    public static void main(String[] args) {
        AmazonMergeMovieShots a = new AmazonMergeMovieShots();

    }
}
