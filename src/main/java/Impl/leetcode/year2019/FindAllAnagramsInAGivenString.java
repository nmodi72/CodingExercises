package main.java.Impl.leetcode.year2019;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class FindAllAnagramsInAGivenString {
    /**
    438. Find All Anagrams in a String
    Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.

    Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.

    The order of output does not matter.

    Example 1:

    Input:
    s: "cbaebabacd" p: "abc"

    Output:
    [0, 6]

    Explanation:
    The substring with start index = 0 is "cba", which is an anagram of "abc".
    The substring with start index = 6 is "bac", which is an anagram of "abc".
    Example 2:

    Input:
    s: "abab" p: "ab"

    Output:
    [0, 1, 2]

    Explanation:
    The substring with start index = 0 is "ab", which is an anagram of "ab".
    The substring with start index = 1 is "ba", which is an anagram of "ab".
    The substring with start index = 2 is "ab", which is an anagram of "ab".
     */
    public List<Integer> findAnagrams(String s, String p) {
        if (s.length() < p.length()) return new LinkedList<>();
        int[] pData = new int[26];
        int[] sData = new int[26];
        for (char c : p.toCharArray()) pData[(c - 'a')]++;
        int sLength = s.length();
        int pLength = p.length();
        List<Integer> result = new LinkedList<>();
        for (int i = 0; i < sLength; i++) {
            sData[(int)(s.charAt(i) - 'a')]++;
            if (i >= pLength) sData[(int)s.charAt(i-pLength) - 'a']--;
            if (Arrays.equals(sData, pData)) result.add(i-pLength+1);
        }
        return result;
    }

}
