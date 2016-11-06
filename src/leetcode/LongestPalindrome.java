package leetcode;

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

    public int longestPalindrome(String s) {
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
}
