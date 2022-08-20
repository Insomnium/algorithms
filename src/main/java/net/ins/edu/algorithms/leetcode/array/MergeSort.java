package net.ins.edu.algorithms.leetcode.array;

import java.util.Arrays;

public class MergeSort {

    public void mergeSort(int[] a, int len) {
        if (len <= 1) return;

        int mid = a.length / 2;

        int[] l = new int[mid];
        int[] r = new int[len - mid];

        int k = 0;
        for (int i = 0; i < a.length; i++) {
            if (i < mid) {
                l[i] = a[i];
            } else {
                r[k++] = a[i];
            }
        }

        mergeSort(l, mid);
        mergeSort(r, len - mid);

        merge(l, r, a, mid, len - mid);
    }

    private void merge(int[] left, int[] right, int[] source, int leftSize, int rightSize) {
        int i = 0, j = 0, k = 0;

        while (i < leftSize && j < rightSize) {
            if (left[i] < right[j]) {
                source[k++] = left[i++];
            } else {
                source[k++] = right[j++];
            }
        }

        while (i < leftSize) {
            source[k++] = left[i++];
        }

        while (j < rightSize) {
            source[k++] = right[j++];
        }
    }


    public static void main(String[] args) {
        var arr = new int[] { 9, 1, 8, 2, 7, 3, 6, 4, 5, 10 };
        new MergeSort().mergeSort(arr, arr.length);
        System.out.println(Arrays.toString(arr));
    }
}
