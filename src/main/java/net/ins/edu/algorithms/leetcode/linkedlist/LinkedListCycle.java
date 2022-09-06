package net.ins.edu.algorithms.leetcode.linkedlist;

import net.ins.edu.algorithms.leetcode.util.integer.ListNode;

/**
 * <a href="https://leetcode.com/explore/interview/card/top-interview-questions-easy/93/linked-list/773/">Linked List Cycle</a>
 */
public class LinkedListCycle {

    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;

        ListNode slow = head, fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast != null && slow == fast) { // comparison by reference (values could not be unique)
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        var noCycleLL = new ListNode(10, new ListNode(20, new ListNode(30, new ListNode(40))));

        ListNode lastNode = new ListNode(40);
        ListNode secondNode = new ListNode(20, new ListNode(30, lastNode));
        lastNode.next = secondNode;
        var cycledLL = new ListNode(10, secondNode);

        System.out.println(new LinkedListCycle().hasCycle(noCycleLL)); // false
        System.out.println(new LinkedListCycle().hasCycle(cycledLL));  // true
    }
}
