package main.java.Impl.leetcode.year2019;

import java.util.Stack;

/**
 * This is the leetcode problem: 48. Rotate Image
 *
 * You are given an n x n 2D matrix representing an image.
 * Rotate the image by 90 degrees (clockwise).
 *
 * Note:
 * You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.
 *
 * Example 1:
 * Given input matrix =
 * [
 *   [1,2,3],
 *   [4,5,6],
 *   [7,8,9]
 * ],
 *
 * rotate the input matrix in-place such that it becomes:
 * [
 *   [7,4,1],
 *   [8,5,2],
 *   [9,6,3]
 * ]
 */
public class RotateImage {
    public static void convertRowsToColumn(int[][] matrix) {
        if (matrix != null && matrix.length > 0 && matrix[0].length > 0) {
            for (int i =0; i < matrix.length; i++) {
                for (int j = i; j < matrix[0].length; j++) {
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = temp;
                }
            }
        }
    }

    public static void reverse(int[][] matrix) {
        if (matrix != null && matrix.length > 0 && matrix[0].length > 0) {
            int y = matrix.length;
            int i = 0, j = matrix[0].length-1;
            for (int a =0; a < matrix.length; a++) {
                while (i < j) {
                    int temp = matrix[a][i];
                    matrix[a][i] = matrix[a][j];
                    matrix[a][j] = temp;
                    i++;
                    j--;
                }
                i = 0;
                j = matrix[0].length-1;
            }
        }
    }

    static int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};

    public static void main(String[] arr) {
        convertRowsToColumn(matrix);
        reverse(matrix);
        for (int i =0; i < matrix.length; i++) {
            for (int j =0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println(" ");
        }

    }


}
