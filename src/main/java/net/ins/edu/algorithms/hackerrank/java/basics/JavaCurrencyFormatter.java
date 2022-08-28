package net.ins.edu.algorithms.hackerrank.java.basics;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

public class JavaCurrencyFormatter {

    private static void format(double amount) {
        System.out.printf("US: %s\n", NumberFormat.getCurrencyInstance(Locale.US).format(amount));
//        System.out.printf("India: %s\n", new DecimalFormat("", ).format(amount));
        System.out.printf("India: %s\n", NumberFormat.getCurrencyInstance(new Locale("us", "in")).format(amount));
        System.out.printf("China: %s\n", NumberFormat.getCurrencyInstance(Locale.CHINA).format(amount));
        System.out.printf("France: %s\n", NumberFormat.getCurrencyInstance(Locale.FRANCE).format(amount));
    }

    public static void main(String[] args) {
        format(1234.123);
    }
}
