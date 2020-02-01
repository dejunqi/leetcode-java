package microsoftOA.fairIndexes;

public class Solution {
    public int fairIndexes(int[] A, int[] B) {
        int len = A.length;
        int res = 0;
        int[] sumA = new int[len + 1], sumB = new int[len + 1];
        for (int i = 1; i < len + 1; i++) {
            sumA[i] = sumA[i - 1] + A[i - 1];
            sumB[i] = sumB[i - 1] + B[i - 1];
        }

        for (int k = 1; k < len; k++) {
            int p1 = sumA[k] - sumA[0];
            int p2 = sumA[len] - sumA[k];
            int p3 = sumB[k] - sumB[0];
            int p4 = sumB[len] - sumB[k];
            if (p1 == p2 && p2 == p3 && p3 == p4) {
                res++;
            }
        }

        return res;
    }

    public void test() {
        int[] A1 = {4,-1,0,3}, B1 = {-2, 5, 0 ,3};
        int[] A2 = {2,-2,-3,3}, B2 = {0,0,4,-4};
        int[] A3 = {4,-1,0,3}, B3 = {-2,6,0,4};
        int[] A4 = {3,2,6}, B4 = {4,1,6};
        int[] A5 = {1,4,2,-2,5}, B5 = {7,-2,-2,2,5};
        System.out.println(fairIndexes(A1, B1));
        System.out.println(fairIndexes(A2, B2));
        System.out.println(fairIndexes(A3, B3));
        System.out.println(fairIndexes(A4, B4));
        System.out.println(fairIndexes(A5, B5));
    }
}
