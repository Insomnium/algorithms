package net.ins.edu.algorithms.hackerrank.dictsandmaps;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

public class CountTriplets {

    /**
     *
     * @param arr - input array
     * @param r - geometric progression ratio
     * @return geometric progression triplets count
     */
    public static long countTriplets(List<Long> arr, long r) {
        Map<Long, Integer> singles = new HashMap<>();
        Map<Long, Integer> doubles = new HashMap<>();
        int tripletsCount = 0;

        for (Long num : arr) {
            if (doubles.containsKey(num / r)) {
                tripletsCount += doubles.get(num / r);
            }

            doubles.put(num, doubles.getOrDefault(num, 0) + singles.getOrDefault(num / r, 0));

            singles.put(num, singles.getOrDefault(num, 0) + 1);
        }

        return tripletsCount;
    }

    private static long binomialSimple(final int elementsTotal, final int elementsInBucket) {
        long ret = 1;
        for (int k = 0; k < elementsInBucket; k++) {
            ret = ret * (elementsTotal-k) / (k+1);
        }
        return ret;
    }


    public static void main(String[] args) {
        System.out.println(countTriplets(new ArrayList<>(List.of(1L, 3L, 9L, 9L, 27L, 81L)), 3)); // 6
        System.out.println(countTriplets(new ArrayList<>(List.of(1L, 5L, 5L, 25L, 125L)), 5)); // 4
        System.out.println(countTriplets(new ArrayList<>(List.of(1L, 2L, 2L, 4L)), 2)); // 2
        System.out.println(countTriplets(new ArrayList<>(List.of(1L, 1L, 3L, 9L, 27L, 81L)), 3)); // 4
        System.out.println(countTriplets(new ArrayList<>(List.of(1L, 1L, 3L, 3L, 9L, 27L)), 3)); // 6
//
        List<Long> hundredOnes = LongStream.generate(() -> 1L)
                .limit(100)
                .boxed()
                .toList();
        System.out.println(countTriplets(new ArrayList<>(hundredOnes), 1)); // 161700
    }
}
