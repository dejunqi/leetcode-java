package leetcode0528;

import java.util.Random;
import java.util.TreeMap;

public class RandomPickWeight {

    int sum;
    int[] weights;
    TreeMap<Integer, Integer> map;
    Random random;

    public RandomPickWeight(int[] w) {
        weights = w;
        sum = 0;
        map = new TreeMap<>();
        random = new Random();
        for (int i = 0; i < w.length; i++) {
            sum += w[i];
            map.put(sum, i);
        }
    }

    public int pickIndex() {
        int w = map.higherKey(random.nextInt(sum));
        return map.get(w);
    }
}
