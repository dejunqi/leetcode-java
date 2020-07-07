package leetcode.leetcode0277;

// https://leetcode.com/problems/find-the-celebrity/
public class Solution implements Relation {
    public int findCelebrity(int n) {
        int candidate = 0;
        for (int i = 1; i < n; i++) {
            if (knows(candidate, i)) {
                candidate = i;
            }
        }

        for (int i = 0; i < n; i++) {
            if (i != candidate && (!knows(i, candidate) || knows(candidate, i)) ) {
                return -1;
            }
        }

        return candidate;
    }


    @Override
    public boolean knows(int a, int b) {
        return false;
    }
}
