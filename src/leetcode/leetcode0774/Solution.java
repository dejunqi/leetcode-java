package leetcode0774;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;

public class Solution {

    private class Interval {
        int length;
        int insertionNum;
        Interval(int len, int num) {
            length = len;
            insertionNum = num;
        }

        double distance() {
            return length / ((double) (insertionNum + 1));

        }
    }

    public double minmaxGasDist(int[] stations, int K) {
        Arrays.sort(stations);

        PriorityQueue<Interval> queue = new PriorityQueue<>(new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                double diff = o1.distance() - o2.distance();
                if (diff > 0) {
                    return -1;
                } else if (diff < 0) {
                    return 1;
                } else {
                    return 0;
                }
            }
        });

        int totalLength = stations[stations.length - 1] - stations[0];
        int remaining = K;

        for (int i = 0; i < stations.length - 1; i++) {
            double percentage = (double) (stations[i + 1] - stations[i]) / totalLength; // 计算该区间占总区间长度的比例
            double numOfInertionFract = K * percentage; // 计算该区间应该占用多少个insertion
            int insertionNum = (int) numOfInertionFract; // 向下取整
            queue.offer(new Interval(stations[i + 1] - stations[i], insertionNum));
            remaining -= insertionNum;
        }

        while (remaining > 0) {
            Interval cur = queue.poll(); // 平均距离最大的那个区间还有余地可以存放insertion
            cur.insertionNum += 1;
            queue.offer(cur);
            remaining -= 1;
        }

        return queue.poll().distance();
    }


    public void test() {
        int[] stations = {1, 5, 10};
        int K = 3;
        double res = minmaxGasDist(stations, K);
        System.out.println(res);
    }
}
