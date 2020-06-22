package googleInterview.matrixCharacterfilling;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {
    private class Node {
        int i;
        int j;
        char c;
        int dist;
        Node(int i, int j, char c, int dist) {
            this.i = i;
            this.j = j;
            this.c = c;
            this.dist = dist;
        }
    }

    public void fillMatrix(char[][] matrix) {
        int row = matrix.length, col = matrix[0].length;
        Queue<Node> queue = new PriorityQueue<>((a, b) -> a.dist - b.dist);
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] != ' ') {
                    queue.add(new Node(i, j, matrix[i][j], 0));
                }
            }
        }

        int [][] dirs = {{1, 0}, {0, -1}, {-1, 0}, {0, 1}};

        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            int i = cur.i, j = cur.j;
            if (matrix[i][j] == ' ') {
                matrix[i][j] = cur.c;
            }

            for (int[] d : dirs) {
                int r = i + d[0], c = j + d[1];
                if (r >= 0 && r < row && c >= 0 && c < col && matrix[r][c] == ' ') {
                    queue.add(new Node(r, c, cur.c, cur.dist + 1));
                }
            }
        }

        for (char[] chars : matrix) {
            System.out.println(Arrays.toString(chars));
        }
    }

    public void test() {
        char[][] matrix = { {'A', ' ', ' ', ' ', ' '},
                            {' ', ' ', ' ', ' ', ' '},
                            {' ', ' ', ' ', 'B', ' '}};
        fillMatrix(matrix);
    }
}
