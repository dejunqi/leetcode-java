package leetcode0332;

import java.util.*;

public class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> graph = new HashMap<>();
        for (List<String> t : tickets) {
            String u = t.get(0), v = t.get(1);
            if (!graph.containsKey(u)) {
                graph.put(u, new PriorityQueue<>());
            }
            graph.get(u).offer(v);

        }
        List<String> res = new LinkedList<>();
        helper("JFK", res, graph);
        return res;
    }

    private void helper(String city, List<String> res, Map<String, PriorityQueue<String>> graph) {
        PriorityQueue<String> neighbors = graph.get(city);
        while (neighbors != null && !neighbors.isEmpty()) {
            String newCity = neighbors.poll();
            helper(newCity, res, graph);
        }
        res.add(0, city);
    }
}
