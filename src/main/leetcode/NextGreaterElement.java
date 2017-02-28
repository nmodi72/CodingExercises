package main.leetcode;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import java.util.TreeSet;

/**
 * Created by nirmodi on 2/15/17.
 */
public class NextGreaterElement {

    public static int[] nextGreaterElement(int[] findNums, int[] nums) {
        int[] result = new int[findNums.length];
        Map<Integer, Integer> data = new HashMap<Integer, Integer>();
        for(int i = 0; i < findNums.length; i++) {
            data.put(findNums[i], 1);
        }
        int value;
        for(int i = 0; i < findNums.length; i++) {
            value = Integer.MAX_VALUE;
            for(int j = 0; j < nums.length; j++){
                if((findNums[i] < nums[j]) && (nums[j] < value) && (data.get(nums[j]) == null)) {
                    value = nums[j];
                    data.put(nums[j], 1);
                }
            }

            if(value != Integer.MAX_VALUE){
                result[i] = value;
            } else {
                result[i] = -1;
            }

        }
        return result;
    }

    // another best approach
    public static int[] nextGreaterElement1(int[] findNums, int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack();
        for(int i : nums){
            while(!stack.isEmpty() && stack.peek() < i){
                map.put(stack.pop(), i);
            }
            stack.push(i);
        }
        for (int i = 0; i < findNums.length; i++) {
            findNums[i] = map.getOrDefault(findNums[i], -1);
        }
        return findNums;
    }

    public static void main(String[] args) {
        int[] arr1 = {4,1,2};
        int[] arr2 = {1,3,4,2};
        int[] result = nextGreaterElement1(arr1, arr2);

        Set<Integer> rank = new TreeSet<Integer>();
        for(int i = 0; i < arr1.length; i++) {
            rank.add(arr1[i]);
        }

    }
}
