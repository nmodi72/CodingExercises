package main.java.Impl.leetcode.year2019;

import java.util.Arrays;

public class LongestIncreasingSubstring {

    /*
    300. Longest Increasing Subsequence
    Given an unsorted array of integers, find the length of longest increasing subsequence.

    Example:

    Input: [10,9,2,5,3,7,101,18]
    Output: 4
    Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
    Note:

    There may be more than one LIS combination, it is only necessary for you to return the length.
    Your algorithm should run in O(n2) complexity.
    Follow up: Could you improve it to O(n log n) time complexity?
     */
    public int lengthOfLIS(int[] nums) {
        int[] matrix = new int[nums.length];
        int i = 0;
        int j = i+1;
        Arrays.fill(matrix, 1);
        while (i < nums.length-1 && j < nums.length) {
            if (i == j) {
                i=0;
                j++;
            }
            if (nums[i] < nums[j]) {
                matrix[j] = Math.max(matrix[j], matrix[i]+1);
            }
            i++;
        }
        // now iterate through matrix and find max count
        int count = 0;
        for (int id = 0; id < matrix.length; id++) {
            count = Math.max(count, matrix[id]);
        }
        return count;
    }

    public int lengthOfLISWithMemoization(int[] nums) {
        int[][] matrix = new int[nums.length + 1][nums.length];
        for (int[] arr: matrix)
            Arrays.fill(arr, -1);
        return length(nums, -1, 0, matrix);
    }

    public int length(int[] nums, int prev, int curr, int[][] matrix) {
        if(curr == nums.length) return 0;
        if(matrix[prev+1][curr] >= 0) return matrix[prev+1][curr];
        int steps = 0;
        if (prev < 0 || nums[curr] > nums[prev]) {
            steps = 1 + length(nums, curr, curr+1, matrix);
        }
        int currSteps = length(nums, prev, curr+1, matrix);
        matrix[prev+1][curr] = Math.max(steps, currSteps);
        return matrix[prev+1][curr];

    }
}
