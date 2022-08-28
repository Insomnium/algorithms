package net.ins.edu.algorithms.hackerrank.java.advanced;

import java.lang.reflect.Method;
import java.util.*;

public class JavaReflectionAttributes {

    public static void main(String[] args) throws ClassNotFoundException {
        // java 8+
        Arrays.stream(Class.forName("net.ins.edu.algorithms.hackerrank.java.advanced.Student").getMethods())
                .map(Method::getName)
                .sorted()
                .forEach(System.out::println);

        //
        System.out.println("===============================");
        //

        // java 7
        Set<String> uniqueMethodNames = new TreeSet<>();
        for (Method method : Student.class.getMethods()) {
            uniqueMethodNames.add(method.getName());
        }

        List<String> exclusions = new ArrayList<>();
        for (Method method : Object.class.getMethods()) {
            exclusions.add(method.getName());
        }

        for (String uniqueMethodName : uniqueMethodNames) {
            if (!exclusions.contains(uniqueMethodName)) {
                System.out.println(uniqueMethodName);
            }
        }
    }



}

