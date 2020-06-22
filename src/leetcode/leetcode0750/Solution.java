package leetcode0750;

public class Solution {
    public int countCornerRectangles(int[][] grid) {

        int row = grid.length;
        int col = grid[0].length;
        int res = 0;

        for (int i = 0; i < row; i++) {
            for (int j = i + 1; j < row; j++) {
                int cnt = 0;
                for (int k = 0; k < col; k++) {
                    if (grid[i][k] == 1 && grid[j][k] == 1) {
                        cnt += 1;
                    }
                }
                // C(cnt, 2) 在cnt对平衡的1 -- 1中抽出两对来构成矩形，总共有
                // C(cnt, 2) 组合数种取法。
                res += cnt * (cnt - 1) / 2 ;
            }
        }

        return res;
    }
}
