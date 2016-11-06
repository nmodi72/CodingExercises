package leetcode;

import java.util.HashMap;
import java.util.Stack;

/**
 * This is the leetcode problem #349
 * Intersection of two arrays
 *
 * Given two arrays, write a function to compute their intersection.
 * Example:
 * Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].
 *
 * Note:
 * Each element in the result must be unique.
 * The result can be in any order.
 */
public class IntersectionOfTwoArrays {

    // 6 ms - 48.41% beat others
    public int[] intersection(int[] nums1, int[] nums2) {
        Stack stack = new Stack();
        HashMap<Integer, Boolean> table = new HashMap();
        for (int number : nums1) {
            if(!table.containsKey(number))     table.put(number, true);
        }
        for (int number : nums2) {
            if(table.containsKey(number)){
                stack.add(number);
                table.remove(number);
            }
        }
        int[] resultArray = new int[stack.size()];
        int i = 0;
        while(!stack.isEmpty()) {
            resultArray[i++] = (Integer) stack.pop();
        }
        return resultArray;
    }
}
