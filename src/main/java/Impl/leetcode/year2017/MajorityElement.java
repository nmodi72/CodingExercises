package main.java.Impl.leetcode.year2017;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * This is leetcode # 169
 * Majority Element
 *
 * Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.
 * You may assume that the array is non-empty and the majority element always exist in the array.
 */
public class MajorityElement {

    // 30 ms
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> table = new HashMap<>();
        for (int number: nums) {
            if(!table.containsKey(number))  table.put(number, 1);
            else    table.put(number, table.get(number) + 1);
        }
        Iterator iterator = table.entrySet().iterator();
        while(iterator.hasNext()){
            Map.Entry pair = (Map.Entry)iterator.next();
            if((int)pair.getValue() > (nums.length/2)){
                return (int)pair.getKey();
            }
        }
        return 0;
    }

    // 3 ms - 36% beat
    public int majorityElementNiceSolution(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }
}
