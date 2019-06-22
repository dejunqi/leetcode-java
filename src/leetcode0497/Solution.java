package leetcode0497;

import java.util.Random;
import java.util.TreeMap;

public class Solution {
    int[][] rects;
    Random random;
    TreeMap<Integer, Integer> map;
    int area;

    public Solution(int[][] rects) {
        this.rects = rects;
        random = new Random();
        map = new TreeMap<>();
        area = 0;
        int i = 0;
        for (int[] rec : rects) {
            int x1 = rec[0], y1 = rec[1], x2 = rec[2], y2 = rec[3];
            area += (y2 - y1 + 1) * (x2 - x1 + 1);
            map.put(area, i);
            i += 1;
        }
    }

    public int[] pick() {
        int randArea = random.nextInt(area);
        int areaKey = map.higherKey(randArea);
        int[] rect = this.rects[map.get(areaKey)];
        int x1 = rect[0], y1 = rect[1], x2 = rect[2], y2 = rect[3];
        return new int[] {x1 + random.nextInt(x2 - x1 + 1), y1 + random.nextInt(y2 - y1 + 1)};
    }

}
