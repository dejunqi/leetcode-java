package leetcode.leetcode0752;

import java.util.*;

public class Solution {

    public int openLock(String[] deadends, String target) {
        Set<String> deadLoks = new HashSet<>(Arrays.asList(deadends));
        if (deadLoks.contains(target) || deadLoks.contains("0000")) {
            return -1;
        }

        Queue<String> queue = new LinkedList<>();
        queue.add("0000");
        deadLoks.add("0000");
        int res = 0;
        while (!queue.isEmpty()) {
            res++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String cur = queue.poll();
                for (int j = 0; j < cur.length(); j++) {
                    int val = Character.getNumericValue(cur.charAt(j));
                    int pos = (val + 1) % 10, neg = (val -1 + 10) % 10;
                    String s1 = cur.substring(0, j) + pos + cur.substring(j + 1);
                    if (s1.equals(target)) {
                        return res;
                    }
                    if (!deadLoks.contains(s1)) {
                        deadLoks.add(s1);
                        queue.add(s1);
                    }

                    String s2 = cur.substring(0, j) + neg + cur.substring(j + 1);
                    if (s2.equals(target)) {
                        return res;
                    }
                    if (!deadLoks.contains(s2)) {
                        deadLoks.add(s2);
                        queue.add(s2);
                    }
                }
            }
        }
        return -1;
    }

    public void test() {
        String[] deadends = {"0201","0101","0102","1212","2002"};
        String target = "0202";
        int res = this.openLock(deadends, target);
        System.out.println(res);
    }
}

