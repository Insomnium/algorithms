package net.ins.edu.algorithms.leetcode.array;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/559/">Plus One</a>
 */
public class PlusOne {

    private static final int VALUE = 1;

    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            int curr = digits[i];
            if (i == 0 && curr + VALUE >= 10) {
                digits[i] = 0;
                int[] interim = new int[digits.length+1];
                System.arraycopy(digits, 0, interim, 1, digits.length);
                i++;
                digits = interim;
            } else if (curr + VALUE < 10) {
                digits[i] = curr + VALUE;
                return digits;
            } else {
                digits[i] = 0;
            }
        }
        return digits;
    }

    public static void main(String[] args) {
//        System.out.println(Arrays.toString(new PlusOne().plusOne(new int[]{1, 2, 3}))); // [ 1, 2, 4 ]
//        System.out.println(Arrays.toString(new PlusOne().plusOne(new int[]{1, 2, 9}))); // [ 1, 3, 0 ]
        System.out.println(Arrays.toString(new PlusOne().plusOne(new int[]{9, 9, 9}))); // [ 1, 0, 0, 0 ]
    }
}
