package main.java.Impl.leetcode.year2019;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * This is the leetcode problem: #498
 * Diagonal Traverse
 *
 * Given a matrix of M x N elements (M rows, N columns), return all elements of the matrix in diagonal order as shown in the below image.
 * Input:
 * [
 *  [ 1, 2, 3 ],
 *  [ 4, 5, 6 ],
 *  [ 7, 8, 9 ]
 * ]
 *
 * Output:  [1,2,4,7,5,3,6,8,9]
 */
public class DiagonalTraverse {
    public static int[] findDiagonalOrder(int[][] matrix) {
        // check base condition
        int x = matrix[0].length;
        int y = matrix.length;
        int  i = 0, j = 0;
        int[] result = new int[x*y];
        boolean areWeGoingUpward = true;
        for (int var = 0; var < x*y; var ++) {
            result[var] = matrix[i][j];
            if (areWeGoingUpward) {
                if (i == 0 || j == x-1) {
                    if (j < x-1) {
                        j++;
                    } else {
                        i++;
                    }
                    areWeGoingUpward = false;
                } else {
                    i--;
                    j++;
                }
            } else {
                if (j==0 || i==y-1) {
                   if (i < y-1) {
                       i++;
                   } else {
                       j++;
                   }
                   areWeGoingUpward = true;
                } else {
                    i++;
                    j--;
                }
            }
        }
        return result;
    }

    public static void main(String[] arr) {
        int[][] input = {{1,2,3},{4,5,6},{7,8,9}};
        int[] result = findDiagonalOrder(input);
        for (int i : result) {
            System.out.print(i + " ");
        }
    }
}
