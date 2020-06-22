package microsoftOA.lexicographicallySmallestString;

public class Solution {
    public String lexiSmallestString(String s) {
        StringBuilder sb = new StringBuilder();
        int len = s.length();
        int idx = 0;
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) > s.charAt(i + 1)) {
                idx = i;
                break;
            }
        }
        return s.substring(0, idx) + s.substring(idx + 1);
    }

    public void test() {
        String s = "abczd";
        System.out.println(lexiSmallestString(s));
    }
}
