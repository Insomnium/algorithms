package net.ins.edu.algorithms.leetcode;

import java.math.BigInteger;

public class StringToInteger {

    private static final BigInteger MAX_INT = new BigInteger(String.valueOf(Integer.MAX_VALUE));
    private static final BigInteger MIN_INT = new BigInteger(String.valueOf(Integer.MIN_VALUE));

    public int myAtoi(String s) {
        if (s.isEmpty()) return 0;

        var builder = new StringBuilder();
        boolean numHasBegun = false;
        boolean numHasEnded = false;
        boolean negated = false;
        boolean mathOperator = false;
        char[] charArray = s.toCharArray();
        boolean trailingZeroes = true;
        boolean trailingSpace = true;
        for (char c : charArray) {
            if (c == '-' || c == '+') {
                if (mathOperator && !numHasBegun) return 0;
                mathOperator = true;
            }
            if (trailingZeroes) {
                trailingZeroes = c == '0';
            }
            if (trailingSpace) {
                trailingSpace = c == ' ';
            }
            if (!numHasBegun) numHasBegun = (c >= '0' && c <= '9');
            if (numHasBegun) numHasEnded = (c < '0' || c > '9');
            if (numHasBegun) {
                if (numHasEnded) {
                    break;
                } else if (!trailingZeroes) {
                    builder.append(c);
                }
            } else {
                if (c == '-') {
                    negated = true;
                } else if (!trailingSpace && c != '+') break;
            }
        }
        String strNum = builder.toString();
        if (strNum.isEmpty()) return 0;
        var i = new BigInteger(strNum);
        if (negated) i = i.negate();
        if (i.compareTo(MIN_INT) < 0) return Integer.MIN_VALUE;
        if (i.compareTo(MAX_INT) > 0) return Integer.MAX_VALUE;
        return i.intValue();
    }

    public static void main(String[] args) {
        System.out.println(new StringToInteger().myAtoi("-5-"));
        System.out.println(new StringToInteger().myAtoi(" 42"));
        System.out.println(new StringToInteger().myAtoi("00000-42a1234"));
        System.out.println(new StringToInteger().myAtoi("018080381-1231312312"));
        System.out.println(new StringToInteger().myAtoi("-5"));
        System.out.println(new StringToInteger().myAtoi("+42"));
        System.out.println(new StringToInteger().myAtoi("+-42"));
        System.out.println(new StringToInteger().myAtoi("42"));
        System.out.println(new StringToInteger().myAtoi("-42"));
        System.out.println(new StringToInteger().myAtoi("4193 with words"));
        System.out.println(new StringToInteger().myAtoi("817236512786351278635671253781357123527153721357157123573571235752378157631"));
        System.out.println(new StringToInteger().myAtoi("words and 987"));
        System.out.println(new StringToInteger().myAtoi("words 934 word"));
    }
}
