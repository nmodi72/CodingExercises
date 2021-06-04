package main.java.Impl.leetcode.year2019;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class PermutationsInArray {
    /*
    46. Permutations
    Given a collection of distinct integers, return all possible permutations.

    Example:

    Input: [1,2,3]
    Output:
    [
      [1,2,3],
      [1,3,2],
      [2,1,3],
      [2,3,1],
      [3,1,2],
      [3,2,1]
    ]

     */
    List<List<Integer>> result = new LinkedList<>();

    public List<List<Integer>> permute(int[] nums) {
        findPermutations(nums, nums.length, 0);
        return result;
    }

    private void findPermutations(int[] nums, int size, int id) {
        if (id == size)
            result.add(Arrays.stream(nums).boxed().collect(Collectors.toList()));

        for(int i = id; i < size; i++) {
            swap(nums, id, i);
            findPermutations(nums, size, id + 1);
            swap(nums, id, i);
        }
    }

    private int[] swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
        return nums;
    }
}
