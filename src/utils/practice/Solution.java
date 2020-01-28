package utils.practice;


import java.util.*;


public class Solution {
    public int maxLength(List<String> arr) {
        int[] res = {0};
        helper("", arr, 0, res);
        return res[0];
    }

    private void helper(String cur, List<String> arr, int idx, int[] res) {
        int len = arr.size();
        boolean isUnique = noDuplicateLetters(cur);
        if (isUnique) {
            res[0] = Math.max(res[0], cur.length());
        }

        if (!isUnique || idx == len) return;

        for (int i = idx; i < len; i++) {
            helper(cur + arr.get(i), arr, i + 1, res);
        }
    }

    private boolean noDuplicateLetters(String s) {
        int[] chars = new int[26];
        int len = s.length();
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (chars[c - 'a'] == 1) {
                return false;
            }
            chars[c - 'a']++;

        }
        return true;

    }

    public void test() {
        String[] arr = {"un","iq","ue"};
        System.out.println(maxLength(Arrays.asList(arr)));
    }
}