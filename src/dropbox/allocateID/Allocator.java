package dropbox.allocateID;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 Things to consider:
 - what happens if all IDs used up? throws Exception or return -1

 release invalid ID or release id that is not allocated, how to handle? just return or
 throw Exception??


 FreeList approach:
 Space is O(n), heavy, because of the data structure of queue and set too
 O(1) time in allocate and release
 */

public class Allocator {
    private Queue<Integer> queue;
    private Set<Integer> allocated;
    private final int MAX_ID;

    public Allocator(int maxId) {
        MAX_ID = maxId;
        queue = new LinkedList<>();
        for (int i = 0; i < maxId; i++) {
            queue.offer(i);
        }
        allocated = new HashSet<>();
    }

    public int allocate() {
        if (queue.isEmpty()) {
            return -1;
        }
        int id = queue.poll();
        allocated.add(id);
        return id;
    }

    public void release(int id) {
        if (id < 0 || id >= MAX_ID || !allocated.contains(id)) {
            return;
        }
        allocated.remove(id);
        queue.add(id);
    }

    public boolean check(int id) {
        return !allocated.contains(id);
    }

}
