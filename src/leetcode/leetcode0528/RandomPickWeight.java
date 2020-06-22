package leetcode0528;


import java.util.Random;
import java.util.TreeMap;

public class RandomPickWeight {
    TreeMap<Integer, Integer> map;
    Random random;
    int sum = 0;
    public RandomPickWeight(int[] w) {
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

