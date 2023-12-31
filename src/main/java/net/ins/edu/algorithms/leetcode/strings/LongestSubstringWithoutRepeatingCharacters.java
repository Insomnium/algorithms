package net.ins.edu.algorithms.leetcode.strings;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/longest-substring-without-repeating-characters">Longest Substring Without Repeating Characters</a>
 */
public class LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {
        Deque<Character> deq = new LinkedList<>();
        char[] chars = s.toCharArray();
        int longest = 0;
        Map<Character, Integer> prevIdxByChar = new HashMap<>();
        for (int i = 0; i < chars.length; i++) {
            var c = chars[i];

            if (deq.contains(c)) {
                if (deq.size() > longest) {
                    longest = deq.size();
                }
                i = prevIdxByChar.get(c);
                deq.clear();
                prevIdxByChar.clear();
            } else {
                prevIdxByChar.put(c, i);
                deq.push(c);
            }
        }

        return Math.max(deq.size(), longest);
    }
}
