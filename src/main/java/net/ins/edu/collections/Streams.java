package net.ins.edu.collections;

import net.ins.edu.domain.Employee;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Streams {

    private static final List<String> domains = List.of("mail.org", "gmail.com", "yandex.ru");

    public static void main(String[] args) {
        var employees = Stream.iterate(0, idx -> idx + 1)
                .limit(10)
                .map(idx -> new Employee(idx, String.format("email%s@%s", idx, domains.get(idx % domains.size()))))
                .toList();

        var result = employees.stream()
                .collect(Collectors.filtering(e -> e.getId() % 2 == 0,
                        Collectors.groupingBy(e -> e.getEmail().substring(e.getEmail()
                                .indexOf('@') + 1), Collectors.mapping(Employee::getEmail, Collectors.toList()))));

        result.forEach((k, v) -> System.out.printf("%s = %s\n", k, v));

        // maps
        var mapToConvertValues = Map.of("1", 1, "2", 2);

        Map<String, String> convertedMap = mapToConvertValues.entrySet()
                .stream()
                .collect(Collectors.toMap(Map.Entry::getKey, e -> e.getValue().toString()));
        System.out.println(convertedMap);

        // flattening
        List<List<String>> partitions = List.of(
                List.of("3", "4"),
                List.of("1", "2"),
                List.of("5", "6")
        );

        var ordered = partitions.stream()
                .flatMap(Collection::stream)
                .sorted()
                .toList();
        System.out.println(ordered);
    }
}
