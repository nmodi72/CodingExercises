package main.leetcode;

/**
 * Leetcode problem# 5
 * Longest Palindromic Substring
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
 *
 * Example: Input: "babad" Output: "bab"
 * Note: "aba" is also a valid answer.
 *
 * Example: Input: "cbbd" Output: "bb"
 */
public class LongestPalindromicSubstring {

    public String longestPalindrome(String s) {
        String result = "";
        int currentLength = 0;
        for(int i = 0; i < s.length(); i++) {
            if(isPalindrome(s, i-currentLength-1, i)) {
                result = s.substring(i-currentLength-1, i+1);
                currentLength += 2;
            } else if(isPalindrome(s, i-currentLength, i)){
                result = s.substring(i-currentLength, i+1);
                currentLength += 1;
            }
        }
        return result;
    }


    public boolean isPalindrome(String string, int begin, int end) {
        if(begin < 0) return false;
        while (begin < end) {
            if (string.charAt(begin++) != string.charAt(end--)) return false;
        }
        return true;
    }

}
