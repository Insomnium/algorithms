package net.ins.edu.algorithms.leetcode.strings;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/explore/interview/card/top-interview-questions-easy/127/strings/881/">First Unique Character in a String</a>
 */
public class FirstUniqueCharacterInAString {

    public int firstUniqChar(String s) {
        var chars = s.toCharArray();
        var charCount = new LinkedHashMap<Character, Entry>();
        for (int i = 0, charsLength = chars.length; i < charsLength; i++) {
            var entry = charCount.getOrDefault(chars[i], new Entry(i, 0));
            charCount.put(chars[i], new Entry(i, entry.count + 1));
        }

        for (Map.Entry<Character, Entry> charCountEntry : charCount.entrySet()) {
            if (charCountEntry.getValue().count == 1) {
                return charCountEntry.getValue().index;
            }
        }
        return -1;
    }

    class Entry {
        int index;
        int count;

        public Entry(int index, int count) {
            this.index = index;
            this.count = count;
        }
    }

    public static void main(String[] args) {
        System.out.println(new FirstUniqueCharacterInAString().firstUniqChar("leetcode"));
        System.out.println(new FirstUniqueCharacterInAString().firstUniqChar("loveleetcode"));
        System.out.println(new FirstUniqueCharacterInAString().firstUniqChar("aabb"));
        System.out.println(new FirstUniqueCharacterInAString().firstUniqChar("dddccdbba"));
    }
}
