package net.ins.edu.algorithms.leetcode.linkedlist;

import net.ins.edu.algorithms.leetcode.util.integer.ListNode;

/**
 * <a href="https://leetcode.com/explore/interview/card/top-interview-questions-easy/93/linked-list/553/">Delete Node in a Linked List</a>
 */
public class DeleteNodeInLinkedList {

    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

    public static void main(String[] args) {

    }
}
