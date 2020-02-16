package leetcode.leetcode0206;

public class Solution {

    private class ListNode {
        int val;
        ListNode next;
        ListNode(int v) {
            val = v;
            next = null;
        }

        public ListNode reverseList(ListNode head) {
            if (head == null) {
                return null;
            }
            ListNode p = null;
            ListNode cur = head;
            ListNode post = cur.next;

            while (post != null) {
                cur.next = p;
                p = cur;
                cur = post;
                post = cur.next;
            }
            cur.next = p;

            return cur;
        }
    }
}
