package net.ins.edu.domain.service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ServiceB implements Service {

    private final ServiceC serviceC;

    @Override
    public void voidMethod() {
        System.out.println("ServiceB: voidMethod");
    }

    @Override
    public long process(long seconds) {
        try {
            System.out.println("ServiceB: processing...");
            Thread.sleep(seconds);
        } catch (InterruptedException e) {
            System.err.println("ServiceB: interrupted!");
            throw new RuntimeException(e);
        }
        System.out.println("ServiceB: done");
        return seconds;
    }

    public long processServiceC(long seconds) {
        return serviceC.process(seconds);
    }
}
