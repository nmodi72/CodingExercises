package main.java.Impl.leetcode.year2019;

public class MissingElementInSortedArray {
    /**
      1060. Missing Element in Sorted Array
     Given a sorted array A of unique numbers, find the K-th missing number starting from the leftmost number of the array.



     Example 1:

     Input: A = [4,7,9,10], K = 1
     Output: 5
     Explanation:
     The first missing number is 5.
     Example 2:

     Input: A = [4,7,9,10], K = 3
     Output: 8
     Explanation:
     The missing numbers are [5,6,8,...], hence the third missing number is 8.
     Example 3:

     Input: A = [1,2,4], K = 3
     Output: 6
     Explanation:
     The missing numbers are [3,5,6,7,...], hence the third missing number is 6.
     */
    public int missingElement(int[] nums, int k) {
        int n = nums.length;
        if (k > missingNumbers(n-1, nums)) return nums[n-1] + k - missingNumbers(n-1, nums);
        int left = 0, right = n-1, pivot;
        while (left != right) {
            pivot = left + (right-left)/2;
            if (missingNumbers(pivot, nums) < k) left = pivot + 1;
            else right = pivot;
        }
        return nums[left-1] + k - missingNumbers(left-1, nums);
    }
    int missingNumbers(int id, int[] nums) {
        return nums[id] - nums[0] - id;
    }
}
