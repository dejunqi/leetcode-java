package microsoftOA.minSwapPalindrome;

import java.util.*;

public class Solution {
    public int minSwap(String s) {
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.add(s);
        int step = 0;
        int n = s.length();
        while (!queue.isEmpty()) {
            int len = queue.size();
            step++;
            for (int i = 0; i < len; i++) {
                String cur = queue.poll();
                for (int j = 0; j < n - 1; j++) {
                    char[] chars = cur.toCharArray();
                    swap(chars, j, j + 1);
                    String str = join(chars);
                    if (isPalindrome(str)) {
                        return step;
                    }
                    if (!visited.contains(str)) {
                        visited.add(str);
                        queue.offer(str);
                    }
                }
            }
        }
        return -1;
    }

    private boolean isPalindrome(String s) {
        int l = 0, r = s.length() - 1;
        while (l <= r && s.charAt(l) == s.charAt(r)) {
            l++;
            r--;
        }
        return l > r;
    }

    private void swap(char[] chars, int i, int j) {
        char tmp = chars[i];
        chars[i] = chars[j];
        chars[j] = tmp;
    }

    private String join(char[] chars) {
        StringBuilder sb = new StringBuilder();
        for (char c : chars) {
            sb.append(c);
        }
        return sb.toString();
    }

    public void test() {
        String[] testcase = {"manmand", "asflkj", "aabb", "ntiin"};
        for (String s : testcase) {
            System.out.println(minSwap(s));
        }
    }
}
