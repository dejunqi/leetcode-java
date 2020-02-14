package utils.practice;

import org.omg.CORBA.portable.ValueInputStream;

import java.util.Arrays;

public class Maze {

    int size;
    int[][] board;
    public Maze(int N) {
        size = N;
        board = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i % 2 == 0|| i == N - 1 ) {
                    board[i][j] = 1;
                }
                if (j == 0 || j == N - 1) {
                    board[i][j] = 1;
                }
                if (i % 2 != 0 && j % 2 == 0) {
                    board[i][j] = 1;
                }
            }
        }

        // set entrance and exits
        board[1][0] = 0;
        board[N - 2][N - 1] = 0;
    }

    public int[][] generate() {
        RandomQueue queue = new RandomQueue();
        queue.add(new int[] {1, 1});
        boolean[][] visited = new boolean[size][size];
        visited[1][1] = true;
        int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        while (!queue.isEmpty()) {
            int[] p = queue.poll();
            int i = p[0], j = p[1];
            for (int[] d : dirs) {
                int r = i + 2 * d[0], c = j + 2 * d[1];
                if (r >= 0 && r < size && c >= 0 && c < size && !visited[r][c]) {
                    queue.add(new int[] {r, c});
                    visited[r][c] = true;
                    board[i + d[0]][j + d[1]] = 0;
                }
            }

        }

        for (int[] row : board) {
            System.out.println(Arrays.toString(row));
        }

        return board;
    }


}
