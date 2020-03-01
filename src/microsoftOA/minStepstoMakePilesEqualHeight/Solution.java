package microsoftOA.minStepstoMakePilesEqualHeight;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 Alexa is given n piles of equal or unequal heights.
 In one step, Alexa can remove any number of boxes from the pile which has the maximum height and try to make it equal to the one
 which is just lower than the maximum height of the stack.
 Determine the minimum number of steps required to make all of the piles equal in height.
 */
public class Solution {
    public int minStep(int[] piles) {

        int len = piles.length;
        Arrays.sort(piles);
        int step = 0;
        int res = 0;
        for (int i = 1; i < len; i++) {
            if (piles[i] != piles[i - 1]) {
                step++;
            }
            res += step;
        }
        return res;
    }

    public void test() {
        System.out.println(minStep(new int[]{5,2,1}));
        System.out.println(minStep(new int[]{4,5,5,4,2}));
    }
}
