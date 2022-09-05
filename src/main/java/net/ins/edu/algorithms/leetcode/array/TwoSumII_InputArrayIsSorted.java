package net.ins.edu.algorithms.leetcode.array;

/**
 * <a href="https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/">Two Sum II - Input Arrays Is Sorted</a>
 */
public class TwoSumII_InputArrayIsSorted {

    public int[] twoSum(int[] nums, int target) {
        for (int i = 0, j = nums.length-1; ; ) {
            if (i > j) {
                break; // not found
            }
            if (nums[i] + nums[j] == target) {
                return new int[] { i+1, j+1 }; // +1, because according to the problem, the array is 1-indexed
            } else if (nums[i] + nums[j] > target) {
                j--;
            } else if (nums[i] + nums[j] < target) { // redundant check, if statement could be postponed
                i++;
            }
        }

        return new int[] { -1, -1 };
    }
}
