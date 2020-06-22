package leetcode0428;

import java.util.ArrayList;

public class Solution {
    public void test() {
        /*
        [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
        * */
        Node n1 = new Node(1, new ArrayList<>());
        Node n2 = new Node(2, new ArrayList<>());
        Node n3 = new Node(3, new ArrayList<>());
        Node n4 = new Node(4, new ArrayList<>());
        Node n5 = new Node(5, new ArrayList<>());
        Node n6 = new Node(6, new ArrayList<>());
        Node n7 = new Node(7, new ArrayList<>());
        Node n8 = new Node(8, new ArrayList<>());
        Node n9 = new Node(9, new ArrayList<>());

        n1.children.add(n2);
        n1.children.add(n3);
        n1.children.add(n4);


        n2.children.add(n5);
        n2.children.add(n6);

        n3.children.add(n7);
        n3.children.add(n8);
        n3.children.add(n9);

        Codec codec = new Codec();
        String res = codec.serialize(n1);
        System.out.println(res);

        System.out.println(codec.serialize(codec.deserialize(res)));

    }
}
