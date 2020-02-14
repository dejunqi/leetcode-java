package leetcode0269;

import java.util.*;

public class Solution {
    public String alienOrder(String[] words) {
        Map<Character, Set<Character>> graph = new HashMap<>();
        Map<Character, Integer> parentNum = new HashMap<>();

        for (String w : words) {
            for (int i = 0; i < w.length(); i++) {
                char c = w.charAt(i);
                parentNum.put(c, 0);
                graph.put(c, new HashSet<>());
            }
        }

        for (int i = 1; i < words.length; i++) {
            String w1 = words[i - 1], w2 = words[i];
            int len = Math.min(w1.length(), w2.length());
            for (int j = 0; j < len; j++) {
                char c1 = w1.charAt(j), c2 = w2.charAt(j);
                if (c1 != c2) {
                    if (!graph.get(c1).contains(c2)) {
                        graph.get(c1).add(c2);
                        parentNum.put(c2, parentNum.get(c2) + 1);
                    }
                    break;
                }
            }
        }

        Queue<Character> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        for (Character c : parentNum.keySet()){
            if (parentNum.get(c) == 0) {
                queue.offer(c);
            }
        }

        while (!queue.isEmpty()) {
            char c = queue.poll();
            sb.append(c);
            Set<Character> neighbors = graph.get(c);
            if (neighbors != null) {
                for (Character v : neighbors) {
                    parentNum.put(v, parentNum.get(v) - 1);
                    if (parentNum.get(v) == 0) {
                        queue.offer(v);
                    }
                }
            }
        }
        String res = sb.toString();
        return res.length() == parentNum.size() ? res : "";
    }


    public void test() {
        String[] words = {"wrt", "wrf", "er", "ett", "rftt"};
        String res = alienOrder(words);
        System.out.println(res);
    }
}
