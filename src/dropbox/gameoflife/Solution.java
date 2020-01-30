package dropbox.gameoflife;

import java.io.*;



public class Solution {
    public void gameOfLife(int[][] board) {
        int row = board.length, col = board[0].length;
        int[][] nextstate = new int[row][col];

        int[][] dirs = {{1, 0}, {0, -1}, {-1, 0}, {0, 1},
                {-1, -1}, {-1, 1}, {1, -1}, {1, 1}};

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int cnt = 0;
                for (int[] d : dirs) {
                    int r = i + d[0], c = j + d[1];
                    if (r >= 0 && r < row && c >= 0 && c < col) {
                        if (board[r][c] == 1) {
                            cnt++;
                        }
                    }
                }

                if (board[i][j] == 1 && cnt < 2) {
                    nextstate[i][j] = 0;
                }
                if (board[i][j] == 1 && (cnt == 2 || cnt == 3)) {
                    nextstate[i][j] = 1;
                }
                if (board[i][j] == 1 && cnt > 3) {
                    nextstate[i][j] = 0;
                }
                if (board[i][j] == 0 && cnt == 3) {
                    nextstate[i][j] = 1;
                }
            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                board[i][j] = nextstate[i][j];
                System.out.print(board[i][j] + ", ");
            }

            System.out.println();

        }

    }

    public void test() {
        int[][] board = {{0, 1, 0},
                {0, 0, 1},
                {1, 1, 1},
                {0, 0, 0}};
        /*

               {{00, 00, 00},
                {01, 00, 11},
                {10, 10, 10},
                {00, 00, 00}};
        */
        gameOfLife(board);
    }
}

/**
 [0,1,0],
 [0,0,1],
 [1,1,1],
 [0,0,0]

 Any live cell with fewer than two live neighbors dies, as if caused by under-population.
 Any live cell with two or three live neighbors lives on to the next generation.
 Any live cell with more than three live neighbors dies, as if by over-population..
 Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.

 if cell == 1 and num of 1 surrounded < 2:
 cell = 0
 if cell == 1 and num of 1 surrounded == 2 or 3:
 cell = 1
 if cell 1 and num of 1 surrounded > 3
 cell = 0
 if cell == 0 and num of 1 surrounded == 3:
 cell = 1


 sliding window with 100 X 100

 round 1 : from 0 - 99
 round 2 : from 100 - 199
 ....


 KB = 1024 bytes which is 1 Kilobyte

 MB = 1024 KB which is 1 MegaByte

 GB = 1024 MB which is 1 Gigabyte


 1 million = 1000000
 1000000 * 2 = 200000 bytes ~ 1953.125 KB  ~ 2MB

 1 million by 1 million  = 1E6 ** 2 = 1E12 ~ 953674 MB


 readSize(int size) {

 }



 public String readSize(int size) {}


 public void readAndWrite() {
    try {
        do {
            String data = readSize(1000);
            if (data.length() != 0) {
                write(data, filepath);
             }
        } while (!data.equals(""));
    } catch(IOException e) {e.printStack();}
 }

 */

