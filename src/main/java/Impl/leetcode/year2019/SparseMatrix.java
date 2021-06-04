package main.java.Impl.leetcode.year2019;

public class SparseMatrix {

    /*
    311. Sparse Matrix Multiplication
    Given two sparse matrices A and B, return the result of AB.

    You may assume that A's column number is equal to B's row number.

    Example:

    Input:

    A = [
      [ 1, 0, 0],
      [-1, 0, 3]
    ]

    B = [
      [ 7, 0, 0 ],
      [ 0, 0, 0 ],
      [ 0, 0, 1 ]
    ]

    Output:

         |  1 0 0 |   | 7 0 0 |   |  7 0 0 |
    AB = | -1 0 3 | x | 0 0 0 | = | -7 0 3 |
                      | 0 0 1 |
     */
    public int[][] multiply(int[][] A, int[][] B) {
        int[][] result = new int[A.length][B[0].length];

        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                int sum = 0;
                for (int a = 0; a < B.length; a++) {
                    sum += (A[i][a] * B[a][j]);
                }
                result[i][j] = sum;
            }
        }
        return result;
    }
}
