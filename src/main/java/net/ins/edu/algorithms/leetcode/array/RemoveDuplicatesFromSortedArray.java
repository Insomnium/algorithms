package net.ins.edu.algorithms.leetcode.array;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/727/">Remove Duplicates from Sorted Array</a>
 */
public class RemoveDuplicatesFromSortedArray {

    public int removeDuplicates(int[] nums) {
        int k = 1;
        int prev = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (prev != nums[i]) {
                nums[k++] = nums[i];
            }
            prev = nums[i];
        }
        return k;
    }

    public static void main(String[] args) {
        int k = 0;
        int[] arr = null;

        arr = new int[] { 1,1,2 };
        k = new RemoveDuplicatesFromSortedArray().removeDuplicates(arr);
        System.out.printf("%s:  %s\n", k, Arrays.toString(arr));

        arr = new int[] { 0,0,1,1,1,2,2,3,3,4 };
        k = new RemoveDuplicatesFromSortedArray().removeDuplicates(arr);
        System.out.printf("%s:  %s\n", k, Arrays.toString(arr));
    }
}
