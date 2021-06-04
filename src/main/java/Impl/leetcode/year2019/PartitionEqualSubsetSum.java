package main.java.Impl.leetcode.year2019;

import java.util.HashSet;
import java.util.Set;

public class PartitionEqualSubsetSum {

    /*
    416. Partition Equal Subset Sum
    Given a non-empty array containing only positive integers, find if the array can be partitioned into two subsets such that the sum of elements in both subsets is equal.

    Note:
    Each of the array element will not exceed 100.
    The array size will not exceed 200.

    Example 1:
    Input: [1, 5, 11, 5]
    Output: true
    Explanation: The array can be partitioned as [1, 5, 5] and [11].


    Example 2:
    Input: [1, 2, 3, 5]
    Output: false
    Explanation: The array cannot be partitioned into equal sum subsets.
     */
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int n : nums) {
            sum += n;
        }
        if(sum % 2 == 1) return false;
        return isPartitionPossible(nums, sum/2-nums[0], 1, new HashSet<>());
    }

    private boolean isPartitionPossible(int[] nums, int target, int id, Set<Integer> visited){
        if(target == 0) return true;
        if(id >= nums.length || target < 0 || visited.contains(target)) return false;
        visited.add(target);
        for (int i=id; i < nums.length; i++) {
            target -= nums[i];
            if(isPartitionPossible(nums, target, i+1, visited)) return true;
            target += nums[i];
        }
        return false;
    }
}
