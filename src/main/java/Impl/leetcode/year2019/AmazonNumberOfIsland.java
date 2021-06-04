package main.java.Impl.leetcode.year2019;

import java.util.List;

public class AmazonNumberOfIsland {

    /**
        count number of islands '1' represent land '0' water
     */
    int numberAmazonTreasureTrucks(int m, int n, Integer[][] grid){
        int result = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    result++;
                    findNumberOfIsland(i, j, m, n, grid);
                }
            }
        }
        return result;
    }

    void findNumberOfIsland(int i, int j, int m, int n, Integer[][] grid) {
        if(i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == 0) return;
        grid[i][j] = 0;
        findNumberOfIsland(i-1, j, m, n, grid);
        findNumberOfIsland(i+1, j, m, n, grid);
        findNumberOfIsland(i, j-1, m, n, grid);
        findNumberOfIsland(i, j+1, m, n, grid);

    }

    public static void main(String[] args) {
        AmazonNumberOfIsland a = new AmazonNumberOfIsland();
        Integer[][] input = {
                {1, 1, 1, 1},
                {0, 0, 0, 0},
                {1, 1, 1, 1},
                {1, 1, 1, 1}};
        int result = a.numberAmazonTreasureTrucks(4, 4, input);
        System.out.println(result);
    }
}
