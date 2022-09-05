package net.ins.edu.algorithms.leetcode.strings;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * <a href="https://leetcode.com/explore/interview/card/top-interview-questions-easy/127/strings/887/">Longest Common Prefix</a>
 */
public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {
        AtomicInteger minLen = new AtomicInteger(Integer.MAX_VALUE);
        List<char[]> cmp = Arrays.stream(strs)
                .map(String::toCharArray)
                .peek(it -> {
                    if (it.length < minLen.get()) {
                        minLen.set(it.length);
                    }
                })
                .toList();

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < minLen.get(); i++) {
            if (i == 0 && !areCharsEqualAt(cmp, i)) {
                return "";
            } else if (areCharsEqualAt(cmp, i)) {
                result.append(cmp.get(0)[i]);
            } else {
                break;
            }
        }
        return result.toString();
    }

    private boolean areCharsEqualAt(List<char[]> chars, int i) {
        char prevChar = chars.get(0)[i];
        for (int j = 1; j < chars.size(); j++) {
            char charAtPos = chars.get(j)[i];
            if (prevChar != charAtPos) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new LongestCommonPrefix().longestCommonPrefix(new String[] { "a","a","a" }));
        System.out.println(new LongestCommonPrefix().longestCommonPrefix(new String[] { "flower","flow","flight" }));
        System.out.println(new LongestCommonPrefix().longestCommonPrefix(new String[] { "dog","racecar","car" }));
    }
}
