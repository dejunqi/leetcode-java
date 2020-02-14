package leetcode0490;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        int row = maze.length, col = maze[0].length;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(start);
        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        boolean[][] visited = new boolean[row][col];

        while (!queue.isEmpty()) {
            int[] p = queue.poll();
            for (int[] d : dirs) {
                int r = p[0] + d[0];
                int c = p[1] + d[1];
                while (r >= 0 && r < row && c >= 0 && c < col && maze[r][c] == 0) {
                    r += d[0];
                    c += d[1];
                }
                r -= d[0];
                c -= d[1];
                if (r == destination[0] && c == destination[1]) {
                    return true;
                }
                if (!visited[r][c]) {
                    visited[r][c] = true;
                    queue.offer(new int[] {r, c});
                }
            }
        }
        return false;
    }
}
