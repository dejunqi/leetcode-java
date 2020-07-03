package leetcode.leetcode0703;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class KthLargest {
    private PriorityQueue<Integer> queue;
    private int k;
    public KthLargest(int k, int[] nums) {
        queue = new PriorityQueue<>();
        this.k = k;
        Arrays.sort(nums);
        int len = nums.length;

        int i = len - 1;
        while (i >= 0 && i >= len - k) {
            queue.add(nums[i]);
            i--;
        }
    }

    public int add(int val) {
        if (queue.size() < k) {
            queue.add(val);
        } else if (queue.peek() < val) {
            queue.poll();
            queue.add(val);
        }

        return queue.peek();
    }
}
