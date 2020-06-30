package leetcode0894;

import leetcode.utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<TreeNode> allPossibleFBT(int N) {
        List<TreeNode> res = new ArrayList<>();
        if (N == 1) {
            res.add(new TreeNode(0));
            return res;
        }

        N -= 1;
        for (int i = 1; i < N; i += 2) {
            List<TreeNode> leftList = allPossibleFBT(N - i);
            List<TreeNode> rightList = allPossibleFBT(i);
            for (TreeNode nl : leftList) {
                for (TreeNode nr : rightList) {
                    TreeNode node = new TreeNode(0);
                    node.left = nl;
                    node.right = nr;
                    res.add(node);
                }
            }
        }

        return res;
    }
}
