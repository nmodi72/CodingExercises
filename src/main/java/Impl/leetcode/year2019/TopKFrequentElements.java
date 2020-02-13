package main.java.Impl.leetcode.year2019;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This is the leetcode problem: 347. Top K Frequent Elements
 *
 * Given a non-empty array of integers, return the k most frequent elements.
 *
 * Example 1:
 *
 * Input: nums = [1,1,1,2,2,3], k = 2
 * Output: [1,2]
 * Example 2:
 *
 * Input: nums = [1], k = 1
 * Output: [1]
 * Note:
 *
 * You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
 * Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
 */
public class TopKFrequentElements {
    public static List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> valueToCount = new HashMap<>();
        Map<Integer, List<Integer>> countToValues = new HashMap<>();
        int highest = -1;

        for (int num : nums) {
            if (valueToCount.containsKey(num)) {
                int ct = valueToCount.get(num);
                ct++;
                valueToCount.put(num, ct);
            } else {
                valueToCount.put(num, 1);
            }
        }

        for (Map.Entry mapElement : valueToCount.entrySet()) {
            int retrivedCountPerValue = (int)mapElement.getValue();
            if (retrivedCountPerValue > highest) {
                highest = retrivedCountPerValue;
            }

            List<Integer> valueList;
            if (countToValues.containsKey(retrivedCountPerValue)) {
                valueList = countToValues.get(retrivedCountPerValue);
            } else {
                valueList = new ArrayList<>();
            }
            valueList.add((int)mapElement.getKey());
            countToValues.put(retrivedCountPerValue, valueList);
        }

        List<Integer> result = new ArrayList<>();
        while(k > 0) {
            if (countToValues.containsKey(highest)) {
                List<Integer> retrievedValueList = countToValues.get(highest);
                for(Integer val : retrievedValueList) {
                    if (k > 0) {
                        result.add(val);
                        k--;
                    }
                }
            }

        }
        return result;
    }

    public static void main(String[] arr) {
        int[] input = {5,3,1,1,1,3,73,1};
        List<Integer> result = topKFrequent(input, 2);
        for(Integer val : result) {
            System.out.println(val);
        }
    }


}
