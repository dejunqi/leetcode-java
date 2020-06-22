package leetcode.leetcode0785;

public class Solution {
    public boolean isBipartite(int[][] graph) {
        int len = graph.length;
        int[] color = new int[len];
        for (int i = 0; i < len; i++) {
            color[i] = -1;
        }
        for (int i = 0; i < len; i++) {
            if (color[i] == -1 && !helper(i, graph, color, 0)) {
                return false;
            }
        }
        return true;
    }

    private boolean helper(int idx, int[][] graph, int[] color, int requiredColor) {
        if (color[idx] != -1) {
            return color[idx] == requiredColor;
        }

        color[idx] = requiredColor;
        int[] neighbors = graph[idx];
        for (int v : neighbors) {
            if (!helper(v, graph, color, 1 - requiredColor)) {
                return false;
            }
        }
        return true;
    }
}
