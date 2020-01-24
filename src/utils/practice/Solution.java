package utils.practice;


import java.util.*;


public class Solution {
    public void test() {
        boolean[] visited = new boolean[10000];
        int idx = 0;
        int size = 1;
        while (true) {
            if (idx > 0 && !visited[idx] && visited[idx - 1]) {
                break;
            }
            if (!visited[idx]) {
                size *= 2;
                idx += size;
            }
        }
    }
}
