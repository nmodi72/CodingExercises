package main.java.Impl.leetcode.year2019;

import java.util.HashMap;
import java.util.Map;

public class ImageOverlap {
     /*
     835. Image Overlap
     Two images A and B are given, represented as binary, square matrices of the same size.  (A binary matrix has only 0s and 1s as values.)

    We translate one image however we choose (sliding it left, right, up, or down any number of units), and place it on top of the other image.  After, the overlap of this translation is the number of positions that have a 1 in both images.

    (Note also that a translation does not include any kind of rotation.)

    What is the largest possible overlap?

    Example 1:

    Input: A = [[1,1,0],
            [0,1,0],
            [0,1,0]]
       B = [[0,0,0],
            [0,1,1],
            [0,0,1]]
    Output: 3
    Explanation: We slide A to right by 1 unit and down by 1 unit.
      */
     public int largestOverlap(int[][] A, int[][] B) {
         Map<String, Integer> vectorMap = new HashMap<>();
         for (int ai = 0; ai < A.length; ai++) {
             for (int aj = 0; aj < A[0].length; aj++) {
                 if (A[ai][aj] != 1) continue;
                 for (int bi = 0; bi < B.length; bi++) {
                     for (int bj = 0; bj < B[0].length; bj++) {
                         if (B[bi][bj] != 1) continue;
                         String vector = (ai - bi) + ":" + (aj - bj);
                         vectorMap.put(vector, vectorMap.getOrDefault(vector, 0) + 1);
                     }
                 }
             }
         }
         int max = 0;
         for (int count : vectorMap.values()) max = Math.max(max, count);
         return max;
     }
}
