package net.ins.edu.algorithms.hackerrank.java.basics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class JavaLoopsII {

    public static void main(String[] args) throws IOException {
            Scanner scanner = new Scanner(System.in);

            int sampleCount = scanner.nextInt(), i = 0;
            while (i < sampleCount) {
                int a = scanner.nextInt(), b = scanner.nextInt(), n = scanner.nextInt();
                i++;

                int s = 0;
                for (int j = 0; j < n; j++) {
                    s += Math.pow(2, j) * b;
                    System.out.printf("%d ", a + s);
                }
                System.out.println();
            }

            scanner.close();
        }
}
