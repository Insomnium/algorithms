package net.ins.edu.algorithms.leetcode.may2023.strings;

/**
 * <a href="https://leetcode.com/problems/valid-palindrome/">125. Valid Palindrome</a>
 */
public class ValidPalindromeII {

    public static void main(String[] args) {
        System.out.println(new Solution().isPalindrome("aba")); // true
    }

    public static class Solution {

        public boolean isPalindrome(String s) {
            if (s == null) return false;
            if (s.isBlank()) return true;

            var chars = sanitize(s).toCharArray();
            for (int i = 0, j = chars.length-1; i <= j; i++, j--) {
                if (chars[i] != chars[j]) {
                    return false;
                }
            }

            return true;
        }

        private String sanitize(String s) {
            return s.replaceAll("[^A-Za-z0-9]+", "").toLowerCase();
        }
    }
}
