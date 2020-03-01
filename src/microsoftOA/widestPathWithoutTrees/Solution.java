package microsoftOA.widestPathWithoutTrees;

import java.util.Arrays;
import java.util.TreeSet;

// Widest Path Without Trees
// https://leetcode.com/discuss/interview-question/447448/
public class Solution {
    public int width(int[] X, int[] Y) {
        if (X.length < 2) {
            return 0;
        }
        Arrays.sort(X);
        int dist = 0;
        int left = 0, right = 1;
        while (right < X.length) {
            if (X[right] - X[left] > dist) {
                dist = X[right] - X[left];
            }
            left = right;
            right++;
        }

        return dist;
    }

    public void test() {
//        int[] X = {5, 5, 5, 7, 7, 7};
//        int[] Y = {3, 4, 5, 1, 3, 7};
        int[] X = {4, 1, 5, 4};
        int[] Y = {4, 5, 1, 3};
        int res = width(X, Y);
        System.out.println(res);
    }
}
