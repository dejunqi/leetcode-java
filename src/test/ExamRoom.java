package test;

import java.util.Iterator;
import java.util.TreeSet;

public class ExamRoom {
    int capacity;
    TreeSet<Integer> set;

    public ExamRoom(int capacity) {
        this.capacity = capacity;
        set = new TreeSet<>();
    }

    public int seat() {
        if (set.isEmpty()) { // case 1 : room is empty
            set.add(0);
            return 0;
        }

        if (set.size() == 1) { // case 2 : only one person in the room
            int num = set.first();
            int left = 0, right = capacity - 1;
            int pos = right - num > num - left ? right : left;
            set.add(pos);
            return pos;
        }


        // multiple ppeople in the room
        Iterator<Integer> iter = set.iterator();
        int left = iter.next();
        int dist = -1;
        int pos = -1;

        if (left > 0) {
            dist = left;
            pos = 0;
        }

        while (iter.hasNext()) {
            int right = iter.next();
            int tmp = (right - left) / 2;
            if (tmp > dist) {
                dist = tmp;
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