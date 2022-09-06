package net.ins.edu.algorithms.leetcode.linkedlist;

import net.ins.edu.algorithms.leetcode.util.integer.ListNode;

/**
 * <a href="https://leetcode.com/explore/interview/card/top-interview-questions-easy/93/linked-list/772/">Palindrome Linked List</a>
 */
public class PalindromeLinkedList {

    public boolean isPalindrome(ListNode head) {
        var copy = copy(head);
        var reversed = reverse(head);

        var mid = size(copy, 1) / 2;

        var leftCurr = copy;
        var rightCurr = reversed;
        int i = 0;
        while (i <= mid) {
            if (leftCurr.val != rightCurr.val) {
                return false;
            }
            leftCurr = leftCurr.next;
            rightCurr = rightCurr.next;
            i++;
        }
        return true;
    }

    private ListNode copy(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode newHead = new ListNode(head.val, head.next);
        ListNode currOrigin = head, curr = newHead;

        while (currOrigin.next != null) {
            curr.next = new ListNode(currOrigin.next.val);
            curr = curr.next;
            currOrigin = currOrigin.next;
        }
        return newHead;
    }

    private ListNode reverse(ListNode head) {
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

    private int size(ListNode node, int n) {
        if (node.next == null) {
            return n;
        }

        return size(node.next, n+1);
    }

    public static void main(String[] args) {
        var palindrome0 = new ListNode(1);
        var palindrome1 = new ListNode(1, new ListNode(2, new ListNode(1)));
        var palindrome2 = new ListNode(1, new ListNode(2, new ListNode(2, new ListNode(1))));

        var nonPalindrome0 = new ListNode(1, new ListNode(2));
        var nonPalindrome1 = new ListNode(1, new ListNode(2, new ListNode(2)));
        var nonPalindrome2 = new ListNode(1, new ListNode(2, new ListNode(2, new ListNode(3))));

        System.out.println(new PalindromeLinkedList().isPalindrome(palindrome0));    // true
        System.out.println(new PalindromeLinkedList().isPalindrome(palindrome1));    // true
        System.out.println(new PalindromeLinkedList().isPalindrome(palindrome2));    // true

        System.out.println(new PalindromeLinkedList().isPalindrome(nonPalindrome0)); // false
        System.out.println(new PalindromeLinkedList().isPalindrome(nonPalindrome1)); // false
        System.out.println(new PalindromeLinkedList().isPalindrome(nonPalindrome2)); // false

    }
}
