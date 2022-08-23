package net.ins.edu.algorithms.leetcode.array;

/**
 * <a href="https://leetcode.com/problems/binary-search">Binary Search</a>
 */
public class BinarySearch {
    public int search(int[] nums, int target) {
        return find(nums, 0, nums.length-1, target);
    }

    private int find(int nums[], int low, int high, int target) {
        if (low > high) return -1;

        int mid = low + (high-low) / 2;

        if (nums[mid] == target) return mid;

        if (target < nums[mid]) {
            return find(nums, low, mid-1, target);
        }

        return find(nums, mid+1, high, target);
    }
}
