package leetcode0449;

import utils.TreeNode;

public class Solution {

    public void test() {
        TreeNode n6 = new TreeNode(6);
        TreeNode n4 = new TreeNode(4);
        TreeNode n7 = new TreeNode(7);
        TreeNode n5 = new TreeNode(5);
//        TreeNode n3 = new TreeNode(3);
        n6.left = n5;
        n5.left = n4;
        n6.right = n7;
        Codec codec = new Codec();
        String data = codec.serialize(n6);
        TreeNode root = codec.deserialize(data);
        System.out.println(codec.serialize(root));
        System.out.println(data);
    }
}
