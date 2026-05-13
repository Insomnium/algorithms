package ru.neoflex.sample;

public class TwoThreadedCounter {

    private static int count = 0;

    public static void main(String[] args) throws InterruptedException {
        var workerOne = new Thread(new IncrementWorker());
        var workerTwo = new Thread(new IncrementWorker());

        workerOne.start();
        workerTwo.start();

        workerOne.join();
        workerTwo.join();

        System.out.printf("Result: %s", count);
    }

    static class IncrementWorker implements Runnable {

        @Override
        public void run() {
            for (int i = 0; i < 200_000; i++) {
                count++;
            }
        }
    }
}
