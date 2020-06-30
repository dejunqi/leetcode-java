package leetcode.leetcode0339;

import java.util.List;

public class Solution {
    public int depthSum(List<NestedInteger> nestedList) {
        return helper(nestedList, 1);
    }

    private int helper(List<NestedInteger> list, int curDepth) {
        if (list.size() == 0) {
            return 0;
        }
        NestedInteger item = list.remove(0);
        if (item.isInteger()) {
            return curDepth * item.getInteger() + helper(list, curDepth);
        }
        return helper(item.getList(), curDepth + 1) + helper(list, curDepth);
    }
}
