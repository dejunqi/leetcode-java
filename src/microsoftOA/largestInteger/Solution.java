package microsoftOA.largestInteger;

import java.util.Arrays;

/**
 * Write a function that, given an array A of N integers, returns the largest integer K > 0 such that both values K and -K exisit in array A. If
 * there is no such integer, the function should return 0.
 *
 * Example:
 *
 * Input: [3, 2, -2, 5, -3]
 * Output: 3
 *
 * Input: [1, 2, 3, -4]
 * Output: 0
 */
public class Solution {

    public int largestInteger(int[] A) {
        Arrays.sort(A);
        int l = 0, r = A.length - 1;
        int candidate = 0;
        System.out.println(Arrays.toString(A));
        while (l < r) {
            if (A[l] >= 0) {
                break;
            }
            if (Math.abs(A[l]) == A[r]) {
                candidate = Math.max(candidate, A[r]);
                break;
            } else if (Math.abs(A[l]) < A[r]) {
                r--;
            } else {
                l++;
            }
        }
        return candidate;
    }

    public void test() {
        int[] A1 = {3, 2, -2, 5, -3};
        int[] A2 = {1, 2, 3, -4};
        int[] A3 = {6, 7, -7, 1, 8, 9, 10, -2, -5, -4, 4};
        int[][] testcase = {A1, A2, A3};

        for (int[] a : testcase) {
            System.out.println(largestInteger(a));
        }
    }
}
