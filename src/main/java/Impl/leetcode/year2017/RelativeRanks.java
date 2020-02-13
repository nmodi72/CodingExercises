package main.java.Impl.leetcode.year2017;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 * 506. Relative Ranks
 * Given scores of N athletes, find their relative ranks and the people with the top three highest scores,
 * who will be awarded medals: "Gold Medal", "Silver Medal" and "Bronze Medal".
 *
 * Input: [5, 4, 3, 2, 1]
 * Output: ["Gold Medal", "Silver Medal", "Bronze Medal", "4", "5"]
 * Explanation: The first three athletes got the top three highest scores, so they got "Gold Medal", "Silver Medal" and "Bronze Medal".
 * For the left two athletes, you just need to output their relative ranks according to their scores
 */
public class RelativeRanks {

    public static String[] findRelativeRanks(int[] nums) {
        Map<Integer, String> data = new HashMap<Integer, String>();
        for(int i = 0; i < nums.length; i++) {
            data.put(nums[i], "");
        }
        Set<Integer> rank = new TreeSet<Integer>();
        for(int i = 0; i < nums.length; i++) {
            rank.add(nums[i]);
        }
        Iterator it = rank.iterator();
        int var = nums.length;
        while(it.hasNext()) {
            if (var == 1) {
                data.put((Integer) it.next(), "Gold Medal");
            } else if(var == 2) {
                data.put((Integer) it.next(), "Silver Medal");
            } else if(var == 3) {
                data.put((Integer) it.next(), "Bronze Medal");
            } else {
                data.put((Integer) it.next(), String.valueOf(var));
            }
            var--;
        }
        String[] result = new String[nums.length];
        for(int i = 0; i < nums.length; i++) {
            result[i] = data.get(nums[i]);
        }
        return result;
    }
    public static void main(String[] args) {
        int[] arr1 = {5, 4, 3, 2, 1};
        int[] arr2 = {1,3,4,2};
        String[] result = findRelativeRanks(arr1);


    }
}
