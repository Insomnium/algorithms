package net.ins.edu.collections;

import net.ins.edu.domain.Employee;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Streams {

    private static final List<String> domains = List.of("mail.org", "gmail.com", "yandex.ru");

    public static void main(String[] args) {
        var employees = Stream.iterate(0, idx -> idx + 1)
                .limit(10)
                .map(idx -> new Employee(idx, String.format("email%s@%s", idx, domains.get(idx % domains.size()))))
                .collect(Collectors.toList());

        var result = employees.stream()
                .collect(Collectors.filtering(e -> e.getId() % 2 == 0,
                        Collectors.groupingBy(e -> e.getEmail().substring(e.getEmail()
                                .indexOf('@') + 1), Collectors.mapping(Employee::getEmail, Collectors.toList()))));

        result.forEach((k, v) -> System.out.printf("%s = %s\n", k, v));
    }
}
