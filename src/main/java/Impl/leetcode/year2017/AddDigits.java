package main.java.Impl.leetcode.year2017;

/**
 * This is the leetcode problem: # 258
 * Add Digits
 *
 * Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.
 *
 * For example:
 * Given num = 38, the process is like: 3 + 8 = 11, 1 + 1 = 2. Since 2 has only one digit, return it.
 * Follow up:
 * Could you do it without any loop/recursion in O(1) runtime?
 */
public class AddDigits {

    // performance time 2 ms, beats 26.11% of total submissions
    public int addDigits(int num) {
        if (num <= 0){
            return 0;
        }
        int result = 0;
        while(num > 0) {
            result += (num % 10);
            num = num / 10;
        }
        if(result > 9){
            result = addDigits(result);
        }
        return result;

    }
}
