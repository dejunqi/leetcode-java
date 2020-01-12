package leetcode0857;
import java.lang.reflect.Array;
import java.util.*;

public class Solution {

    private class Worker {
        double r;
        double q;
        Worker(int q, int w) {
            r = (double)w / q;
            this.q = (double)q;
        }
    }

    public double mincostToHireWorkers(int[] quality, int[] wage, int K) {

        int n = wage.length;
        Worker[] workers = new Worker[n];
        for (int i = 0; i < n; i++) {
            workers[i] = new Worker(quality[i], wage[i]);
        }

        Arrays.sort(workers, Comparator.comparingDouble(o -> o.r));
        double res = Double.MAX_VALUE;
        int totalQuality = 0;
        PriorityQueue<Double> queue = new PriorityQueue<>((a, b) -> (int)(b - a));

        for (Worker w : workers) {
            queue.add(w.q);
            totalQuality += w.q;
            if (queue.size() > K) {
                totalQuality -= queue.poll();
            }
            if (queue.size() == K) {
                res = Math.min(res, totalQuality * w.r);
            }
        }

        return res;
    }


    public void test() {
//       int[] quality = {3,1,10,10,1};
//       int[] wage = {4,8,2,2,7}; int K = 3;
        int[] quality = {30,20,5};
        int[] wage = {70,50,30};
        int K = 2;

        double res = mincostToHireWorkers(quality, wage, K);
        System.out.println(res);

    }
}
