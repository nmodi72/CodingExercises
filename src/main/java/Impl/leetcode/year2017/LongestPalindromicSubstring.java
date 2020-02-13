package main.java.Impl.leetcode.year2017;

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

    public static String longestPalindromeWithDP(String s) {
        char[] str = s.toCharArray();
        boolean[][] T = new boolean[str.length][str.length];
        String result = "";
        for(int i = 0; i < str.length; i++) {
            T[i][i] = true;
        }
        for (int l = 2; l <= str.length; l++) {
            for (int i = 0; i < str.length-l+1; i++) {
                int j = i + l - 1;
                if (l == 2 && str[i] == str[j]) {
                    T[i][j] = true;
                } else if (str[i] == str[j] && T[i+1][j-1]) {
                    T[i][j] = true;
                } else {
                    T[i][j] = false;
                }
            }
        }
        for (int j = str.length-1; j >= 0; j--) {
            int x = 0;
            int y = j;
            int k = str.length-j;

            while (k > 0) {
                if (T[x][y]) {
                    result = s.substring(x, y+1);
                    return result;
                }
                x++;
                y++;
                k--;
            }

        }
        return result;
    }

    public static void main(String[] args) {

        String palindromeString = "baabaaad";

        System.out.println("longest palindromic string of length is: " +
                LongestPalindromicSubstring.longestPalindromeWithDP(palindromeString));


    }
}
