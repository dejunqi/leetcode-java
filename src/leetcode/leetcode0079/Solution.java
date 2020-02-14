package leetcode0079;

public class Solution {
    public boolean exist(char[][] board, String word) {

        int row = board.length, col = board[0].length;
        boolean[][] visited = new boolean[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (helper(board, i, j, word, visited, 0)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean helper(char[][] board, int i, int j, String word, boolean[][] visited, int idx) {
        int row = board.length, col = board[0].length;
        if (idx == word.length()) {
            return true;
        }
        if (i < 0 || i >= row || j < 0 || j >= col || board[i][j] != word.charAt(idx) || visited[i][j]) {
            return false;
        }

        visited[i][j] = true;
        int[][] dirs = {{1, 0}, {0, -1}, {-1, 0}, {0, 1}};
        for (int[] d : dirs) {
            int r = i + d[0], c = j + d[1];
            boolean res = helper(board, r, c, word, visited, idx + 1);
            if (res) {
                return true;
            }
        }
        visited[i][j] = false;
        return false;
    }

    public void test() {
        char[][] board = {{'A', 'B', 'C', 'E'},
                        {'S', 'F', 'C', 'S'},
                        {'A', 'D', 'E', 'E'}};

        String word = "ABCCED";
        System.out.println(exist(board, word));
    }
}
