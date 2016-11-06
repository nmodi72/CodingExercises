package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/**
 * This is leetcode problem # 217
 * Contains Duplicate
 *
 * Given an array of integers, find if the array contains any duplicates.
 * Your function should return true if any value appears at least twice in the array, and it should return false if every element is distinct.
 *
 *
 */
public class ContainsDuplicate {

    // 16 ms - 9 % beat
    public boolean containsDuplicate(int[] nums) {

        HashMap<Integer, Integer> table = new HashMap<>();
        for (int number: nums) {
            if(table.put(number, 1) != null)   return true;
        }
        return false;
    }

    // 9 ms = 67.67% beat
    public boolean containsDuplicateWithHashSet(int[] nums) {
        if(nums==null || nums.length==0)
            return false;
        HashSet<Integer> set = new HashSet<Integer>();
        for(int i: nums){
            if(!set.add(i)){
                return true;
            }
        }

        return false;
    }


}
