package leetcode0752;

import java.util.*;

public class Solution {
    public int openLock(String[] deadends, String target) {
        int[] initState = {0, 0, 0, 0};
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(initState);
        int step = 0;

        Set<String> unavailable = new HashSet<>(Arrays.asList(deadends));
        String initStr = join(initState);
        if (unavailable.contains(initStr)) {
            return -1;
        }
        unavailable.add(initStr);

        while (!queue.isEmpty()) {
            int len = queue.size();
            step += 1;
            for (int i = 0; i < len; i++) {
                int[] curstate = queue.poll();
                for (int j = 0; j < 4; j++) {
                    int[] arr = clone(curstate);
                    int positiveNum = (arr[j] + 1) % 10;
                    int negativeNum = (arr[j] - 1 + 10) % 10;
                    arr[j] = positiveNum;
                    String positiveState = join(arr);
                    if (positiveState.equals(target)) {
                        return step;
                    }
                    if (!unavailable.contains(positiveState)) {
                        unavailable.add(positiveState);
                        queue.offer(clone(arr));
                    }

                    arr[j] = negativeNum;
                    String negativeState = join(arr);
                    if (negativeState.equals(target)) {
                        return step;
                    }
                    if (!unavailable.contains(negativeState)) {
                        unavailable.add(negativeState);
                        queue.offer(clone(arr));
                    }
                }
            }
        }

        return -1;
    }

    private int[] clone(int[] arr) {
        int[] clone = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            clone[i] = arr[i];
        }
        return clone;
    }

    private String join(int[] arr) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
        }
        return sb.toString();
    }

    public void test() {
        String[] deadends = {"0201","0101","0102","1212","2002"};
        String target = "0202";
        int res = openLock(deadends, target);
        System.out.println(res);
    }
}
