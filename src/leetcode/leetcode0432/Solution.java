package leetcode.leetcode0432;

public class Solution {

    public void test() {
        AllOne obj = new AllOne();
//        obj.inc("a");
//        obj.inc("b");
//        obj.inc("c");
//
//        obj.inc("a");
//
//
//        obj.inc("a");
//        obj.inc("b");
//        obj.inc("e");
//        obj.visualize();
//
//        obj.getMaxKey();
//        obj.getMinKey();
//
//        obj.dec("b");
//        obj.dec("b");
//
//        obj.visualize();

        /*
["AllOne",


"inc","inc","inc","getMaxKey","getMinKey","inc","inc","getMinKey"]

[[], ["world"],["world"],["leet"],[],[],["leet"],["leet"],[]]
        * */

        /*
        obj.inc("hello");
        obj.inc("hello");
        obj.getMaxKey();
        obj.getMinKey();
        obj.inc("leet");
        obj.visualize();
        obj.getMaxKey();
        obj.getMinKey();
        */


//        obj.inc("hello");
//        obj.inc("hello");
//        obj.inc("world");
//        obj.inc("world");
//        obj.inc("hello");
////        obj.visualize();
//        obj.dec("world");
//        obj.visualize();
//
//        obj.getMaxKey();
//        obj.getMinKey();
//
//
//        obj.inc("world");
//        obj.inc("world");
//        obj.inc("leet");
//        obj.visualize();
//        obj.getMaxKey();
//        obj.getMinKey();
//
//        obj.inc("leet");
//        obj.inc("leet");
//        obj.visualize();
//        obj.getMinKey();

        obj.inc("a");
        obj.inc("b");
        obj.inc("b");
        obj.inc("c");
        obj.inc("c");
        obj.inc("c");

//        obj.visualize();

        obj.dec("b");
        obj.dec("b");

        obj.visualize();

        obj.getMinKey();
        obj.getMaxKey();

        obj.dec("a");

        obj.visualize();
        obj.getMinKey();
        obj.getMaxKey();

    }


}
