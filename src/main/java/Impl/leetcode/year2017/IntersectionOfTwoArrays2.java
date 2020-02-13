package main.java.Impl.leetcode.year2017;

import java.util.HashMap;
import java.util.Stack;

/**
 * This is the leetcode problem # 350
 * Intersection of two arrays II
 *
 * Given two arrays, write a function to compute their intersection.
 * Example:
 * Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2, 2].
 *
 * Note:
 * 1. Each element in the result should appear as many times as it shows in both arrays.
 * 2. The result can be in any order.
 *
 * Follow up:
 * 1. What if the given array is already sorted? How would you optimize your algorithm?
 * 2. What if nums1's size is small compared to nums2's size? Which algorithm is better?
 * 3. What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?
 */
public class IntersectionOfTwoArrays2 {

    // 8 ms - 26.27% beat
    public int[] intersect(int[] nums1, int[] nums2) {
        if(nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) return new int[0];
        Stack stack = new Stack();
        HashMap<Integer, Integer> hashMap = new HashMap();
        for (int number : nums1) {
            if(!hashMap.containsKey(number))  hashMap.put(number, 1);
            else {
                hashMap.put(number, hashMap.get(number) + 1);
            }
        }
        for (int number : nums2) {
            if(hashMap.containsKey(number) && hashMap.get(number) > 0) {
                stack.push(number);
                hashMap.put(number, hashMap.get(number) - 1);
            }
        }
        int[] resultArray = new int[stack.size()];
        int i = 0;
        while (!stack.isEmpty()) {
            resultArray[i++] = (int) stack.pop();
        }
        return resultArray;
    }

}
