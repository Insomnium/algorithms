package net.ins.edu.algorithms.j.search;

public class BinarySearch<T extends Comparable<T>> {

    public BinarySearch(T[] arr) {
        this.arr = arr;
    }

    private T[] arr;

    public int find(T search) {
        return find(0, arr.length - 1, search);
    }

    private int find(int low, int high, T search) {
        if (low > high) {
            return -1;
        }
        int mid = low + (high - low) / 2;
        if (arr[mid].equals(search)) {
            return mid;
        }
        if (search.compareTo(arr[mid]) > 0) {
            return find(mid + 1, high, search);
        } else {
            return find(low, mid + 1, search);
        }
    }


    public static void main(String[] args) {
        Integer[] arr = new Integer[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        BinarySearch<Integer> search = new BinarySearch<>(arr);
        System.out.println(search.find(8));;
    }
}
