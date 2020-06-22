package leetcode1304;

public class Solution {
    public int[] sumZero(int n) {
        int[] res = new int[n];
        int i = 0, j = n - 1;
        while (i < j) {
            res[i] = -n;
            res[j] = n;
            n--;
            i++;
            j--;
        }
        if (i == j) {
            res[i] = 0;
        }

        return res;
    }
}
