package net.ins.edu.basics;

public class InitOrder {

    private String str = "str";
    private int inty = 10;

    {
        String debug = "debug";
    }

    public InitOrder() {
        String debug = "debug";
    }

    public static void main(String[] args) {
        var io = new InitOrder();
        System.out.println("Done");
    }
}
