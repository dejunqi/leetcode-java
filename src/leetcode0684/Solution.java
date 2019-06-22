package leetcode0684;

public class Solution {
    public int[] findRedundantConnection(int[][] edges) {

        int n = edges.length;
        int[] nums = new int[n + 1];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = i;
        }

        for (int[] e : edges) {
            int a = e[0], b = e[1];
            int ra = findRoot(a, nums);
            int rb = findRoot(b, nums);
            System.out.println(ra + ", " + rb);
            if (ra != rb) {
                nums[rb] = ra;
            } else {
                return e;
            }
        }

        return new int[] {};
    }

    private int findRoot(int idx, int[] nums) {
        while (idx != nums[idx]) {
            idx = nums[idx];
        }
        return idx;
    }

    public void test() {
//        int[][] edges = {{1,2}, {2,3}, {3,4}, {1,4}, {1,5}};
        int[][] edges = {{1, 2}, {1, 3}, {2, 3}};
        int[] res = findRedundantConnection(edges);
        System.out.println("[" + res[0] + ", " + res[1] + "]");
    }
}