package main.java.Impl.leetcode.year2017;

import java.util.Stack;

/**
 * This is leetcode problem # 415
 * Add Strings
 *
 * Given two non-negative numbers num1 and num2 represented as string, return the sum of num1 and num2.
 * Note:
 * 1. The length of both num1 and num2 is < 5100.
 * 2. Both num1 and num2 contains only digits 0-9.
 * 3. Both num1 and num2 does not contain any leading zero.
 * 4. You must not use any built-in BigInteger library or convert the inputs to integer directly.
 *
 */
public class AddStrings {

    public String addStrings(String num1, String num2) {
        int maxLength = Math.max(num1.length(), num2.length());
        int carry = 0;
        StringBuilder result = new StringBuilder();
        Stack stack = new Stack();
        for(int i = 0; i < maxLength; i++) {
            int value = carry;
            if(i < num1.length())      value += num1.charAt((num1.length()-1) - i) - '0';
            if(i < num2.length())      value += num2.charAt((num2.length()-1) - i) - '0';
            if(value >= 10) {
                stack.push(value % 10);
                carry = value / 10;
            } else {
                stack.push(value);
                carry = 0;
            }
        }
        if(carry != 0)     stack.push(carry);
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }
        return result.toString();
    }
}
