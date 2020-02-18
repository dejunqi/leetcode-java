package leetcode.leetcode0323;

public class Solution {

    public int countComponents(int n, int[][] edges) {
        int res = n;
        int[] nodes = new int[n];
        for (int i = 0; i < n; i++) {
            nodes[i] = i;
        }

        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            int ru = root(u, nodes);
            int rv = root(v, nodes);
            if (ru != rv) {
                nodes[rv] = ru;
                res--;
            }
        }
        return res;
    }

    private int root(int q, int[] nums) {
        while (q != nums[q]) {
            q = nums[q];
        }
        return q;
    }

    public void test() {
        int n = 5;
        int[][] edges = {{ 0, 1 }, { 1, 2 }, { 3, 4 }};
        System.out.println(this.countComponents(n, edges));
    }
}
