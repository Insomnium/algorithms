package net.ins.edu.algorithms.leetcode.concurrency;

import lombok.SneakyThrows;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

/**
 * <a href="https://leetcode.com/problems/print-in-order">Print In Order</a>
 */
public class PrintInOrder {

    private final Semaphore s1 = new Semaphore(0);
    private final Semaphore s2 = new Semaphore(0);

    public void first(Runnable printFirst) throws InterruptedException {
        printFirst.run();
        s1.release();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        s1.acquire();
        printSecond.run();
        s1.release();
        s2.release();
    }

    public void third(Runnable printThird) throws InterruptedException {
        s2.acquire();
        printThird.run();
        s2.release();
    }

    @SneakyThrows
    public static void main(String[] args) {
        var pio = new PrintInOrder();

        Callable<Void> t2 = () -> {
            pio.second(() -> System.out.println("second"));
            return null;
        };

        Callable<Void> t3 = () -> {
            pio.third(() -> System.out.println("third"));
            return null;
        };

        Callable<Void> t1 = () -> {
            pio.first(() -> System.out.println("first"));
            return null;
        };

        ExecutorService executorService = Executors.newFixedThreadPool(3);
        List<Future<Void>> futures = executorService.invokeAll(Arrays.asList(t2, t3, t1));

        for (Future<Void> future : futures) {
            future.get();
        }

        executorService.shutdown();
    }
}
