package microsoftOA.maxNetworkRank;


import java.util.*;

/**
An infrastructure consisting of N cities, numbered from 1 to N, and M bidirection roads between them is given.
Roads do not intersect apart from at their start and end points (they can pass through underground tunnels to avoid
 collisions)
For each pair of cities directly connected by a road, lets define their network rank as the total number of roads
 that are connected to either of the two cities.

Give two arrays A, B consisting of M integers each and an integer N, where A[i]
and B[i] are cities at the two ends of the i-th road, return the maximal nework rank in the whole infrastructure.

 Example 1

 input:
 A = [1, 2, 3, 3], B = [2, 3, 1, 4]
 N = 4

 expect output: 4

 The chosen cities may be 2 and 3, and the 4 roads connected to them are:
 (2, 1), (2, 3), (3, 1), (3, 4)


 */

public class Solution {

    public int maxNetworkRank(int[] A, int[] B, int N) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 1; i <= N; i++) {
            map.put(i, new HashSet<>());
        }

        int maxDegree = 0;
        int start = -1;
        for (int i = 0; i < A.length; i++) {
            int u = A[i], v = B[i];
            map.get(u).add(v);
            map.get(v).add(u);
            if (map.get(u).size() > maxDegree) {
                maxDegree = map.get(u).size();
                start = u;
            }
            if (map.get(v).size() > maxDegree) {
                maxDegree = map.get(v).size();
                start = v;
            }
        }

        // from the neighbors of the node that has largest degree, choose the one with biggest degree.
        Set<Integer> neighbors = map.get(start);
        int cnt = 0;
        for (Integer v : neighbors) {
            Set<Integer> set = map.get(v);
            cnt = Math.max(cnt, set.size());
        }
        return maxDegree + cnt - 1;
    }


    public void test() {
        int[] A = {1, 2, 3, 3};
        int[] B = {2, 3, 1, 4};
        int N = 4;
        int res = maxNetworkRank(A, B, N);
        System.out.println(res);
    }
}
