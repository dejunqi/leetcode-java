package leetcode0855;

import java.util.Iterator;
import java.util.TreeSet;

public class ExamRoom {

    TreeSet<Integer> set;
    int capacity;

    public ExamRoom(int N) {
        capacity = N;
        set = new TreeSet<>();
    }

    public int seat() {
        if (set.isEmpty()) {
            set.add(0);
            return 0;
        }

        if (set.size() == 1) {
            int left = set.first();
            int pos = -1;
            if (capacity - 1 - left > left) {
                pos = capacity - 1;
            } else {
                pos = 0;
            }
            set.add(pos);
            return pos;
        }

        Iterator<Integer> iter = set.iterator();
        int left = iter.next();
        int pos = -1;
        int dist = -1;

        if (left > 0) {
            pos = 0;
            dist = left;
        }

        while (iter.hasNext()) {
            int right = iter.next();
            int mid = (right - left) / 2;
            if (mid > dist) {
                dist = mid;
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
