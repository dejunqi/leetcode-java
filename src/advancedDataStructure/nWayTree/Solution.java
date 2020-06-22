package advancedDataStructure.nWayTree;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<TreeNode> getNodes(TreeNode root, int K) {
        List<TreeNode> res = new ArrayList<>();
        helper(root, res, K);
        return res;
    }

    private int helper(TreeNode node, List<TreeNode> res, int K) {
        List<TreeNode> children = node.children;
        if (children.size() == 0) {
            if (node.val >= K) {
                res.add(node);
            }
            return node.val;
        }
        int val = node.val;
        for (TreeNode n : children) {
            val += helper(n, res, K);
        }
        if (val >= K) {
            res.add(node);
        }
        return val;
    }


    public void test() {
       TreeNode n1 = new TreeNode(2);
       TreeNode n2 = new TreeNode(-1);
       TreeNode n3 = new TreeNode(-2);
       TreeNode n4 = new TreeNode(1);
       TreeNode n5 = new TreeNode(1);
       TreeNode n6 = new TreeNode(2);

       n1.children.add(n2);
       n1.children.add(n3);
       n1.children.add(n4);
       n4.children.add(n5);
       n4.children.add(n6);

       List<TreeNode> nodes = getNodes(n1, 3);
       for (TreeNode n : nodes) {
           System.out.println(n.val);
       }
    }
}
