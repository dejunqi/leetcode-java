package leetcode0403;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public boolean canCross(int[] stones) {

        Set<Integer> stoneSet = new HashSet<>();
        for (int i = 0; i < stones.length; i++) {
            stoneSet.add(stones[i]);
        }
        Set<String> memo = new HashSet<>();
        return helper(stoneSet, memo, 1, 1, stones[stones.length - 1]);
    }

    
    private boolean helper(Set<Integer> stoneSet, Set<String> memo, int curunit, int curspeed, int target) {

        String key = curunit + ", " + curspeed;
        if (memo.contains(key)) {
            return false;
        }

        if (curunit == target) {
            return true;
        }

        if (curspeed <= 0 || curunit > target || curunit < 0 || !stoneSet.contains(curunit)) {
            return false;
        }

        int[] speed = {-1, 0, 1};

        for (int i = 0; i < 3; i++) {
            int nextSpeed = curspeed + speed[i];
            int nextUnit = curunit + nextSpeed;
            if (helper(stoneSet, memo, nextUnit, nextSpeed, target)) {
                return true;
            }
        }
        memo.add(key);
        return false;
    }

    public void test() {
        int[] stones = {0,1,3,5,6,8,12,17};
        System.out.println(canCross(stones));
    }
}