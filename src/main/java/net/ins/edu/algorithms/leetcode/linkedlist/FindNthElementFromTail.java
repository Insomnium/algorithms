package net.ins.edu.algorithms.leetcode.linkedlist;

import net.ins.edu.algorithms.leetcode.util.integer.ListNode;

import java.util.ArrayList;
import java.util.List;

public class FindNthElementFromTail {

    public ListNode findNthFromTail(int n, ListNode root) {
        if (root == null || n <= 0) return null;

        ListNode curr = root;
        List<ListNode> listRepr = new ArrayList<>();
        while(curr != null) {
            listRepr.add(curr);
            curr = curr.next;
        }

        if (n > listRepr.size()) {
            return null;
        }

        return listRepr.get(listRepr.size() - n);
    }

    public static void main(String[] args) {
        System.out.println(new FindNthElementFromTail().findNthFromTail(2, new ListNode(0, new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5))))))));
        System.out.println(new FindNthElementFromTail().findNthFromTail(6, new ListNode(0, new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5))))))));
        System.out.println(new FindNthElementFromTail().findNthFromTail(7, new ListNode(0, new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5))))))));
        System.out.println(new FindNthElementFromTail().findNthFromTail(1, new ListNode(0, new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5))))))));
        System.out.println(new FindNthElementFromTail().findNthFromTail(0, new ListNode(0, new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5))))))));
        System.out.println(new FindNthElementFromTail().findNthFromTail(-1, new ListNode(0, new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5))))))));
    }
}
