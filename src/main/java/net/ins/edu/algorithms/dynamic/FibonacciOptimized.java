package net.ins.edu.algorithms.dynamic;

import java.util.HashMap;
import java.util.Map;

public class FibonacciOptimized {

    public int calculate(int i) {
        if (i <= 2) return 1;
        return calculate(i - 1) + calculate(i - 2);
    }

    public long calculateOptimized(long i, Map<Long, Long> cache) {
        var cached = cache.get(i);
        if (cached != null) return cached;

        if (i <= 2) return 1;

        long left = calculateOptimized(i - 1, cache);
        cache.put(i - 1, left);

        long right = calculateOptimized(i - 2, cache);
        cache.put(i - 2, right);

        return left + right;
    }

    public long calculateOptimizedRefactored(long i, Map<Long, Long> cache) {
        var cached = cache.get(i);
        if (cached != null) return cached;

        if (i <= 2) return 1;

        cache.put(i, calculateOptimizedRefactored(i-1, cache) + calculateOptimizedRefactored(i-2, cache));
        return cache.get(i);
    }

    public static void main(String[] args) {
        System.out.println(new FibonacciOptimized().calculate(6)); // 8
        System.out.println(new FibonacciOptimized().calculate(7)); // 13
        System.out.println(new FibonacciOptimized().calculate(8)); // 21
        System.out.println(new FibonacciOptimized().calculateOptimized(6, new HashMap<>())); // 8
        System.out.println(new FibonacciOptimized().calculateOptimized(7, new HashMap<>())); // 13
        System.out.println(new FibonacciOptimized().calculateOptimized(8, new HashMap<>())); // 21

        System.out.println(new FibonacciOptimized().calculateOptimized(50, new HashMap<>())); // 12586269025
        System.out.println(new FibonacciOptimized().calculateOptimizedRefactored(50, new HashMap<>())); // 12586269025
//        System.out.println(new FibonacciOptimized().calculate(50)); // 12586269025 FIXME: too slow
    }
}
