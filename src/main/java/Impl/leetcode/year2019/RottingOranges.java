package main.java.Impl.leetcode.year2019;

import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges {

    /*
    994. Rotting Oranges
    In a given grid, each cell can have one of three values:

    the value 0 representing an empty cell;
    the value 1 representing a fresh orange;
    the value 2 representing a rotten orange.
    Every minute, any fresh orange that is adjacent (4-directionally) to a rotten orange becomes rotten.

    Return the minimum number of minutes that must elapse until no cell has a fresh orange.  If this is impossible, return -1 instead.



    Example 1:



    Input: [[2,1,1],[1,1,0],[0,1,1]]
    Output: 4
    Example 2:

    Input: [[2,1,1],[0,1,1],[1,0,1]]
    Output: -1
    Explanation:  The orange in the bottom left corner (row 2, column 0) is never rotten, because rotting only happens 4-directionally.
    Example 3:

    Input: [[0,2]]
    Output: 0
    Explanation:  Since there are already no fresh oranges at minute 0, the answer is just 0.

     */
    int[][] visited;

    public int orangesRotting(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) return -1;
        visited = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 0) continue;
                visited[i][j] = -1;
            }
        }

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] != 2) continue;
                dfs(grid, i, j, 0);
            }
        }
        int max = 0;
        for (int i = 0; i < visited.length; i++) {
            for (int j = 0; j < visited[i].length; j++) {
                if (visited[i][j] == -1) return -1;
                max = Math.max(visited[i][j], max);
            }
        }
        return max;
    }

    private void dfs(int[][] grid, int i, int j, int time) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) return;
        if (grid[i][j] == 0) {
            visited[i][j] = 0;
            return;
        }
        if (visited[i][j] >= 0 && grid[i][j] >= 1 && time > visited[i][j]) {
            return;
        }
        visited[i][j] = time;
        dfs(grid, i-1, j, time+1);
        dfs(grid, i+1, j, time+1);
        dfs(grid, i, j-1, time+1);
        dfs(grid, i, j+1, time+1);
    }


    public int orangesRottingBFS(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        int freshOranges = 0;
        for(int i =0; i < grid.length; i++) {
            for(int j =0; j < grid[i].length; j++){
                if(grid[i][j] == 2) q.add(new int[]{i, j});
                else if (grid[i][j] == 1) freshOranges++;
            }
        }

        q.offer(new int[]{-1, -1});

        int time = -1;
        int[][] directions = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        while (!q.isEmpty()) {
            int[] poll = q.poll();
            if (poll[0] == -1) {
                time++;
                if (!q.isEmpty()) q.offer(new int[]{-1, -1});
            } else {
                for (int[] d : directions) {
                    int childX = poll[0] + d[0];
                    int childY = poll[1] + d[1];
                    if (childX >= 0 && childX < grid.length && childY >= 0 && childY < grid[0].length) {
                        if (grid[childX][childY] == 1) {
                            grid[childX][childY] = 2;
                            freshOranges--;
                            q.offer(new int[]{childX, childY});
                        }

                    }
                }
            }
        }
        return freshOranges == 0 ? time : -1;
    }
}
