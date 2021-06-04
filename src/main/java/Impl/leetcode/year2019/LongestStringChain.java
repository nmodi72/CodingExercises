package main.java.Impl.leetcode.year2019;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestStringChain {

    /*
        1048. Longest String Chain
        Given a list of words, each word consists of English lowercase letters.

        Let's say word1 is a predecessor of word2 if and only if we can add exactly one letter anywhere in word1 to make it equal to word2.  For example, "abc" is a predecessor of "abac".

        A word chain is a sequence of words [word_1, word_2, ..., word_k] with k >= 1, where word_1 is a predecessor of word_2, word_2 is a predecessor of word_3, and so on.

        Return the longest possible length of a word chain with words chosen from the given list of words.

        Example 1:

        Input: ["a","b","ba","bca","bda","bdca"]
        Output: 4
        Explanation: one of the longest word chain is "a","ba","bda","bdca".
     */
    public int longestStrChain(String[] words) {
        Set<String> data = new HashSet<>(Arrays.asList(words));
        Arrays.sort(words, new Comparator<String>() {
            public int compare(String s1, String s2) {
                return s2.length() - s1.length();
            }
        });
        int max = Integer.MIN_VALUE;
        Map<String, Integer> map = new HashMap<>();
        for(String s : words) {
            max = Math.max(max, countChain(s, data, map));
        }
        return max;
    }

    int countChain(String s, Set<String> data, Map<String, Integer> map) {
        if(s == null || s.length() == 0) return 0;
        if (map.containsKey(s)) return map.get(s);
        if(!data.contains(s)) return 0;

        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            String subStr = s.substring(0, i) + s.substring(i+1, s.length());
            count = Math.max(count, countChain(subStr, data, map) + 1);
        }
        map.put(s, count);
        return count;
    }
}
