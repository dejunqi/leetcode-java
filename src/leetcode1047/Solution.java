package leetcode1047;

public class Solution {
    public String removeDuplicates(String s) {
        int idx = -1;
        char[] chars = s.toCharArray();
        for (char c : chars) {
            if (idx >= 0 && chars[idx] == c) {
                idx--;
            } else {
                idx++;
                chars[idx] = c;
            }
        }

        return String.valueOf(chars, 0, idx + 1);
    }
}
