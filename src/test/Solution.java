package test;

import java.util.*;

public class Solution {
    public int minMeetingRooms(int[][] intervals) {

        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int[] e : intervals) {
            map.put(e[0], map.getOrDefault(e[0], 0) + 1);
            map.put(e[1], map.getOrDefault(e[1], 0) - 1);
        }

        int res = 0;
        int cnt = 0;
        for (Integer key : map.keySet()) {
            cnt += map.get(key);
            res = Math.max(res, cnt);
        }
        return res;
    }
}