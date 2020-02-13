package main.java.Impl.leetcode.year2019;

import java.util.Arrays;
import java.util.Comparator;

/**
 * This is the leetcode problem: #179. Largest Number
 * Given a list of non negative integers, arrange them such that they form the largest number.
 *
 * Example 1:
 * Input: [10,2]
 * Output: "210"
 * Example 2:
 *
 * Input: [3,30,34,5,9]
 * Output: "9534330"
 * Note: The result may be very large, so you need to return a string instead of an integer.
 */
public class LargestNumber {
    public static String largestNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return "";
        }
        int n = nums.length;
        String[] strs = new String[n];
        for (int i = 0; i < n; i++) {
            strs[i] = String.valueOf(nums[i]);
        }
        Comparator<String> c = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String s1 = o1 + o2;
                String s2 = o2 + o1;
                return s2.compareTo(s1);
            }
        };
        Arrays.sort(strs, c);
        if (strs[0].charAt(0) == '0') {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            sb.append(str);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 2};
        largestNumber(arr);
    }
}
