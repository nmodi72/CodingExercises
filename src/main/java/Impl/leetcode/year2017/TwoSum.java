package main.java.Impl.leetcode.year2017;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * You may assume that each input would have exactly one solution.
 *
 * Example: Given nums = [2, 7, 11, 15], target = 9,
 * Explaination: Because nums[0] + nums[1] = 2 + 7 = 9, return [0, 1].
 */
public class TwoSum {

    // 15ms- 44.44 % beat
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        Map table = new HashMap();
        for (int number : nums) {
            if (table.get(number) == null){
                table.put(number, 1);
            } else {
                table.put(number, (int) table.get(number)+1);
            }
        }
        int number2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if((int) table.get(nums[i]) == 1) {
                table.remove(nums[i]);
            }

            if (table.get(target - nums[i]) != null) {
                number2 = target - nums[i];
                result[0] = i;
                table.put(target - nums[i], (int) table.get(target - nums[i])-1);
            }
            if(nums[i] == number2) {
                if(result[0] != i) {
                    result[1] = i;
                    return result;
                }

            }
        }

        return null;
    }
}
