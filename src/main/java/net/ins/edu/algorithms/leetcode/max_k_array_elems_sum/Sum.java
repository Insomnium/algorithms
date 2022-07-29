package net.ins.edu.algorithms.leetcode.max_k_array_elems_sum;

public class Sum {

    public long solution(long[] arr, int k) {
        long currSum = 0L, left = 0L, res = 0L;
        for (int i = 0; i < arr.length; i++) {
            currSum += arr[i];

            if (i+1 < k) continue;

            if (i >= k) {
                left = arr[i-k];
            }

            if (i+1 > k) {
                currSum -= left;
            }

            res = Math.max(res, currSum);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Sum().solution(new long[] {2L, 1L, 5L, 1L, 3L, 2L}, 3));
        System.out.println(new Sum().solution(new long[] {2, 3, 4, 1, 5L}, 2));
    }
}
