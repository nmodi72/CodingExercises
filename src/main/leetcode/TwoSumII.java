package main.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by nirmodi on 1/28/17.
 */
public class TwoSumII {
    public int[] twoSum(int[] numbers, int target) {
        if(numbers == null) {
            return null;
        }
        int[] result = new int[2];
        Map table = new HashMap();
        for(int i = 0; i < numbers.length; i++) {
            if(table.get(i) == null)
                table.put(numbers[i], 1);
            else
                table.put(numbers[i], (int) table.get(i) +1);
        }
        int value1 = Integer.MIN_VALUE;
        int value2 = Integer.MIN_VALUE;
        for(int i = 0; i < numbers.length; i++) {
            if(table.get(target - numbers[i]) != null) {
                if(value1 == Integer.MIN_VALUE) {
                    value1 = i + 1;
                } else {
                    value2 = i + 1;
                }
            }
        }
        result[0] = value1 > value2 ? value2 : value1;
        result[1] = value1 < value2 ? value2 : value1;
        return result;
    }

}
