package net.ins.edu.algorithms.hackerrank.java.advanced;

import net.ins.edu.algorithms.Tmp;

import java.util.ArrayList;
import java.util.List;

public class JavaVarargsSum {

    public static void main(String[] args) {
        new Add().add(1, 2, 3, 4, 5, 6);
    }

    public static class Add {
        public void add(int... values) {
            int exceptWhenArgsCountIs = 4;
            for (int i = 1; i < values.length; i++) {
                int sum = 0;
                List<String> additions = new ArrayList<>();
                for (int j = 0; j <= i; j++) {
                    additions.add(String.valueOf(values[j]));
                    sum += values[j];
                }
                if (additions.size() != exceptWhenArgsCountIs) {
                    System.out.printf("%s=%s\n", String.join("+", additions), sum);
                }
            }
        }
    }
}
