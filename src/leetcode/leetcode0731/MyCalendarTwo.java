package leetcode0731;

import java.util.Map;
import java.util.TreeMap;

public class MyCalendarTwo {

    private Map<Integer, Integer> map;

    MyCalendarTwo() {
        map = new TreeMap<>();
    }

    public boolean book(int start, int end) {
        map.put(start, map.getOrDefault(start, 0) + 1);
        map.put(end, map.getOrDefault(end, 0) - 1);
        int cnt = 0;
        for (Integer k : map.keySet()) {
            cnt += map.get(k);
            if (cnt > 2) {
                map.put(start, map.get(start) - 1);
                if (map.get(start) == 0) {
                    map.remove(start);
                }

                map.put(end, map.get(end) + 1);
                if (map.get(end) == 0) {
                    map.remove(end);
                }

                return false;
            }
        }

        return true;
    }
}
