package net.ins.edu.domain.service;

public class ServiceC implements Service {

    @Override
    public void voidMethod() {
        System.out.println("ServiceC: voidMethod");
    }

    @Override
    public long process(long seconds) {
        try {
            System.out.println("ServiceC: processing...");
            Thread.sleep(seconds);
        } catch (InterruptedException e) {
            System.err.println("ServiceC: interrupted!");
            throw new RuntimeException(e);
        }
        System.out.println("ServiceC: done");
        return seconds;
    }
}
