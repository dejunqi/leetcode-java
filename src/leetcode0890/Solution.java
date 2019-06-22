package leetcode0890;

import java.util.*;

public class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {

        List<String> res = new ArrayList<>();
        for (String w : words) {
            // have to check 2 cases, other wise "abc" will match with "abb"
            if (match(w, pattern) && match(pattern, w)) {
                res.add(w);
            }
        }
        return res;
    }

    private boolean match(String s1, String s2) {
        Map<Character, Character> map = new HashMap<>();
        int n = s1.length();
        for (int i = 0; i < n; i++) {
            char c1 = s1.charAt(i), c2 = s2.charAt(i);
            if (!map.containsKey(c1)) {
                map.put(c1, c2);
            } else {
                if (map.get(c1) != c2) {
                    return false;
                }
            }
        }

        return true;
    }


    public void test() {
        String[] words = {"abc","deq","mee","aqq","dkd","ccc"};
        String pattern = "abb";


        List<String> res = findAndReplacePattern(words, pattern);
        for (String s : res) {
            System.out.print(s + " ");
        }
        System.out.println();
    }
}
