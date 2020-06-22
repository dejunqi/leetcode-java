package leetcode0767;

import java.util.*;

public class Solution {

    private class Pair {
        char c;
        int freq;
        Pair(char c, int freq) {
            this.c = c;
            this.freq = freq;
        }
    }

    public String reorganizeString(String S) {
        Map<Character, Integer> map = new HashMap<>();
        PriorityQueue<Pair> queue = new PriorityQueue<>((p1, p2) -> {
            return p2.freq - p1.freq;
        });
        Queue<Pair> tmp = new LinkedList<>();
        StringBuilder sb = new StringBuilder();

        int len = S.length();
        for (int i = 0; i < len; i++) {
            char c = S.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (char c : map.keySet()) {
            queue.offer(new Pair(c, map.get(c)));
        }

        while (!queue.isEmpty()) {
           Pair p = queue.poll();
           p.freq--;
           sb.append(p.c);
           tmp.add(p);
           if (tmp.size() < 2) {
               continue;
           }

           p = tmp.poll();
           if (p.freq > 0) {
               queue.offer(p);
           }
        }

        String res = sb.toString();
        if (res.length() != len) {
            return "";
        }

        return res;

    }



}
