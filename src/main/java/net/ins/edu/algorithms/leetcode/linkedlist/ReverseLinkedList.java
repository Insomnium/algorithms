package net.ins.edu.algorithms.leetcode.linkedlist;

/**
 * <a href="https://leetcode.com/problems/reverse-linked-list/submissions/">Reverse Linked List</a>
 */
public class ReverseLinkedList {

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode prev = null;
        ListNode cur = head;
        ListNode next = head.next;

        while (next != null) {
            cur.next = prev;
            prev = cur;
            cur = next;
            next = next.next;
        }

        cur.next = prev;

        return cur;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }

    public static void main(String[] args) {
        var ll = new ListNode(10, new ListNode(20, new ListNode(30, new ListNode(40))));
        var debug = new ReverseLinkedList().reverseList(ll);
        System.out.println(debug);
    }
}
