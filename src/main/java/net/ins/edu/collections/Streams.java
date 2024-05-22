package net.ins.edu.collections;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.Collections.shuffle;

public class Streams {

    private static final List<String> domains = List.of("mail.org", "gmail.com", "yandex.ru");

    public static void main(String[] args) {
//        var employees = Stream.iterate(0, idx -> idx + 1)
//                .limit(10)
//                .map(idx -> new Employee(idx, String.format("email%s@%s", idx, domains.get(idx % domains.size()))))
//                .toList();
//
//        var result = employees.stream()
//                .collect(Collectors.filtering(e -> e.getId() % 2 == 0,
//                        Collectors.groupingBy(e -> e.getEmail().substring(e.getEmail()
//                                .indexOf('@') + 1), Collectors.mapping(Employee::getEmail, Collectors.toList()))));
//
//        result.forEach((k, v) -> System.out.printf("%s = %s\n", k, v));

        // maps
        var mapToConvertValues = Map.of("1", 1, "2", 2);

        Map<String, String> convertedMap = mapToConvertValues.entrySet()
                .stream()
                .collect(Collectors.toMap(Map.Entry::getKey, e -> e.getValue().toString()));
        System.out.println("The map with converted values:" + convertedMap);

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
        System.out.println("Flattened and sorted collection" + ordered);

        // generating int array
        List<Integer> integers = IntStream.range(0, 100)
                .boxed()
                .collect(Collectors.toCollection(ArrayList::new));
        shuffle(integers);
        int[] randomArray = integers.stream()
                .mapToInt(i -> i)
                .toArray();
        System.out.println("Randomly generated array: " + Arrays.toString(randomArray));

        System.out.println(findRoomWithHighestAgeEmployee());

        System.out.println(findRoomWithEmployeeOfAge(makeRooms(), 50));
    }

    private static Room findRoomWithHighestAgeEmployee() {
        return makeRooms().stream()
                .filter(r -> !r.employees.isEmpty())
                .max(((o1, o2) -> o1.employees.stream().max(Comparator.comparingInt(e -> e.age)).map(Employee::age).orElse(0) - o2.employees.stream().max(Comparator.comparingInt(e -> e.age)).map(Employee::age).orElse(0)))
                .orElse(null);
    }

    private static Room findRoomWithEmployeeOfAge(List<Room> rooms, int age) {
        return rooms.stream()
                .filter(r -> r.employees.stream().anyMatch(e -> e.age == age))
                .findFirst()
                .orElse(null);
    }

    record Employee(int id, int age) {
    }

    record Room(int id, List<Employee> employees) {
    }

    private static List<Room> makeRooms() {
        return List.of(
                new Room(1, List.of(
                        new Employee(0, 50),
                        new Employee(1, 55)
                )),
                new Room(2, List.of(
                        new Employee(2, 70),
                        new Employee(0, 60)
                )),
                new Room(3, List.of(
                        new Employee(2, 50),
                        new Employee(0, 75)
                ))
        );
    }
}
