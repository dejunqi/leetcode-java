package leetcode0947;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int removeStones(int[][] stones) {
        Map<String, String> map = new HashMap<>();
        for (int[] stone : stones) {
            String key = stone[0] + "," + stone[1];
            map.put(key, key);
        }
        int cnt = stones.length;
        for (int i = 0; i < stones.length; i++) {

            for (int j = 0; j < stones.length; j++) {
                if (i == j) continue;

                if (stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1]) {
                    String p = stones[i][0] + "," + stones[i][1], q = stones[j][0] + "," + stones[j][1];
                    String rp = root(map, p), rq = root(map, q);
                    if (!rp.equals(rq)) {
                        map.put(rp, rq);
                        cnt -= 1;
                    }
                }
            }
        }

        return stones.length - cnt;
    }

    private String root(Map<String, String> map, String p) {
        while (!map.get(p).equals(p)) {
            p = map.get(p);
        }
        return p;
    }


    public void test() {

    }
}