package main.java.Impl.selfpractice;

import java.util.Set;
import java.util.TreeSet;

/**
 *
 */
public class SprialTwoDimensionalArray {

    public static void iterateThroghArray(String[][] input) {
        int left = 0;
        int right = input[0].length - 1;
        int upper = 0;
        int lower = input.length - 1;
        while(upper <= lower && left <= right) {
            iterateForwardDirection(input[upper], left, right);
            upper++;
            iterateDownwardDirection(input, upper, lower, right);
            right--;
            iterateBackwardDirection(input[lower], left, right);
            lower--;
            iterateUpwardDirection(input, upper, lower, left);
            left++;
        }
    }

    public static void validateArray(String[][] array){
        if(array == null || array.length == 0 ) {
            System.exit(0);
        }

    }

    public static void iterateForwardDirection(String[] array, int left, int right){
        for (int i = left; i <= right; i++) {
            System.out.print(array[i] + " ");
        }
    }

    public static void iterateDownwardDirection(String[][] array, int upper, int lower, int right){
        for (int i = upper; i <= lower; i++) {
            System.out.print(array[i][right] + " ");
        }
    }

    public static void iterateBackwardDirection(String[] array, int left, int right){
        for (int i = right; i >= left; i--) {
            System.out.print(array[i] + " ");
        }
    }

    public static void iterateUpwardDirection(String[][] array, int upper, int lower, int left){

        for (int i = lower; i >= upper; i--) {
            System.out.print(array[i][left] + " ");
        }
    }

    public static void main(String[] args){
        String[][] arr = { {"1", "2", "3"},
                            {"10", "11", "4"},
                            {"9", "12", "5"},
                            {"8", "7", "6"}};
        String[][] arr1 = { {"1"}};
        iterateThroghArray(arr1);
        int[] a = {};

        Set d = new TreeSet<>();

    }
}
