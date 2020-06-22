package leetcode0291;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {
    public boolean wordPatternMatch(String pattern, String str) {
        Map<Character, String> map = new HashMap<>();
        Set<String> visited = new HashSet<>();
        return helper(pattern, str, map, visited, 0, 0);
    }

    private boolean helper(String pattern, String str, Map<Character, String> map, Set<String> visited, int i, int j) {
        int n = pattern.length();
        int m = str.length();
        if (i == n && j == m) {
            return true;
        }
        if (i == n || j == m) {
            return false;
        }

        char c = pattern.charAt(i);
        for (int k = j + 1; k <= m; k++) {
            String substr = str.substring(j, k);
            if (!map.containsKey(c) && !visited.contains(substr)) {
                map.put(c, substr);
                visited.add(substr);
                if (helper(pattern, str, map, visited, i + 1, k)) {
                    return true;
                }
                map.remove(c);
                visited.remove(substr);
            } else if (map.containsKey(c) && visited.contains(substr) && map.get(c).contentEquals(substr)) {
                if (helper(pattern, str, map, visited, i + 1, k)) {
                    return true;
                }
            }
        }

        return false;
    }
}