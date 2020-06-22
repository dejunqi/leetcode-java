package leetcode1306;

import java.util.LinkedList;
import java.util.Queue;

/*
Space: O(n)
Time : O(n)

obviously, due to the queue we allocate for space, it is O(n),
As for time complexity, we are building the binary tree, the nodes we have for the trees
is double to the number of element of the array. O(2 * n) ~ O(n)
 */
public class Solution {
    public boolean canReach(int[] arr, int start) {
        Queue<Integer> queue = new LinkedList<>();
        if (arr[start] == 0) {
            return true;
        }
        queue.add(start);
        boolean[] visited = new boolean[arr.length];
        visited[start] = true;
        int[] dirs = {1, -1}; // two direction, left and right
        while (!queue.isEmpty()) {
            int pos = queue.poll();
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
