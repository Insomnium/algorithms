package net.ins.edu.algorithms.hackerrank.dictsandmaps;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TwoStrings {

    public String twoStrings(String s1, String s2) {
        Map<Character, Long> s1CharCount = groupCounting(s1);

        Map<Character, Long> s2CharCount = groupCounting(s2);

        for (Character c1 : s1CharCount.keySet()) {
            for (Character c2 : s2CharCount.keySet()) {
                if (c1.equals(c2)) {
                    return "YES";
                }
            }
        }
        return "NO";
    }

    private Map<Character, Long> groupCounting(String s2) {
        return s2.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }
}
