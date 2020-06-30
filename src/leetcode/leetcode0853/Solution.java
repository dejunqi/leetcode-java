package leetcode0853;


import leetcode.utils.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class Solution {
    public int carFleet(int target, int[] position, int[] speed) {

        TreeMap<Integer, Double> map = new TreeMap<>();
        for (int i = 0; i < position.length; i++) {
            int dist = target - position[i];
            Double t = (dist * 1.0) / speed[i];
            map.put(dist, t);
        }
        int cnt = 0;
        double time = -1.0;
        for (Integer d : map.keySet()) {
            double t = map.get(d);
            if (t > time) {
                cnt += 1;
                time = t;
            }
        }

        return cnt;
    }


    public int carFleet2(int target, int[] position, int[] speed) {
        List<Pair<Integer, Double>> list = new ArrayList<>();
        for (int i = 0; i < position.length; i++) {
            int dist = target - position[i];
            double t = (dist * 1.0) / speed[i];
            list.add(new Pair<>(dist, t));
        }

        list.sort((a, b) -> {
            return a.getKey() - b.getKey();
        });
        int cnt = 0;
        double time = -1.0;
        for (Pair p : list) {
            double t = (double) p.getValue();
            if (t > time) {
                cnt += 1;
                time = t;
            }
        }
        return cnt;
    }


    public void test() {
        int[] position = {10, 8, 0, 5, 3};
        int[] speed = {2, 4, 1, 1, 3};
        int target = 12;
        int res = carFleet(target, position, speed);
        System.out.println(res);
    }
}
