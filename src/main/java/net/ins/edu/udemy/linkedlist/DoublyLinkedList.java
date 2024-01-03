package net.ins.edu.udemy.linkedlist;

import lombok.Data;
import lombok.ToString;

@Data
public class DoublyLinkedList {

    private Node head;
    private Node tail;
    private int length;

    @ToString(of = {"value"})
    class Node {
        int value;
        Node next;
        Node prev;

        Node(int value) {
            this.value = value;
        }
    }

    public DoublyLinkedList(int value) {
        Node newNode = new Node(value);
        head = newNode;
        tail = newNode;
        length = 1;
    }

    public DoublyLinkedList() {
        // no-op
    }

    public static DoublyLinkedList of(int... values) {
        var ll = new DoublyLinkedList();
        for (final int value : values) {
            ll.append(value);
        }
        return ll;
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
            System.out.println("Tail: null");
        } else {
            System.out.println("Head: " + head.value);
            System.out.println("Tail: " + tail.value);
        }
        System.out.println("Length:" + length);
        System.out.println("\nDoubly Linked List:");
        if (length == 0) {
            System.out.println("empty");
        } else {
            printList();
        }
    }

    public void makeEmpty() {
        head = null;
        tail = null;
        length = 0;
    }

    public void append (int value) {
        Node newNode = new Node(value);
        if(length == 0) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        length++;
    }

    public Node get(int index) {
        if (index < 0 || index >= length) return null;
        Node temp = head;
        if (index < length/2) {
            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }
        } else {
            temp = tail;
            for (int i = length - 1; i > index; i--) {
                temp = temp.prev;
            }
        }
        return temp;
    }

    public void reverse() {
        if (length <= 1) return;

        Node prevHead = head;
        Node prevTail = tail;
        if (length == 2) {
            prevHead.next = null;
            prevHead.prev = tail;
            prevTail.next = head;
            prevTail.prev = null;

            head = prevTail;
            tail = prevHead;
            return;
        }

        Node prev = null;
        Node curr = head;
        Node next = head.next;

        while (next != null) {
            curr.next = prev;
            curr.prev = next;

            prev = curr;
            curr = next;
            next = next.next;
        }

        curr.next = prev;
        curr.prev = null;

        head = prevTail;
        tail = prevHead;
    }

    public boolean isPalindrome() {
        if (length <= 1) return true;
        Node left = head;
        Node right = tail;

        while (left != right) {

            if (left.value != right.value) return false;

            left = left.next;
            right = right.prev;
        }

        return true;
    }

    public void swapPairs() {
        if (length <= 1) return;

        Node curr = head;

        int i = 0;
        while (curr != null) {
            Node afterSecond = null;
            Node beforeFirst = null;
            if (++i % 2 == 0) {
                Node first = curr.prev;
                Node second = curr;
                System.out.println("Processing at i == " + i + "; first: " + first.value + ", second: " + second.value);

                afterSecond = second.next;
                beforeFirst = first.prev;

                second.prev = first.prev;
                first.next = second.next;
                second.next = first;
                first.prev = second;

                if (afterSecond != null) {
                    afterSecond.prev = first;
                }
                if (beforeFirst != null) {
                    beforeFirst.next = second;
                }

                if (i == 2) {
                    head = second;
                }
                curr = afterSecond;
            } else {

                curr = curr.next;
            }
        }
    }
}


