package main.java.Impl.leetcode.year2019;

import java.util.ArrayList;
import java.util.List;

public class FindPathInAMaze {

    /*
    Given matrrix find a word locations

    char[][] grid = {
                { 1, 0, 0, 1, 0},
                { 1, 1, 1, 0, 0},
                { 1, 1, 1, 0, 0},
                { 0, 0, 1, 0, 0},
                { 1, 0, 1, 1, 1}};

    look for "crdvs" -> return it;s indexes
  */
    public List<String> findPathInMaze(int[][] grid) {

        List<String> result = calculatePath(grid, 0, 0);
        return result == null ? new ArrayList<>() : result;

    }


    List<String> calculatePath(int[][] grid, int i, int j) {
        if ((i == grid.length - 1 && j == grid[i].length -1) && grid[i][j] == 1) {
            List<String> res = new ArrayList<>();
            res.add(i + "," + j);
            return res;
        }
        if (grid[i][j] != 1) return null;

        if (j+1 <  grid[i].length) {
            List<String> res1 = calculatePath(grid, i, j+1);
            if (res1 != null) {
                res1.add(i + "," + j);
                return res1;
            }
        }

        if (i+1 <  grid.length) {
            List<String> res2 = calculatePath(grid, i+1, j);
            if (res2 != null) {
                res2.add(i + "," + j);
                return res2;
            }
        }

        return null;
    }

}
