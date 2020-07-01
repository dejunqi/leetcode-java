package leetcode.leetcode0636;

import java.util.*;

public class Solution {

    public int[] exclusiveTime(int n, List<String> logs) {

        Stack<Integer> stack = new Stack<>();
        int[] res = new int[n];
        int prevTime = -1;

        for (String log : logs) {

            String[] strs = log.split(":");
            int id = Integer.parseInt(strs[0]);
            String type = strs[1];
            int timestamp = Integer.parseInt(strs[2]);

            if (type.equals("start")) {
                if (!stack.isEmpty()) {
                    res[stack.peek()] += timestamp - prevTime - 1;
                }
                stack.push(id);
                prevTime = timestamp - 1;
            } else {
                int prevId = stack.pop();
                res[prevId] += timestamp - prevTime;
                prevTime = timestamp;
            }

        }

        return res;

    }

    public void test() {
        String[] logs = {"0:start:0","1:start:2","1:end:5","0:end:6"};
        int[] res = exclusiveTime(2, new ArrayList<>(Arrays.asList(logs)));
        System.out.println(Arrays.toString(res));
    }
}
