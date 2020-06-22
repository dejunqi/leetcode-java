package leetcode.leetcode0659;

import java.util.*;

public class Solution {

    public boolean isPossible(int[] nums) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        map.put(0, new ArrayList<>());

        for (int val : nums) {
            boolean allocate = false;
            int idx = map.size() - 1;
            for (int i = idx; i >= 0; i--) {
                List<Integer> list = map.get(i);
                if (list.size() == 0 || val - list.get(list.size() - 1) == 1) {
                    list.add(val);
                    allocate = true;
                    break;
                }
            }
            if (!allocate) {
                map.put(idx + 1, new ArrayList<>());
                map.get(idx + 1).add(val);
            }
        }

        for (Integer key : map.keySet()) {
            if (map.get(key).size() < 3) {
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
