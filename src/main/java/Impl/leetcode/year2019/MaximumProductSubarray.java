package main.java.Impl.leetcode.year2019;

import java.util.ArrayList;
import java.util.List;

public class MaximumProductSubarray {
    /*
    152. Maximum Product Subarray
    Given an integer array nums, find the contiguous subarray within an array (containing at least one number) which has the largest product.

    Example 1:

    Input: [2,3,-2,4]
    Output: 6
    Explanation: [2,3] has the largest product 6.
    Example 2:

    Input: [-2,0,-1]
    Output: 0
    Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
     */
    public int maxProductFastSolution(int[] nums)
    {
        int currmax=nums[0];
        int currmin=nums[0];
        int finalans=nums[0];
        for(int a=1;a<nums.length;a++)
        {
            int temp=currmax;
            currmax=Math.max(Math.max(currmax*nums[a],currmin*nums[a]),nums[a]);
            currmin=Math.min(Math.min(temp*nums[a],currmin*nums[a]),nums[a]);
            finalans=Math.max(finalans,currmax);
        }
        return finalans;
    }


    public int maxProduct(int[] nums) {
        // if array contains 0, then split into two arrays and pass to find max product
        List<Integer> list = new ArrayList<>();
        int lastIndex = 0;
        int max = Integer.MIN_VALUE;
        while (lastIndex < nums.length) {
            for (int i = lastIndex; i < nums.length; i++) {
                if(nums[i] == 0) {
                    //compare if 0 is not max product.
                    max = Math.max(max, 0);
                    Integer[] arr1 = list.size() > 0 ? list.toArray(new Integer[list.size()]) : new Integer[0];
                    max = Math.max(findMaxProductForGivenArray(arr1), max);
                    list.clear();
                } else {
                    list.add(nums[i]);
                }
                lastIndex++;
            }
        }
        // if still some element left in list, pass and find max product
        if (!list.isEmpty()) {
            Integer[] arr1 = list.size() > 0 ? list.toArray(new Integer[list.size()]) : new Integer[0];
            max = Math.max(findMaxProductForGivenArray(arr1), max);
        }
        return max;
    }

    private Integer findMaxProductForGivenArray(Integer[] nums) {
        if(nums == null) return Integer.MIN_VALUE;
        if(nums.length == 1) return nums[0];
        int countNegatives = 0;
        for (int n : nums) {
            if (n < 0) countNegatives++;
        }
        // if negatives are in even number then directly pass and find product
        if (countNegatives % 2 == 0) {
            return findProduct(nums);
        } else {
            // otherwise, split into two arrays - first, skip first negative then in second, skip last negative.
            List<Integer> list1 = new ArrayList<>();
            List<Integer> list2 = new ArrayList<>();
            int negatives = 0;
            for(int n : nums) {
                if (n < 0) negatives++;
                if (negatives < (countNegatives)) {
                    list1.add(n);
                }
            }
            //let's make another list
            boolean firstNegativeskipped = false;
            for(int n : nums) {
                if (firstNegativeskipped) {
                    list2.add(n);
                }
                if (!firstNegativeskipped && n < 0) firstNegativeskipped = true;
            }
            Integer[] arr1 = list1.size() > 0 ? list1.toArray(new Integer[list1.size()]) : new Integer[0];
            Integer[] arr2 = list2.size() > 0 ? list2.toArray(new Integer[list2.size()]) : new Integer[0];
            return Math.max(findProduct(arr1), findProduct(arr2));
        }
    }

    private Integer findProduct(Integer[] nums) {
        int max = Integer.MIN_VALUE;
        int totalProduct = 0;
        if(nums.length == 0) return Integer.MIN_VALUE;
        for(int n : nums) {
            int currProduct = (totalProduct == 0) ? 1 : totalProduct;
            currProduct *= n;
            totalProduct = currProduct;
            max = Math.max(totalProduct, max);
        }
        return max;
    }
}
