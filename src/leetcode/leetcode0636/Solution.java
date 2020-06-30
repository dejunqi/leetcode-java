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
            int prevId = -1;
            if (type.equals("start")) {
                timestamp -= 1;
                if (!stack.isEmpty()) {
                    prevId = stack.peek();
                    res[prevId] += timestamp - prevTime;
                }
                stack.push(id);
            } else {
                prevId = stack.pop();
                res[prevId] += timestamp - prevTime;
            }
            prevTime = timestamp;
        }

        return res;
    }

    public void test() {
        String[] logs = {"0:start:0","1:start:2","1:end:5","0:end:6"};
        int[] res = exclusiveTime(2, new ArrayList<>(Arrays.asList(logs)));
        System.out.println(Arrays.toString(res));
    }
}
