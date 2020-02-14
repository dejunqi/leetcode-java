package leetcode0348;

public class TicTacToe {

    int[][] rows;
    int[][] cols;
    int[][] diag;
    int size;
    /** Initialize your data structure here. */
    public TicTacToe(int n) {
        rows = new int[2][n];
        cols = new int[2][n];
        diag = new int[2][2];
        size = n;
    }

    /** Player {player} makes a move at ({row}, {col}).
     @param row The row of the board.
     @param col The column of the board.
     @param player The player, can be either 1 or 2.
     @return The current winning condition, can be either:
     0: No one wins.
     1: Player 1 wins.
     2: Player 2 wins. */
    public int move(int row, int col, int player) {
        int idx = player - 1;
        rows[idx][row] += 1;
        cols[idx][col] += 1;
        if (row == col) {
            diag[idx][0] += 1;
        }
        if (row + col == size - 1) {
            diag[idx][1] += 1;
        }
        if (rows[idx][row] == size || cols[idx][col] == size || diag[idx][0] == size || diag[idx][1] == size) {
            return player;
        }

        return 0;
    }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */