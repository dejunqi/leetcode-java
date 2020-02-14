package leetcode0685;

import java.util.*;

// edges = [[4,2],[1,5],[5,2],[5,3],[2,4]]
// edges = [[1,2], [2,3], [3,4], [4,1], [1,5]]
public class Solution {
    public int[] findRedundantDirectedConnection(int[][] edges) {
        int len = edges.length;
        int[] nums = new int[len + 1];
        int[] canA = null, canB = null;
        for (int[] e : edges) {
            int p = e[0], q = e[1];
            if (nums[q] == 0) {
                nums[q] = p;
            } else {
                canA = new int[] {p, q};
                canB = new int[] {nums[q], q};
                e[1] = 0;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            nums[i] = i;
        }

        for (int[] e : edges) {
            if (e[1] == 0) continue;
            int p = e[0], q = e[1];
            if (find(p, nums) == q) { // loop exist
                if (canB == null && canA == null) { // case 1
                    return e;
                }
                return canB;
            }
            nums[q] = p;
        }

        return canA;
    }

    private int find(int v, int[] nums) {
        while (nums[v] != v) {
            v = nums[v];
        }
        return v;
    }

    public void test() {
        int[][] edges = {{3, 1}, {2, 1}, {4, 2}, {1, 4}};
        int[] res = findRedundantDirectedConnection(edges);
        System.out.println("[" + res[0] + ", " + res[1] + "]");
    }
}