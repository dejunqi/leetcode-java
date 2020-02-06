package googleInterview.randomColorBoard;

import java.lang.reflect.Parameter;
import java.util.*;

/*
* Generate N * N board with given set of colors randomly.
Such that no 3 cells adjancent to each other vertically and horizontally should have the same color (diagonals are not considered,
* and regardless of the size of the grid only 3 cells shouldn't be same.)

* https://leetcode.com/discuss/interview-question/493844/Google-or-Phone-or-Generate-Randomized-Color-Board
**/
public class Solution {

    private class Pair {
        int color;
        int cnt;
        Pair(int c, int n) {
            color = c;
            cnt = n;
        }
    }

    public int[][] generate(int N, int colorSize) {
        int[][] board = new int[N][N];
        Map<Integer, int[]> col = new HashMap<>();
        for (int j = 0; j < N; j++) {
            col.put(j, new int[] {-1, -1});
        }

        Random rnd = new Random();

        for (int i = 0; i < N; i++) {
            int rowCnt = 0;
            if (i == 0) {
                for (int j = 0; j < N; j++) {
                    while (true) {
                        int color = rnd.nextInt(colorSize);
                        if (j == 0) { // j == 0
                            board[0][j] = color;
                            col.put(j, new int[] {color, 1});
                            rowCnt += 1;
                            break;
                        }

                        if (board[0][j - 1] != color) { // j > 0 and color not equal to previous color
                            board[0][j] = color;
                            col.put(j, new int[] {color, 1});
                            rowCnt = 1;
                            break;
                        }

                        if (rowCnt < 2) { // board[0][j - 1] == color but not 3 consecutive yet
                            board[0][j] = color;
                            col.put(j, new int[] {color, 1});
                            rowCnt += 1;
                            break;
                        } // else { go back to the while loop}
                    }
                }
            } else {
                for (int j = 0; j < N; j++) {
                    while(true) {
                        int color = rnd.nextInt(colorSize);
                        int[] colCnt = col.get(j);
                        if (colCnt[0] != color && j == 0) {
                            board[i][j] = color;
                            col.put(j, new int[] {color, 1});
                            rowCnt += 1;
                            break;
                        }

                        // colCnt[0] != color && j > 0 && board[i][j - 1] != color
                        if (colCnt[0] != color && board[i][j - 1] != color) {
                            board[i][j] = color;
                            rowCnt = 1;
                            col.put(j, new int[] {color, 1});
                            break;
                        }

                        if (colCnt[0] != color && board[i][j - 1] == color && rowCnt < 2) {
                            board[i][j] = color;
                            rowCnt++;
                            col.put(j, new int[] {color, 1});
                            break;
                        }

                        if(colCnt[0] == color && colCnt[1] < 2 && j == 0) {
                            board[i][j] = color;
                            rowCnt = 1;
                            colCnt[1]++;
                            break;
                        }

                        if (colCnt[0] == color && colCnt[1] < 2 && board[i][j - 1] != color) {
                            board[i][j] = color;
                            colCnt[1] += 1;
                            rowCnt = 1;
                            break;
                        }

                        if (colCnt[0] == color && colCnt[1] < 2 && board[i][j - 1] == color && rowCnt < 2) {
                            board[i][j] = color;
                            colCnt[1]++;
                            rowCnt++;
                            break;
                        }
                    }
                }
            }
        }
        return board;
    }

    public void test() {
        int N = 6;
        int colorSize = 3;
        int[][] board = generate(N, colorSize);
        for (int[] row : board) {
            System.out.println(Arrays.toString(row));
        }
    }
}
