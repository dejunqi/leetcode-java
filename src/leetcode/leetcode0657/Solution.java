package leetcode0657;

public class Solution {
    public boolean judgeCircle(String moves) {
        int[] point = {0, 0};
        for (int i = 0; i < moves.length(); i++) {
            int[] d = direction(moves.charAt(i));
            point[0] += d[0];
            point[1] += d[1];
        }
        return point[0] == 0 && point[1] == 0;
    }

    private int[] direction(Character d) {
        if (d == 'U') {
            return new int[] {-1, 0};
        } else if (d == 'D') {
            return new int[] {1, 0};
        } else if (d == 'L') {
            return new int[] {0, -1};
        } else {
            return new int[] {0, 1};
        }
    }
}
