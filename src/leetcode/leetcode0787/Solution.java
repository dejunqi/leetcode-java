package leetcode0787;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;



public class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {

        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        queue.offer(new int[] {0, src, K + 1});
        Map<Integer, Map<Integer, Integer>> graph = new HashMap<>();
        for (int[] flight : flights) {
            int u = flight[0], v = flight[1], price = flight[2];
            if (!graph.containsKey(u)) {
                graph.put(u, new HashMap<>());
            }
            graph.get(u).put(v, price);
        }

        while (!queue.isEmpty()) {
            int[] triple = queue.poll();
            int price = triple[0], city = triple[1], steps = triple[2];
            if (city == dst) {
                return price;
            }
            if (steps > 0) {
                if (graph.containsKey(city)) {
                    Map<Integer, Integer> neighbors = graph.get(city);
                    for (Integer u : neighbors.keySet()) {
                        queue.offer(new int[]{price + neighbors.get(u), u, steps - 1});
                    }
                }
            }
        }

        return -1;
    }

    public void test() {
        int n = 3;
        int[][] edges = {{0,1,100},{1,2,100},{0,2,500}};
        int src = 0;
        int dst = 2;
        int k = 1;
        int res = findCheapestPrice(n, edges, src, dst, k);
        System.out.println(res);

    }
}
