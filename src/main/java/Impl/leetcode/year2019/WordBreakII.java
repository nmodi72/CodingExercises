package main.java.Impl.leetcode.year2019;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class WordBreakII {
    /*
    140. Word Break II

    Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, add spaces in s to construct a sentence where each word is a valid dictionary word. Return all such possible sentences.

    Note:

    The same word in the dictionary may be reused multiple times in the segmentation.
    You may assume the dictionary does not contain duplicate words.
    Example 1:

    Input:
    s = "catsanddog"
    wordDict = ["cat", "cats", "and", "sand", "dog"]
    Output:
    [
      "cats and dog",
      "cat sand dog"
    ]
    Example 2:

    Input:
    s = "pineapplepenapple"
    wordDict = ["apple", "pen", "applepen", "pine", "pineapple"]
    Output:
    [
      "pine apple pen apple",
      "pineapple pen apple",
      "pine applepen apple"
    ]
    Explanation: Note that you are allowed to reuse a dictionary word.
    Example 3:

    Input:
    s = "catsandog"
    wordDict = ["cats", "dog", "sand", "and", "cat"]
    Output:
    []
     */
    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> data = new HashSet<>(wordDict);
        Map<String, List<String>> map = new HashMap<>();
        return traverse(s, data, map);
    }

    private List<String> traverse(String str, Set<String> data, Map<String, List<String>> map) {
        StringBuilder sb = new StringBuilder(str);
        List<String> result = new ArrayList<>();
        if(str.length() == 0) return result;
        if(map.containsKey(str)) return map.get(str);
        for(int i = 1; i < str.length(); i++) {
            String subString = sb.substring(0, i);
            if(data.contains(subString)) {
                for(String suffix : traverse(sb.substring(i), data, map)) {
                    result.add(subString + " " + suffix);
                }
            }
        }
        if(data.contains(str)) result.add(str);
        map.put(str, result);
        return result;
    }
}
