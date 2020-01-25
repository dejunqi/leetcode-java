package utils.practice;


import java.util.*;


public class Solution {

    public int numMatchingSubseq(String S, String[] words) {

        Map<Character, Queue<String>> map = new HashMap<>();
        int start = 'a', end = 'z';
        for (int i = start; i <= end; i++) {
            map.put((char)i, new LinkedList<>());
        }

        for (String w : words) {
            char c = w.charAt(0);
            map.get(c).add(w);
        }

        int len = S.length();
        int cnt = 0;
        for (int i = 0; i < len; i++) {
            char c = S.charAt(i);
            Queue<String> queue = map.get(c);
            int size = queue.size();
            for (int j = 0; j < size; j++) {
                String word = queue.poll();
                if (word.length() == 1) {
                    cnt++;
                } else {
                    String subword = word.substring(1);
                    map.get(subword.charAt(0)).add(subword);
                }
            }
        }

        return cnt;
    }

    public void test() {
        String s = "abcde";
        String[] words = {"a", "bb", "acd", "ace"};
        int res = numMatchingSubseq(s, words);
        System.out.println(res);
    }
}
