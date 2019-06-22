package leetcode0857;
import java.util.Arrays;
import java.util.PriorityQueue;

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
        Worker[] workers = new Worker[quality.length];

        for (int i = 0; i < quality.length; i++) {
            workers[i] = new Worker(quality[i], wage[i]);
        }
        Arrays.sort(workers, (a, b) -> Double.compare(a.r, b.r));
        double res = Double.MAX_VALUE;
        double totalQuality = 0;

        for (Worker w : workers) {
            System.out.print("(" + w.r + ", " + w.q +  ")");
        }
        System.out.println();

        PriorityQueue<Double> queue = new PriorityQueue<>((a, b) -> Double.compare(b, a));
        for (Worker w : workers) {
            totalQuality += w.q;
            queue.add(w.q);
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
       int[] quality = {3,1,10,10,1};
       int[] wage = {4,8,2,2,7};
       int K = 3;

       double res = mincostToHireWorkers(quality, wage, K);
       System.out.println(res);

    }
}
