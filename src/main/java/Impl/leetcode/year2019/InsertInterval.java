package main.java.Impl.leetcode.year2019;

import java.util.LinkedList;
import java.util.List;

public class InsertInterval {

    /*
    57. Insert Interval
    Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).

    You may assume that the intervals were initially sorted according to their start times.

    Example 1:

    Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
    Output: [[1,5],[6,9]]
    Example 2:

    Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
    Output: [[1,2],[3,10],[12,16]]
    Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].
     */
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new LinkedList<>();
        int newStart = newInterval[0];
        int newEnd = newInterval[1];
        int i = 0;
        for (; i < intervals.length; i++) {
            if (intervals[i][0] < newStart && intervals[i][1] < newStart) {
                result.add(new int[]{intervals[i][0], intervals[i][1]});
            } else if ((newStart >= intervals[i][0] && newStart <= intervals[i][1])
                    || (newStart <= intervals[i][0] && newEnd >= intervals[i][0])) {
                newStart = Math.min(newStart, intervals[i][0]);
                newEnd = Math.max(newEnd, intervals[i][1]);
            } else if (newStart < intervals[i][0] && newEnd < intervals[i][0]) {
                break;
            }
        }

        result.add(new int[]{newStart, newEnd});
        for (; i < intervals.length; i++) {
            result.add(new int[]{intervals[i][0], intervals[i][1]});
        }

        return result.toArray(new int[0][0]);
    }
}
