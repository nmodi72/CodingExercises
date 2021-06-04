package main.java.Impl.leetcode.year2019;

import java.util.LinkedList;
import java.util.List;

import com.sun.org.apache.regexp.internal.RE;

public class FindAllAnagrams {
    /**
     * This question was asked to P by google
     *
     * Find all anagrams given in a dictionary
     * step 1: print all anagrams
     * step 2: filter from dictionary
     */
    List<String> printAllAnagrams(String str) {
        return getAllAnagrams("", str, new LinkedList<String>());
    }
    List<String> getAllAnagrams(String s1, String s2, List<String> result) {
        for (int i = 0; i < s2.length(); i++) {
            getAllAnagrams(s1 + s2.charAt(i),  s2.substring(0, i) + s2.substring(i+1),result);
        }
        result.add(s1);
        return result;
    }


    private List<String> printAllAnagramsSameLength(String str) {
        return getAllAnagramsSameLength(str, new LinkedList<String>());
    }

    private List<String> getAllAnagramsSameLength(String str, List<String> result) {
        if (result.contains(str)) return new LinkedList<>();
        result.add(str);
        for (int i = 0; i < str.length(); i++) {
            String subStr = str.charAt(i) + str.substring(0, i) + str.substring(i+1);
            getAllAnagramsSameLength(subStr, result);
        }
        return result;
    }

    public static void main(String[] args) {
        FindAllAnagrams f = new FindAllAnagrams();
        for (String s : f.printAllAnagramsSameLength("123")) {
            System.out.println(s);
        }
    }
}
