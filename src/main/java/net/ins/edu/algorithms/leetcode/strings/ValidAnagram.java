package net.ins.edu.algorithms.leetcode.strings;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ValidAnagram {

    public boolean isAnagram(String s, String t) {
        Map<Character, Long> sCharsCount = countChars(s);
        Map<Character, Long> tCharsCount = countChars(t);

        return sCharsCount.equals(tCharsCount);
    }

    private Map<Character, Long> countChars(String s) {
        return s.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    public static void main(String[] args) {
        System.out.println(new ValidAnagram().isAnagram("anagram", "nagaram"));
        System.out.println(new ValidAnagram().isAnagram("anagramm", "mnagaram"));
        System.out.println(new ValidAnagram().isAnagram("anagramm", "mnagarams"));
    }
}
