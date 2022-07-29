package net.ins.edu.algorithms.leetcode;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SortStringBasedOnDecreasingCharactersFrequency {

    public String solution(String s) {
        var entryCount = new LinkedHashMap<Character, Integer>();

        for (char c : s.toCharArray()) {
            var count = entryCount.getOrDefault(c, 0);
            entryCount.put(c, ++count);
        }

        var resBuilder = new StringBuilder();

        LinkedList<Map.Entry<Character, Integer>> characterCountsSorted = entryCount.entrySet().stream().sorted((o1, o2) -> o2.getValue().compareTo(o1.getValue())).collect(Collectors.toCollection(LinkedList::new));
        characterCountsSorted.forEach(entry -> resBuilder.append(entry.getKey().toString().repeat(entry.getValue())));

        return resBuilder.toString();
    }

    public static void main(String[] args) {
        System.out.println(new SortStringBasedOnDecreasingCharactersFrequency().solution("Programming"));
        System.out.println(new SortStringBasedOnDecreasingCharactersFrequency().solution("abcbab"));
    }
}
