package net.ins.edu.algorithms.strings;

public class CheckIsPalindrome {

    public boolean isPalindrome(String s) {
        s = sanitizeString(s).toLowerCase();
        if (s.isEmpty()) return true;
        var chars = s.toCharArray();

        for (int i = 0, j = chars.length-1; i <= j; i++, j--) {
            if (chars[i] != chars[j]) {
                return false;
            }
        }
        return true;
    }

    private String sanitizeString(String s) {
        return s.replaceAll("[^A-Za-z0-9]+", "");
    }

    public static void main(String[] args) {
//        System.out.println(new CheckIsPalindrome().isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(new CheckIsPalindrome().isPalindrome("ab_a"));
//        System.out.println(new CheckIsPalindrome().isPalindrome("abccba"));
//        System.out.println(new CheckIsPalindrome().isPalindrome("abcba"));
//        System.out.println(new CheckIsPalindrome().isPalindrome("abcb"));
//        System.out.println(new CheckIsPalindrome().isPalindrome("a"));
//        System.out.println(new CheckIsPalindrome().isPalindrome(""));
    }
}
