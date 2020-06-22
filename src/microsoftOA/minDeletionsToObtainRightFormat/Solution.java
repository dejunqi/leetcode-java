package microsoftOA.minDeletionsToObtainRightFormat;


import java.util.ArrayList;
import java.util.List;

/**
 * Given a string S of length N consisting only of A and/or B.
 * We want to obtain a string in the format 'A..AB..B
 *
 */

public class Solution {

    public int minDelete(String s) {
        int len = s.length();
        int cnt = 0;
        int cA = 0, cB = 0;

        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == 'A') {
                cA++;
            } else {
                cB++;
            }
        }

        int i = 0, j = len - 1;

        while (true) {
            while (i <= j && s.charAt(i) != 'B') {
                i++;
            }
            while (i <= j && s.charAt(j) != 'A') {
                j--;
            }
            if (i > j) break;

            if (j - i == 1) { // delete A or delete B
                cnt += 1;
            } else { // delete both B on the left side and A on the right side
                cnt += 2;
            }
            i++;
            j--;
        }

        return Math.min(cnt, Math.min(cA, cB));

    }

    public void test() {
        String[] testcase = {
                "BAAABAB",
                "BBABAA",
                "AABBB"
        };
        List<Integer> res = new ArrayList<>();
        for (String s : testcase) {
            res.add(minDelete(s));
        }
        System.out.println(res);
    }
}
