package main.leetcode;

/**
 * 476. Number Complement
 * Given a positive integer, output its complement number. The complement strategy is to flip the bits of its binary representation.
 *
 * Input: 5
 * Output: 2
 * Explanation: The binary representation of 5 is 101 (no leading zero bits), and its complement is 010. So you need to output 2.
 */
public class NumberComplement {

    public int findComplement(int num) {
        if (num == 1) {
            return 0;
        }
        if (num == 0) {
            return 1;
        }
        String binaryStr = Integer.toBinaryString(num);
        StringBuilder sb = new StringBuilder();
        sb.append(binaryStr);
        sb = sb.reverse();

        int result = 0;
        for (int i = 0; i < binaryStr.length(); i++) {
            if (sb.charAt(i) == '0') {
                result = result + (int) Math.pow(2, i);
            }
        }
        return result;
    }
}
