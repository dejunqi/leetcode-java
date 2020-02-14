package leetcode0975;
import java.util.TreeMap;

public class Solution {
    public int oddEvenJumps(int[] A) {

        int len = A.length;
        boolean[] higherJump = new boolean[len];
        boolean[] lowerJump = new boolean[len];

        higherJump[len - 1] = true;
        lowerJump[len - 1] = true;
        int res = 1;

        TreeMap<Integer, Integer> map = new TreeMap<>();
        map.put(A[len - 1], len - 1);

        for (int i = len - 2; i >= 0; i--) {
            int num = A[i];
            Integer higher = map.ceilingKey(num);
            Integer lower = map.floorKey(num);

            if (higher != null) {
                higherJump[i] = lowerJump[map.get(higher)];
            }

            if (lower != null) {
                lowerJump[i] = higherJump[map.get(lower)];
            }
            map.put(num, i);
            if (higherJump[i] == true) {
                res++;
            }

        }

        return res;

    }
}