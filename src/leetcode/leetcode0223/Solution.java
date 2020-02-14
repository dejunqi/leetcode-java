package leetcode0223;

public class Solution {

    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {

        int total = (C - A) * (D - B) + (H - F) * (G - E);

        int cx1 =  Math.min(C, G), cx2 = Math.max(E, A);
        int crossLen = cx1 - cx2;

        int cy1 = Math.min(D, H), cy2 = Math.max(B, F);
        int crossHig = cy1 - cy2;

        if (cx1 < 0 && cx2 > 0 && crossLen > 0) {
            crossLen = -1;
        }

        if (cy1 < 0 && cy2 > 0 && crossHig > 0) {
            crossHig = -1;
        }

        if (crossLen <= 0 || crossHig <= 0) {
            return total;
        }

        return total - crossLen * crossHig;
    }

    public void test() {
        int A = -3, B = 0, C = 3, D = 4, E = 0, F = -1, G = 9, H = 2;
        int res = computeArea(A, B, C, D, E, F, G, H);
        System.out.println(res);
    }
}
