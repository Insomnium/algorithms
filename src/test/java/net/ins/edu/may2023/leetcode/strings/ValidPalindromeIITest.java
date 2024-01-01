package net.ins.edu.may2023.leetcode.strings;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class ValidPalindromeIITest {

    @ParameterizedTest(name = "isPalindrome(\"{0}\") == {1}")
    @CsvSource(value = {
            "ada;true",
            "a;true",
            "adaada;true",
            "ad;false",
            "'';true",
            "abca;false",
            "A man, a plan, a canal: Panama;true",
            "null;false"
    }, delimiter = ';', nullValues = { "null" })
    void test(
            String input,
            boolean expected
    ) {
        assertEquals(expected, new ValidPalindromeII.Solution().isPalindrome(input));
    }
}