package leetcode;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * This is the leetcode problem: # 136
 * Given an array of integers, every element appears twice except for one. Find that single one.
 *
 * Note:
 * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 */
public class SingleNumber {

    public int singleNumber(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        HashMap<Integer, Boolean> hashMap = new HashMap<>();
        for (int number : nums) {
            if(hashMap.containsKey(number)){
                hashMap.remove(number);
            } else {
                hashMap.put(number, true);
            }
        }
        Iterator iterator = hashMap.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry pair = (Map.Entry)iterator.next();
            return (Integer)pair.getKey();
        }
        // Impossible case, for given problem
        return 0;
    }
}
