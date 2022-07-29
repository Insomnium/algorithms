package net.ins.edu.algorithms.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindArrayPairsGivingExpectedSum {

    public int[][] solution(int[] arr, int k) {
        var tmpRes = new ArrayList<IntPair>();
        for (int i = 0; i < arr.length; i++) {

            for (int j = arr.length-1; j >= i+1; j--) {
                var first = arr[i];
                var second = arr[j];
                if (first + second == k) {
                    tmpRes.add(new IntPair(first, second));
                }
            }
        }

        var res = new int[tmpRes.size()][2];
        for (int i = 0; i < tmpRes.size(); i++) {
            IntPair pair = tmpRes.get(i);
            res[i] = new int[] {pair.left, pair.right};
        }
        return res;
    }

    private class IntPair {
        public IntPair(int left, int right) {
            this.left = left;
            this.right = right;
        }

        int left;
        int right;
    }

    public static void main(String[] args) {
        int[][] solution = new FindArrayPairsGivingExpectedSum().solution(new int[]{5, 4, 3, 2, 1, 6, 8}, 10);
        for (int i = 0; i < solution.length; i++) {
            System.out.println(Arrays.toString(solution[i]));
        }
    }
}
