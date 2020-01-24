package dropbox.gameoflife;

import java.io.*;

public class Solution {

    int[][] board;

    public void gameoflife() {
        int r = 0;
        int c = 0;
        int pagination = 100;

    }


    private String read(int startRow, int starCol, int pagination) {

        // give a a text file with a matrix of m X n
        // where m = startRow + pagination, n = startCol  + pagination
        // Repeatly invoke this function startfrom from startRow = startCol = 0, and pagination = 100
        // 1st call --> 0 ~ 99 row and col
        // 2ned call --> row from (0, 99) col from (100 ~ 199)

        StringBuilder sb = new StringBuilder();
        sb.append("start: " + startRow  + ", " + starCol + ". Size : " + pagination);
        sb.append("\n");

        for(int i = startRow; i < startRow + pagination; i++) {
            for (int j = starCol; j < starCol + pagination; j++) {
                sb.append(board[i][j]);
                if (j == starCol + pagination - 1) {
                    sb.append("\n");
                }
            }
        }
        return sb.toString();
    }

    private void write(String path, File file) {
        // compute and then write the result into a file
    }


    public void test() {
        int M = 10000;
        board = new int[M][M];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < M; j++) {
                board[i][j] = Math.random() > 0.5 ? 1 : 0;
            }
        }
    }

}
