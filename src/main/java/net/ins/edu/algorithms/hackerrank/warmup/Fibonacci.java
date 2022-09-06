package net.ins.edu.algorithms.hackerrank.warmup;

import java.util.HashMap;
import java.util.Map;

/**
 * 0 1 1 2 3 5 8 13 21 34
 */
public class Fibonacci {

    public long fibonacci(long n) {
        return fibonacciMemo(n, new HashMap<>());
    }

    private long fibonacciMemo(long n, Map<Long, Long> memo) {
        if (n == 0) return 0;
        if (n == 1 || n == 2) return 1;

        if (memo.containsKey(n)) return memo.get(n);

        memo.put(n, fibonacciMemo(n-1, memo) + fibonacciMemo(n-2, memo));
        return memo.get(n);
    }

    public static void main(String[] args) {
        System.out.println(new Fibonacci().fibonacci(1)); // 1
        System.out.println(new Fibonacci().fibonacci(6)); // 8
        System.out.println(new Fibonacci().fibonacci(7)); // 13
        System.out.println(new Fibonacci().fibonacci(8)); // 21
        System.out.println(new Fibonacci().fibonacci(50)); // 12586269025
    }
}
