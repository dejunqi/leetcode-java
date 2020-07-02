package leetcode.leetcode0380;

import java.util.*;

public class RandomizeSetV2 {
    private TreeSet<Integer> treeSet;
    private Random rnd;
    /** Initialize your data structure here. */
    public RandomizeSetV2() {
        treeSet = new TreeSet<>();
        rnd = new Random();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (treeSet.contains(val)) {
            return false;
        }
        treeSet.add(val);
        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!treeSet.contains(val)) {
            return false;
        }
        treeSet.remove(val);
        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        int min = treeSet.first(), max = treeSet.last();
        int val = rnd.nextInt(max - min + 1) + min;
        if (val == min || val == max) {
            return val;
        }

        if (Math.random() > 0.5) {
            return treeSet.ceiling(val);
        }
        return treeSet.floor(val);

    }
}
