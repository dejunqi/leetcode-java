package leetcode.leetcode0818;

import java.util.*;

public class Solution {

    public int racecar(int target) {
        int step = 0;
        int[] initialState = {1, 0};
        Queue<int[]> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.add(initialState);
        visited.add(1 + "," + 0);
        while (!queue.isEmpty()) {
            step += 1;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] state = queue.poll();
                int speed = state[0], position = state[1];
                System.out.print(" " + speed + "," + position + " ");
                if (position + speed == target) {
                    return step;
                }

                int p1 = position + speed;
                int v1 = 2 * speed;
                if (p1 >= 0) {
                    String keyA = v1 + "," + p1;
                    if (!visited.contains(keyA)) {
                        visited.add(keyA);
                        queue.add(new int[] {v1, p1});
                    }
                }

                int v2 = speed > 0 ? -1 : 1;
                int p2 = position;
                if (p2 >= 0) {
                    String keyB = v2 + "," + p2;
                    if (!visited.contains(keyB)) {
                        visited.add(keyB);
                        queue.add(new int[] {v2, p2});
                    }
                }
            }

            System.out.println();
        }
        return -1;
    }

    public void test() {
        int target = 6;
        System.out.println("\n" + this.racecar(target));
    }
}
