package leetcode0802;

import java.util.*;

public class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int N = graph.length;
        int[] states = new int[N];
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            if (helper(graph, states, i)) {
                res.add(i);
            }
        }
        return res;
    }

    private boolean helper(int[][] graph, int[] states, int cur) {
        if (states[cur] != 0) {
            return states[cur] == 1;
        }

        states[cur] = 2;
        for (int v : graph[cur]) {
            if (!helper(graph, states, v)) {
                return false;
            }
        }

        states[cur] = 1;
        return true;
    }
}
