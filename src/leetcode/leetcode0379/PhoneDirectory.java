package leetcode0379;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class PhoneDirectory {

    private boolean[] used;
    private int capacity;

    /** Initialize your data structure here
     @param maxNumbers - The maximum numbers that can be stored in the phone directory. */
    public PhoneDirectory(int maxNumbers) {
        capacity = maxNumbers;
        used = new boolean[maxNumbers];

    }

    /** Provide a number which is not assigned to anyone.
     @return - Return an available number. Return -1 if none is available. */
    public int get() {
        int idx = 0;
        while (idx < capacity && used[idx]) {
            idx++;
        }
        if (idx == capacity) {
            return -1;
        }

        used[idx] = true;
        return idx;
    }

    /** Check if a number is available or not. */
    public boolean check(int number) {
        return number < capacity && !used[number];
    }

    /** Recycle or release a number. */
    public void release(int number) {
        if (number < capacity) {
            used[number] = false;
        }
    }
}
