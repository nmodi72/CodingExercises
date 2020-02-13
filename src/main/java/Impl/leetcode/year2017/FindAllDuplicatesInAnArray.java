package main.java.Impl.leetcode.year2017;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * This is leetcode problem # 442
 * Find all duplicates in an array
 *
 * Given an array of integers, 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.
 * Find all the elements that appear twice in this array.
 * Could you do it without extra space and in O(n) runtime?
 *
 * Example:
 * Input: [4,3,2,7,8,2,3,1]
 * Output: [2,3]
 */
public class FindAllDuplicatesInAnArray {

    // took for 27 testcase - 115 ms
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> resultList = new LinkedList<>();
        HashMap<Integer, Integer> hashMap = new HashMap();

        for (int number : nums) {
            if(hashMap.get(number) == null)     hashMap.put(number, 1);
            else {
                hashMap.put(number, (int) hashMap.get(number) + 1);
            }
        }
        for (Map.Entry entry : hashMap.entrySet()) {
            if((int) entry.getValue() > 1){
                resultList.add((int) entry.getKey());
            }
        }
        return resultList;
    }


    // just took 19ms
    public List<Integer> findDuplicatesNiceSolution(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; ++i) {
            int index = Math.abs(nums[i])-1;
            if (nums[index] < 0)
                res.add(Math.abs(index+1));
            nums[index] = -nums[index];
        }
        return res;
    }
}
