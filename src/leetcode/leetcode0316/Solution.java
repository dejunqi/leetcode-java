package leetcode0316;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

    public String removeDuplicateLetters(String s) {

        int len = s.length();
        if (len == 0) {
            return "";
        }

        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int idx = 0;
        for (int i = 0; i < len; i++) {
            char ci = s.charAt(i);
            char cidx = s.charAt(idx);
            if (ci < cidx) {
                idx = i;
            }
            map.put(ci, map.get(ci) - 1);
            if (map.get(ci) == 0) {
                break;
            }
        }


        char c = s.charAt(idx);

        String cs = Character.toString(c);
        return c + removeDuplicateLetters(s.substring(idx + 1).replace(cs, ""));
    }

    public void test() {
        String s = "cbacdcbc";
        System.out.println(removeDuplicateLetters(s));
    }
}
