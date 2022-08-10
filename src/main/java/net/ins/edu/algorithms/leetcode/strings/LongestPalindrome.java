package net.ins.edu.algorithms.leetcode.strings;

import java.util.*;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;

/**
 * <a href="https://leetcode.com/problems/longest-palindrome">Longest Palindrome</a>
 */
public class LongestPalindrome {

    public int longestPalindrome(String s) {
        var countBySymbols = new HashMap<Character, Integer>();
        for (char c : s.toCharArray()) {
            countBySymbols.put(c, countBySymbols.getOrDefault(c, 0) + 1);
        }

        var oddsSum = 0;
        var evenCount = 0;
        var evenSum = 0;
        for (Map.Entry<Character, Integer> entry : countBySymbols.entrySet()) {
            if (entry.getValue() % 2 == 0) {
                oddsSum += entry.getValue();
            } else {
                evenSum += entry.getValue() - 1;
                evenCount++;
            }
        }

        return oddsSum + evenSum + (evenCount >= 1 ? 1 : 0);
    }

    public static void main(String[] args) {
        System.out.println(new LongestPalindrome().longestPalindrome("abccccdd"));
        System.out.println(new LongestPalindrome().longestPalindrome("ccc"));
        System.out.println(new LongestPalindrome().longestPalindrome("bananas"));
        System.out.println(new LongestPalindrome().longestPalindrome("civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth"));
    }
}
