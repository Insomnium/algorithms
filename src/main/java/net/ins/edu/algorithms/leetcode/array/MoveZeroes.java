package net.ins.edu.algorithms.leetcode.array;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/567/">Move Zeroes</a>
 */
public class MoveZeroes {

    public void moveZeroes(int[] nums) {
        int[] result = new int[nums.length];
        int i = 0, k = 0;
        while (i < nums.length) {
            if (nums[i] != 0) {
                result[k++] = nums[i];
            }
            i++;
        }
        while (k < i) {
            result[k++] = 0;
        }
        System.arraycopy(result, 0, nums, 0, nums.length);
    }

    public static void main(String[] args) {
        int[] arr;

        arr = new int[] { 0,1,0,3,12 };
        new MoveZeroes().moveZeroes(arr);
        System.out.println(Arrays.toString(arr)); // [1,3,12,0,0]

        arr = new int[] { 0 };
        new MoveZeroes().moveZeroes(arr);
        System.out.println(Arrays.toString(arr)); // [0]

        arr = new int[] { 0, 0, 1, 2, 0, 0 };
        new MoveZeroes().moveZeroes(arr);
        System.out.println(Arrays.toString(arr)); // [1,2,0,0,0,0]
    }
}
