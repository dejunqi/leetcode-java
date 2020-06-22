package leetcode.leetcode1170;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        int[] freqQ = freq(queries);
        int[] freqW = freq(words);
        Arrays.sort(freqW);
        int[] res = new int[queries.length];

        for (int i = 0; i < freqQ.length; i++) {
            int q = freqQ[i];
            int l = 0, r = words.length - 1;
            while (l <= r) {
                int mid = l + (r - l) / 2;
                if (q >= freqW[mid]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
            System.out.println(l + ", " + r);
            res[i] = words.length - l;
        }
        return res;
    }

    private int[] freq(String[] A) {
        int[] res = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            int[] arr = new int[26];
            String s = A[i];
            int len = s.length();
            for (int j = 0; j < len; j++) {
                arr[s.charAt(j) - 'a'] += 1;
            }

            for (int k = 0; k < 26; k++) {
                if (arr[k] > 0) {
                    res[i] = arr[k];
                    break;
                }
            }
        }
        return res;
    }

    public void test() {
        String[] queries = {"bbb","cc"};
        String[] words = {"a","aa","aaa","aaaa"};
        System.out.println(Arrays.toString(this.numSmallerByFrequency(queries, words)));
    }
}
