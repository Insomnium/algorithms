package net.ins.edu.algorithms.leetcode;

import lombok.Data;

import java.math.BigDecimal;

/**
 * https://leetcode.com/problems/add-two-numbers/
 */
public class AddTwoNumbers {

    private static ListNode first = new ListNode(2, new ListNode(4, new ListNode(3)));
    private static ListNode second = new ListNode(5, new ListNode(6, new ListNode(4)));

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        var num = toReversedInt(l1).add(toReversedInt(l2));
        return toListNode(num);
    }

    private static ListNode toListNode(BigDecimal num) {
        var strNum = new StringBuilder(String.valueOf(num)).reverse().toString().toCharArray();
        var result = new ListNode(Integer.parseInt(String.valueOf(strNum[0])));

        if (strNum.length <= 1) {
            return result;
        }

        var currentNode = result;
        for (int i = 1; i < strNum.length; i++) {
            currentNode.next = new ListNode(Integer.parseInt(String.valueOf(strNum[i])));
            currentNode = currentNode.next;
        }

        return result;
    }

    private static BigDecimal toReversedInt(ListNode node) {
        if (node == null) {
            return BigDecimal.ZERO;
        }
        StringBuilder str = new StringBuilder(String.valueOf(node.val));
        var next = node.next;
        while (next != null) {
            str.append(next.val);
            next = next.next;
        }
        return new BigDecimal(str.reverse().toString());
    }

    public static void main(String[] args) {
        System.out.println(addTwoNumbers(first, second));
    }

    @Data
    private static class ListNode {
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
    }
}
