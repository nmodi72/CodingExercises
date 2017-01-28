package AccessMethod;

import java.util.Arrays;
import main.leetcode.RansomNote;
import main.leetcode.ZigZagProblem;
import main.selfpractice.ArrayRotate;
import main.selfpractice.BinarySearch;
import main.selfpractice.MaxSubArrayProblem;

/**
 * Created by nirmodi on 10/6/16.
 */
// {{"A", "B", "C", "D"}, {"E", "F", "G", "H"}, {"I", "J", "K", "L"}, {"M", "N", "O", "P"}}

// {{"A", "B", "C", "D"},
// {"E", "F", "G", "H"},
// {"I", "J", "K", "L"},
// {"M", "N", "O", "P"}}

public class MainClass {
//    public static void main(String[] args) {
////        SprialTwoDimensionalArray sprialTwoDimensionalArray = new SprialTwoDimensionalArray();
//////        String[][] array = {{"A", "B", "C", "D"}, {"E", "F", "G", "H"}, {"I", "J", "K", "L"}, {"M", "N", "O", "P"}, {"Q", "R", "S", "T"}};
////        String[][] array = {{"A", "B"}};
////        String[][] array1 = {{"A", "B", "C"}, {"E", "F", "G"}, {"I", "J", "K"}};
////        sprialTwoDimensionalArray.iterateThroghArray(array1);
//
//
//        ReverseAStringWithRecursion reverseAStringWithRecursion = new ReverseAStringWithRecursion();
//        System.out.println("Result:" + reverseAStringWithRecursion.reverseString("Hello"));
//
//        reverseAStringWithRecursion.run();
//    }

    public static void main(String args[]) throws Exception {
//        int[] arr = {1, 2, 3, 4, 5, 6, 7};
//
//        int[] result = ArrayRotate.leftRotatebyOne(arr, 3);
//        for (int i : result) {
//            System.out.print(i + " ");
//        }

        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        int[] result = ArrayRotate.leftRotate(arr, 2, 5);
        for (int i : result) {
            System.out.print(i + " ");
        }


    }
}
