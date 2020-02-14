package leetcode0855;

import java.util.Iterator;
import java.util.TreeSet;

public class Solution {

    public void test() {
        ExamRoom er = new ExamRoom(10);
        for (int i = 0; i < 4; i++) {
            System.out.println(er.seat());
        }
        System.out.println();
        er.leave(4);
        System.out.println(er.seat());
    }

    public void testTreeSet() {
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i <= 10; i += 2) {
            set.add(i);
        }
//        int a = set.ceiling(5); // return x, where x >= 5
//        int b = set.floor(5); // return x , where x <= 5
//        System.out.println(a);
//        System.out.println(b);
        Iterator<Integer> iter = set.iterator();
        System.out.println(set.first());
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }
    }
}
