package net.ins.edu.algorithms.leetcode.array;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/546/">Two Sum</a>
 */
public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[] { i, j };
                }
            }
        }

        return new int[] { -1, -1 };
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new TwoSum().twoSum(new int[]{2, 7, 11, 15}, 9)));  // [0, 1]
        System.out.println(Arrays.toString(new TwoSum().twoSum(new int[]{3, 2, 4}, 6)));       // [1, 2]
        System.out.println(Arrays.toString(new TwoSum().twoSum(new int[]{3, 3}, 6)));          // [0, 1]
        System.out.println(Arrays.toString(new TwoSum().twoSum(new int[]{-5 ,0 ,2 ,4}, -1)));  // [0, 3]
        System.out.println(Arrays.toString(new TwoSum().twoSum(new int[]{-5 ,0 ,2 ,4}, 100))); // [-1, -1]
    }
}
