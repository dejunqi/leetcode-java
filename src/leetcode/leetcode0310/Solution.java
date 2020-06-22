package leetcode0310;

import java.util.*;

public class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) {
            List<Integer> res = new LinkedList<>();
            res.add(0);
            return res;
        }
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        List<Integer> leaves = new LinkedList<>();
        for (int[] e : edges) {
            int u = e[0], v = e[1];
            if (!graph.containsKey(u)) {
                graph.put(u, new HashSet<>());
            }
            graph.get(u).add(v);

            if (!graph.containsKey(v)) {
                graph.put(v, new HashSet<>());
            }
            graph.get(v).add(u);
        }

        for (int num : graph.keySet()) {
            if (graph.get(num).size() == 1) {
                leaves.add(num);
            }
        }

        while (n > 2) {
            List<Integer> tmp = new LinkedList<>();
            int len = leaves.size();
            n -= len;
            for (int v : leaves) {
                Iterator<Integer> iter = graph.get(v).iterator();
                int u = iter.next();
                graph.get(u).remove(v);
                if (graph.get(u).size() == 1) {
                    tmp.add(u);
                }
            }
            leaves = tmp;

        }
        return leaves;
    }
}
