package net.ins.edu.algorithms.hackerrank.dictsandmaps;

import java.util.*;

public class CountTriplets {

    public static long countTriplets(List<Long> arr, long ratio) {
        if (arr.size() < 3) return 0;

        Collections.sort(arr);

        Set<String> triplets = new HashSet<>();
        for (int i = 0; i < arr.size()-2; i++) {
            for (int j = i+1; j < arr.size() - 1; j++) {
                for (int k = j+1; k < arr.size(); k++) {
                    long a = arr.get(i), b = arr.get(j), c = arr.get(k);
                    if (isTripletOfRatio(a, b, c, ratio)) {
                        triplets.add(String.format("%s%s%s", i, j, k));
                    }
                }
            }
        }
        return triplets.size();
    }

    private static boolean isTripletOfRatio(long a, long b, long c, long r) {
        return a*r == b && b*r == c;
    }

    public static void main(String[] args) {
        System.out.println(countTriplets(new ArrayList<>(List.of(1L, 3L, 9L, 9L, 27L, 81L)), 3)); // 6
        System.out.println(countTriplets(new ArrayList<>(List.of(1L, 5L, 5L, 25L, 125L)), 5)); // 4
        System.out.println(countTriplets(new ArrayList<>(List.of(1L, 2L, 2L, 4L)), 2)); // 2
    }
}
