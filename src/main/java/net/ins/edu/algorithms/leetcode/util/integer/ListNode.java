package net.ins.edu.algorithms.leetcode.util.integer;

import java.util.function.Supplier;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
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

    public static Supplier<ListNode> sampleSupplier = () -> new ListNode(10, new ListNode(20, new ListNode(30, new ListNode(40, new ListNode(50)))));
}
