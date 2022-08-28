package net.ins.edu.algorithms.leetcode.array;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/646/">Rotate Array</a>
 */
public class RotateArray {

    public void rotate(int[] nums, int k) {
        k = (k > nums.length) ? (int) (k - nums.length * Math.ceil(k / nums.length)) : k;
        int[] leftAux = Arrays.copyOfRange(nums, 0, nums.length - k);
        int[] rightAux = Arrays.copyOfRange(nums, nums.length - k, nums.length);
        for (int i = 0, j = 0; i < nums.length; i++) {
            if (i < rightAux.length) {
                nums[i] = rightAux[i];
            } else {
                nums[i] = leftAux[j++];
            }
        }
    }

    public static void main(String[] args) {
        int arr[];

        arr = new int[] { 1,2,3,4,5,6,7 };
        new RotateArray().rotate(arr, 3);
        System.out.println(Arrays.toString(arr));

        arr = new int[] { -1, -100, 3, 99 };
        new RotateArray().rotate(arr, 2);
        System.out.println(Arrays.toString(arr));

        arr = new int[] { -1 };
        new RotateArray().rotate(arr, 1);
        System.out.println(Arrays.toString(arr));

        arr = new int[] { -1, -100, 3, 99 };
        new RotateArray().rotate(arr, 9);
        System.out.println(Arrays.toString(arr));
    }
}
