package main.java.Impl.leetcode.year2019;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This is the leetcode problem: #720. Longest Word in Dictionary
 *Given a list of strings words representing an English Dictionary, find the longest word in words that can be built one character at a time by other words in words. If there is more than one possible answer, return the longest word with the smallest lexicographical order.
 *
 * If there is no answer, return the empty string.
 * Example 1:
 * Input:
 * words = ["w","wo","wor","worl", "world"]
 * Output: "world"
 * Explanation:
 * The word "world" can be built one character at a time by "w", "wo", "wor", and "worl".
 * Example 2:
 * Input:
 * words = ["a", "banana", "app", "appl", "ap", "apply", "apple"]
 * Output: "apple"
 * Explanation:
 * Both "apply" and "apple" can be built from other words in the dictionary. However, "apple" is lexicographically smaller than "apply".
 *
 * Note:
 * All the strings in the input will only contain lowercase letters.
 * The length of words will be in the range [1, 1000].
 * The length of words[i] will be in the range [1, 30].
 */
public class LongestWordInDictionary {
    private static class TrieNode {
        TrieNode[] chiild;
        boolean isEnd;
        public TrieNode() {
            this.chiild = new TrieNode[26];
            this.isEnd = false;
        }
    }
    final static String longestWord(String[] words) {
        Arrays.sort(words, new Comparator<String>() {
            @Override public int compare(String o1, String o2) {
                if (o1.length() == o2.length())
                    return o1.compareTo(o2);
                return o1.length() - o2.length();
            }
        });
        TrieNode root = new TrieNode();
        int max = 0;
        String ans = "";
        for (String w : words) {
            TrieNode curr = root;
            int pass = 0, n = w.length();
            for (int j = 0; j < n; j++) {
                int idx = (int) (w.charAt(j) - 'a');
                if (curr.chiild[idx] == null)
                    curr.chiild[idx] = new TrieNode();
                else
                    if (curr.chiild[idx].isEnd)
                        pass++;
                curr = curr.chiild[idx];
            }
            curr.isEnd = true;
            if (pass == n-1 && n > max) {
                max = n;
                ans = w;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String[] arr = {"w", "wo", "wor", "worl", "world", "we", "wel", "weld", "weldi", "welding", "weldin"};
        System.out.println(longestWord(arr));
    }
}
