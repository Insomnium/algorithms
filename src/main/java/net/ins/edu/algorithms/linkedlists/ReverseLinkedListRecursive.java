package net.ins.edu.algorithms.linkedlists;

import net.ins.edu.algorithms.leetcode.util.integer.ListNode;

public class ReverseLinkedListRecursive {

    public ListNode reverse(ListNode node) {
        if (node.next == null) {
            return node;
        }

        var newHead = reverse(node.next);
        node.next.next = node;
        node.next = null;

        return newHead;
    }

    public static void main(String[] args) {
        var ll = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode reverse = new ReverseLinkedListRecursive().reverse(ll);
        System.out.println(reverse);
    }
}
