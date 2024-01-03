package net.ins.edu.udemy.linkedlist;

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class DoublyLinkedListTest {

    @ParameterizedTest(name = "Should determine palindrome DLL")
    @MethodSource("palindrome")
    void shouldDeterminePalindrome(
            DoublyLinkedList dll,
            boolean expected
    ) {
        assertEquals(expected, dll.isPalindrome());
    }

    @Test
    void shouldSwapPairs() {
        var ll = DoublyLinkedList.of(1, 2, 3, 4);
        ll.swapPairs();

        var curr = ll.getHead();
        assertAll(
                () -> assertEquals(curr.value, 2),
                () -> assertEquals(curr.next.value, 1),
                () -> assertEquals(curr.next.next.value, 4),
                () -> assertEquals(curr.next.next.next.value, 3)
        );
    }

    static Stream<Arguments> palindrome() {
        return Stream.of(
                Arguments.of(DoublyLinkedList.of(1, 2, 3, 4), false),
                Arguments.of(DoublyLinkedList.of(1, 2, 3, 4, 3, 2, 1), true),
                Arguments.of(DoublyLinkedList.of(1, 2, 3, 4, 4, 3, 2, 1), true),
                Arguments.of(DoublyLinkedList.of(1), true),
                Arguments.of(DoublyLinkedList.of(1, 1), true)
        );
    }
}
