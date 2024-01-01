package net.ins.edu.algorithms.leetcode.dec2023.linkedlist;

import java.util.stream.Stream;
import net.ins.edu.algorithms.leetcode.util.integer.ListNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class AddTwoNumbersTest {

    @ParameterizedTest(name = "Should add two numbers from reversed linked lists")
    @MethodSource("numbers")
    void shouldAddTwoReversedNumbers(
            ListNode firstList,
            ListNode secondList,
            ListNode expected
    ) {
        final ListNode actual = new AddTwoNumbers().addTwoNumbers(firstList, secondList);
        Assertions.assertEquals(
                expected,
                actual
        );
    }

    static Stream<Arguments> numbers() {
        return Stream.of(
                Arguments.of(
                        ListNode.build(2, 4, 3),
                        ListNode.build(5, 6, 4),
                        ListNode.build(7, 0, 8)
                ),
                Arguments.of(
                        ListNode.build(2, 4, 3),
                        ListNode.build(5, 8),
                        ListNode.build(7, 2, 4)
                ),
                Arguments.of(
                        ListNode.build(9,9,9,9,9,9,9),
                        ListNode.build(9,9,9,9),
                        ListNode.build(8,9,9,9,0,0,0,1)
                )
        );
    }
}