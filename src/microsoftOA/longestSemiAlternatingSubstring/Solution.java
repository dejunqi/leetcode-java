package microsoftOA.longestSemiAlternatingSubstring;

/*

https://leetcode.com/discuss/interview-question/398037/

You are give a string S of length N containing only character 'a' and 'b'.
A substring (contiguous fragment) of S is called a semi-alternating substring
if it does not contain 3 identical consecutive characters. In other words, it does not contain either
'aaa' or 'bbb' substring. Note that wholse S is its own substring.

Example:
Input: "baaabbabbb"
output 7
Which is the leng of aabbabb
*/
public class Solution {
    public int alternativeSemiSubstring(String s) {
        int len = s.length();
        if (len <= 2) {
            return len;
        }
        int l = 0, r = 1;
        int cnt = 0;
        int res = 0;
        while (r < len) {
            if (s.charAt(r) == s.charAt(r - 1)) {
                cnt++;
                if (cnt == 2) {
                    cnt = 0;
                    res = Math.max(res, r - l);
                    l = r - 1;
                }
            } else {
                cnt = 0;
            }
            r++;
        }

        res = Math.max(res, r - l);
        return res;
    }

    public void test() {
        String s1 = "baaabbabbb";
        String s2 = "babba";
        String s3 = "abaaaa";
        String s4 = "a";
        System.out.println(alternativeSemiSubstring(s1));
        System.out.println(alternativeSemiSubstring(s2));
        System.out.println(alternativeSemiSubstring(s3));
        System.out.println(alternativeSemiSubstring(s4));
    }
}
