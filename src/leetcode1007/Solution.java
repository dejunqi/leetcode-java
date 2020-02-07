package leetcode1007;

import java.util.*;

public class Solution {
    public int minDominoRotations(int[] A, int[] B) {
        int res = Math.min(helper(A, B), helper(B, A));
        return res;
    }

    private int helper(int[] A, int[] B) {
        int[] count = new int[7];
        for (int value : A) {
            count[value] += 1;
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            list.add(i);
        }

        list.sort((a, b) -> count[b] - count[a]);
        int cnt = 0;

        for (Integer val : list) {
            int sameCnt = 0;
            for (int j = 0; j < A.length; j++) {
                if (A[j] == val) {
                    sameCnt++;
                } else if (A[j] != val && B[j] == val) {
                    cnt++;
                    sameCnt++;
                }

                if (sameCnt == A.length) {
                    return cnt;
                }
            }
        }

        return -1;
    }


    public void test() {
        // int[] A = {2, 1, 2, 4, 2, 2}, B = {5, 2, 6, 2, 3, 2};
        int[] A = {3,5,1,2,3 }, B = {3,6,3,3,4};
        int res = minDominoRotations(A, B);
        System.out.println(res);
    }
}
