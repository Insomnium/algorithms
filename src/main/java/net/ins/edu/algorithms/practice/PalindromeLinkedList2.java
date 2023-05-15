package net.ins.edu.algorithms.practice;

import net.ins.edu.algorithms.leetcode.util.integer.ListNode;

public class PalindromeLinkedList2 {

    public boolean isPalindrome(ListNode head) {
        var originStrRepr = linkedListToString(head);
        var reverseStrRepr = linkedListToString(reverse(head));
        return originStrRepr.equals(reverseStrRepr);
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

    private String linkedListToString(ListNode head) {
        if (head == null) return "";
        var sb = new StringBuilder();

        var curr = head;
        while (curr != null) {
            sb.append(curr.val);
            sb.append(";");
            curr = curr.next;
        }
        return sb.deleteCharAt(sb.length()-1).toString();
    }

    public static void main(String[] args) {
        var palindrome0 = new ListNode(1);
        var palindrome1 = new ListNode(1, new ListNode(2, new ListNode(1)));
        var palindrome2 = new ListNode(1, new ListNode(2, new ListNode(2, new ListNode(1))));

        var nonPalindrome0 = new ListNode(1, new ListNode(2));
        var nonPalindrome1 = new ListNode(1, new ListNode(2, new ListNode(2)));
        var nonPalindrome2 = new ListNode(1, new ListNode(2, new ListNode(2, new ListNode(3))));

        System.out.println(new PalindromeLinkedList2().isPalindrome(palindrome0));    // true
        System.out.println(new PalindromeLinkedList2().isPalindrome(palindrome1));    // true
        System.out.println(new PalindromeLinkedList2().isPalindrome(palindrome2));    // true

        System.out.println(new PalindromeLinkedList2().isPalindrome(nonPalindrome0)); // false
        System.out.println(new PalindromeLinkedList2().isPalindrome(nonPalindrome1)); // false
        System.out.println(new PalindromeLinkedList2().isPalindrome(nonPalindrome2)); // false
    }
}
