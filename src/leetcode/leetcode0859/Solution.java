package leetcode0859;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public boolean buddyStrings(String A, String B) {
        if (A == null || B == null || A.length() == 0 || B.length() == 0) {
            return false;
        }

        Map<Character, Integer> map = new HashMap<>();
        int a = -1, b = -1, diff = 0;
        boolean canSwitch = false;

        for (int i = 0; i < A.length(); i++) {
            char ca = A.charAt(i), cb = B.charAt(i);
            map.put(ca, map.getOrDefault(ca, 0) + 1);
            if (map.get(ca) >= 2) {
                canSwitch = true;
            }
            if (ca != cb) {
                diff += 1;
                if (a == -1) {
                    a = i;
                } else if (b == -1) {
                    b = i;
                }
            }
        }

        boolean case1 = diff == 0 && canSwitch;
        boolean case2 = diff == 2 && A.charAt(a) == B.charAt(b) && A.charAt(b) == B.charAt(a);

        return case1 || case2;
    }

    public void test() {
        String[][] cases = {{"ab", "ba"},
                            {"aa", "aa"},
                            {"aaaabc", "aaaabc"},
                            {"aaabcd", "aaadcb"},
                            {"aaabcd", "aaadcd"}
        };
        for (String[] pair : cases) {
            String A = pair[0], B = pair[1];
            System.out.print(A + ", " + B + " => ");
            System.out.println(buddyStrings(A, B));
        }
    }
}
