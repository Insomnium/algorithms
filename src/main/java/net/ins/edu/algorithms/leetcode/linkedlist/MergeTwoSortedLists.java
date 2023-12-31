package net.ins.edu.algorithms.leetcode.linkedlist;

import net.ins.edu.algorithms.leetcode.util.integer.ListNode;

/**
 * <a href="https://leetcode.com/explore/interview/card/top-interview-questions-easy/93/linked-list/771/">Merge Two Sorted Lists</a>
 */
public class MergeTwoSortedLists {

    public ListNode mergeTwoLists(ListNode leftHead, ListNode rightHead) {
        if (leftHead == null) {
            return rightHead;
        } else if (rightHead == null) {
            return leftHead;
        }

        ListNode curLeft = null, curRight = null;

        ListNode newHead = null;
        if (leftHead.value <= rightHead.value) {
            newHead = leftHead;
            curRight = rightHead;
            curLeft = leftHead.next;
        } else {
            newHead = rightHead;
            curLeft = leftHead;
            curRight = rightHead.next;
        }

        ListNode tail = newHead;
        while (curLeft != null && curRight != null) {
            if (curLeft.value <= curRight.value) {
                tail.next = new ListNode(curLeft.value, null);
                curLeft = curLeft.next;
                tail = tail.next;
            } else {
                tail.next = new ListNode(curRight.value, null);
                curRight = curRight.next;
                tail = tail.next;
            }
        }

        if (curLeft != null) {
            tail.next = curLeft;
        } else {
            tail.next = curRight;
        }

        return newHead;
    }

    public static void main(String[] args) {
        var l1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        var l2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        System.out.println(new MergeTwoSortedLists().mergeTwoLists(l1, l2));
    }
}
