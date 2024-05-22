package net.ins.edu.concurrency;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.StructuredTaskScope;

public class StructuredConcurrency {

    public void sample() throws InterruptedException, ExecutionException {
        try (var scope = new StructuredTaskScope.ShutdownOnFailure()) {
            var first = scope.fork(() -> {
                Thread.currentThread().sleep(1000L);
                System.out.println("Thread 1 is about to fail");
                throw new IllegalStateException("Let's fail");
//                return 1L;
            });
            var second = scope.fork(() -> {
                Thread.currentThread().sleep(2000L);
                System.out.println("Thread 2 is about to return value");
                return 2L;
            });
            scope.join().throwIfFailed();

            var left = (Long) first.get();
            var right = (Long) second.get();

            var result = left + right;
            System.out.println(STR."Result: \{result}");
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        var start = System.currentTimeMillis();
        try {
            new StructuredConcurrency().sample();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(STR."Finished in: \{System.currentTimeMillis() - start} ms");
    }
}
