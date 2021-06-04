package main.java.Impl.karat;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindTopLeftBottomRightCoordinatesOfZeroKarat {
/*
    This was for an mid-level role at Roblox.

    Find the top left and bottom right coordinates of a rectangle of 0's within a matrix of 1's. It's essentially a modified version of the finding the number of island problem where you only need to dfs to the right and down.
    Ex.
    [[ 1, 1, 1, 1],
    [ 1, 0, 0, 1],
    [ 1, 0, 0, 1],
    [ 1, 1, 1, 1]]
    Expected output: [[1,1], [2,2]]

    Follow up question: Expand it so it works for any number of rectangles. I ran out of time to code this part so get throught the first part quickly. Main part of this problem is updating how results are stored and tracking what's been seen.
    Ex.
    [[0, 1, 1, 1],
    [1, 0, 0, 1],
    [1, 0, 0, 1],
    [1, 1, 1, 1]]
    Expected output: [ [[0,0],[0,0]], [[1,1], [2,2]] ]

    https://leetcode.com/problems/number-of-islands

    Time Complexity: O(MN)
    Space Complexity: O(MN)
 */

    public static List<Cord> numIslands(int [][] grid) {
        int [][] graph = new int [grid.length][grid[0].length];

        List<Cord> finalRes = new ArrayList<Cord>();
        for(int row=0; row<grid.length; row++){
            for(int col=0; col<grid[0].length; col++){
                if(grid[row][col] == 0 && graph[row][col] != 1){
                    List<Cord> res = new ArrayList<>();
                    traceIsland(grid, row,col, graph, res);
                    res.sort(Comparator.comparingInt(Cord::getRow).thenComparing(Cord::getCol));
                    if(res.size() > 0){
                        finalRes.add(res.get(0));
                        finalRes.add(res.get(res.size()-1));
                    }
                }
            }

        }


        return finalRes;
    }

    public static void traceIsland(int [][] grid,int row, int col, int [][] graph, List<Cord> res){
        if(row <0 || row >= grid.length || col <0 || col>=grid[row].length)
            return;

        if(graph[row][col] == 1)
            return;

        if(grid[row][col] == 1)
            return;

        if(grid[row][col] == 0){
            graph[row][col] = 1;
            res.add(new Cord(row,col));
            traceIsland(grid, row,col+1, graph, res);
            traceIsland(grid, row,col-1, graph, res);
            traceIsland(grid, row+1,col, graph, res);
            traceIsland(grid, row-1,col, graph, res);
        }
    }
    public static void main(String[] args) {
        int [][] grid1 = {{1,1,1,1,1},
                {1,0,0,1,1},
                {1,0,0,1,1},
                {1,1,1,1,1}
        };

        int [][] grid2 = {{1,1,1,1,1},
                {1,0,0,1,1},
                {1,0,0,1,1},
                {1,1,1,1,0}
        };

        int [][] grid3 = {
                {0, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1},
                {0, 1, 1, 0, 0, 0, 1},
                {1, 0, 1, 0, 0, 0, 1},
                {1, 0, 1, 1, 1, 1, 1},
                {1, 0, 1, 0, 0, 1, 1},
                {1, 1, 1, 0, 0, 1, 1},
                {1, 1, 1, 1, 1, 1, 0},
        };

        int [][] grid4 = {{0}};

        int [][] grid5 = {{1}};

        int [][] grid6 = {
                {1, 1, 1, 1, 1},
                {1, 0, 0, 0, 1},
                {1, 0, 0, 0, 1},
                {1, 0, 0, 0, 1},
                {1, 1, 1, 1, 1},
        };
        System.out.println(numIslands(grid1));
        System.out.println(numIslands(grid2));
        System.out.println(numIslands(grid3));
        System.out.println(numIslands(grid4));
        System.out.println(numIslands(grid5));
        System.out.println(numIslands(grid6));
    }
}

class Cord {
    int row;
    int col;

    public Cord(int row, int col){
        this.row = row;
        this.col = col;
    }

    public int getRow() {
        return row;
    }

    public void setRow(final int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(final int col) {
        this.col = col;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("[");
        sb.append(row);
        sb.append(",").append(col);
        sb.append(']');
        return sb.toString();
    }
}
