package leetcode.leetcode0297;

import leetcode.utils.TreeNode;

public class Solution {

    public void test() {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        n1.left = n2;
        n1.right = n3;
        n3.left = n4;
        n3.right = n5;

        Codec codec = new Codec();
        String data = codec.serialize(n1);
        System.out.println(data);
        TreeNode root = codec.deserialize(data);

        System.out.println(codec.serialize(root));
    }
}
