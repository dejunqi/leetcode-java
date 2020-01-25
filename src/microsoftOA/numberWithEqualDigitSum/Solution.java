package microsoftOA.numberWithEqualDigitSum;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/*
Given an array A consisting of N integers, returns the maximum sum of two numbers whose digits add up to an equal sum.
If there are now two numbers whose digits have an equal sum, return -1;
*/
public class Solution {

    public int maximumSum(int[] A) {
        Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            int dsum = digitSum(A[i]);
            map.put(dsum, map.getOrDefault(dsum, new PriorityQueue<>((a, b) -> b - a)));
            map.get(dsum).add(A[i]);
        }

        int res = -1;
        for (int key : map.keySet()) {
            if (map.get(key).size() < 2) {
                continue;
            }
            PriorityQueue<Integer> queue = map.get(key);
            int a = queue.poll(), b = queue.poll();
            res = Math.max(res, a + b);
        }

        return res;
    }

    private int digitSum(int num) {
        int res = 0;
        while (num > 0) {
            res += (num % 10);
            num /= 10;
        }
        return res;
    }

    public void test() {
        int[] A = {51, 71, 17, 42};
        int[] B = {42, 33, 60};
        System.out.println(maximumSum(B));
    }
}
