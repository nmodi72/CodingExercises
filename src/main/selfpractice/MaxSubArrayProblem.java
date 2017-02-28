package main.selfpractice;

import java.util.Random;

/**
 * Created by nirmodi on 1/9/17.
 */
public class MaxSubArrayProblem {

    public int findMaxValueFromSubArray(int[] arr) {
        int size = arr.length;
        int maxValueSoFar = Integer.MIN_VALUE;
        int maxValue = 0;
        String a = "abcd\n";
        ReverseAStringWithRecursion ra = new ReverseAStringWithRecursion();
        String b = ra.reverseStringWithoutRecursion(a);
        System.out.println("Input:*" +a +"*");
        System.out.println("*" +b +"*");

        String abc = null;
        if(abc.length() > 0) {

        }
        for(int i = 0; i < size; i++) {
            maxValue = maxValue + arr[i];
            if(maxValueSoFar < maxValue) {
                maxValueSoFar = maxValue;
            }
            if(maxValue < 0) {
                maxValue = 0;
            }
        }
        return maxValueSoFar;
    }

    public static String replace(String string, char character, char replacement) {
        String returnValue;

        if (string.length() > 0) {
            StringBuffer buffer = new StringBuffer();
            for (int i = 0; i < string.length(); i++) {
                char tempChar = string.charAt(i);
                if (tempChar != character) {
                    buffer.append(tempChar);
                } else {
                    buffer.append(replacement);
                }
            }
            returnValue = buffer.toString();
        } else {
            returnValue = string;
        }
        return returnValue;
    }

    public static String reverse1(String str) {
        if (str.isEmpty() || str.length() == 1) {
            return str;
        }
        int length = str.length() - 1;
        return str.charAt(length) + reverse1(str.substring(0, length));
    }
    public static String generateRandomString(String s) {
        if (s == null || s.length() == 1) {
            return s;
        }
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            sb.append(s.charAt(random.nextInt(s.length())));
        }
        return sb.toString();
    }

    public static int[] sortarray(int [] value)
    {
        for (int arrayIterator = 0; arrayIterator < value.length; arrayIterator++)
        {
            for(int iterator2=arrayIterator+1;iterator2<value.length;iterator2++){
                if(value[iterator2] < value[arrayIterator]){
                    int temp=value[arrayIterator];
                    value[arrayIterator]=value[iterator2];
                    value[iterator2]=temp;
                }
            }
        }  return value;
    }

    public static boolean isInPower2(int data) {
        if (data == 0) {
            return true;
        }
        int temp = -1;
        int i = 0;
        while (temp <= data) {
            temp =  findPower(2, i);
            if(temp == data) {
                return true;
            }
            i++;
        }
        return false;
    }

    public static int findPower(int a, int b){
        if(b == 0) {
            return 0;
        }
        if(b == 1) {
            return a;
        }
        return a * findPower(a, b - 1);
    }

    public String convertToBase7(int num) {
        if(num < 0){
            return "-" + convertToBase7(-num);
        } else if(num < 7){
            return num % 7 + "";
        } else {
            return convertToBase7(num / 7) + (num % 7);
        }

    }
}
