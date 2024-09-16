package net.ins.edu.algorithms.strings;

import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/roman-to-integer">Roman to Integer</a>
 */
public class RomanToInteger {

    private Map<Character, Integer> romanToInteger = Map.ofEntries(
            Map.entry('I', 1),
            Map.entry('V', 5),
            Map.entry('X', 10),
            Map.entry('L', 50),
            Map.entry('C', 100),
            Map.entry('D', 500),
            Map.entry('M', 1000)
    );

    public int romanToInt(String s) {
        final char[] chars = s.toCharArray();
        int result = 0;

        for (int i = chars.length - 1; i >= 0; i--) {
            final char c = chars[i];
            int curr = romanToInteger.get(c);
            int next = i > 0 ? romanToInteger.get(chars[i - 1]) : Integer.MAX_VALUE;

            if (next >= curr) {
                result += curr;
            } else {
                result += curr - next;
                i--;
            }
        }
        return result;
    }
}
