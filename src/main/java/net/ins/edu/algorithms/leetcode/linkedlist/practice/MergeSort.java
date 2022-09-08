package net.ins.edu.algorithms.leetcode.linkedlist.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.Collections.shuffle;

public class MergeSort {

    private void sort(int[] randomArray) {
        if (randomArray.length <= 1) return;

        int mid = randomArray.length / 2;
        int[] left = Arrays.copyOfRange(randomArray, 0, mid);
        int[] right = Arrays.copyOfRange(randomArray, mid, randomArray.length);

        sort(left);
        sort(right);

        merge(randomArray, left, right);
    }

    private void merge(int[] randomArray, int[] left, int[] right) {
        int lLen = left.length, rLen = right.length;
        int i = 0, j = 0, k = 0;

        while (i < lLen && j < rLen) {
            if (left[i] < right[j]) {
                randomArray[k++] = left[i++];
            } else {
                randomArray[k++] = right[j++];
            }
        }

        while (i < lLen) {
            randomArray[k++] = left[i++];
        }

        while (j < rLen) {
            randomArray[k++] = right[j++];
        }
    }

    public static void main(String[] args) {
        List<Integer> integers = IntStream.range(0, 100)
                .boxed()
                .collect(Collectors.toCollection(ArrayList::new));
        shuffle(integers);
        int[] randomArray = integers.stream()
                .mapToInt(i -> i)
                .toArray();

        System.out.println("Sorting array: " + Arrays.toString(randomArray));
        new MergeSort().sort(randomArray);


        System.out.println("Result:        " + Arrays.toString(randomArray));
    }
}
