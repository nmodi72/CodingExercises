package main.java.Impl.leetcode.year2019;

import java.util.HashMap;

/**
 * This is the leetcode problem: #383
 * Rotate Array
 *
 * Given an array, rotate the array to the right by k steps, where k is non-negative.
 *
 * Example 1:
 * Input: [1,2,3,4,5,6,7] and k = 3
 * Output: [5,6,7,1,2,3,4]
 * Explanation:
 * rotate 1 steps to the right: [7,1,2,3,4,5,6]
 * rotate 2 steps to the right: [6,7,1,2,3,4,5]
 * rotate 3 steps to the right: [5,6,7,1,2,3,4]
 *
 * Example 2:
 * Input: [-1,-100,3,99] and k = 2
 * Output: [3,99,-1,-100]
 * Explanation:
 * rotate 1 steps to the right: [99,-1,-100,3]
 * rotate 2 steps to the right: [3,99,-1,-100]
 */
public class RotateArray {
    public static int[] rotate(int[] nums, int k) {
        while (k > 0) {
            for (int i = nums.length - 1; i > 0; i--) {
                int temp = nums[i-1];
                nums[i-1] = nums[i];
                nums[i] = temp;
            }
            k--;
        }
        return nums;
    }

    public static void main(String[] arr) {
        int[] input = {1,2,3,4,5,6,7};
        int[] result = rotate(input, 3);
        for (int i : result) {
            System.out.println(i);
        }
    }
}
