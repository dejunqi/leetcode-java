package leetcode0853;


import java.util.TreeMap;

public class Solution {

    public int carFleet(int target, int[] position, int[] speed) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < position.length; i++) {
            map.put(target - position[i], speed[i]);
        }
        int res = 0;
        double time = -1.0;

        for (Integer dist : map.keySet()) {
            int v = map.get(dist);
            double t = (dist * 1.0) / v ;
            if (t > time) {
                res += 1;
                time = t;
            }

        }

        return res;
    }


    public void test() {
        int[] position = {10, 8, 0, 5, 3};
        int[] speed = {2, 4, 1, 1, 3};
        int target = 12;
        int res = carFleet(target, position, speed);
        System.out.println(res);
    }
}