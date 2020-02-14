package leetcode0340;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (k == 0) {
            return 0;
        }

        Map<Character, Integer> map = new HashMap<>();
        int l = 0, r = 0;
        int len = s.length();
        int res = 0;
        while (r < len) {
            char cr = s.charAt(r);
            map.put(cr, map.getOrDefault(cr, 0) + 1);

            while (l < r && map.size() > k) {
                res = Math.max(res, r - l);
                char cl = s.charAt(l);
                map.put(cl, map.get(cl) - 1);
                if (map.get(cl) == 0) {
                    map.remove(cl);
                }
                l++;
            }
            r++;
        }

        res = Math.max(res, r - l);
        return res;
    }
}
