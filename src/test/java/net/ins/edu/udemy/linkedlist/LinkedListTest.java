package net.ins.edu.udemy.linkedlist;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

class LinkedListTest {

    @ParameterizedTest(name = "Should remove value duplicates")
    @MethodSource("duplicates")
    void removeDuplicates(
            LinkedList givenLinkedList,
            LinkedList expected
    ) {
        givenLinkedList.removeDuplicates();
        Assertions.assertEquals(expected, givenLinkedList);
    }

    @ParameterizedTest(name = "Should convert binary (LL) to decimal Integer value")
    @CsvSource({
            "0,0",
            "1,1",
            "10,2",
            "101,5",
            "1000,8",
            "10011,19",
    })
    void binaryToDecimal(
            String strLinkedListRepr,
            Integer expected
    ) {
        LinkedList ll = LinkedList.of();
        for (final char c : strLinkedListRepr.toCharArray()) {
            ll.append(Character.getNumericValue(c));
        }

        assertEquals(expected, ll.binaryToDecimal());
    }

    static Stream<Arguments> duplicates() {
        return Stream.of(
                Arguments.of(
                        LinkedList.of(1, 2, 3, 2, 5),
                        LinkedList.of(1, 2, 3, 5)
                ),
                Arguments.of(
                        LinkedList.of(1, 2, 3, 2, 5, 1),
                        LinkedList.of(1, 2, 3, 5)
                ),
                Arguments.of(
                        LinkedList.of(),
                        LinkedList.of()
                )
        );
    }
}