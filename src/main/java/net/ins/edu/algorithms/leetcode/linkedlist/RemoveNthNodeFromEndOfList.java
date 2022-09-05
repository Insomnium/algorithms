package net.ins.edu.algorithms.leetcode.linkedlist;

import net.ins.edu.algorithms.leetcode.util.integer.ListNode;

/**
 * <a href="https://leetcode.com/explore/interview/card/top-interview-questions-easy/93/linked-list/603/">Remove Nth node from end of list</a>
 */
public class RemoveNthNodeFromEndOfList {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (remove(null, head, 0, n) < 0) {
            return null;
        }
        return head;
    }

    private int remove(ListNode prevNode, ListNode node, int currN, int removeN) {
        if (node == null) { // last node reached
            return currN;
        }
        int depth = remove(node, node.next, currN+1, removeN);
        if (depth - currN == removeN) {
            if (node.next == null) {
                if (prevNode == null) {
                    return -1;
                } else {
                    prevNode.next = null;
                }
            } else {
                node.val = node.next.val;
                node.next = node.next.next;
            }
        }
        return depth;
    }

    public static void main(String[] args) {
        System.out.println(new RemoveNthNodeFromEndOfList().removeNthFromEnd(ListNode.sampleSupplier.get(), 2));
        System.out.println(new RemoveNthNodeFromEndOfList().removeNthFromEnd(ListNode.sampleSupplier.get(), 5));
        System.out.println(new RemoveNthNodeFromEndOfList().removeNthFromEnd(ListNode.sampleSupplier.get(), 1));
        System.out.println(new RemoveNthNodeFromEndOfList().removeNthFromEnd(new ListNode(1), 1));
    }
}
