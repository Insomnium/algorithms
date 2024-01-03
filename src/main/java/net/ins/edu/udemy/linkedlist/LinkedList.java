package net.ins.edu.udemy.linkedlist;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class LinkedList {

    @Override
    public boolean equals(final Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        final LinkedList that = (LinkedList) o;
        return length == that.length && Objects.equals(head, that.head);
    }

    @Override
    public int hashCode() {
        return Objects.hash(head, length);
    }

    @Override
    public String toString() {
        return "LinkedList{" +
                "head=" + head +
                ", length=" + length +
                '}';
    }

    public static LinkedList of(int... values) {
        LinkedList list = new LinkedList();
        for (final int value : values) {
            list.append(value);
        }
        return list;
    }

    private Node head;
    private int length;

    class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }

        @Override
        public boolean equals(final Object o) {
            if (this == o)
                return true;
            if (o == null || getClass() != o.getClass())
                return false;
            final Node node = (Node) o;
            return value == node.value && Objects.equals(next, node.next);
        }

        @Override
        public int hashCode() {
            return Objects.hash(value, next);
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    ", next=" + next +
                    '}';
        }
    }

    public LinkedList(int value) {
        Node newNode = new Node(value);
        head = newNode;
        length = 1;
    }

    public LinkedList() {

    }

    public Node getHead() {
        return head;
    }

    public int getLength() {
        return length;
    }

    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    public void printAll() {
        if (length == 0) {
            System.out.println("Head: null");
        } else {
            System.out.println("Head: " + head.value);
        }
        System.out.println("Length:" + length);
        System.out.println("\nLinked List:");
        if (length == 0) {
            System.out.println("empty");
        } else {
            printList();
        }
    }

    public void makeEmpty() {
        head = null;
        length = 0;
    }

    public void append(int value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        length++;
    }

    public void partitionList(int x) {
        if (head == null) return;
        Node curr = head;
        Node left = null;
        Node right = null;
        Node leftHead = null;
        Node rightHead = null;
        while (curr != null) {
            if (curr.value < x) {
                if (left == null) {
                    left = new Node(curr.value);
                    leftHead = left;
                } else {
                    left.next = curr;
                    left = left.next;
                }
            } else {
                if (right == null) {
                    right = new Node(curr.value);
                    rightHead = right;
                } else {
                    right.next = curr;
                    right = right.next;
                }
            }
            curr = curr.next;
        }
        left.next = rightHead;
        right.next = null;
        head = leftHead;
    }

    public void removeDuplicates() {
        Node curr = head;
        Node tmp = null;
        Node newHead = null;
        Set<Integer> uniqueValues = new HashSet<>();
        while (curr != null) {
            if (uniqueValues.add(curr.value)) { // does not contain value
                if (tmp == null) {
                    tmp = curr;
                    newHead = tmp;
                } else {
                    tmp.next = curr;
                    tmp = tmp.next;
                }
            } else {
                length--;
            }

            curr = curr.next;
        }
        if (tmp != null) {
            tmp.next = null;
        }
        head = newHead;
    }

    public int binaryToDecimal() { // every next node.value is to be doubled and current value is to be added
        Node curr = head;
        int sum = 0;
        while (curr != null) {
            sum = (sum*2) + curr.value;
            curr = curr.next;
        }
        return sum;
    }

    public static void main(String[] args) {
        LinkedList ll = new LinkedList(3);
        ll.append(5);
        ll.append(8);
        ll.append(10);
        ll.append(5);
//        ll.append(6);

        ll.removeDuplicates();

        ll.printList();
    }
}

