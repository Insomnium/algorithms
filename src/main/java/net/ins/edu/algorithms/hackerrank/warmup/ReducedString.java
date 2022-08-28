package net.ins.edu.algorithms.hackerrank.warmup;

/**
 * <a href="https://www.hackerrank.com/challenges/reduced-string/problem?isFullScreen=true">Reduced String</a>
 */

import java.io.*;

import static java.util.stream.Collectors.joining;

class Result {

    /*
     * Complete the 'superReducedString' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    private static final String EMPTY = "Empty String";

    public static String superReducedString(String s) {
        if (s.isEmpty()) return EMPTY;

        var builder = new StringBuilder(s);
        for (int i = 0; i < builder.length()-1; ) {
            if (builder.charAt(i) == builder.charAt(i + 1)) {
                builder = builder.delete(i, i+2);
                if (i > 0) {
                    i--;
                }
            } else {
                i++;
            }
        }
        var result = builder.toString();
        return result.isEmpty() ? EMPTY : result;
    }

}

public class ReducedString {
    public static void main(String[] args) throws IOException {
        System.out.println(Result.superReducedString("aaabccddd"));
    }
}
