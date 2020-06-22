package leetcode0849;

public class Solution {
    public int maxDistToClosest(int[] seats) {
        int len = seats.length;
        int l = -1, r = 0;
        int dist = 0;
        while (r < len) {
            while (r < len && seats[r] == 0) {
                r++;
            }
            if (l == -1) {
                dist = r;
            } else if (r == len) {
                System.out.println("Hit this case ?");
                dist = Math.max(dist, r - l - 1);
            } else {
                dist = Math.max(dist, (r - l) / 2);
            }
            l = r;
            r++;
        }
        return dist;
    }

    public void test() {
        int[] seats = {1, 0, 0, 0};
        int res = maxDistToClosest(seats);
        System.out.println(res);
    }
}
