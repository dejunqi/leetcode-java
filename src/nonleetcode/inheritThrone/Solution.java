package nonleetcode.inheritThrone;



/*
假设王有大皇子二皇子三皇子，大皇子有长子次子三子，那么继承顺序是王->大皇子->大皇子长子->大皇子次子->大皇子三子->二皇子->三皇子
死掉的人不能出现在继承顺序里，但是如果上面例子中大皇子死了，只需把大皇子移除
原始继承顺序保持不变：王->大皇子长子->大皇子次子->大皇子三子->二皇子->三皇子
 */


import java.util.ArrayList;
import java.util.List;

public class Solution {

    private class Member {
        String name;
        List<Member> children;
        Member(String name) {
            this.name = name;
            children = new ArrayList<>();
        }
    }

    public List<String> inheritOrder(Member root) {
        List<String> orders = new ArrayList<>();
        helper(root, orders);
        return orders;
    }

    // preorder traverse for N-ary tree
    private void helper(Member node, List<String> orders) {
        if (node == null) {
            return;
        }
        orders.add(node.name);
        List<Member> children = node.children;
        for (Member v : children) {
            helper(v, orders);
        }
    }

    public void remove(Member root,String name) {
        removeHelper(root, name);
    }

    private Member removeHelper(Member node, String name) {
        if (node == null) {
            return null;
        }

        if (node.children.size() == 0) {
            return node.name.equals(name) ? null : node;
        }

        if (node.name.equals(name)) {
            Member firstChild = node.children.remove(0);
            List<Member> grandChildren = firstChild.children;
            node.name = firstChild.name;
            grandChildren.addAll(node.children);
            node.children = grandChildren;
            return node;
        }

        List<Member> tmp = new ArrayList<>();
        for (Member m : node.children) {
            tmp.add(removeHelper(m, name));
        }
        node.children = tmp;
        return node;

    }

    public void test() {
        Member A = new Member("A");
        Member B = new Member("B");
        Member C = new Member("C");
        Member D = new Member("D");
        Member E = new Member("E");
        Member F = new Member("F");
        Member G = new Member("G");
        Member H = new Member("H");
        Member I = new Member("I");
        Member J = new Member("J");
        Member K = new Member("K");

        A.children.add(B);
        A.children.add(C);
        A.children.add(D);

        B.children.add(E);
        B.children.add(F);
        B.children.add(G);
        B.children.add(H);

        D.children.add(I);
        D.children.add(J);
        D.children.add(K);

        List<String> order = inheritOrder(A);
        System.out.println(order);

        remove(A, "B");
        System.out.println(inheritOrder(A));
    }

}