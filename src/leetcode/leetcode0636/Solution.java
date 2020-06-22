package leetcode.leetcode0636;

import java.util.List;
import java.util.Stack;

public class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {

        Stack<Integer> stack = new Stack<>();
        int[] res = new int[n];
        int prevTime = 0;
        for (String log : logs) {
            String[] parts = log.split(":");
            int id = Integer.parseInt(parts[0]);
            String type = parts[1];
            int time = Integer.parseInt(parts[2]);

            if (!stack.isEmpty()) {
                res[stack.peek()] += time - prevTime;
            }
            prevTime = time;
            if (type.equals("start")) {
                stack.push(id);
            } else {
                res[stack.pop()] += 1;
                prevTime += 1;
            }
        }

        return res;
    }
}
