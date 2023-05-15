package net.ins.edu.algorithms.practice;

import net.ins.edu.algorithms.leetcode.util.integer.ListNode;

public class ReverseLinkedList3 {

    public ListNode reverse(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode prev = null, curr = head, next = head.next;

        while (next != null) {
            curr.next = prev;
            prev = curr;
            curr = next;
            next = next.next;
        }

        curr.next = prev;

        return curr;
    }

    public static void main(String[] args) {
        var ll = new ListNode(10, new ListNode(20, new ListNode(30, new ListNode(40))));
        var debug = new ReverseLinkedList3().reverse(ll);
        System.out.println(debug);
    }

}
