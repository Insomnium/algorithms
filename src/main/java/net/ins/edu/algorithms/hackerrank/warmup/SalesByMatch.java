package net.ins.edu.algorithms.hackerrank.warmup;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * <a href="https://www.hackerrank.com/challenges/sock-merchant/problem?isFullScreen=true&h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=warmup">Sales By Match</a>
 */
public class SalesByMatch {

    public static int sockMerchant(int n, List<Integer> socks) {

        return socks.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .values()
                .stream()
                .mapToInt(value -> (int) Math.ceil(value.intValue() / 2))
                .sum();
    }


    public static void main(String[] args) {
        System.out.println(SalesByMatch.sockMerchant(7, List.of(1, 2, 1, 2, 1, 3, 2)));
    }
}
