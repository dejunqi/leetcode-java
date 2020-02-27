package googleInterview.triggerAlert;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public boolean isTriggerAlert(int[] A, int threshold) {

        int len = A.length;
        for (int i = 0; i < len; i++) {
            Integer[] arr = new Integer[len];
            for (int j = 0; j < len; j++) {
                arr[j] = A[j] / (i + 1);
            }

            if (helper(arr, i + 1, threshold)) {
                return true;
            }
        }
        return false;
    }

    private boolean helper(Integer[] A, int size, int threshold) {
        int i = 0, j = 0;
        while (j < A.length)  {
            if (A[j] < threshold) {
                if (j - i == size) {
                    return true;
                }
                i = j + 1;
            } else {
                j++;
            }
        }
        return false;
    }
}
