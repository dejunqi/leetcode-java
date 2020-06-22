package leetcode0207;

import java.util.*;

public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        Map<Integer, List<Integer>> graph = new HashMap<>();
        Map<Integer, Integer> parentNum = new HashMap<>();
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            parentNum.put(i, 0);
        }
        int cnt = 0;
        for (int[] p : prerequisites) {
            int u = p[0], v = p[1];
            if (!graph.containsKey(u)) {
                graph.put(u, new ArrayList<>());
            }
            graph.get(u).add(v);
            parentNum.put(v, parentNum.get(v) + 1);
        }

        for (Integer node : parentNum.keySet()) {
            if (parentNum.get(node) == 0) {
                queue.offer(node);
            }
        }

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            cnt += 1;
            List<Integer> neighbors = graph.get(cur);
            if (neighbors != null) {
                for (Integer v : neighbors) {
                    parentNum.put(v, parentNum.get(v) - 1);
                    if (parentNum.get(v) == 0) {
                        queue.offer(v);
                    }
                }
            }
        }
        System.out.println(cnt);
        return cnt == numCourses;
    }

    public void test() {
        int[][] prerequisites = {{1, 0}};
        int num = 2;
        boolean res = canFinish(num, prerequisites);
        System.out.println(res);
    }
}
