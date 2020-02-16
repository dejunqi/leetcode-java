package utils.practice;

import java.util.*;

public class Solution {
    private class Task {
        char c;
        int freq;
        Task(char c, int f) {
            this.c = c;
            this.freq = f;
        }
    }
    public int leastInterval(char[] tasks, int n) {
        PriorityQueue<Task> queue = new PriorityQueue<>((t1, t2) -> t2.freq - t1.freq);
        Map<Character, Integer> map = new HashMap<>();
        for (char t : tasks) {
            map.put(t, map.getOrDefault(t, 0) + 1);
        }

        for (Character c : map.keySet()) {
            queue.add(new Task(c, map.get(c)));
        }

        int res = 0;

        while (!queue.isEmpty()) {
            int k = n + 1;
            List<Task> tmp = new ArrayList<>();
            while (!queue.isEmpty() && k > 0) {
                Task task = queue.poll();
                task.freq -= 1;
                k -= 1;
                res += 1;
                tmp.add(task);
            }

            for (Task t : tmp) {
                if (t.freq > 0) {
                    queue.add(t);
                }
            }

            if (queue.isEmpty()) {
                break;
            }
            res += k;
        }

        return res;
    }
}
