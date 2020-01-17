package nonleetcode.cokeMachine;
import java.util.*;

/**
 *
 题目描述:
 有一系列按钮，每个按钮按下去会得到一定体积范围的可乐。先给定一个目标体积范围，问不限制按按钮次数，能否确定一定能得到目标范围内的可乐？
 举例：有三个按钮，按下去得到的范围是[100, 120], [200, 240], [400, 410],
 假设目标是[100, 110], 那答案是不能。因为按下一，可能得到120体积的可乐，不在目标范围里。
 假设目标是[90, 120]，那答案是可以。因为按下一，一定可以得到此范围内的可乐。
 假设目标是[300, 360], 那答案是可以，因为按下一再按二，一定可以得到此范围内
 假设目标是[310, 360], 那答案是不能，因为按下一再按二，有可能得到300，永远没可能确定得到这个范围内的可乐。
 假设目标是[1, 9999999999]，那答案是可以。随便按一个都确定满足此范围。

**/


public class Solution {
    public boolean canObtainCokeWithinTargetRange(int[][] buttons,  int[] target) {
        Map<String, Boolean> memo = new HashMap<>();
        return helper(buttons, target, memo, new int[] {0, 0});
    }

    private boolean helper(int[][] buttons, int[] target, Map<String, Boolean> memo, int[] cur) {
        String key = cur[0] + "," + cur[1];
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        int left = cur[0], right = cur[1];
        if (left >= target[1]) {
            return false;
        }

        if (left >= target[0] && right <= target[1]) {
            memo.put(key, true);
            return true;
        }

        boolean res = false;
        for (int[] btn : buttons) {
            if (helper(buttons, target, memo, new int[] {cur[0] + btn[0], cur[1] + btn[1]})) {
                res = true;
                break;
            }
        }
        memo.put(key, res);
        return res;
    }


    public void test() {
        int[][] buttons = {{100, 120}, {200, 240}, {400, 410}};
        int[][] targets = {{100, 110}, {90, 120}, {300, 360}, {310, 360}};
        // results = [False, True, True, False]
        for (int[] target : targets) {
            System.out.println(canObtainCokeWithinTargetRange(buttons, target));
        }
    }
}
