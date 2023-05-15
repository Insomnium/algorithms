package net.ins.edu.algorithms.practice;

public class BinarySearch {

    private int search(int[] arr, int value) {
        if (arr.length == 0) return -1;
        return search(arr, value, 0, arr.length-1);
    }

    private int search(int[] arr, int value, int low, int high) {
        if (low > high) return -1;

        int mid = low + (high-low) / 2;

        if (arr[mid] == value) return mid;

        return value < arr[mid] ? search(arr, value, low, mid-1) : search(arr, value, mid+1, high);
    }

    public static void main(String[] args) {
        var arr = new int[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        for (int i = -1; i < arr.length + 1; i++) {
            System.out.println(new BinarySearch().search(arr, i)); // -1 for the first and the last elements
        }
    }
}
