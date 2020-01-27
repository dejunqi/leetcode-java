package microsoftOA.longestSubstringWithout2ContiguousLetter;

/*
Given a string s containing only a and b,
find longest substring of s such that s does not contain more than two contiguous occurrences of a and b.
* */

public class Solution {
    public String validLongestSubstring(String s) {
        if (s.length() < 3)
            return s;
        int cur = 0, end = 1;
        char c = s.charAt(0);
        int count = 1;
        int maxLen = 1;
        int start = 0;
        while (end < s.length()) {
            if (s.charAt(end) == c) {
                count ++;
                if (count == 2) {
                    if (end - cur + 1 > maxLen) {
                        maxLen = end - cur + 1;
                        start = cur;
                    }
                }
                else {
                    cur = end - 1;
                }
            }
            else {
                c = s.charAt(end);
                count = 1;
                if (end - cur + 1 > maxLen) {
                    maxLen = end - cur + 1;
                    start = cur;
                }
            }
            end ++;
        }
        return s.substring(start, start + maxLen);
    }

    public String validLongestSubstring2(String s) {

        int len = s.length();
        if (len <= 2) {
            return s;
        }
        int l = 0, r = 1;
        int res = 0;
        int cnt = 0;
        String str = "";
        while (r < len) {
            if (s.charAt(r) == s.charAt(r - 1)) {
                cnt++;
                if (cnt == 2) {
                    if (r - l > res) {
                        res = r - l;
                        str = s.substring(l, r);
                    }
                    cnt = 0;
                    l = r - 1;
                }
            } else {
                cnt = 0;
            }
            r++;
        }

        if (r - l > res) {
            str = s.substring(l, r);
        }

        return str;
    }

    public void test() {
        String[] testcase = {"aabbaabbaabbaa",
                             "abbaabbaaabbaaa",
                             "aabbaaaaabb",
                             "abbaabbaabbabaaaaaaababaabb"};
        for (String s : testcase) {
            System.out.println(validLongestSubstring2(s));
        }
    }
}
