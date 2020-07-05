package leetcode.leetcode0023;

import leetcode.utils.ListNode;

import javax.management.QueryEval;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        PriorityQueue<ListNode> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.val)) ;
        for (ListNode n : lists) {
            queue.offer(n);
        }
        ListNode dummyHead = new ListNode(0);
        ListNode cur = dummyHead;
        while (!queue.isEmpty()) {
            ListNode node = queue.poll();
            cur.next = node;
            cur = cur.next;
            if (node.next != null) {
                queue.offer(node.next);
            }
        }
        return dummyHead.next;
    }
}
