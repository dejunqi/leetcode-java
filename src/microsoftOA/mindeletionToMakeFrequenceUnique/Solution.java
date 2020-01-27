package microsoftOA.mindeletionToMakeFrequenceUnique;

import java.util.*;

/**
 Given a string s consisting of n lowercase letters, you have to delete the minimum number of
 characters from s so that every letter in s appears a unique number of times.
 We only care about the occurrences of letters that appear at least once in result.
 */
public class Solution {
    public int minDeletion(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int len = s.length();
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);
        for (Character c : map.keySet()) {
            queue.add(map.get(c));
        }


        int cnt = 0;
        while (queue.size() > 1) {
            int cur = queue.poll();
            int top = queue.peek();
            if (top != cur || cur == 0) {
                continue;
            }
            cur -= 1;
            queue.offer(cur);
            cnt++;
        }

        return cnt;
    }

    public void test() {
        String[] testcase = {"aabbffddeaee", "eeeeffff", "llll", "example"};
        for (String s : testcase) {
            int res = minDeletion(s);
            System.out.println(res);
        }
    }
}
