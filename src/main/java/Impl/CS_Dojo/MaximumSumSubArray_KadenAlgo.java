package main.java.Impl.CS_Dojo;

public class MaximumSumSubArray_KadenAlgo {

    public int findMaximumSum(int[] input) {
        int currentMax = input[0];
        int overallMax = input[0];
        for (int i = 1; i < input.length; i++) {
            currentMax = Math.max(input[i], currentMax + input[i]);
            if (currentMax > overallMax) {
                overallMax = currentMax;
            }
        }
        return overallMax;
    }
}
