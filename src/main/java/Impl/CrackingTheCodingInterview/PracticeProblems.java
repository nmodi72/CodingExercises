package main.java.Impl.CrackingTheCodingInterview;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Practice solutions of the cracking the coding interview book exercises
 */
public class PracticeProblems {

    // Chapter 1

    /**
     * Exercise 1.1
     * Implement an algorithm to determine if a string has all unique characters. What if you can not use additional data structures?
     */
    public static void main(String[] args) {
        int[][] arr = {{1, 2, 3},
                       {4, 0, 6},
                       {7, 8, 9}};
        int[][] result = setColumnRowZeroIfElementIsZero(arr);

//        for(int i =0; i < result.length; i++) {
//            for (int j = 0; j < result[i].length; j++){
//                System.out.print(result[i][j] + " ");
//            }
//            System.out.println("");
//        }
        System.out.println(isPerfectNumber(100000010L));
    }

    /**
     * Exercise 1.1
     * Implement an algorithm to determine if a string has all unique characters. What if you can not use additional data structures?
     */
    public static boolean isAllCharsAreUnique(String str){
        int[] table = new int[128];
        if(str != null){
            for (int i = 0; i < str.length(); i++) {
                if(table[str.charAt(i)] == 0) {
                    table[str.charAt(i)] = 1;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
    /**
     * Exercise 1.2 - Recursive approach
     * Write code to reverse a C-Style String. (C-String means that “abcd” is represented as five characters, including the null character.)
     */
    public static String reverseAStringRecursive(String str){
        if(str != null) {
            if(str.length() == 1) {
                return str;
            }
            return str.charAt(str.length() - 1) + reverseAStringRecursive(str.substring(0, str.length() - 1));
        }
        return str;
    }

    /**
     * Exercise 1.2 - Recursive approach
     * Write code to reverse a C-Style String. (C-String means that “abcd” is represented as five characters, including the null character.)
     */
    public static String reverseAStringIterative(String str){
        if(str != null) {
            StringBuilder sb = new StringBuilder();
            for(int i = str.length() - 1; i >= 0; i--) {
                sb.append(str.charAt(i));
            }
            return sb.toString();
        }
        return str;
    }


    /**
     * Exercise 1.3 - Remove Duplicate Characters
     * Design an algorithm and write code to remove the duplicate characters in a string without using any additional bu#er.
     * NOTE: One or two additional variables are fine. An extra copy of the array is not.
     */
    public static String removeDuplicateCharacters(String str){
        if(str != null) {
            int[] table = new int[128];
            for (int i = 0; i < str.length(); i++) {
                if(table[str.charAt(i)] == 0) {
                    table[str.charAt(i)] = 1;
                }
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < str.length(); i++) {
                if(table[str.charAt(i)] == 1) {
                    sb.append(str.charAt(i));
                    table[str.charAt(i)] = 0;
                }
            }
            return sb.toString();
        }
        return str;
    }


    /**
     * Exercise - Is given number perfect number?
     */
    public static boolean isPerfectNumber(long num){
        long sum = 0;
        int a = 0;
        for(long i = 1; i < num; i++) {
            if(num % i == 0) {
                sum += i;
                if(sum > num) {
                    return false;
                }
            }
            a += 1;
        }
        if(sum == num) {
            return true;
        }
        return false;
    }

    /**
     * Exercise - Find a ^ b - A square B
     */
    public static double findSquare(double a, int b) {
        if(b == 0) return 1;
        if(b < 0) {
            assert a != 0;
            return 1 / findSquare(a, -b);
        }
        double half = findSquare(a, b/2);
        return half * half * (b % 2 == 1 ? a : 1);
    }

    /**
     * Exercise 1.4 - Are strings anagrams
     * Write a method to decide if two strings are anagrams or not.
     */
    public static boolean isAnagram(String a, String b) {
        if(a == null || b == null)      return false;
        if(a.length() != b.length())    return false;
        int[] table = new int[128];
        for (int i = 0; i < a.length(); i++) {
            if(table[a.charAt(i)] == 0)     table[a.charAt(i)] = 1;
            else {
                table[a.charAt(i)] += 1;
            }
        }
        for (int i = 0; i < b.length(); i++) {
            if(--table[b.charAt(i)] < 0)     return false;
        }
        return true;
    }

    /**
     * Exercise 1.5 - Replace all spaces with ‘%20’
     * Write a method to replace all spaces in a string with ‘%20’
     */
    public static String replaceSpaces(String str) {
        if(str != null) {
            String[] arr = str.split(" ");
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < arr.length - 1; i++) {
                sb.append(arr[i]);
                sb.append("%20");
            }
            sb.append(arr[arr.length - 1]);
            return sb.toString();
        }
        return str;
    }

    /**
     * Exercise 1.6 - Rotate N*N matrix
     * Given an image represented by an NxN matrix, where each pixel in the image is 4
     * bytes, write a method to rotate the image by 90 degrees. Can you do this in place?
     */
    public static int[][] rotateMatrix(int[][] arr) {
        if(arr != null){
            int[][] result = new int[arr.length][arr[0].length];
            for(int i = 0; i < arr.length; i++) {
                for(int j = 0; j < arr[i].length; j++) {
                    result[i][j] = arr[(arr.length - 1) - j][i];
                }
            }
            return result;
        }
        return arr;
    }

    /**
     * Exercise 1.7 - Set Column and Row zero if element is 0
     * Write an algorithm such that if an element in an MxN matrix is 0, its entire row and
     * column is set to 0.
     */
    public static int[][] setColumnRowZeroIfElementIsZero(int[][] arr) {
        if(arr != null){
            int[] row = new int[arr.length];
            int[] column = new int[arr[0].length];

            for(int i = 0; i < arr.length; i++) {
                for(int j = 0; j < arr[i].length; j++) {
                    if(arr[i][j] == 0){
                        row[i] = 1;
                        column[i] = 1;
                    }
                }
            }
            for(int i = 0; i < arr.length; i++) {
                for(int j = 0; j < arr[i].length; j++) {
                    if(row[i] == 1 || column[j] == 1){
                        arr[i][j] = 0;
                    }
                }
            }
            return arr;
        }
        return arr;
    }

    /**
     * Exercise 1.8 - Is string in Rotation
     * Assume you have a method isSubstring which checks if one word is a substring of
     * another. Given two strings, s1 and s2, write code to check if s2 is a rotation of s1 using
     * only one call to isSubstring (i.e., “waterbottle” is a rotation of “erbottlewat”).
     */
    public static boolean isStringInRotation(String s1, String s2){
        if(s1 != null || s2 != null) {
            int len = s1.length();
            if(s2.length() == len && len > 0){
                String newStr = s1 + s1;
                return  true;
                //return isSubString(newStr, s2);
            }
        }
        return false;
    }

    // Chapter 2

    public enum FeeApplyTypeType {

        /**
         * Electronic payment fee
         */
        ELECTRONIC_PAYMENT_FEE("ElectronicPaymentFee"),

        /**
         * Statement reprint fee
         */
        STATEMENT_REPRINT_FEE("StatementReprintFee");

        private static final Map<String, FeeApplyTypeType> NAMES;
        static {
            final Map<String, FeeApplyTypeType> tmpNames = new HashMap<>();
            for (FeeApplyTypeType applyFeeType : values()) {
                tmpNames.put(applyFeeType.getName(), applyFeeType);
            }
            NAMES = Collections.unmodifiableMap(tmpNames);
        }

        private String name;

        public String getName() {
            return this.name;
        }

        public static FeeApplyTypeType lookupByName(final String lookupName) {
            if(NAMES.get(lookupName) == null) {
                throw new IllegalArgumentException(String.format("[%s] is not mapped to any available enums", lookupName));
            }
            return NAMES.get(lookupName);
        }

        private FeeApplyTypeType(final String name) {
            this.name = name;
        }

    }

//    /**
//     * Fee Type DTO
//     */
//    public enum FeeApplyTypeType {
//
//        /**
//         * Electronic payment fee
//         */
//        ELECTRONIC_PAYMENT_FEE("ElectronicPaymentFee"),
//        /**
//         * Statement reprint fee
//         */
//        STATEMENT_REPRINT_FEE("StatementReprintFee");
//
//        /**
//         * String value
//         */
//        private final String value;
//
//        /**
//         * Constructs enum DTO from string value
//         * @param value string value
//         */
//        FeeApplyTypeType(String value) {
//            this.value = value;
//        }
//
//        /**
//         * Returns string value
//         *
//         * @return string value
//         */
//        public String value() {
//            return value;
//        }
//
//        /**
//         * Looks up enum form string value
//         *
//         * @param value string value
//         * @return fee type DTO enum
//         */
//        public static FeeApplyTypeType fromValue(String value) {
//            for (FeeApplyTypeType applyFeeType: FeeApplyTypeType.values()) {
//                if (applyFeeType.value.equals(value)) {
//                    return applyFeeType;
//                }
//            }
//            throw new IllegalArgumentException(value);
//        }
//
//    }
}
