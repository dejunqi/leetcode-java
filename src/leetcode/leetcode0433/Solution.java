package leetcode.leetcode0433;

import java.util.*;

public class Solution {
    public int minMutation(String start, String end, String[] bank) {

        Queue<String> queue = new LinkedList<>();
        queue.add(start);
        Set<String> geneticBank = new HashSet<>(Arrays.asList(bank));
        if (!geneticBank.contains(end)) {
            return -1;
        }
        geneticBank.add(start);

        char[] choices = {'A', 'G', 'C', 'T'};
        int res = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            res += 1;
            for (int i = 0; i < size; i++) {
                String cur = queue.poll();
                for (int j = 0; j < cur.length(); j++) {
                    for (char c : choices) {
                        String nextStr = cur.substring(0, j) + c + cur.substring(j + 1);
                        if (nextStr.equals(end)) {
                            return res;
                        }
                        if (geneticBank.contains(nextStr)) {
                            geneticBank.remove(nextStr);
                            queue.add(nextStr);
                        }
                    }
                }
            }
        }
        return -1;
    }

    public void test() {
        String start = "AAAAACCC";
        String end = "AACCCCCC";
        String[] bank = {"AAAACCCC", "AAACCCCC", "AACCCCCC"};
        int res = minMutation(start, end, bank);
        System.out.println(res);
    }
}
