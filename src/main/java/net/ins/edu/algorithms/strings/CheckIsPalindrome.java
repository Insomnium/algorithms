package net.ins.edu.algorithms.strings;

public class CheckIsPalindrome {

    public boolean isPalindrome(String s) {
        if (s.isEmpty()) return false;
        var chars = s.toCharArray();

        for (int i = 0, j = chars.length-1; i <= j; i++, j--) {
            if (chars[i] != chars[j]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new CheckIsPalindrome().isPalindrome("abccba"));
        System.out.println(new CheckIsPalindrome().isPalindrome("abcba"));
        System.out.println(new CheckIsPalindrome().isPalindrome("abcb"));
        System.out.println(new CheckIsPalindrome().isPalindrome("a"));
        System.out.println(new CheckIsPalindrome().isPalindrome(""));
    }
}
