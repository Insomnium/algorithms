package net.ins.edu.algorithms.leetcode.util.integer;

import java.util.function.Supplier;

public class ListNode {
    public int value;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int value) {
        this.value = value;
    }

    public ListNode(int value, ListNode next) {
        this.value = value;
        this.next = next;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + value +
                ", next=" + next +
                '}';
    }

    public static Supplier<ListNode> sampleSupplier = () -> new ListNode(10, new ListNode(20, new ListNode(30, new ListNode(40, new ListNode(50)))));
}
