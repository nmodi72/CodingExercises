package main.java.Impl.leetcode.year2019;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK {
    /*
    560. Subarray Sum Equals K
    Given an array of integers and an integer k, you need to find the total number of continuous subarrays whose sum equals to k.

    Example 1:
    Input:nums = [1,1,1], k = 2
    Output: 2
    Note:
    The length of the array is in range [1, 20,000].
    The range of numbers in the array is [-1000, 1000] and the range of the integer k is [-1e7, 1e7].
     */
    public int subarraySum(int[] nums, int k) {
        return calculateTable(nums, k);
    }

    private int calculateTable(int[] nums, int k) {
        Map<Integer, Integer> data = new HashMap<>();
        int sum = 0;
        int count = 0;
        data.put(sum, 1);
        for (int n : nums) {
            sum += n;
            int sumCount = data.getOrDefault(sum, 0);
            count += data.getOrDefault(sum-k, 0);
            sumCount++;
            data.put(sum, sumCount);
        }
        return count;
    }
}
