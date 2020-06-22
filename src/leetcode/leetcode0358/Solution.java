package leetcode0358;

import java.util.*;

public class Solution {

    private class Char {
        char c;
        int freq;
        Char(char c, int freq) {
            this.c = c;
            this.freq = freq;
        }
    }

    public String rearrangeString(String s, int k) {
        PriorityQueue<Char> queue = new PriorityQueue<>((c1, c2) ->c2.freq - c1.freq);
        Map<Character, Integer> map = new HashMap<>();
        Queue<Char> tmp = new LinkedList<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (char c : map.keySet()) {
            queue.offer(new Char(c, map.get(c)));
        }

        while (!queue.isEmpty()) {
            Char cur = queue.poll();
            cur.freq -= 1;
            sb.append(cur.c);
            tmp.add(cur);
            if (tmp.size() < k) {
                continue;
            }

            Char chr = tmp.poll();
            if (chr.freq > 0) {
                queue.offer(chr);
            }
        }

        String res = sb.toString();
        if (res.length() != s.length()) {
            return "";
        }
        return res;
    }

    public void test() {
        String s = "aabbcc";
        int k = 3;
        String newStr = rearrangeString(s, k);
        System.out.println(newStr);
    }
}
