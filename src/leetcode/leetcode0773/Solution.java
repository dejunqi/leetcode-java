package leetcode0773;

import java.util.*;

public class Solution {

    private class Item {
        String state;
        int[] pos;
        Item(String s, int[] p) {
            state = s;
            pos = p;
        }
    }

    public int slidingPuzzle(int[][] board) {
        StringBuilder sb = new StringBuilder();
        int x = -1, y = -1;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                sb.append(board[i][j]);
                if (board[i][j] == 0) {
                    x = i;
                    y = j;
                }
            }
        }

        String endState = "123450";
        String initialState = sb.toString();
        if (initialState.equals(endState)) {
            return 0;
        }
        Queue<Item> queue = new LinkedList<>();
        queue.offer(new Item(initialState, new int[] {x, y}));
        Set<String> visited = new HashSet<>();
        int[][] dirs = {{1, 0}, {0, -1}, {-1, 0}, {0, 1}};

        int step = 0;
        while (!queue.isEmpty()) {
            int len = queue.size();
            step++;
            for (int i = 0; i < len; i++) {
                Item cur = queue.poll();
                int r = cur.pos[0], c = cur.pos[1];
                int p = r * 3 + c;
                for (int[] d : dirs) {
                    char[] state = split(cur.state);
                    int nr = r + d[0], nc = c + d[1];
                    if (nr >= 0 && nr < 2 && nc >= 0 && nc < 3) {
                        int np = nr * 3 + nc;
                        swap(state, p, np);
                        String newstate = join(state);
                        if (newstate.equals(endState)) {
                            return step;
                        }
                        if (!visited.contains(newstate)) {
                            Item next = new Item(newstate, new int[] {nr, nc});
                            queue.offer(next);
                            visited.add(newstate);
                        }
                    }

                }
            }
        }

        return -1;
    }

    private void swap(char[] chars, int i, int j) {
        char tmp = chars[i];
        chars[i] = chars[j];
        chars[j] = tmp;
    }

    private char[] split(String str) {
        char[] res = new char[str.length()];
        for (int i = 0; i < str.length(); i++) {
            res[i] = str.charAt(i);
        }
        return res;
    }


    private String join(char[] strs) {
        StringBuilder sb = new StringBuilder();
        for (char c : strs) {
            sb.append(c);
        }
        return sb.toString();
    }

    public void test() {
        int[][] board1 = {{4,1,2},{5,0,3}};
        int[][] board2 = {{1,2,3}, {5,4,0}};
        int res = slidingPuzzle(board1);
        System.out.println(res);
    }
}
