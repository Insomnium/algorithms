package ru.neoflex.sample;

import java.time.Duration;
import java.util.concurrent.locks.ReentrantLock;

public class TwoThreadedCounter {

    private static int count = 0;
    private static ReentrantLock lock = new ReentrantLock(true);

    public static void main(String[] args) throws InterruptedException {

        var workerOne = new Thread(new IncrementWorker());
        var workerTwo = new Thread(new IncrementWorker());

        workerOne.start();
        workerTwo.start();

        Thread interrupter = new Thread(() -> {
            try {
                Thread.sleep(Duration.ofMillis(100));
                workerOne.interrupt();
                workerTwo.interrupt();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        interrupter.start();

        workerOne.join();
        workerTwo.join();

        interrupter.join();

        System.out.printf("Result: %s\n", count);
    }

    static class IncrementWorker implements Runnable {

        @Override
        public void run() {
            for (long i = 0; i < Long.MAX_VALUE; i++) {
                if (Thread.interrupted()) {
                    break;
                }
                count++;
            }
        }
    }
}
