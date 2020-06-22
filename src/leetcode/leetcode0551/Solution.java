package leetcode.leetcode0551;

public class Solution {
    public boolean checkRecord(String s) {
        int ca = 0;
        int cb = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'A') {
                ca += 1;
                if (ca > 1) {
                    return false;
                }
            }

            if (i > 0 && s.charAt(i) == 'L' && s.charAt(i - 1) == 'L') {
                cb += 1;
                if (cb >= 2) {
                    return false;
                }
            } else {
                cb = 0;
            }

        }
        return true;
    }

    public boolean checkRecord2(String s) {
        return !s.matches(".*A.*A.*") && !s.matches(".*LLL.*");
    }

    public void test() {
        String s = "LALL";
        System.out.println(this.checkRecord(s));
    }
}
