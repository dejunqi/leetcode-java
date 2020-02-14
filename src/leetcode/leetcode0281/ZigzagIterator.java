package leetcode0281;
import java.util.*;


public class ZigzagIterator {
    private class Entry {
        int idx;
        List<Integer> list;
        Entry(int i, List<Integer> v) {
            idx = i;
            list = v;
        }

    }
    private Queue<Entry> queue;

    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        queue = new LinkedList<>();
        if (v1.size() > 0) {
            queue.add(new Entry(0, v1));
        }
        if (v2.size() > 0) {
            queue.add(new Entry(0, v2));
        }
    }

    public int next() {
        if (!hasNext()) {
            return Integer.MIN_VALUE;
        }

        Entry e = queue.poll();
        int res = e.list.get(e.idx);
        if (e.idx < e.list.size() - 1) {
            e.idx += 1;
            queue.add(e);
        }

        return res;

    }

    public boolean hasNext() {
        return !queue.isEmpty();
    }
}
