package net.ins.edu.algorithms.leetcode.strings;

import java.util.Deque;
import java.util.LinkedList;

/**
 * <a href="https://leetcode.com/problems/longest-substring-without-repeating-characters">Longest Substring Without Repeating Characters</a>
 */
public class LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {
        Deque<Character> deq = new LinkedList<>();
        char[] chars = s.toCharArray();
        Deque<Character> longest = new LinkedList<>();
        for (int i = 0; i < chars.length; i++) {
            var c = chars[i];
            if (deq.contains(c)) {

                if (deq.size() > longest.size()) {
                    longest = new LinkedList<>(deq);
                }

                deq.clear();
                deq.push(c);
            } else {
                deq.push(c);
            }
        }

        return Math.max(deq.size(), longest.size());
    }
}
