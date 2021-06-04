package main.java.Impl.leetcode.year2019;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ClimbingStairCase {

    int[][] climbingStairCase(int n, int k) {
        if (n < 0) return new int[0][0];
        if (n == 0) return new int[1][0];
        Stream<IntStream> r = Stream.empty();
        for (int i = 0; i <= k; i++) {
            int[][] c = climbingStairCase(n-i, k);
            final int finalStep = i;
            Stream<IntStream> newStr = Arrays.stream(c)
                    .map(a -> IntStream.concat(IntStream.of(finalStep), Arrays.stream(a)));
            r = Stream.concat(r, newStr);
        }
        return r.map(s -> s.toArray()).toArray(int[][]::new);
    }


}
