package leetcode.leetcode1312;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int minInsertions(String s) {
        List<Character> list = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            list.add(s.charAt(i));
        }

        int l = 0, r = s.length() - 1;
        while (l < r) {
            if (list.get(l) != list.get(r)) {
                r++;
                char c = list.get(l);
                list.add(r, c);
            }
            l += 1;
            r -= 1;
        }
        System.out.println(list);
        return list.size() - s.length();
    }

    public void test() {
        String[] testcase = {"mbadm", "leetcode", "no", "zjveiiwvc"};
        for (String s : testcase) {
            System.out.println(minInsertions(s));
        }
    }
}
