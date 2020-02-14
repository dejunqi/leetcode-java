package leetcode0528;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Solution {

    public void test() {

        int[] weights = {7, 3, 1, 7, 4, 1, 2, 8, 5};
        RandomPickWeight rp  = new RandomPickWeight(weights);
        Map<Integer, Integer> freq = new HashMap<>();
        for (int i = 0; i < 100; i++) {
            int num = rp.pickIndex();
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        for (Integer k : freq.keySet()) {
            System.out.println(k + ": " + freq.get(k));
        }
    }
}
