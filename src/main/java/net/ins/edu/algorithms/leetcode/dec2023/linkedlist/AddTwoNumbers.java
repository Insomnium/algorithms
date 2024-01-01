package net.ins.edu.algorithms.leetcode.dec2023.linkedlist;

import net.ins.edu.algorithms.leetcode.util.integer.ListNode;

/**
 * <a href="https://leetcode.com/problems/add-two-numbers/">Add Two Numbers</a>
 */
public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        var leftHead = l1;
        var rightHead = l2;
        int leftover = 0, current = 0;
        ListNode result = new ListNode(0);
        ListNode tail = result;

        while (leftHead != null || rightHead != null) {
            var lValue = leftHead != null ? leftHead.value : 0;
            var rValue = rightHead != null ? rightHead.value : 0;

            var sum = lValue + rValue + leftover;
            leftover = sum / 10;
            current = sum % 10;

            tail.next = new ListNode(current);
            tail = tail.next;

//            System.out.println(lValue + " + " + rValue + " = " + sum + ": leftover = " + leftover + "; current = " + current);
            leftHead = leftHead != null ? leftHead.next : null;
            rightHead = rightHead != null ? rightHead.next : null;
        }

        if (leftover > 0) {
            tail.next = new ListNode(leftover);
        }

        return result.next;
    }
}
