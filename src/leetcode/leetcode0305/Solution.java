package leetcode.leetcode0305;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        Map<String, String> map = new HashMap<>();
        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                String key = i + "," + j;
                map.put(key, "");
            }
        }

        int res = 0;
        List<Integer> list = new ArrayList<>();
        for (int[] p : positions) {
            String key = p[0] + "," + p[1];
            map.put(key, key);
            res++;
            for (int[] d : dirs) {
                int r = p[0] + d[0], c = p[1] + d[1];
                String s = r + "," + c;
                if (r >= 0 && r < m && c >= 0 && c < n && !map.get(s).equals("")) {
                    String rs = root(s, map);
                    if (!rs.equals(key)) {
                        map.put(key, rs);
                        key = rs;
                        res--;
                    }
                }
            }
            list.add(res);
        }
        return list;
    }

    private String root(String k, Map<String, String> map) {
        while (!k.equals(map.get(k))) {
            k = map.get(k);
        }
        return k;
    }

    public void test() {

    }
}
