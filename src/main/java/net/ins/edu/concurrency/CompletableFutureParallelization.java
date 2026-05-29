package net.ins.edu.concurrency;

import java.util.List;
import java.util.concurrent.*;

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
//        chainOnCallableFuture(serviceA, serviceB);

//        System.out.printf("Complete in %s ms", (System.currentTimeMillis() - start));

        var executorService = Executors.newFixedThreadPool(10);

        var divider = 1;
        var cf = new CompletableFuture<String>();
        var result = CompletableFuture.supplyAsync(() -> serviceA.process(1000))
                .thenApply(it -> it - 10)
                .thenApplyAsync(it -> it / divider)
//                .exceptionally((th) -> {
//                    log(STR."Failed due to: \{th.getMessage()}");
//                    return -100L;
//                })
                .handleAsync((res, e) -> {
                    if (e != null) {
                        log("Failed: " + e.getMessage());
                        throw new CompletionException("Fucked up", e);
//                        return "999999";
                    } else {
                        log("Proceeding with value: " + res);
                        return res.toString();
                    }
                }, executorService)
                .thenApply(it -> STR."\{it}000")
                .thenApplyAsync(s -> {
                    log(STR."Parsing long value: \{s}");
                    return Long.parseLong(s);
                });

        result.whenComplete((res, th) -> {
            if (th != null) {
                log("Oops: " + th.getMessage());
            } else {
                log("Succeeded: " + res);
            }
        });

        result.join();

        executorService.shutdown();
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

    private static void log(String message) {
        var threadName = STR."\{Thread.currentThread().getName()} - \{Thread.currentThread().threadId()}";
        System.out.println(STR."\{threadName} >>> \{message}");
    }
}
