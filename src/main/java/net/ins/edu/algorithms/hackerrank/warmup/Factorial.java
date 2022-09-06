package net.ins.edu.algorithms.hackerrank.warmup;

public class Factorial {

    public long factorial(long n) {
        if (n == 1) return 1;
        return n * factorial(n-1);
    }

    public static void main(String[] args) {
        System.out.println(new Factorial().factorial(4)); // 24
        System.out.println(new Factorial().factorial(5)); // 120
        System.out.println(new Factorial().factorial(20)); // 2432902008176640000
    }
}
