package net.ins.edu.algorithms.leetcode.strings;

/**
 * <a href="https://leetcode.com/explore/interview/card/top-interview-questions-easy/127/strings/885/">Implement strStr()</a>
 */
public class ImplementStrStr {

    public int strStr(String haystack, String needle) {
        return haystack.indexOf(needle);
    }

    public int anotherSolution(String haystack, String needle) {
        var hChars = haystack.toCharArray();
        var nChars = needle.toCharArray();

        for (int i = 0; i < hChars.length; i++) {
            if (hChars[i] == nChars[0] && probe(hChars, i, nChars)) {
                return i;
            }
        }
        return -1;
    }

    private boolean probe(char[] hChars, int i, char[] nChars) {
        if (hChars.length - i < nChars.length) return false;

        for (int j = 0; j < nChars.length; j++) {
            if (nChars[j] != hChars[i++]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        new ImplementStrStr().anotherSolution("mississippi", "issipi");
    }
}
