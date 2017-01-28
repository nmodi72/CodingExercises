package main.leetcode;

/**
 * This is leetcode problem # 7
 * Reverse integer
 *
 * Reverse digits of an integer.
 * Example1: x = 123, return 321
 * Example2: x = -123, return -321
 */
public class ReverseInteger {
    public int reverse(int x) {
        int result = 0;
        boolean flag = false;
        if(x < 0) {
            flag = true;
            x = -x;
        }
        try {
            StringBuilder st = new StringBuilder();
            st.append(String.valueOf(x));
            String reverseString = st.reverse().toString();
            result = Integer.parseInt(reverseString);
        } catch (NumberFormatException e) {
            return result;
        }
        return result = flag == true ? -result : result;
    }
}
