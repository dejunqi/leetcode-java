package leetcode0792;

/*
Given string S and a dictionary of words words, find the number of words[i] that is a subsequence of S.

Example :
Input:
S = "abcde"
words = ["a", "bb", "acd", "ace"]
Output: 3
Explanation: There are three words in words that are a subsequence of S: "a", "acd", "ace".
*/

import java.util.*;

public class Solution {
    public int numMatchingSubseq(String S, String[] words) {
        int res = 0;
        int len = S.length();
        Map<Character, Queue<String>> map = new HashMap<>();
        for (String w : words) {
            char c = w.charAt(0);
            if (!map.containsKey(c)) {
                map.put(c, new LinkedList<>());
            }
            map.get(c).add(w);
        }

        for (int i = 0; i < len; i++) {
            char c0 = S.charAt(i);
            if (map.containsKey(c0)) {
                Queue<String> queue = map.get(c0);
                int size = queue.size();
                for (int j = 0; j < size; j++) {
                    String word = queue.poll();
                    if (word.length() == 1) {
                        res++;
                    } else {
                        char c1 = word.charAt(1);
                        if (!map.containsKey(c1)) {
                            map.put(c1, new LinkedList<>());
                        }
                        map.get(c1).add(word.substring(1));
                    }
                }
            }
        }

        return res;
    }
}
