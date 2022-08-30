package net.ins.edu.algorithms.hackerrank.java.advanced;

import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class JavaStackParentheses {

    private static final Map<Character, Character> PARENTHESES = Map.of(
            '{', '}',
            '[', ']',
            '(', ')'
    );

    public static void main(String[] args) {
//        var sc = new Scanner(System.in);
//
//        while (sc.hasNext()) {
//            String input=sc.next();
//            System.out.println(isValid(input));
//        }

        var sample = """
                ({}[])
                (({()})))
                ({(){}()})()({(){}()})(){()}
                {}()))(()()({}}{}
                }}}}
                ))))
                {{{
                (((
                []{}(){()}((())){{{}}}{()()}{{}{}}
                [[]][][]
                }{
                """;

        for (String s : sample.split("\n")) {
            System.out.println(isValid(s.trim()));
        }
    }

    private static boolean isValid(String s) {
        var stack = new Stack<Character>();
        int i = 0;
        for (char c : s.toCharArray()) {
            if (PARENTHESES.containsKey(c)) {
                stack.push(c);
            } else {
                if (stack.isEmpty() || !PARENTHESES.get(stack.pop()).equals(c)) return false;
            }
            i++;
        }
        return i == s.length() && stack.isEmpty();
    }
}
