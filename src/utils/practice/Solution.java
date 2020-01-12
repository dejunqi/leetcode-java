package utils.practice;


import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {

    private class Item {
        double ratio;
        double quality;
        Item(int w, int q) {
            ratio = (w * 1.0) / q;
            quality = q;
        }
    }

    public double mincostToHireWorkers(int[] quality, int[] wage, int K) {
        int len = quality.length;
        Item[] items = new Item[len];
        for (int i = 0; i < len; i++) {
            items[i] = new Item(wage[i], quality[i]);
        }

        Arrays.sort(items, Comparator.comparingDouble(o -> o.ratio));
        PriorityQueue<Double> queue = new PriorityQueue<>((a, b) -> (int)(b - a));
        int totalQuality = 0;
        double res = Double.MAX_VALUE;

        for (Item item : items) {
            queue.add(item.quality);
            totalQuality += item.quality;
            if (queue.size() > K) {
                totalQuality -= queue.poll();
            }
            if (queue.size() == K) {
                res = Math.min(res, totalQuality * item.ratio);
            }
        }
        return res;
    }

    public void test() {

        int[] quality = {10,20,5};
        int[] wage = {70,50,30};
        int K = 2;
        System.out.println(mincostToHireWorkers(quality, wage, K));

    }
}