package main.java.Impl.leetcode.year2019;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestDistanceFromAllBuildings {
    /*
    317. Shortest Distance from All Buildings
    Hard

    You want to build a house on an empty land which reaches all buildings in the shortest amount of distance. You can only move up, down, left and right. You are given a 2D grid of values 0, 1 or 2, where:

    Each 0 marks an empty land which you can pass by freely.
    Each 1 marks a building which you cannot pass through.
    Each 2 marks an obstacle which you cannot pass through.
    Example:

    Input: [[1,0,2,0,1],[0,0,0,0,0],[0,0,1,0,0]]

    1 - 0 - 2 - 0 - 1
    |   |   |   |   |
    0 - 0 - 0 - 0 - 0
    |   |   |   |   |
    0 - 0 - 1 - 0 - 0

    Output: 7

    Explanation: Given three buildings at (0,0), (0,4), (2,2), and an obstacle at (0,2),
                 the point (1,2) is an ideal empty land to build a house, as the total
                 travel distance of 3+3+1=7 is minimal. So return 7.
     */
    int buildings = 0;
    public int shortestDistance(int[][] grid) {

        int buildingCounts = 0;
        for(int i =0; i < grid.length; i++) {
            for(int j = 0; j < grid[i].length; j++) {
                if(grid[i][j] == 1) buildingCounts++;
            }
        }
        int min = Integer.MAX_VALUE;
        for(int i =0; i < grid.length; i++) {
            for(int j = 0; j < grid[i].length; j++) {
                if(grid[i][j] > 0) continue;
                buildings = buildingCounts;
                int distance = calculateDistanceBFS(grid, i, j);
                if (buildings == 0 && distance != Integer.MAX_VALUE) min = Math.min(min, distance);
            }
        }
        return min == Integer.MAX_VALUE ? -1 : (min);
    }

    private int calculateDistanceBFS(int[][] grid, int curr_i, int curr_j) {
        boolean[][] visited = new boolean[grid.length][grid[curr_i].length];
        int totalDistance = 0;
        int distance = 0;
        Queue<int[]> q = new LinkedList<int[]>();
        q.add(new int[]{curr_i, curr_j});
        while(!q.isEmpty()) {
            int size = q.size();
            distance++;
            for (int i = 0; i < size; i++) {
                int[] p = q.poll();
                int p_i = p[0];
                int p_j = p[1];
                if (isIndexValid(grid, visited, p_i+1, p_j)) {
                    visited[p_i+1][p_j] = true;
                    if (grid[p_i+1][p_j] == 1) {
                        totalDistance += distance;
                        buildings--;
                        if (buildings == 0) return totalDistance;
                    } else
                        q.add(new int[]{p_i+1, p_j});
                }
                if (isIndexValid(grid, visited, p_i-1, p_j)) {
                    visited[p_i-1][p_j] = true;
                    if (grid[p_i-1][p_j] == 1) {
                        totalDistance += distance;
                        buildings--;
                        if (buildings == 0) return totalDistance;
                    } else
                        q.add(new int[]{p_i-1, p_j});
                }
                if (isIndexValid(grid, visited, p_i, p_j+1)) {
                    visited[p_i][p_j+1] = true;
                    if (grid[p_i][p_j+1] == 1) {
                        totalDistance += distance;
                        buildings--;
                        if (buildings == 0) return totalDistance;
                    } else
                        q.add(new int[]{p_i, p_j+1});
                }
                if (isIndexValid(grid, visited, p_i, p_j-1)) {
                    visited[p_i][p_j-1] = true;
                    if (grid[p_i][p_j-1] == 1) {
                        totalDistance += distance;
                        buildings--;
                        if (buildings == 0) return totalDistance;
                    } else
                        q.add(new int[]{p_i, p_j-1});
                }
            }
        }
        return (buildings > 0) ? Integer.MAX_VALUE : totalDistance;
    }

    private boolean isIndexValid(int[][] grid, boolean[][] visited, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[i].length || visited[i][j]) return false;
        return (grid[i][j] == 0 || grid[i][j] == 1);
    }
}
