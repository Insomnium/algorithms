package net.ins.edu.algorithms.leetcode.linkedlist;

/**
 * <a href="https://leetcode.com/problems/reverse-linked-list-ii/submissions/">Reverse Linked List II</a>
 */
public class ReverseLinkedList2 {

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || head.next == null) return head;
        int i = 0, tmpIdx = 0;

        ListNode beforeLeft = null, afterRight = null;

        ListNode curr = head;

        ListNode[] midSublist = new ListNode[right-left+1];

        while (curr != null) {
            if (i+2 == left)
                beforeLeft = curr;
            if (i+1 == right)
                afterRight = curr.next;

            if (i+1 >= left && i+1 <= right) {
                midSublist[tmpIdx++] = new ListNode(curr.val);
            }

            curr = curr.next;
            i++;
        }

        ListNode revTail = new ListNode(midSublist[midSublist.length-1].val);
        ListNode revHead = revTail;
        if (midSublist.length > 1) {
            for (int j = midSublist.length - 1; j > 0; j--) {
                revTail.next = new ListNode(midSublist[j-1].val);
                revTail = revTail.next;
            }
        }

        revTail.next = afterRight;
        if (beforeLeft != null) {
            beforeLeft.next = revHead;
            return head;
        }

        return revHead;
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
        System.out.println(new ReverseLinkedList2().reverseBetween(new ListNode(10, new ListNode(20, new ListNode(30, new ListNode(40, new ListNode(50))))), 2, 4));
        System.out.println(new ReverseLinkedList2().reverseBetween(new ListNode(10, new ListNode(20, new ListNode(30, new ListNode(40, new ListNode(50))))), 1, 4));
        System.out.println(new ReverseLinkedList2().reverseBetween(new ListNode(10, new ListNode(20, new ListNode(30, new ListNode(40, new ListNode(50))))), 3, 4));
        System.out.println(new ReverseLinkedList2().reverseBetween(new ListNode(10, new ListNode(20, new ListNode(30, new ListNode(40, new ListNode(50))))), 2, 5));
        System.out.println(new ReverseLinkedList2().reverseBetween(new ListNode(50), 1, 1));
        System.out.println(new ReverseLinkedList2().reverseBetween(new ListNode(10, new ListNode(20)), 1, 2));
    }
}
