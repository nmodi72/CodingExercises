package main.leetcode;

/**
 * This is leetcode problem# 242
 * Valid Anagram
 *
 * Given two strings s and t, write a function to determine if t is an anagram of s.
 * For example,
 * s = "anagram", t = "nagaram", return true.
 * s = "rat", t = "car", return false.
 *
 * Note: You may assume the string contains only lowercase alphabets.
 * Follow up: What if the inputs contain unicode characters? How would you adapt your solution to such case?
 */
public class ValidAnagram {

    // 4 ms - 90.70% beat others
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
        int[] table = new int[128];
        for (char characterOFStringS : s.toCharArray())     table[characterOFStringS]++;
        for (char characterOFStringT : t.toCharArray()) {
            if(table[characterOFStringT] > 0) {
                table[characterOFStringT]--;
            } else {
                return false;
            }
        }
        return true;
    }
}
