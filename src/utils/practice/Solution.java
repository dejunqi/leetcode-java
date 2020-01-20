package utils.practice;


import java.util.*;


public class Solution {
    public String removeDuplicates(String S) {
        char[] chars = S.toCharArray();
        int idx = -1;
        for (int i = 0; i < chars.length; i++) {
            if (idx == -1 || chars[i] != chars[idx]) {
                idx += 1;
                chars[idx] = chars[i];
            } else {
                idx -= 1;
            }
        }
        return String.valueOf(chars, 0, idx + 1);
    }
}
