package leetcode.leetcode0003;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int len = s.length();
        if (len == 0) {
            return 0;
        }
        Map<Character, Integer> map = new HashMap<>();
        int res = 0;
        int i = 0, j = 0;
        while (j < len) {
            char c = s.charAt(j);
            if (map.containsKey(c) && i <= map.get(c)) {
                res = Math.max(res, j - i);
                i = map.get(c) + 1;
            }
            map.put(c, j);
            j += 1;
        }

        return Math.max(res, j - i);
    }
}
