package leetcode.leetcode1239;

import java.util.*;

public class Solution {
    public int maxLength(List<String> arr) {
        int[] res = {0};
        helper("", arr, 0, res);
        return res[0];
    }

    // DFS for array N elements, time complexity is O(N!)
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
        String[] arr1 = {"un","iq","ue"};
        String[] arr2 = {"cha","r","act","ers"};
        String[] arr3 = {"abcdefghijklmnopqrstuvwxyz"};
        int res = maxLength(Arrays.asList(arr1));
        System.out.println(res);
    }
}
