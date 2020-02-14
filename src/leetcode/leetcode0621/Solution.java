package leetcode0621;


import java.util.*;

public class Solution {
    private class Task {
        char name;
        int freq;
        Task(char name, int freq) {
            this.name = name;
            this.freq = freq;
        }
    }

    public int leastInterval(char[] tasks, int n) {
        PriorityQueue<Task> queue = new PriorityQueue<>((t1, t2) -> {
           return t2.freq - t1.freq;
        });
        Map<Character, Integer> map = new HashMap<>();
        int res = 0;

        for (char c : tasks) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (char c : map.keySet()) {
            queue.offer(new Task(c, map.get(c)));
        }

        while (!queue.isEmpty()) {
            int cnt = n + 1;
            List<Task> tmp = new ArrayList<>();
            while (!queue.isEmpty() && cnt > 0) {
                Task task = queue.poll();
                task.freq--;
                cnt--;
                res++;
                tmp.add(task);
            }

            for (Task t : tmp) {
                if (t.freq > 0) {
                    queue.offer(t);
                }
            }

            if (queue.isEmpty()) break;

            res += cnt;
        }
        return res;
    }

}
