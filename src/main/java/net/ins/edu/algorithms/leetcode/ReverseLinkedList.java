package net.ins.edu.algorithms.leetcode;

/**
 * <a href="https://leetcode.com/problems/reverse-linked-list/submissions/">Reverse Linked List</a>
 */
public class ReverseLinkedList {

    public ListNode reverseList(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return head;

        ListNode prev = null;
        ListNode curr = head;
        ListNode next = head.next;

        while (curr != null) {
            next = curr.next;

            curr.next = prev; //
            prev = curr; //
//            next = curr;
            curr = next;
        }
        head = prev;
        return head;
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
        var ll = new ListNode(10, new ListNode(20, new ListNode(30)));
        var debug = new ReverseLinkedList().reverseList(ll);
        System.out.println(debug);
    }
}
