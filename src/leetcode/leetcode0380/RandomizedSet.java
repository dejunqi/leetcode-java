package leetcode.leetcode0380;

import java.util.*;

public class RandomizedSet {

    Map<Integer, Integer> map;
    List<Integer> list;
    Random rnd;

    /** Initialize your data structure here. */
    public RandomizedSet() {
        map = new HashMap<>();
        list = new ArrayList<>();
        rnd = new Random();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        }
        map.put(val, list.size());
        list.add(val);
        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }
        int idx = map.get(val);
        if (idx < list.size() - 1) {
            int lastVal = list.get(list.size() - 1);
            list.set(idx, lastVal);
            map.put(lastVal, idx);
        }
        map.remove(val);
        list.remove(list.size() - 1);
        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        return list.get(rnd.nextInt(list.size()));
    }
}
