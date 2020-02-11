package googleInterview.uniquePath;

import java.util.*;

/*
*
*给定一个矩形的宽和长，求所有可能的路径数量
Rules：
1. 从左上角走到右上角
2. 要求每一步只能向正右、右上或右下走，即 →↗↘
followup1: 优化空间复杂度至 O(n)
followup2: 给定矩形里的三个点，判断是否存在遍历这三个点的路经
followup3: 给定矩形里的三个点，找到遍历这三个点的所有路径数量
followup4: 给定一个下界 (x == H)，找到能经过给定下界的所有路径数量 (x >= H)
followup5: 起点和终点改成从左上到左下，每一步只能 ↓↘↙，求所有可能的路径数量
* */
public class Solution {

    // original question
    public int uniqueParh1(int m, int n) {
        int[][] dp = new int[m][n];
        dp[0][0] = 1;
        for (int j = 1; j < n; j++) {
            for (int i = 0; i < m; i++) {
                if (i == 0) {
                    dp[i][j] = dp[i][j - 1] + dp[i + 1][j - 1];
                } else if (i == m - 1) {
                    dp[i][j] = dp[i][j - 1] + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = dp[i][j - 1] + dp[i - 1][j - 1] + dp[i + 1][j - 1];
                }
            }
        }

        for (int[] row : dp) {
            System.out.println(Arrays.toString(row));
        }
        return dp[0][n - 1];
    }

    // followup 1: do it with O(n) complexity in space
    public int uniquePath2(int row, int col) {
        int[] dp = new int[row];
        int[] tmp = new int[row];
        dp[0] = 1;
        tmp[0] = 1;
        for (int j = 1; j < col; j++) {
            for (int i = 0; i < row; i++) {
                if (i == 0) {
                    dp[i] = tmp[i] + tmp[i + 1];
                } else if (i == row - 1) {
                    dp[i] = tmp[i] + tmp[i - 1];
                } else {
                    dp[i] = tmp[i] + tmp[i - 1] + tmp[i + 1];
                }
            }
            tmp = dp.clone();
        }

        System.out.println(Arrays.toString(dp));
        return dp[0];
    }

    // followup 2: followup2: 给定矩形里的三个点，判断是否存在遍历这三个点的路经
    public boolean uniquePath3(int row, int col, int[][] points) {
        if (points.length < 3) {
            return false;
        }
        Arrays.sort(points, (p1, p2) -> {
            if (p1[1] != p2[1]) {
                return p1[1] - p2[1];
            } else {
                return p1[0] - p2[0];
            }
        });


        for (int i = 1; i < 3; i++) {
            int[] p2 = points[i], p1 = points[i - 1];
            int r1 = p1[0], c1 = p1[1], r2 = p2[0], c2 = p2[1];
            boolean valid = r1 >= r2 + c1 - c2 || r1 <= r2 - c2 - c1;
            if (!valid) {
                return false;
            }
        }
        return true;
    }

    // followup 3: 给定矩形里的三个点, 找出遍历这三个点的所有路径的数量
    public int uniquePath4(int row, int col, int[][] points) {
        int[] res = {0};
        int[] start = {0, 0}, end = {0, col - 1};
        Set<int[]> set = new HashSet<>(Arrays.asList(points));
        uniquePath4_helper(start, end, set, res, 3, row, col);
        return res[0];
    }

    private void uniquePath4_helper(int[] cur, int[] end, Set<int[]> set, int[] res, int cnt, int row, int col) {
        if (cur[0] == end[0] && cur[1] == end[1]) {
            if (cnt == 1) {
                res[0] += 1;
            }
            return;
        }

        if (set.contains(cur)) {
            cnt -= 1;
        }
        int r = cur[0], c = cur[1];
        if (c + 1 < col) {
            uniquePath4_helper(new int[] {r, c + 1}, end, set, res, cnt, row, col);
        }
        if (r + 1 < row && c + 1 < col) {
            uniquePath4_helper(new int[] {r + 1, c + 1}, end, set, res, cnt, row, col);
        }
        if (r - 1 >= 0 && c + 1 < col) {
            uniquePath4_helper(new int[] {r - 1, c + 1}, end, set, res, cnt, row, col);
        }
    }

    // followup4: 给定一个下界 (x == H)，找到能经过给定下界的所有路径数量 (x >= H)
    public int uniquePath5(int row, int col, int h) {
        return -1;
    }



    public void test() {
         case1();
        followup1();
    }

    private void case1() {
        int m = 4, n = 4;
        int res = uniqueParh1(m, n);
        System.out.println();
        System.out.println(res);
    }

    private void followup1() {
        int res = uniquePath2(4, 4);
    }
}
