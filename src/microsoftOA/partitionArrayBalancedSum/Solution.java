package microsoftOA.partitionArrayBalancedSum;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;


/**
 * Givn you one sorted array, please put them into b buckets.
 * We need to ensure we get n subarray with approximately equal weights
 *
 * Greedy approach, always started to add number to the smallest sum
 */
public class Solution {

    public List<List<Integer>> part(int[] A, int n) {
        int[] sums = new int[n];
        List<List<Integer>> res = new ArrayList<>();
//        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> sums[a] - sums[b]);
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.comparingInt(a -> sums[a]));
        for (int i = 0; i < n; i++) {
            res.add(new ArrayList<>());
            queue.offer(i);
        }

        for (int i = A.length - 1; i >= 0; i--) {
            int c = queue.poll();
            res.get(c).add(A[i]);
            sums[c] += A[i];
            queue.offer(c);
        }
        return res;
    }


    public void test() {
        // int[] A = {1, 2, 3, 4, 5};
        // int n = 3;
        int[] A = {1,2,3,4,5,6,7,8,9,10};
        int n = 3;
        List<List<Integer>> result = part(A, n);
        System.out.println(result);
    }
}
