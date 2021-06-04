package main.java.Impl.leetcode.year2019;

import java.util.Arrays;

public class TaskScheduler {
     /*
        621. Task Scheduler
        Given a char array representing tasks CPU need to do. It contains capital letters A to Z where different letters represent different tasks. Tasks could be done without original order. Each task could be done in one interval. For each interval, CPU could finish one task or just be idle.

        However, there is a non-negative cooling interval n that means between two same tasks, there must be at least n intervals that CPU are doing different tasks or just be idle.

        You need to return the least number of intervals the CPU will take to finish all the given tasks.

        Example:
        Input: tasks = ["A","A","A","B","B","B"], n = 2
        Output: 8
        Explanation: A -> B -> idle -> A -> B -> idle -> A -> B.
      */
        public int leastInterval(char[] tasks, int n) {
             // create map for each char vs count
             int[] data = new int[26];
             for(char c : tasks) data[c -'A']++;
             Arrays.sort(data);
             // now we will sort based on value
             return getMinPossiblePath(n, data);
        }

        private int getMinPossiblePath(int n, int[] data) {
            int time = 0;
            while(data[25] > 0) {
                int i = 0;
                while (i <= n) {
                    if (data[25] == 0) break;
                    if (i < 26 && data[25-i] > 0) data[25 -i]--;
                    time++;
                    i++;
                }
                Arrays.sort(data);
            }
            return time;
        }
}
