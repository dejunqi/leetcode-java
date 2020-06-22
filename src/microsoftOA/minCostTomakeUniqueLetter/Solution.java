package microsoftOA.minCostTomakeUniqueLetter;

/*
* 输入String[]S 和int[]C，删除 S 第K位的cost是C[k]，求把S调整到没有连续重复字母的最小cost
*  a a a b b c c c d
*  3 1 2 1 2 2 5 7 2
*
*
*  a       b     c d
*  3 0 0 0 2 0 0 7 2
*  1 + 2 + 1 + 2 + 5 = 11
* */

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Solution {
    public int minCost(String s, int[] cost) {
        if (s.length() != cost.length) {
            return 0;
        }
        int mincost = 0;
        Map<Character, PriorityQueue<Integer>> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!map.containsKey(c)) {
                map.put(c, new PriorityQueue<>());
            }
            map.get(c).offer(cost[i]);
        }

        for (Character c : map.keySet()) {
            PriorityQueue<Integer> queue = map.get(c);
            while (queue.size() > 1) {
                mincost += queue.poll();
            }
        }

        return mincost;
    }

    public void test() {
        String s = "aaabbcccd";
        int[] cost = {3, 1, 2, 1, 2, 2, 5, 7, 2};
        System.out.println(minCost(s, cost));
    }
}
