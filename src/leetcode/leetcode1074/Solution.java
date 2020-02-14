package leetcode1074;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int row = matrix.length, col = matrix[0].length;
        int res = 0;
        for (int r = 0; r < row; r++) {
            int[] arr = new int[col];
            for (int i = r; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    arr[j] += matrix[i][j];
                }
                res += subArraySum(arr, target);
            }
        }
        return res;
    }

    private int subArraySum(int[] arr, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int sum = 0, res = 0;

        for (int value : arr) {
            sum += value;
            if (map.containsKey(sum - target)) {
                res += map.get(sum - target);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return res;
    }

    public void test() {
        int[][] matrix = {{0,1,0},
                          {1,1,1},
                          {0,1,0}};
        int res = numSubmatrixSumTarget(matrix, 0);
        System.out.println(res);

    }
}
