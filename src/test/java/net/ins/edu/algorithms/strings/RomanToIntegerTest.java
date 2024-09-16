package net.ins.edu.algorithms.strings;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class RomanToIntegerTest {

    @ParameterizedTest(name = "Should convert Roman {0} to integer {1}")
    @MethodSource("dataSet")
    void shouldConvertRomanToInteger(
            String roman,
            int expectedInt
    ) {
        assertEquals(expectedInt, new RomanToInteger().romanToInt(roman));
    }

    static List<Arguments> dataSet() {
        return List.of(
                Arguments.of("III", 3),
                Arguments.of("XX", 20),
                Arguments.of("XXX", 30),
                Arguments.of("X", 10),
                Arguments.of("IX", 9),
                Arguments.of("VIII", 8),
                Arguments.of("XI", 11),
                Arguments.of("XII", 12),
                Arguments.of("MCMXCIV", 1994)
        );
    }

}
