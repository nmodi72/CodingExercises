package main.java.Impl.leetcode.year2019;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class MinimumKnightsMove {
    /*
    1197. Minimum Knight Moves

    In an infinite chess board with coordinates from -infinity to +infinity, you have a knight at square [0, 0].

    A knight has 8 possible moves it can make, as illustrated below. Each move is two squares in a cardinal direction, then one square in an orthogonal direction.



    Return the minimum number of steps needed to move the knight to the square [x, y].  It is guaranteed the answer exists.

    Example 1:
    Input: x = 2, y = 1
    Output: 1
    Explanation: [0, 0] → [2, 1]

    Example 2:
    Input: x = 5, y = 5
    Output: 4
    Explanation: [0, 0] → [2, 1] → [4, 2] → [3, 4] → [5, 5]

    Constraints:

    |x| + |y| <= 300
     */
    Set<String> visited = new HashSet<>();
    Queue<int[]> q = new LinkedList<>();
    StringBuilder sb = new StringBuilder();

    public int minKnightMoves(int x, int y) {
        x = Math.abs(x);
        y = Math.abs(y);
        int steps = 0;
        q.add(new int[]{0, 0});
        visited.add(locationString(0,0));
        while(!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] poll = q.poll();
                if (poll[0] == x && poll[1]==y) return steps;

                addToQueue(poll[0]+2, poll[1]-1);
                addToQueue(poll[0]+2, poll[1]+1);

                addToQueue(poll[0]-2, poll[1]-1);
                addToQueue(poll[0]-2, poll[1]+1);

                addToQueue(poll[0]-1, poll[1]+2);
                addToQueue(poll[0]-1, poll[1]-2);

                addToQueue(poll[0]+1, poll[1]+2);
                addToQueue(poll[0]+1, poll[1]-2);
            }
            steps++;
        }
        return steps;
    }

    private String locationString(int x, int y) {

        return x +":" + y;
    }

    private void addToQueue(int x, int y) {
        if (x < -2 || y < -2) return;
        if (Math.abs(x) + Math.abs(y) > 300) return;
        String pos = locationString(x, y);
        if (visited.add(pos)){
            q.add(new int[]{x, y});
        }
    }
}
