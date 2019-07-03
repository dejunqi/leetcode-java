package leetcode0731;

import java.util.TreeMap;

public class MyCalendarTwo {

    private TreeMap<Integer, Integer> map;
    public MyCalendarTwo() {
        map = new TreeMap<>();
    }

    public boolean book(int start, int end) {
        map.put(start, map.getOrDefault(start, 0) + 1);
        map.put(end, map.getOrDefault(end, 0) - 1);
        int cnt = 0;
        System.out.println(start + ", " + end);
        for (Integer key : map.keySet()) {
            cnt += map.get(key);
            System.out.println(key + ": " + map.get(key) + ", cnt = " + cnt);
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
        System.out.println();
        return true;
    }

    /*
    ["MyCalendarTwo","book","book","book","book","book","book"]
    [[],[10,20],[50,60],[10,40],[5,15],[5,10],[25,55]]

    [null,true,true,true,false,true,true]
    * */

}
