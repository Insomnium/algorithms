package net.ins.edu.algorithms.hackerrank.warmup;

import java.util.Arrays;

public class BubbleSort {

    public void sort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) { // bubble has already floated up. No need to reach the end of the array
                if (arr[j] > arr[j+1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                }
            }
        }
    }

    public static void main(String[] args) {
        var arr = new int[] { 9, 0, 1, 5, 3, 2, 4, 7, 6, 8 };
        new BubbleSort().sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
