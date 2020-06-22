package googleInterview.binaryColorableGraph;

// similar problem: leetcode 785

import java.util.*;

public class Solution {
    public boolean isBinaryColorable(Map<Integer, List<Integer>> graph) {
        Map<Integer, Integer> color = new HashMap<>();
        for (int n : graph.keySet()) {
            color.put(n, -1);
        }
        for (int v : graph.keySet()) {
            if (color.get(v) != -1) continue;
            if (!helper(color, graph, v, 0)) {
                return false;
            }
        }
        return true;
    }

    private boolean helper(Map<Integer, Integer> color, Map<Integer, List<Integer>> graph,  int v, int c) {
        if (color.get(v) != -1) {
            return color.get(v) == c;
        }

        color.put(v, c);
        for (Integer u : graph.get(v)) {
            if (!helper(color, graph, u, 1 - c)) {
                return false;
            }
        }
        return true;
    }

    public void test() {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        graph.put(1, new ArrayList<>(Arrays.asList(4, 5)));
        graph.put(4, new ArrayList<>(Arrays.asList(1, 5, 9)));
        graph.put(9, new ArrayList<>(Arrays.asList(4, 5)));
        graph.put(5, new ArrayList<>(Arrays.asList(1, 4, 9)));
        System.out.println(isBinaryColorable(graph));
    }
}
