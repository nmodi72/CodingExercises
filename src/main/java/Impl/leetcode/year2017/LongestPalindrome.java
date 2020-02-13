package main.java.Impl.leetcode.year2017;

import main.java.Impl.concept.Patterns.VehicleBuilder;

/**
 * This is leetCode problem # 407
 * Longest Palindrome
 *
 * Given a string which consists of lowercase or uppercase letters,
 * find the length of the longest palindromes that can be built with those letters.
 * This is case sensitive, for example "Aa" is not considered a palindrome here.
 * Note: Assume the length of given string will not exceed 1,010.
 *
 * Example:
 * Input: "abccccdd"
 * Output: 7
 * Explanation: One longest palindrome that can be built is "dccaccd", whose length is 7.
 */
public class LongestPalindrome {

    public static int longestPalindrome(String s) {
        int[] table = new int[128];
        int maxLength = 0;
        boolean counted = true;
        for (char character : s.toCharArray()) table[character]++;
        for (int i = 0; i < table.length; i++) {
            if(table[i] > 1){
                maxLength += (table[i] - (table[i] % 2));
            }
            if(counted && table[i] % 2 == 1) {
                counted = false;
                maxLength += 1;
            }
        }
        return maxLength;
    }

    public static int longestPalindromeWithDP(char[] str) {
        int[][] T = new int[str.length][str.length];
        for(int i = 0; i < str.length; i++) {
            T[i][i] = 1;
        }
        for (int l = 2; l <= str.length; l++) {
            for (int i = 0; i < str.length-l+1; i++) {
                int j = i + l - 1;
                if (l == 2 && str[i] == str[j]) {
                    T[i][j] = 2;
                } else if (str[i] == str[j]) {
                    T[i][j] = 2 + T[i+1][j-1];
                } else {
                    T[i][j] = Math.max(T[i+1][j], T[i][j-1]);
                }
            }
        }
        return T[0][str.length-1];
    }

    public static void main(String[] args) {

        String palindromeString = "dccaccd";

        System.out.println("longest palindromic string of length is: " +
                LongestPalindrome.longestPalindromeWithDP(palindromeString.toCharArray()));
    }


}
