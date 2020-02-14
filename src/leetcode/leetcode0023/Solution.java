package leetcode.leetcode0023;


import java.util.PriorityQueue;

public class Solution {

    private class ListNode {
        int val;
        ListNode next;
        ListNode(int v) {val = v;}
    }

    public ListNode  mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> queue = new PriorityQueue<>((a, b) -> a.val - b.val);
        for (ListNode n : lists) {
            if (n != null) {
                queue.offer(n);
            }
        }

        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;

        while (!queue.isEmpty()) {
            ListNode node = queue.poll();
            cur.next = node;
            cur = cur.next;
            if (node.next != null) {
                queue.offer(node.next);
            }
        }

        return dummy.next;
    }
}
