package leetcode.leetcode0460;

import java.util.*;


public class LFUCache {

    private int capacity;
    private PriorityQueue<Node> queue;
    private int time;
    private Map<Integer, Node> map;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        time = 0;
        map = new HashMap<>();
        queue = new PriorityQueue<>((o1, o2) -> {
            if (o1.visitCnt != o2.visitCnt) {
                return o2.visitCnt - o1.visitCnt;
            }
            return o2.time - o1.time;
        });
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }

        Node node = map.get(key);
        node.visitCnt += 1;
        time += 1;
        node.time = time;
        removeNodeFromQueue(key);
        queue.offer(node);
        printQueue("Get " + key);
        return node.value;
    }

    public void put(int key, int value) {
        if (capacity == 0) {
            return;
        }
        time += 1;
        Node node = null;
        printQueue("Put " + key);
        if (map.containsKey(key)) {
            node = map.get(key);
            node.value = value;
            node.time = time;
            node.visitCnt += 1;
            removeNodeFromQueue(key);
            queue.offer(node);
        } else {
            node = new Node(key, value, time);
            if (map.size() > capacity) {
                evictOld();
            }
            map.put(key, node);
            queue.offer(node);
        }
        printQueue("Put " + key);
    }

    private void evictOld() {
        List<Node> list = new ArrayList<>();
        while (!queue.isEmpty()) {
            list.add(queue.poll());
        }
        Node oldest = list.remove(list.size() - 1);
        for (Node node : list) {
            queue.offer(node);
        }
        map.remove(oldest.key);
    }

    private Node removeNodeFromQueue(int key) {
        if (!map.containsKey(key)) {
            return null;
        }
        List<Node> list = new ArrayList<>();
        Node res = null;
        while (!queue.isEmpty()) {
            res = queue.poll();
            if (res.key != key) {
                list.add(res);
            }
        }
        queue.addAll(list);
        return res;
    }

    public void printCache() {
        int[] vales = new int[map.size()];
        int i = 0;
        for (Integer key : map.keySet()) {
            vales[i] = map.get(key).value;
            i++;
        }
//        System.out.println(Arrays.toString(vales));
    }

    public void printQueue(String msg) {
        System.out.println(msg);
        List<Node> list = new ArrayList<>();
        while (!queue.isEmpty()) {
            list.add(queue.poll());
        }
        for (Node n : list) {
            System.out.print("(" + n.key + ", " + n.value + ", " + n.visitCnt + ", " + n.time + ") ");
        }
        System.out.println("\n");
        queue.addAll(list);

    }

}
