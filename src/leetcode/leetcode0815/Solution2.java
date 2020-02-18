package leetcode.leetcode0815;

import java.util.*;

public class Solution2 {

    public int numBusesToDestination(int[][] routes, int S, int T) {
        if (S == T) return 0;
        List<Set<Integer>> list = new ArrayList<>();
        for (int[] route : routes) {
            Set<Integer> set = new HashSet<>();
            for (int r : route) {
                set.add(r);
            }
            list.add(set);
        }

        int start = -1;
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < routes.length; i++) {
            graph.put(i, new ArrayList<>());
        }
        for (int i = 0; i < list.size(); i++) {
            Set<Integer> ri = list.get(i);
            for (int v : ri) {
                if (v == S) {
                    start = i;
                    break;
                }
            }
            for (int j = 0; j < list.size(); j++) {
                if (i == j) continue;
                Set<Integer> rj = list.get(j);
                if (isConnected(ri, rj)) {
                    graph.get(i).add(j);
                    graph.get(j).add(i);
                }
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        int res = 0;
        boolean[] visited = new boolean[routes.length];
        visited[start] = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            res += 1;
            for (int i = 0; i < size; i++) {
                int idx = queue.poll();
                Set<Integer> stops = list.get(idx);
                for (int t : stops) {
                    if (t == T) {
                        return res;
                    }
                }
                for (int n : graph.get(idx)) {
                    if (!visited[n]) {
                        visited[n] = true;
                        queue.add(n);
                    }
                }
            }
        }

        return res;

    }

    private boolean isConnected(Set<Integer> stops1, Set<Integer> stops2) {
        for (Integer v : stops1) {
            if (stops2.contains(v)) {
                return true;
            }
        }
        return false;
    }

    public void test() {
        int[][] routes = {{1, 2, 3, 4, 5, 6}, {4, 7, 8, 9, 10, 11}};
        int s = 1, t = 9;
        int res = this.numBusesToDestination(routes, s, t);
        System.out.println(res);
    }

}
