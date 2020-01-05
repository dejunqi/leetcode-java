package nonleetcode.cokeMachine;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
    public boolean canObtainCokeWithinTargetRange(List<List<Integer>> buttons, List<Integer> target) {
        return false;
    }


    public void test() {
        Integer[][] btns = {{100, 120}, {200, 240}, {400, 410}};
        List<List<Integer>> buttons = new ArrayList<>();
        for (Integer[] btn : btns) {
            List<Integer> tmp = Arrays.asList(btn);
            buttons.add(tmp);
        }

        List<Integer> target = new ArrayList<>();
        target.add(310);
        target.add(360);

        boolean res = canObtainCokeWithinTargetRange(buttons, target);
        System.out.println(res);

    }
}
