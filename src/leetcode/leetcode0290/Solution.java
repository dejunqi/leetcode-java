package leetcode0290;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public boolean wordPattern(String pattern, String str) {
        String[] words = str.split(" ");
        Map<Character, String> map1 = new HashMap<>();
        Map<String, Character> map2 = new HashMap<>();


        int len = pattern.length();
        if (len != words.length) {
            return false;
        }
        for (int i = 0; i < len; i++) {
            char c = pattern.charAt(i);
            String w = words[i];
            if (map1.containsKey(c) && !map1.get(c).equals(w)) {
                return false;
            }

            if (map2.containsKey(w) && !map2.get(w).equals(c)) {
                return false;
            }

            map1.put(c, w);
            map2.put(w, c);
        }

        return true;
    }

    public void test() {
        // String pattern = "abba", str = "dog cat cat dog";
        String pattern = "aaa", str = "aa aa aa aa";
        boolean res = wordPattern(pattern, str);
        System.out.println(res);
    }
}
