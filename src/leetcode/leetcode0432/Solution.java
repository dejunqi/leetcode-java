package leetcode.leetcode0432;

public class Solution {

    public void test() {
        AllOne obj = new AllOne();
        obj.inc("a");
        obj.inc("b");
        obj.inc("c");

        obj.visualize();

        obj.inc("a");
        obj.visualize();

        obj.inc("a");
        obj.inc("b");
        obj.inc("e");
        obj.visualize();
    }
}
