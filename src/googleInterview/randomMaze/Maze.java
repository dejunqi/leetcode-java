package googleInterview.randomMaze;


public class Maze {
    int size;
    char[][] board;
    boolean[][] visited;

    public Maze(int N) {
        if (N % 2 == 0) {
            N += 1;
        }
        size = N;
        board = new char[size][size];
        visited = new boolean[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (i % 2 == 1 && j % 2 == 1) {
                    board[i][j] = ' ';
                } else {
                    board[i][j] = '#';
                }
            }
        }
        board[1][0] = ' ';
        board[size - 2][size - 1] = ' ';
    }

    public char[][] generate() {
        RandomQueue queue = new RandomQueue();
        visited[1][1] = true;
        queue.add(new int[] {1, 1});
        int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        while (!queue.isEmpty()) {
            int[] point = queue.pop();
            int i = point[0], j = point[1];
            for (int[] d : dirs) {
                int r = i + d[0] * 2, c = j + d[1] * 2;
                if (r >= 0 && r < size && c >= 0 && c < size && !visited[r][c]) {
                    board[i + d[0]][j + d[1]] = ' ';
                    queue.add(new int[] {r, c});
                    visited[r][c] = true;
                }
            }
        }
        return board;
    }

    public void print() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

}
