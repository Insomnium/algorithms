package net.ins.edu.algorithms.leetcode.array;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/549/">Single Number</a>
 */
public class SingleNumber {

    public int singleNumber(int[] nums) {
        var map = new HashMap<Integer, Integer>(nums.length / 2 + 1);
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        return map.entrySet().stream()
                .filter(it -> it.getValue() == 1)
                .map(Map.Entry::getKey)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("No unique element found"));
    }

    public static void main(String[] args) {
        System.out.println(new SingleNumber().singleNumber(new int[] { 2,2,1 }));
        System.out.println(new SingleNumber().singleNumber(new int[] { 4,1,2,1,2 }));
    }
}
