package leetcode0076;

import java.util.*;

public class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> count = new HashMap<>();
        Map<Character, Queue<Integer>> map = new HashMap<>();
        TreeSet<Integer> window = new TreeSet<>();

        String res = "";

        int len = t.length();

        for (int i = 0; i < len; i++) {
            char c = t.charAt(i);
            count.put(c, count.getOrDefault(c, 0) + 1);
        }

        len = s.length();
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (!count.containsKey(c)) {
                continue;
            }
            map.putIfAbsent(c, new LinkedList<>());
            map.get(c).add(i);
            if (map.get(c).size() > count.get(c)) {
                int idx = map.get(c).poll();
                window.remove(idx);
            }
            window.add(i);
            if (window.size() == t.length()) {
                int start = window.first(), end = window.last();
                if (res.equals("") || end - start < res.length()) {
                    res = s.substring(start, end + 1);
                }
            }
        }

        return res;
    }

    public void test() {
        String S = "ADOBECODEBANC", T = "ABC";
        String res = minWindow(S, T);
        System.out.println(res);
    }
}
