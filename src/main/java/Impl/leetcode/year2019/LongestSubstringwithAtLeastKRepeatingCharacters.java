package main.java.Impl.leetcode.year2019;

public class LongestSubstringwithAtLeastKRepeatingCharacters {

    /*
    395. Longest Substring with At Least K Repeating Characters
    Find the length of the longest substring T of a given string (consists of lowercase letters only) such that every character in T appears no less than k times.

    Example 1:

    Input:
    s = "aaabb", k = 3

    Output:
    3

    The longest substring is "aaa", as 'a' is repeated 3 times.
    Example 2:

    Input:
    s = "ababbc", k = 2

    Output:
    5

    The longest substring is "ababb", as 'a' is repeated 2 times and 'b' is repeated 3 times.
     */
    public int longestSubstring(String str, int k) {
        if(str == null || k > str.length()) return 0;

        int[] data = new int[26];
        for(char c : str.toCharArray()) data[c - 'a']++;
        boolean isLongestSubString = true;
        for(char c : str.toCharArray()) {
            if (data[c - 'a'] < k) {
                isLongestSubString = false;
                break;
            }
        }
        if (isLongestSubString) return str.length();

        int i = 0, j = 0, res = 0;
        while (j < str.length()) {
            if(data[str.charAt(j) - 'a'] < k){
                if(j > i) res = Math.max(res, longestSubstring(str.substring(i, j), k));
                i = ++j;
            } else {
                j++;
            }
        }
        return Math.max(res, longestSubstring(str.substring(i), k));
    }
}
