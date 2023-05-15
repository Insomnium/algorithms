package net.ins.edu.algorithms.practice;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SortStringCharactersByFrequency_Counting {

    private Map<Character, Long> sort(String s) {
        Map<Character, Long> charsCount = s.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        Map<Character, Long> orderedByValuesLinkedHashMap = charsCount.entrySet()
                .stream()
                .sorted((o1, o2) -> {
                    if (o1.getValue().equals(o2.getValue())) {
                        return o1.getKey().compareTo(o2.getKey());
                    }
                    return o2.getValue().compareTo(o1.getValue());
                })
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (a, b) -> a, LinkedHashMap::new));
        return orderedByValuesLinkedHashMap;
    }

    public static void main(String[] args) {
        Map<Character, Long> sortedByFrequency = new SortStringCharactersByFrequency_Counting().sort("hello");
        sortedByFrequency.forEach((k, v) -> System.out.printf("%s %s\n", k, v));
    }

}
