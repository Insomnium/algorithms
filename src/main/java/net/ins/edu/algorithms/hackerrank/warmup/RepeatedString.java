package net.ins.edu.algorithms.hackerrank.warmup;

import java.util.Arrays;

/**
 * <a href="https://www.hackerrank.com/challenges/repeated-string/problem?isFullScreen=true&h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=warmup">Repeated String</a>
 */
public class RepeatedString {

    public static long repeatedString(String sample, long n) {
        long countPerSample = countA(sample);
        long fullSamples = (n / sample.length());
        long result = countPerSample * fullSamples;

        int partialSampleTailLen = (int) (n % sample.length());
        if (partialSampleTailLen == 0) {
            return result;
        }

        return result + countA(sample.substring(0, partialSampleTailLen));
    }

    private static long countA(String sample) {
        return Arrays.stream(sample.split("")).filter("a"::equals).count();
    }

    public static void main(String[] args) {
        System.out.println(RepeatedString.repeatedString("abcacabcac", 10)); // 4
        System.out.println(RepeatedString.repeatedString("aba", 10)); // 7
    }
}
