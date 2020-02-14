package leetcode0210;

import java.util.*;

public class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        Map<Integer, Integer> parentNum = new HashMap<>();
        Queue<Integer> queue = new LinkedList<>();
        int[] res = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            parentNum.put(i, 0);
        }

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

        int idx = numCourses - 1;
        int cnt = 0;
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            res[idx--] = cur;
            cnt++;
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
        return cnt == numCourses ? res : new int[] {};
    }
}

