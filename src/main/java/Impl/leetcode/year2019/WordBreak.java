package main.java.Impl.leetcode.year2019;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {

    /*
    139. Word Break
    Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, determine if s can be segmented into a space-separated sequence of one or more dictionary words.

    Note:

    The same word in the dictionary may be reused multiple times in the segmentation.
    You may assume the dictionary does not contain duplicate words.
    Example 1:

    Input: s = "leetcode", wordDict = ["leet", "code"]
    Output: true
    Explanation: Return true because "leetcode" can be segmented as "leet code".
    Example 2:

    Input: s = "applepenapple", wordDict = ["apple", "pen"]
    Output: true
    Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
                 Note that you are allowed to reuse a dictionary word.
    Example 3:

    Input: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
    Output: false
     */
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> data = new HashSet<>(wordDict);
        int[] lookupTable = new int[s.length() + 1];
        return evaluateWords(s, data, lookupTable, 0);
    }

    private boolean evaluateWords(String s, Set<String> data, int[] lookupTable, int index) {
        if (lookupTable[index] == -1) return false;
        if (lookupTable[index] == 1) return true;
        if(s == null || s.length() == 0) {
            lookupTable[index] = 1;
            return true;
        }
        for (int j = 1; j <= s.length(); j++) {
            String str = s.substring(0, j);
            if (data.contains(str) && evaluateWords(s.substring(j), data, lookupTable, j)) {
                lookupTable[index] = 1;
                return true;
            }
        }
        lookupTable[index] = -1;
        return false;
    }
}
