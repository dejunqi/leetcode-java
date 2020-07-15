package leetcode.leetcode0269;

import java.util.*;

public class Solution {

    public String alienOrder(String[] words) {
        Map<Character, Set<Character>> graph = new HashMap<>();
        Map<Character, Integer> numOfParents = new HashMap<>();

        for (String w : words) {
            for (int i = 0; i < w.length(); i++) {
                char c = w.charAt(i);
                graph.put(c, new HashSet<>());
                numOfParents.put(c, 0);
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
                        numOfParents.put(c2, numOfParents.get(c2) + 1);
                    }
                    break;
                }
            }
        }

        for (Character c : numOfParents.keySet()) {
            System.out.println(c + ": " + graph.get(c).size());
        }

        StringBuilder sb = new StringBuilder();
        Queue<Character> queue = new LinkedList<>();

        for (Character c : numOfParents.keySet()) {
            if (numOfParents.get(c) == 0) {
                queue.add(c);
            }
        }

        if (queue.size() == numOfParents.size()) {
            return "";
        }

        while (!queue.isEmpty()) {
            char c = queue.poll();
            sb.append(c);
            Set<Character> neighbors = graph.get(c);
            if (neighbors == null) continue;
            for (Character n : neighbors) {
                numOfParents.put(n, numOfParents.get(n) - 1);
                if (numOfParents.get(n) == 0) {
                    queue.add(n);
                }
            }
        }

        String res = sb.toString();
        return res.length() == numOfParents.size() ? res : "";

    }


    public void test() {
//        String[] words = {"wrt", "wrf", "er", "ett", "rftt"};
//        String[] words = {"za","zb","ca","cb"};
        String[] words = {"abc","ab"};
        String res = alienOrder(words);
        System.out.println(res);
    }
}
