package main.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * This is the leetcode problem: # 283
 * Move Zeroes
 *
 * Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements
 * For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].
 * Note:
 *      1. You must do this in-place without making a copy of the array
 *      2. Minimize the total number of operations.
 */
public class MoveZeroes {

    // performance is 4ms : beats 16.15% other java submissions
    public int[] moveZeroes(int[] nums) {
        if(nums == null || nums.length == 0){
            return null;
        }
        Queue<Integer> queue = new LinkedList<>();
        int zeroCount = 0;
        for (int number : nums) {
            if (number == 0){
                zeroCount++;
            } else {
                queue.add(number);
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if(!queue.isEmpty()){
                nums[i] = queue.poll();
            } else {
                nums[i] = 0;
            }
        }
        return nums;
    }
}
