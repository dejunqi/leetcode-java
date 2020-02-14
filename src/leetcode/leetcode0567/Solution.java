package leetcode0567;

import java.util.Map;
import java.util.HashMap;

public class Solution {
    public boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> map = new HashMap<>();
        int len1 = s1.length();
        int len2 = s2.length();
        for (int i = 0; i < len1; i++) {
            char c = s1.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int j = 0;
        int i = 0;

        int zeroCount = 0;

        while (j < len2) {
            char cj = s2.charAt(j);
            if (map.containsKey(cj)) {
                map.put(cj, map.get(cj) - 1);
                if (map.get(cj) == 0) {
                    zeroCount++;
                }
            }
            j++;

            if (zeroCount == map.size()) {
                return true;
            }

            if (j - i == len1) {
                char ci = s2.charAt(i);
                if (map.containsKey(ci)) {
                    map.put(ci, map.get(ci) + 1);
                    if (map.get(ci) == 1) {
                        zeroCount--;
                    }
                }
                i++;
            }
        }

        return false;
    }

    private boolean allZero(Map<Character, Integer> map) {
        boolean res = true;
        for (char c : map.keySet()) {
            res = res && (map.get(c) == 0);
        }
        return res;
    }
}