package leetcode.leetcode0050;

public class Solution {
    public double myPow(double x, int n) {

        if (n == Integer.MIN_VALUE ) {
            if (Math.abs(x) == 1.0) {
                return  1.0;
            } else {
                return 0.0;
            }
        }

        return helper(x, n);
    }

    private double helper(double x, int n) {

        if (n == 0) {
            return 1.0;
        }

        if (n < 0) {
            return helper(1 / x, -n);
        }

        if ( n % 2 == 0) {
            return helper(x * x, n / 2);
        } else {
            return x * helper(x * x, (n - 1) / 2);
        }
    }

    public void test() {}
}
