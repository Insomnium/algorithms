package net.ins.edu.algorithms.leetcode.strings;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LongestSubstringWithoutRepeatingCharactersTest {

    @CsvSource(
            value = {
                    "dvdf,3",
                    "aab,2",
                    "' ',1",
                    "abcabcbb,3",
                    "bbbbb,1",
                    "pwwkew,3",
            },
            delimiter = ',',
            quoteCharacter = '\''
    )
    @ParameterizedTest(name = "For \"{0}\" max unique substring count must be {1}")
    void shouldSolve(
            String str,
            int expectedLen
    ) {
        assertEquals(expectedLen, new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring(str));
    }
}
