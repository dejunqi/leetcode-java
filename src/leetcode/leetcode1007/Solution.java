package leetcode.leetcode1007;

import java.util.*;

class Solution {
    public int minDominoRotations(int[] A, int[] B) {
        return Math.min(swaptAndCount(A, B), swaptAndCount(B, A));
    }

    private int swaptAndCount(int[] A, int[] B) {
        int[] count = new int[7];
        for (int v : A) {
            count[v] += 1;
        }
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        list.sort((a, b) -> count[b] - count[a]);


        for (int v : list) {
            int num = 0;
            int swap = 0;
            for (int j = 0; j < A.length; j++) { // O (N)
                if (A[j] == v) {
                    num += 1;
                } else {
                    if (A[j] != v && B[j] == v) {
                        num += 1;
                        swap += 1;
                    }
                }
                if (num == A.length) {
                    return swap;
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
