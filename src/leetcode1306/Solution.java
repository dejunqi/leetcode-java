package leetcode1306;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public boolean canReach(int[] arr, int start) {
        Queue<Integer> queue = new LinkedList<>();
        if (arr[start] == 0) {
            return true;
        }
        queue.add(start);
        boolean[] visited = new boolean[arr.length];
        visited[start] = true;
        while (!queue.isEmpty()) {
            int pos = queue.poll();
            int[] dirs = {1, -1};
            for (int d : dirs) {
                int next = pos + d * arr[pos];
                if (next >= 0 && next < arr.length) {
                    if (arr[next] == 0) {
                        return true;
                    }
                    if (!visited[next]) {
                        visited[next] = true;
                        queue.add(next);
                    }
                }
            }

        }
        return false;
    }

    public void test() {
        int[] arr = {4, 2, 3, 0, 3, 1, 2};
        int start = 5;
        System.out.println(canReach(arr, start));
    }
}
