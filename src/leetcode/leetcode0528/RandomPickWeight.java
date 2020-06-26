package leetcode.leetcode0528;

import java.util.Random;
import java.util.TreeMap;

public class RandomPickWeight {

    private TreeMap<Integer, Integer> map;
    private Random rand = new Random();
    int sum = 0;

    public RandomPickWeight(int[] w) {
        map = new TreeMap<>();
        for (int i = 0; i < w.length; i++) {
            sum += w[i];
            map.put(sum, i);
        }
    }

    public int pickIndex() {
        int idx = rand.nextInt(sum);
        int key = map.higherKey(idx);
        return map.get(key);
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */
