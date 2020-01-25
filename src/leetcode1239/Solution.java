package leetcode1239;

import java.util.*;

public class Solution {
    public int maxLength(List<String> arr) {
        int[] res = {0};
        helper(arr, "",  0, res);
        return res[0];
    }

    private void helper(List<String> arr, String cur, int idx, int[] res) {
        int len = arr.size();
        boolean isUnique = uniqueChar(cur);
        if (isUnique) {
            res[0] = Math.max(res[0], cur.length());
        }
        if (!isUnique || idx == len) {
            return;
        }
        for (int i = idx; i < len; i++) {
            helper(arr, cur + arr.get(i), i + 1, res);
        }
    }

    private boolean uniqueChar(String u) {
        int len = u.length();
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < len; i++) {
            char c = u.charAt(i);
            if (set.contains(c)) {
                return false;
            }
            set.add(c);
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
