package leetcode.leetcode0218;

import java.util.*;

public class Solution {

    private class Triple {
        int x;
        int h;
        char type;
        Triple(int x, int h, char c) {
            this.x = x;
            this.h = h;
            type = c;
        }

        public String toString() {
            return "(" + x + ", " + h + ", " + type + ")";
        }
    }

    public List<List<Integer>> getSkyline(int[][] buildings) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);
        List<List<Integer>> res = new ArrayList<>();
        List<Triple> list = new ArrayList<>();
        for (int[] b : buildings) {
            list.add(new Triple(b[0], b[2], 's'));
            list.add(new Triple(b[1], b[2], 'e'));
        }

        list.sort((o1, o2) -> {
            if (o1.x != o2.x) {
                return o1.x - o2.x;
            } else if (o1.type == o2.type) {
                if (o1.type == 's') {
                    return o2.h - o1.h;
                } else {
                    return o1.h - o2.h;
                }
            } else {
                if (o1.type == 's') {
                    return -1;
                } else {
                    return 1;
                }
            }
        });

        queue.add(0);
        for (int i = 0; i < list.size(); i++) {
            Triple t = list.get(i);
            int x = t.x, h = t.h;
            char type = t.type;
            if (type == 's') {
                if (h > queue.peek()) {
                    res.add(new ArrayList<>(Arrays.asList(x, h)));
                }
                queue.add(h);
            } else {
                int max = queue.peek();
                queue.remove(h);
                if (max != queue.peek()) {
                    res.add(new ArrayList<>(Arrays.asList(x, queue.peek())));
                }
            }

        }

        return res;
    }


    public void test() {
         int[][] buildings = {{ 2, 9, 10}, {3, 7, 15}, {5, 12, 12}, {15, 20, 10}, {19 ,24, 8}};
//         int[][] buildings = {{0,2,3}, {2,5,3}};
//        int[][] buildings = {{2,4,7 }, {2,4,5 }, {2,4,6 }};
        System.out.println(this.getSkyline(buildings));
    }
}
