package net.ins.edu.algorithms.leetcode;

import java.util.LinkedList;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/valid-parentheses">Valid Parentheses</a>
 */
public class ValidParentheses {

    private static final Map<Character, Character> RULES = Map.of('{', '}', '[', ']', '(', ')');

    public boolean isValid(String s) {
        if (s.length() % 2 != 0) return false;

        var queue = new LinkedList<Character>();
        for (char c : s.toCharArray()) {
            if (RULES.containsKey(c)) {
                queue.push(c);
            } else {
                if (queue.isEmpty() || !RULES.get(queue.pop()).equals(c)) return false;
            }
        }

        return queue.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(new ValidParentheses().isValid("{}[]()"));
        System.out.println(new ValidParentheses().isValid("{}[]()()"));
        System.out.println(new ValidParentheses().isValid("({}{[]()}())"));
        System.out.println(new ValidParentheses().isValid("{}[()"));
        System.out.println(new ValidParentheses().isValid("{[()"));
        System.out.println(new ValidParentheses().isValid("}[()"));
    }
}
