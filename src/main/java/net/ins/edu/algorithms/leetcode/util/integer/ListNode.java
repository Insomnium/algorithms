package net.ins.edu.algorithms.leetcode.util.integer;

import java.util.Objects;
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

    @Override
    public boolean equals(final Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        final ListNode listNode = (ListNode) o;
        return value == listNode.value && Objects.equals(next, listNode.next);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, next);
    }

    public static Supplier<ListNode> sampleSupplier = () -> new ListNode(10, new ListNode(20, new ListNode(30, new ListNode(40, new ListNode(50)))));

    public static ListNode build(int... values) {
        if (values == null || values.length == 0) {
            return null;
        }
        var node = new ListNode();
        var head = node;
        for (int i = 0; i < values.length; i++) {
            node.value = values[i];
            if (i < values.length-1) {
                node.next = new ListNode();
                node = node.next;
            }
        }
        return head;
    }
}
