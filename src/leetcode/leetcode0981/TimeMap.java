package leetcode0981;

import java.util.TreeMap;
import java.util.HashMap;

public class TimeMap {

    private HashMap<String, TreeMap<Integer, String>> map;

    /** Initialize your data structure here. */
    public TimeMap() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        if (!map.containsKey(key)) {
            map.put(key, new TreeMap<Integer, String>());
        }
        map.get(key).put(timestamp, value);
    }

    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) {
            return "";
        }

        TreeMap<Integer, String> itemsmap = map.get(key);
        Integer floorkey = itemsmap.floorKey(timestamp);
        if (floorkey == null) {
            return "";
        }

        return itemsmap.get(floorkey);
    }
}