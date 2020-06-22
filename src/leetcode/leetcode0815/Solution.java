package leetcode0815;

import java.util.*;

public class Solution {
    public int numBusesToDestination(int[][] routes, int S, int T) {

        if (S == T) return 0;
        Map<Integer, List<Integer>> map = new HashMap<>();
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        int res = 0;

        for (int i = 0; i < routes.length; i++) {
            for (int j = 0; j < routes[i].length; j++) {
                int b = routes[i][j];
                if (!map.containsKey(b)) {
                    map.put(b, new ArrayList<>());
                }
                map.get(b).add(i);
            }
        }

        queue.offer(S);
        while (!queue.isEmpty()) {
            int len = queue.size();
            res += 1;
            for (int i = 0; i < len; i++) {
                int busStop = queue.poll();
                List<Integer> routeIndexes = map.get(busStop);
                for (int rIdx : routeIndexes) {
                    if (visited.contains(rIdx)) continue;
                    visited.add(rIdx);
                    int[] route = routes[rIdx];
                    for (int bstop : route) {
                        if (bstop == T) return res;
                        queue.offer(bstop);
                    }
                }
            }
        }

        return -1;
    }

    public void test() {
         int[][] routes = {{1, 2, 7}, {3, 6, 7}};
         int S = 1;
         int T = 6;
//        int[][] routes = {{24},{3,6,11,14,22},{1,23,24},{0,6,14},{1,3,8,11,20}};

        int res = numBusesToDestination(routes, S, T);
        System.out.println(res);
    }


    private void showGraph(Map<Integer, List<Integer>> graph) {
        for (Integer key : graph.keySet()) {
            List<Integer> neighbors = graph.get(key);
            System.out.print(key + ": [ ");
            for (int i = 0; i < neighbors.size(); i++) {
                if (i < neighbors.size() - 1) {
                    System.out.print(neighbors.get(i) + ", ");
                } else {
                    System.out.println(neighbors.get(i) + " ]");
                }
            }
        }
    }
}


/*
1: [ 0 ]
2: [ 0 ]
3: [ 1 ]
6: [ 1 ]
7: [ 0, 1 ]
* */