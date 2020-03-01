package utils.practice;

import java.util.*;

public class Solution {

    int solution(int[] A, int M) {
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            int val = A[i];
            while (val < 0) {
                val += M;
            }
            int mod = val % M;
            map.put(mod, map.getOrDefault(mod, 0) + 1);
        }
        for (int k : map.keySet()) {
            res = Math.max(res, map.get(k));
        }
        return res;
    }

    public void test() {
        int[] A = {-3, -2, 1, 0, 8, 7, 1};
        int a = 3;
        int[] B = {7, 1, 11, 8, 4, 10};
        int b = 8;
        System.out.println(solution(B, b));
    }
}
