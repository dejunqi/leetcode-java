package leetcode.leetcode0460;

public class Solution {

    public void test() {
//        LFUCache cache = new LFUCache(0);
//        cache.put(0, 0);
//        cache.get(0);
//        cache.printCache();


        LFUCache cache = new LFUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        cache.get(1);
//        cache.printCache();
        cache.put(3, 3);
//        cache.printCache();


        cache.get(2);       // returns -1 (not found)
        cache.get(3);       // returns 3.
        cache.put(4, 4);    // evicts key 1.
//        cache.printCache();
        cache.get(1);       // returns -1 (not found)
        cache.get(3);       // returns 3
        cache.get(4);       // returns 4

    }
}
