package microsoftOA.particleVelocity;

public class Solution {
    public int solution(int[] A) {
        int res = 0;
        if (A.length < 3) {
            return 0;
        }
        int i = 0, j = 2;
        int len = A.length;
        while (j < len) {
            if (A[j] - A[j - 1] != A[j - 1] - A[j - 2]) {
                res += (j - i - 2);
                i = j - 1;
            }
            j++;
        }

        if (i < len - 2) {
            res += (j - i - 2);
        }

        return res < 1000000000 ? res : -1;
    }

    public void test() {
        int[] A = {-1, 1, 3, 3, 3, 2, 3, 2, 1, 0};
        int res = solution(A);
        System.out.println(res);
    }
}
