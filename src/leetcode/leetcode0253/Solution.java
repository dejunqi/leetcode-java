package leetcode0253;

import java.util.TreeMap;

public class Solution {

    // O(nlog(n)) in time
    // O(n) space
    public int minMeetingRooms(int[][] intervals) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int[] e : intervals) {
            int start = e[0], end = e[1];
            // O(log(n)) average in time complexity
            map.put(start, map.getOrDefault(start, 0) + 1);
            map.put(end, map.getOrDefault(end, 0) - 1);
        }

        /*
         * scan the ordered map, if come across start, increase seat by 1, if end time, decrease seat number by 1
         * The maximum number of seat need arrange during the process is the result.
         */
        int res = 0;
        int cnt = 0;
        for (Integer key : map.keySet()) {
            cnt += map.get(key);
            res = Math.max(res, cnt);
        }
        return res;
    }
}
