package leetcode0855;

import java.util.Iterator;
import java.util.TreeSet;

public class ExamRoom {
    private int capacity;
    private TreeSet<Integer> set;

    public ExamRoom(int n) {
        capacity = n;
        set = new TreeSet<>();
    }

    public int seat() {
        if (set.isEmpty()) {
            set.add(0);
            return 0;
        }

        if (set.size() == 1) {
            int num = set.first();
            if (num < capacity / 2) {
                set.add(capacity - 1);
                return capacity - 1;
            } else {
                set.add(0);
                return 0;
            }
        }

        // more then 2 people in the exam room
        Iterator<Integer> iter = set.iterator();
        int left = iter.next();
        int dist = -1, pos = -1;

        if (left > 0) {
            dist = left;
            pos = 0;
        }

        while (iter.hasNext()) {
            int right = iter.next();
            if ((right - left) / 2 > dist) {
                dist = (right - left) / 2;
                pos = left + dist;
            }
            left = right;
        }

        if (capacity - 1 - left > dist) {
            pos = capacity - 1;
        }
        set.add(pos);
        return pos;
    }

    public void leave(int p) {
        set.remove(p);
    }
}
