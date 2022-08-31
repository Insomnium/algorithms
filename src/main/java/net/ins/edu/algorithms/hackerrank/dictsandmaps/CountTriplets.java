package net.ins.edu.algorithms.hackerrank.dictsandmaps;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
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
        if (arr.size() < 3) return 0;

        Collections.sort(arr);
        Map<Long, Long> entriesCount = arr.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        if (entriesCount.size() == 1) {
            return binomialSimple(arr.size(), 3);
        }

        long tripletCount = 0, lowLevelTriplets = 0L;
        long a = 0L, b = 0L, c = 0L;
        int i, j, k;
        for (i = 0; i < arr.size()-2; i++) {
            for (j = i+1; j < arr.size() - 1;) {
                for (k = j+1; k < arr.size();) {
                    a = arr.get(i); b = arr.get(j); c = arr.get(k);
                    if (isTripletOfRatio(a, b, c, r)) {
                        lowLevelTriplets = entriesCount.get(c);
                        k += entriesCount.get(c);
                        break;
                    } else {
                        k++;
                    }
                }
                j++;
                tripletCount += lowLevelTriplets;
                lowLevelTriplets = 0;
            }

        }
        return tripletCount;
    }

    private static long binomialSimple(final int elementsTotal, final int elementsInBucket) {
        long ret = 1;
        for (int k = 0; k < elementsInBucket; k++) {
            ret = ret * (elementsTotal-k) / (k+1);
        }
        return ret;
    }

    private static boolean isTripletOfRatio(long a, long b, long c, long r) {
        return a*r == b && b*r == c;
    }

    public static void main(String[] args) {
        System.out.println(countTriplets(new ArrayList<>(List.of(1L, 3L, 9L, 9L, 27L, 81L)), 3)); // 6
        System.out.println(countTriplets(new ArrayList<>(List.of(1L, 5L, 5L, 25L, 125L)), 5)); // 4
        System.out.println(countTriplets(new ArrayList<>(List.of(1L, 2L, 2L, 4L)), 2)); // 2

        List<Long> hundredOnes = LongStream.generate(() -> 1L)
                .limit(100)
                .boxed()
                .toList();
        System.out.println(countTriplets(new ArrayList<>(hundredOnes), 1));
    }
}
