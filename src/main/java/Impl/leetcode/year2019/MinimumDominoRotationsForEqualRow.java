package main.java.Impl.leetcode.year2019;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MinimumDominoRotationsForEqualRow {
    /*
    1007. Minimum Domino Rotations For Equal Row

    In a row of dominoes, A[i] and B[i] represent the top and bottom halves of the i-th domino.  (A domino is a tile with two numbers from 1 to 6 - one on each half of the tile.)
    We may rotate the i-th domino, so that A[i] and B[i] swap values.
    Return the minimum number of rotations so that all the values in A are the same, or all the values in B are the same.
    If it cannot be done, return -1.

    Example 1:
    Input: A = [2,1,2,4,2,2], B = [5,2,6,2,3,2]
    Output: 2
    Explanation:
    The first figure represents the dominoes as given by A and B: before we do any rotations.
    If we rotate the second and fourth dominoes, we can make every value in the top row equal to 2, as indicated by the second figure.
     */
    public int minDominoRotations(int[] A, int[] B) {
        if (A.length != B.length) return -1;
        int[] diceInA = new int[7];
        int[] diceInB = new int[7];
        for(int i : A) diceInA[i]++;
        for(int i : B) diceInB[i]++;

        PriorityQueue<Integer> pqA = new PriorityQueue<>(new Comparator<Integer>() {
            public int compare(Integer i1, Integer i2)
            {
                return diceInA[i2] - diceInA[i1];
            }
        });
        PriorityQueue<Integer> pqB = new PriorityQueue<>(new Comparator<Integer>() {
            public int compare(Integer i1, Integer i2)
            {
                return diceInB[i2] - diceInB[i1];
            }
        });
        pqA.add(1);
        pqA.add(2);
        pqA.add(3);
        pqA.add(4);
        pqA.add(5);
        pqA.add(6);

        pqB.add(1);
        pqB.add(2);
        pqB.add(3);
        pqB.add(4);
        pqB.add(5);
        pqB.add(6);
        boolean replaceA = false;
        int iteration = 0;
        //while ((!pqA.isEmpty() && !pqB.isEmpty()))  {
        while (iteration < 2)  {
            int value = 0;
            if ((diceInA[pqA.peek()] > diceInB[pqB.peek()]) || (pqA.size() == 6)) {
                value = pqA.poll();
            } else {
                value = pqB.poll();
                replaceA = true;
            }
            int countA = countSteps(A, B, value, replaceA);
            int countB = countSteps(A, B, value, !replaceA);
            if (countA >= 0 && countB >= 0) {
                return Math.min(countA, countB);
            }
            iteration++;
        }
        return -1;

    }

    int countSteps(int[] A, int[] B, int value, boolean replaceA)  {
        int count = 0;
        int valueMatched = 0;
        for (int i = 0; i < A.length; i++) {
            if (replaceA) {
                if (A[i] == value) {
                    valueMatched++;
                } else if (A[i] != value && B[i] == value) {
                    valueMatched++;
                    count++;
                }
            } else {
                if (B[i] == value) {
                    valueMatched++;
                } else if (B[i] != value && A[i] == value) {
                    valueMatched++;
                    count++;
                }
            }
        }
        return (valueMatched == A.length) ? count : -1;
    }
}
