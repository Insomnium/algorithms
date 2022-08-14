package net.ins.edu.algorithms.princeton;

public class QuickUnion {

    /**
     * i - value
     * arr[i] - parent (a value)
     */
    private int arr[];

    public QuickUnion(int size) {
        arr = new int[size];
        for (int i = 0; i < size - 1; i++) {
            arr[i] = i;
        }
    }

    public QuickUnion(int[] arr) {
        this.arr = arr;
    }

    public void union(int p, int q) {
        if (!connected(p, q)) {
            arr[p] = q;
        }
    }

    public boolean connected(int p, int q) {
        return findRoot(p) == findRoot(q);
    }

    private int findRoot(int value) {
        while (arr[value] != value) {
            value = arr[value];
        }
        return value;
    }

    public static void main(String[] args) {
        var qu = new QuickUnion(new int[] { 0, 1, 9, 4, 9, 6, 6, 7, 8, 9 });
        System.out.println(qu.connected(3, 4)); // true
        System.out.println(qu.connected(3, 9)); // true
        System.out.println(qu.connected(3, 2)); // true
        System.out.println(qu.connected(2, 3)); // true
        System.out.println(qu.connected(0, 1)); // false
        System.out.println(qu.connected(1, 2)); // false
        System.out.println(qu.connected(1, 3)); // false
        System.out.println(qu.connected(1, 9)); // false
        System.out.println(qu.connected(5, 6)); // true

        System.out.println(qu.connected(3, 5)); // false

        qu.union(9, 6);
        System.out.println(qu.connected(3, 5)); // true
    }
}
