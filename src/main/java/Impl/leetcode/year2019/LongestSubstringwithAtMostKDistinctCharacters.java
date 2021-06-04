package main.java.Impl.leetcode.year2019;

public class LongestSubstringwithAtMostKDistinctCharacters {
    /*
    340. Longest Substring with At Most K Distinct Characters
    Given a string, find the length of the longest substring T that contains at most k distinct characters.

    Example 1:

    Input: s = "eceba", k = 2
    Output: 3
    Explanation: T is "ece" which its length is 3.
    Example 2:

    Input: s = "aa", k = 1
    Output: 2
    Explanation: T is "aa" which its length is 2.
     */
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if(k == 0 || s == null || s.length() == 0) return 0;
        int[] data = new int[256];
        int i = 0, j = 0, max = 0;
        for(; j < s.length(); j++) {
            data[s.charAt(j)]++;
            if(isValid(data, k)) max = Math.max(max, j-i+1);
            while(!isValid(data, k)) {
                char c = s.charAt(i);
                data[c]--;
                i++;
            }
        }
        return max;
    }

    private boolean isValid(int[] data, int k) {
        int distinct = 0;
        for (int i : data) if (i > 0) distinct++;
        return distinct <= k;
    }
}
