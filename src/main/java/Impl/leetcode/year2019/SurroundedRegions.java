package main.java.Impl.leetcode.year2019;

public class SurroundedRegions {

    /*
    130. Surrounded Regions
    Given a 2D board containing 'X' and 'O' (the letter O), capture all regions surrounded by 'X'.

    A region is captured by flipping all 'O's into 'X's in that surrounded region.

    Example:

    X X X X
    X O O X
    X X O X
    X O X X
    After running your function, the board should be:

    X X X X
    X X X X
    X X X X
    X O X X
    Explanation:

    Surrounded regions shouldn’t be on the border, which means that any 'O' on the border of the board are not flipped to 'X'. Any 'O' that is not on the border and it is not connected to an 'O' on the border will be flipped to 'X'. Two cells are connected if they are adjacent cells connected horizontally or vertically.
     */
    // Time Limit Exceeded
    public void solveTimeLimitExceded(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 'X') continue;
                boolean[][] visited = new boolean[board.length][board[i].length];
                if(dfs(board, i, j, visited)) board[i][j] = 'X';
            }
        }
    }

    int[][] directions = {{1, 0},{-1, 0},{0, 1},{0, -1}};
    boolean dfs(char[][] board, int i, int j, boolean[][] visited) {
        if ((i < 0 || i >= board.length || j < 0 || j >= board[i].length)) return false;
        if(visited[i][j]) return true;
        visited[i][j] = true;
        if ((i == 0 || i == board.length-1 || j == 0 || j == board[i].length-1) && (board[i][j] == 'O')) return false;
        if (board[i][j] == 'X') return true;

        for (int[] dir : directions) {
            if (!dfs(board, i+dir[0], j+dir[1], visited)) return false;
        }
        return true;
    }

    public void solve(char[][] board) {
        if (board.length == 0) return;
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O') updateUncapturable(i, 0, board);
            if (board[i][n-1] == 'O') updateUncapturable(i, n-1, board);
        }
        for (int j = 1; j < n-1; j++) {
            if (board[0][j] == 'O') updateUncapturable(0, j, board);
            if (board[m-1][j] == 'O') updateUncapturable(m-1, j, board);
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 'O') board[i][j] = 'X';
                if (board[i][j] == '*') board[i][j] = 'O';
            }
        }
    }

    private void updateUncapturable(int i, int j, char[][] board) {
        board[i][j] = '*';
        for (int[] dir : directions) {
            int x = i + dir[0];
            int y = j + dir[1];
            if (regionIsO(x, y, board)) updateUncapturable(x, y, board);
        }
    }

    private boolean regionIsO(int i, int j, char[][] board) {
        return i >= 0 && i < board.length && j >= 0 && j < board[i].length && board[i][j] == 'O';
    }

}
