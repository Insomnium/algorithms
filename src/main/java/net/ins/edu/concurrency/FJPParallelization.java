package net.ins.edu.concurrency;

import java.util.List;
import java.util.concurrent.RecursiveTask;
import lombok.RequiredArgsConstructor;

public class FJPParallelization {

    @RequiredArgsConstructor
    static class FJPArraySum extends RecursiveTask<Integer> {

        private final List<Integer> arr;
        private static final int THRESHOLD = 2;

        @Override
        protected Integer compute() {
            if (arr.size() <= THRESHOLD) {
                return arr.stream().mapToInt(i -> i).sum();
            }
            var firstChunk = new FJPArraySum(arr.subList(0, arr.size() / 2));
            var secondChunk = new FJPArraySum(arr.subList(arr.size() / 2, arr.size()));
            var firstTask = firstChunk.fork();
            var secondTask = secondChunk.fork();
            return firstTask.join() + secondTask.join();
        }
    }

    @RequiredArgsConstructor
    static class FJPFactorial extends RecursiveTask<Integer> {

        private final int n;

        @Override
        protected Integer compute() {
            if (n == 0 || n == 1) return 1;
            return n * new FJPFactorial(n - 1).fork().join();
        }
    }
}
