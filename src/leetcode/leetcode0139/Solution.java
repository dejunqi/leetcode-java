package leetcode0139;

import java.util.*;

public class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        Queue<Integer> queue = new LinkedList<>();
        int len = s.length();
        boolean[] visited = new boolean[len];

        queue.add(0);

        while (!queue.isEmpty()) {
            int idx = queue.poll();
            if (idx == len) {
                return true;
            }
            if (visited[idx]) {
                continue;
            }

            for (int i = idx + 1; i < len + 1; i++) {
                String substr = s.substring(idx, i);
                if (wordSet.contains(substr)) {
                    queue.offer(i);
                }
            }
            visited[idx] = true;
        }

        return false;
    }
}