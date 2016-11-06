package leetcode;

import java.util.Stack;

/**
 * This is the leetcode problem: # 344
 * Reverse a string,
 *
 * For given a string, reverse the string (E.g Input-"Hello", Output "olleH")
 */
public class ReverseString {

    public String reverseString(String s) {
        if(s == null){
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        char[] charArray = s.toCharArray();
        for (int i = charArray.length - 1; i >= 0; i--) {
            stringBuilder.append(charArray[i]);
        }
        return stringBuilder.toString();
    }
}
