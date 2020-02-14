package leetcode0399;

import java.util.*;

public class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Map<String, Double>> graph = new HashMap<>();
        int len = equations.size();
        for (int i = 0; i < len; i++) {
            String u = equations.get(i).get(0), v = equations.get(i).get(1);
            double value = values[i];
            if (!graph.containsKey(u)) {
                graph.put(u, new HashMap<>());
            }
            graph.get(u).put(v, value);

            if (!graph.containsKey(v)) {
                graph.put(v, new HashMap<>());
            }
            graph.get(v).put(u, 1.0 / value);
        }
        double[] res = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            Set<String> visited = new HashSet<>();
            String u = queries.get(i).get(0), v = queries.get(i).get(1);
            res[i] = helper(1, u, v, graph, visited);
        }
        return res;
    }

    private double helper(double val, String cur, String end,
                          Map<String, Map<String, Double>> graph, Set<String> visited) {
        if (!graph.containsKey(cur) || !graph.containsKey(end) || visited.contains(cur)) {
            return -1.0;
        }
        if (cur.equals(end)) {
            return val;
        }
        visited.add(cur);
        Map<String, Double> neighbors = graph.get(cur);
        if (neighbors != null) {
            for (String v : neighbors.keySet()) {
                double res = helper(val * neighbors.get(v), v, end, graph, visited);
                if (res != -1.0) {
                    return res;
                }
            }
        }
        return -1.0;
    }
}
