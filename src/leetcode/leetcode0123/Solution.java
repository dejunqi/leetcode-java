package leetcode0123;

public class Solution {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len < 2) {
            return 0;
        }
        int[] dpA = new int[len];
        int min = prices[0];
        // Max profit, if I sell the stocks at ith day
        for (int i = 1; i < len; i++) {
            min = Math.min(min, prices[i]);
            dpA[i] = Math.max(dpA[i - 1], prices[i] - min);
        }

        int[] dpB = new int[len];
        int max = prices[len - 1];
        for (int i = len - 2; i >= 0; i--) {
            max = Math.max(max, prices[i]);
            dpB[i] = Math.max(dpB[i + 1], max - prices[i]);
        }

        int res = 0;
        for (int i = 0; i < len; i++) {
            res = Math.max(res, dpA[i] + dpB[i]);
        }

        return res;
    }

    public int maxProfit2(int[] prices) {
        int len = prices.length;
        if (len < 2) {
            return 0;
        }
        int[] dpA = new int[len];
        int min = prices[0];
        // Max profit, if I sell the stocks at ith day
        for (int i = 1; i < len; i++) {
            min = Math.min(min, prices[i]);
            dpA[i] = Math.max(dpA[i - 1], prices[i] - min);
        }

        int max = prices[len - 1];
        int dpB = 0;
        int res = 0;
        for (int i = len - 2; i >= 0; i--) {
            max = Math.max(max, prices[i]);
            dpB = Math.max(dpB, max - prices[i]);
            res = Math.max(res, dpB + dpA[i]);
        }

        return res;

    }
}
