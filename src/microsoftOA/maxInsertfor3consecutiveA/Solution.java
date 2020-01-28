package microsoftOA.maxInsertfor3consecutiveA;

/**
 Given a string S consisting of N characters, return a maximum number of letters 'a' that can be inserted into S.
 (including at the from and end of S) so that the resulting string doesn't contain 3 consecutive letters 'a'. If string S already contains the
 substring 'aaa', then your function should return -1

 input: S = 'aabab'
 output: 3

 */

public class Solution {
    public int maxInsert(String s) {
        int cnt = 0;
        int len = s.length();
        int res = 0;
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == 'a') {
                cnt++;
                if (cnt == 3) {
                    return -1;
                }
            } else {
                res += 2 - cnt;
                cnt = 0;
            }
        }
        res += 2 - cnt;
        return res;
    }

    public void test() {
        String[] testcase = {"aabab", "dog", "aa", "baaa", "aaba"};
        for (String s : testcase) {
            System.out.println(maxInsert(s));
        }
    }
}
