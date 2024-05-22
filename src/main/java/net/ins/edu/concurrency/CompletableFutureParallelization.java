package net.ins.edu.concurrency;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import net.ins.edu.domain.service.Service;
import net.ins.edu.domain.service.ServiceA;
import net.ins.edu.domain.service.ServiceB;
import net.ins.edu.domain.service.ServiceC;

public class CompletableFutureParallelization {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        final long start = System.currentTimeMillis();
        var serviceA = new ServiceA();
        var serviceB = new ServiceB(new ServiceC());

//        parallelOnExecutor(serviceA, serviceB);
//        parallelOnCallableFuture(serviceA, serviceB);
        chainOnCallableFuture(serviceA, serviceB);

        System.out.printf("Complete in %s ms", (System.currentTimeMillis() - start));
    }

    private static void parallelOnExecutor(
            Service serviceA,
            ServiceB serviceB
    ) throws InterruptedException {
        final ExecutorService executorService = Executors.newFixedThreadPool(4);
        final List<Future<Long>> futures = executorService.invokeAll(
                List.of(
                        () -> serviceA.process(5000),
                        () -> serviceB.processServiceC(5000)
                )
        );
        final List<? extends Number> list = futures
                .stream()
                .map(f -> {
                    try {
                        return f.get();
                    } catch (Exception e) {
                        return -1;
                    }
                })
                .toList();
        executorService.shutdown();
        list.forEach(System.out::println);
    }

    private static void parallelOnCallableFuture(Service serviceA, ServiceB serviceB) {
        CompletableFuture
                .supplyAsync(() -> serviceA.process(2000))
                .completeAsync(() -> serviceB.processServiceC(2000))
                .join();
    }

    private static void chainOnCallableFuture(Service serviceA, ServiceB serviceB) throws ExecutionException, InterruptedException {
        final Long l = CompletableFuture.supplyAsync(() -> serviceA.process(2000))
                .thenApply(seconds -> 999 + serviceB.processServiceC(seconds))
                .get();
        System.out.println("Value must be 2999: " + l);
    }
}
