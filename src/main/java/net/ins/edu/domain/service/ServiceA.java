package net.ins.edu.domain.service;

public class ServiceA implements Service {

    @Override
    public void voidMethod() {
        System.out.println("ServiceA: voidMethod");
    }

    @Override
    public long process(long seconds) {
        try {
            System.out.println("ServiceA: processing...");
            Thread.sleep(seconds);
        } catch (InterruptedException e) {
            System.err.println("ServiceA: interrupted!");
            throw new RuntimeException(e);
        }
        System.out.println("ServiceA: done");
        return seconds;
    }
}
