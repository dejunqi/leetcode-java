package leetcode0380;

public class Solution {

    public void test() {
        RandomizedSet randomSet = new RandomizedSet();
        randomSet.insert(0);
        randomSet.insert(1);
        randomSet.remove(0);
        randomSet.insert(2);
        randomSet.remove(1);
        randomSet.getRandom();
    }
}
