package leetcode1054;

import java.util.*;

public class Solution {

    public int[] rearrangeBarcodes(int[] barcodes) {
        Map<Integer, Integer> map = new HashMap<>();
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        for (int b : barcodes) {
            map.put(b, map.getOrDefault(b, 0) + 1);
        }

        for (Integer b : map.keySet()) {
            queue.offer(new int[] {b, map.get(b)});
        }

        int[] res = new int[barcodes.length];
        int idx = 0;
        while (!queue.isEmpty()) {
            List<int[]> tmp = new ArrayList<>();
            int cnt = 2;
            while (!queue.isEmpty() && cnt > 0) {
                int[] tuple = queue.poll();
                res[idx] = tuple[0];
                idx++;
                cnt--;
                tuple[1]--;
                tmp.add(tuple);
            }
            for (int[] t : tmp) {
                if (t[1] > 0) {
                    queue.offer(t);
                }
            }
        }
        return res;
    }

    public void test() {
        int[] barcodes = { 1,1,1,1,2,2,3,3 };
        int[] res = rearrangeBarcodes(barcodes);
        for (int r : res) {
            System.out.println(r);
        }
    }
}
