package main.java.Impl.leetcode.year2019;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

    /*
    15. 3Sum
    Target to zero - 0
     */
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length < 3) return result;
        int j = 1;
        int sum = 0;
        for (int i=0; i < nums.length-2; ++i) {
            if (i > 0 && nums[i-1] == nums[i]) continue;
            j = i+1; int k = nums.length - 1;
            while (j < k) {
                sum = nums[i] + nums[j] + nums[k];
                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    while(++j < k && nums[j-1] == nums[j]);
                    while(--k > j && nums[k] == nums[k+1]);
                } else if (sum > 0){
                    while(--k > j && nums[k] == nums[k+1]);
                } else {
                    while(++j < k && nums[j-1] == nums[j]);
                }
            }
        }
        return result;
    }
}
