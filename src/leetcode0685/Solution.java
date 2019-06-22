package leetcode0685;

import java.util.*;

// edges = [[4,2],[1,5],[5,2],[5,3],[2,4]]
// edges = [[1,2], [2,3], [3,4], [4,1], [1,5]]
public class Solution {
    public int[] findRedundantDirectedConnection(int[][] edges) {
        int[] canA = null;
        int[] canB = null;
        int[] parent = new int[edges.length + 1];

        for (int[] e : edges) {
            int p = e[0], q = e[1];
            if (parent[q] == 0) {
                parent[q] = p;
            } else {
                canB = new int[] {p, q};
                canA = new int[] {parent[q], q};
                e[1] = 0;
            }
        }

        for (int i = 0; i < edges.length; i++) {
            parent[i] = i;
        }

        for (int[] e : edges) {
            if (e[1] == 0) {
                continue;
            }

            int child = e[1], p = e[0];
            if (findRoot(parent, p) == child) {
                if (canA == null) {
                    return e;
                }
                return canA;
            }

            parent[child] = p;
        }

        return canB;
    }


    private int findRoot(int[] ids, int k) {
        while (ids[k] != k) {
            k = ids[k];
        }
        return k;
    }
}