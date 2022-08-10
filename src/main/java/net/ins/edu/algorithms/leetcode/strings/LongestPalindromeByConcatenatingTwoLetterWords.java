package net.ins.edu.algorithms.leetcode.strings;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * <a href="https://leetcode.com/problems/longest-palindrome-by-concatenating-two-letter-words">Longest Palindrome by Concatenating Two Letter Words</a>
 */
public class LongestPalindromeByConcatenatingTwoLetterWords {

    public int longestPalindrome(String[] words) {
        var buffer = new ArrayList<String>();
        var result = 0;
        for (String word : words) {
            String reversed = "" + word.charAt(1) + word.charAt(0);
            if (buffer.contains(reversed)) {
                buffer.remove(reversed);
                result += 4;
            } else {
                buffer.add(word);
            }
        }
        boolean hasSymmetricEntry = buffer.stream().anyMatch(it -> it.charAt(0) == it.charAt(1));
        return result + (hasSymmetricEntry ? 2 : 0);
    }

    public static void main(String[] args) {
        System.out.println(new LongestPalindromeByConcatenatingTwoLetterWords().longestPalindrome(new String[] { "lc","cl","gg" }) + " == 6");
        System.out.println(new LongestPalindromeByConcatenatingTwoLetterWords().longestPalindrome(new String[] { "lc","cl","gg" }) + " == 6");
        System.out.println(new LongestPalindromeByConcatenatingTwoLetterWords().longestPalindrome(new String[] { "ab","ty","yt","lc","cl","ab" }) + " == 8");
        System.out.println(new LongestPalindromeByConcatenatingTwoLetterWords().longestPalindrome(new String[] { "cc","ll","xx" }) + " == 2");
        System.out.println(new LongestPalindromeByConcatenatingTwoLetterWords().longestPalindrome(new String[] { "mm","mm","yb","by","bb","bm","ym","mb","yb","by","mb","mb","bb","yb","by","bb","yb","my","mb","ym" }) + " == 30");
    }
}
