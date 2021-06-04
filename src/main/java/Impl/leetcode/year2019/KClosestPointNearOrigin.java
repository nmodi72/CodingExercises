package main.java.Impl.leetcode.year2019;

import java.util.Arrays;

public class KClosestPointNearOrigin {

    /*
    973. K Closest Points to Origin
    We have a list of points on the plane.  Find the K closest points to the origin (0, 0).

    (Here, the distance between two points on a plane is the Euclidean distance.)

    You may return the answer in any order.  The answer is guaranteed to be unique (except for the order that it is in.)



    Example 1:

    Input: points = [[1,3],[-2,2]], K = 1
    Output: [[-2,2]]
    Explanation:
    The distance between (1, 3) and the origin is sqrt(10).
    The distance between (-2, 2) and the origin is sqrt(8).
    Since sqrt(8) < sqrt(10), (-2, 2) is closer to the origin.
    We only want the closest K = 1 points from the origin, so the answer is just [[-2,2]].
    Example 2:

    Input: points = [[3,3],[5,-1],[-2,4]], K = 2
    Output: [[3,3],[-2,4]]
    (The answer [[-2,4],[3,3]] would also be accepted.)
     */
    public int[][] kClosest(int[][] points, int K) {
        int[][] data = new int[points.length][2];
        for(int i = 0; i < points.length; i++) {
            data[i][0] = (points[i][0]*points[i][0]) + (points[i][1]*points[i][1]);
            data[i][1] = i;
        }

        Arrays.sort(data, (e1, e2) -> {
            if (e1[0] > e2[0]) return 1;
            else return -1;
        });

        int[][] result = new int[K][2];
        int index = 0;
        while(K > 0) {
            result[index][0] = points[data[index][1]][0];
            result[index][1] = points[data[index][1]][1];
            index++;
            K--;
        }
        return result;
    }
}
