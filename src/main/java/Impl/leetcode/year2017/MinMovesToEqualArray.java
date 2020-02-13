package main.java.Impl.leetcode.year2017;

/**
 *
 * Given a non-empty integer array of size n, find the minimum number of moves required to make all array elements equal,
 * where a move is incrementing n - 1 elements by 1.
 *
 * Input: [1,2,3]
 * Output:3
 * Explanation:
 * Only three moves are needed (remember each move increments two elements):
 * [1,2,3]  =>  [2,3,3]  =>  [3,4,3]  =>  [4,4,4]
 */
public class MinMovesToEqualArray {

    public static int minMoves(int[] nums) {
        if(nums != null || nums.length == 0) {
            int min = nums[0];
            for (int n : nums)  min = Math.min(n, min);
            int result = 0;
            for (int n : nums)  result += + n - min;
            return result;
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] array = {1,2147483647};
        System.out.print("Result: " + MinMovesToEqualArray.minMoves(array));
    }
}
