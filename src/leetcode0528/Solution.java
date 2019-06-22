package leetcode0528;

import java.util.Random;
import java.util.TreeMap;

public class Solution {

    private TreeMap<Integer, Integer> map;
    private int[] weights;
    private int sumWeight;
    private Random random;

    public Solution(int[] w) {
        this.weights = w;
        map = new TreeMap<>();
        random = new Random();

        for (int i = 0; i < w.length; i++) {
            sumWeight += w[i];
            map.put(sumWeight, i);
        }
    }

    public int pickIndex() {
        int w = random.nextInt(sumWeight);
        int weight = map.higherKey(w);
        return map.get(weight);
    }
}
