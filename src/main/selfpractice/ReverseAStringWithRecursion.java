package main.selfpractice;

import java.util.Stack;
import jdk.nashorn.internal.objects.annotations.Getter;

/**
 * Created by nirmodi on 12/6/16.
 */
public class ReverseAStringWithRecursion {

    public String reverseStringWithoutRecursion(String str) {
        if(str.isEmpty() || str.length() <= 1) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = str.length()-1; i >= 0 ; i--){
            sb.append(str.charAt(i));
        }
        return sb.toString();
    }

    public String reverseString(String str) {
        if(str.isEmpty() || str.length() <= 1) {
            return str;
        }
        return reverseString(str.substring(1)) + str.charAt(0);
    }

    public static void run() {
        String word = "ABC";
        printAnagrams("", word);
    }
    boolean isPalindrome(String s) {
        int n = s.length();
        for (int i = 0; i < (n/2); ++i) {
            if (s.charAt(i) != s.charAt(n - i - 1)) {
                return false;
            }
        }

        return true;
    }

    public static void printAnagrams(String prefix, String word) {
        if(word.length() <= 1) {
            System.out.print(prefix + word);
        } else {
            for(int i = 0; i < word.length(); i++) {
                String cur = word.substring(i, i + 1);
                String before = word.substring(0, i); // letters before cur
                String after = word.substring(i + 1); // letters after cur
                printAnagrams(prefix + cur, before + after);
            }
        }
    }



    public static void main(String args[]) throws Exception {
        System.out.println(longestPalindrome("Hello"));
    }

    public static String longestPalindrome(String s) {
        if (s.isEmpty()) {
            return null;
        }

        if (s.length() == 1) {
            return s;
        }

        String longest = s.substring(0, 1);
        for (int i = 0; i < s.length(); i++) {
            // get longest palindrome with center of i
            String tmp = helper(s, i, i);
            if (tmp.length() > longest.length()) {
                longest = tmp;
            }

            // get longest palindrome with center of i, i+1
            tmp = helper(s, i, i + 1);
            if (tmp.length() > longest.length()) {
                longest = tmp;
            }
        }

        return longest;
    }

    // Given a center, either one letter or two letter,
// Find longest palindrome
    public static String helper(String s, int begin, int end) {


        while (begin >= 0 && end <= s.length() - 1 && s.charAt(begin) == s.charAt(end)) {
            begin--;
            end++;
        }
        return s.substring(begin + 1, end);
    }
}
