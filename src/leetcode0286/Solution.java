package leetcode0286;

public class Solution {
    public void wallsAndGates(int[][] rooms) {
        if (rooms.length == 0 || rooms[0].length == 0) {
            return;
        }
        int row = rooms.length, col = rooms[0].length;
        int[][] dirs = {{1, 0}, {0, -1}, {-1, 0}, {0, 1}};
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (rooms[i][j] == 0) {
                    helper(rooms, i, j, dirs, 0);
                }
            }
        }
    }

    private void helper(int[][] rooms, int i, int j, int[][] dirs, int dist) {
        int row = rooms.length, col = rooms[0].length;
        if (i < 0 || i >= row || j < 0 || j >= col
                ||  rooms[i][j] == -1 || rooms[i][j] < dist) {
            return;
        }

        rooms[i][j] = Math.min(dist, rooms[i][j]);
        for (int[] d : dirs) {
            int r = i + d[0], c = j + d[1];
            helper(rooms, r, c, dirs, dist + 1);
        }
    }

    public void test() {
        int MAX = Integer.MAX_VALUE;
        int[][] rooms = {{MAX, -1, 0, MAX},
                        {MAX, MAX, MAX, -1},
                        {MAX, -1, MAX, -1},
                        {0, -1, MAX, MAX}};
        wallsAndGates(rooms);
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[0].length; j++) {
                System.out.print(rooms[i][j] + " ");
            }
            System.out.println();
        }
    }
}
