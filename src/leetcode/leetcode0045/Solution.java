package leetcode0045;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public int jump(int[] nums) {

        int len = nums.length;

        if (len < 2) {
            return 0;
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        int res = 0;

        while (!queue.isEmpty()) {
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                int idx = queue.poll();
                if (idx == len - 1) {
                    return res;
                }

                int num = nums[idx];
                for (int j = 1; j <= num; j++) {
                    queue.offer(idx + j);
                }
            }
            res += 1;
        }

        return 0;
    }
}