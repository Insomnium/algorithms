package net.ins.edu.algorithms.j.search;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class BinarySearchV2 {

    private final int[] arr;

    public int find(int v) {
        return find(0, arr.length-1, v);
    }

    private int find(int low, int high, int v) {
        if (low > high) {
            return -1;
        }

        int mid = low + (high-low) / 2;

        if (v == arr[mid]) {
            return mid;
        }

        if (v < arr[mid]) {
            return find(low, mid-1, v);
        } else {
            return find(mid+1, high, v);
        }
    }

    public static void main(String[] args) {
        System.out.println(new BinarySearchV2(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 }).find(5)); // 4
        System.out.println(new BinarySearchV2(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 }).find(6)); // 5
        System.out.println(new BinarySearchV2(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 }).find(1)); // 0
        System.out.println(new BinarySearchV2(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 }).find(10)); // 9
        System.out.println(new BinarySearchV2(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 }).find(11)); // -1
    }
}
