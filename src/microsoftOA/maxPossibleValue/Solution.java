package microsoftOA.maxPossibleValue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 Given an integer N, returns the maximum possible value obtain
 by inserting on '5' digit inside the decimal representation of integer N

 Examples:

 Input N = 268
 output: 5268

 Input N = 670
 output: 6750

 */
public class Solution {
    public int maxPossible(int N) {
        // positive number, looks for the first digit that is <= 5, insert 5 in front of it
        // negative number, looks for the first digit that is >= 5, insert 5 in front of it
        int flag = N >= 0 ? 1 : -1;
        N = Math.abs(N);
        ArrayList<Integer> nums = new ArrayList<>();
        do {
            nums.add(0, N % 10);
            N /= 10;
        } while (N > 0);

        int len = nums.size();
        int pos = 0;
        if (flag == 1) {
            while (pos < len && nums.get(pos) >= 5) {
                pos++;
            }
        } else {
            while (pos < len && nums.get(pos) <= 5) {
                pos++;
            }
        }
        nums.add(pos, 5);
        int res = 0;
        for (Integer n : nums) {
            res = res * 10 + n;
        }
        return res * flag;
    }

    public void test() {
        int[] testcase = {945, 439, -945, -439, 268, 670, -999, -1, 0};
        // expect output {9545, 5439, -5945, -4359. 5268, 6750, -5999}
        for (int n : testcase) {
            System.out.println(this.maxPossible(n));
        }
    }
}
