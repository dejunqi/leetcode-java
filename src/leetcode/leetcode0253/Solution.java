package leetcode.leetcode0253;

import java.util.TreeMap;

public class Solution {

    // O(nlog(n)) in time
    // O(n) space
    public int minMeetingRooms(int[][] intervals) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int[] interval: intervals) {
            map.put(interval[0], map.getOrDefault(interval[0], 0) + 1);
            map.put(interval[1], map.getOrDefault(interval[1], 0) - 1);
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
