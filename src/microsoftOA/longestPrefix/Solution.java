package microsoftOA.longestPrefix;


/*
Given two positive integers X and Y, and an array arr[] of positive integers.
We need to find the longest prefix index which contains an equal number of X and Y.
Print the maximum index of largest prefix exist otherwise print -1

Input : array[] = [7, 42, 5, 6, 42, 8, 7, 5, 3, 6, 7]
        X = 7 Y = 42
Output : 9
The longest prefix with same number of occurrences
of 7 and 42 is:

from 0 to 9
*/
public class Solution {
    public int longestPrefix(int[] arr, int x, int y) {
        int cntX = 0, cntY = 0;
        int idx = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == x) {
                cntX++;
            }

            if (arr[i] == y) {
                cntY++;
            }
            if (cntX > 0 && cntX == cntY) {
                idx = i;
            }
        }
        return idx;
    }

    public void test() {
        int[] array = {7, 42, 5, 6, 42, 8, 7, 5, 3, 6, 7};
        int X = 7, Y = 42;
        System.out.println(longestPrefix(array, X, Y));
    }
}
