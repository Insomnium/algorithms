package net.ins.edu.java;

import java.util.function.Supplier;

public class ObjectConstructionOrder {

    static {
        System.out.println("Static init block");
    }

    private String field = ((Supplier<String>) () -> {
        System.out.println("Inline initialization");
        return "123";
    }).get();

    public ObjectConstructionOrder() {
        System.out.println("Constructor");
    }

    {
        System.out.println("Init block");
    }

    public static void main(String[] args) {
        new ObjectConstructionOrder();
    }
}
