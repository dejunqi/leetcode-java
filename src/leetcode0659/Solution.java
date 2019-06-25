package leetcode0659;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

    // Use only one map, very slow, but it works
    public boolean isPossible(int[] nums) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        map.put(0, new ArrayList<>());

        for (int i = 0; i < nums.length; i++) {
            int len = map.size();
            int idx = len - 1;
            while (true) {
                List<Integer> list = map.get(idx);
                int size = list.size();
                if (size == 0 || nums[i] - list.get(size - 1) == 1) {
                    list.add(nums[i]);
                    break;
                }

                if (idx == 0) {
                    map.put(len, new ArrayList<>());
                    map.get(len).add(nums[i]);
                    break;
                }
                idx -= 1;
            }
        }

        for (Integer k : map.keySet()) {
            if (map.get(k).size() < 3) {
                return false;
            }
        }
        return true;
    }

    public void test() {
        int[] nums = {1,2,3,4,5,6,6,8,9,9};
        boolean res = isPossible(nums);
        System.out.println(res);
    }
}
