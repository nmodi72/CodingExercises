package main.selfpractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by nirmodi on 12/2/16.
 */
public class SprialTwoDimensionalArray {


    public static void iterateThroghArray(String[][] input) {
        if(input.length != input[0].length){
            throw new RuntimeException("Given array is not M * M");
        }

//        validateArray(input);
        iterateForwardDirection(input[0]);
        iterateDownwardDirection(input);
        iterateBackwardDirection(input[input.length - 1]);
        iterateUpwardDirection(input);
        if(input.length > 2 && input[0].length > 2){
            iterateThroghArray(createNewArray(input));
        }
        int square = (int) Math.pow(2, 3);


    }
    public static void validateArray(String[][] array){
        if(array == null || array.length == 0 ) {
            System.exit(0);
        }

    }
    public static String[][] createNewArray(String[][] array){
        String[][] result = new String[array.length - 2][array[0].length - 2];
        for (int i = 1; i < array.length - 1; i++) {
            for (int j = 1; j < array[i].length - 1; j++) {
                result[i-1][j-1] = array[i][j];
            }
        }
        return result;
    }
    public static void iterateForwardDirection(String[] array){
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }
    public static void iterateDownwardDirection(String[][] array){
        for (int i = 1; i < array.length; i++) {
            System.out.print(array[i][array[i].length - 1] + " ");
        }
    }
    public static void iterateBackwardDirection(String[] array){
        for (int i = array.length - 2; i > 0; i--) {
            System.out.print(array[i] + " ");
        }
    }
    public static void iterateUpwardDirection(String[][] array){
        for (int i = array.length - 1; i > 0; i--) {
            System.out.print(array[i][0] + " ");
        }
    }

    public static void main(String[] args){
        String[][] arr = { {"1", "2", "3"},
                            {"1", "2", "3"},
                            {"1", "2", "3"}};
//        iterateThroghArray(arr);
        int[] a = {};

        Set d = new TreeSet<>();

    }
}
