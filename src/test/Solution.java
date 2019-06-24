package test;

import java.util.TreeMap;

public class Solution {

    public void test() {
        TreeMap<Integer, Character> map = new TreeMap<>();
        int[] nums = {4, 1, 3, 8};
        char[] characters = {'d', 'a', 'c', 'h'};
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], characters[i]);
        }

        for (Integer key : map.keySet()) {
            System.out.println(key + ": " + map.get(key));
        }

    }
}
