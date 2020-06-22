package leetcode0723;

public class Solution {
    public int[][] candyCrush(int[][] board) {
        int row = board.length;
        int col = board[0].length;
        boolean stable = false;

        while (!stable) {
            stable = true;
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    int val = abs(board[i][j]);
                    if (val == 0) continue;

                    if (j < col - 2 && abs(board[i][j + 1]) == val && abs(board[i][j + 2]) == val) {
                        stable = false;
                        int idx = j;
                        while (idx < col && abs(board[i][idx]) == val) {
                            board[i][idx] = -val;
                            idx += 1;
                        }
                    }

                    if (i < row - 2 && abs(board[i + 1][j]) == val && abs(board[i + 2][j]) == val) {
                        stable = false;
                        int idx = i;
                        while (idx < row && abs(board[idx][j]) == val) {
                            board[idx][j] = -val;
                            idx += 1;
                        }
                    }
                }
            }

            if (!stable) {
                for (int j = 0; j < col; j++) {
                    int idx = row - 1;
                    for (int i = row - 1; i >= 0; i--) {
                        if (board[i][j] > 0) {
                            swap(board, i, j, idx, j);
                            idx -= 1;
                        }
                    }
                    for (int k = idx; k >= 0; k--) {
                        board[k][j] = 0;
                    }
                }
            }
        }

        return board;
    }


    private int abs(int v) {
        return Math.abs(v);
    }

    private void swap(int[][] g, int r1, int c1, int r2, int c2) {
        int tmp = g[r1][c1];
        g[r1][c1] = g[r2][c2];
        g[r2][c2] = tmp;
    }


    public void test() {
        int[][] board = {
                {110,  5,   112, 113, 114},
                {210,  211, 5,   213, 214},
                {310,  311, 3,   313, 314},
                {410,  411, 412, 5,   414},
                {5,    1,   512, 3,   3},
                {610,  4,   1,   613, 614},
                {710,  1,   2,   713, 714},
                {810,  1,   2,   1,   1},
                {1,    1,   2,   2,   2},
                {4,    1,   4,   4,   1014}
        };

        candyCrush(board);
    }
}