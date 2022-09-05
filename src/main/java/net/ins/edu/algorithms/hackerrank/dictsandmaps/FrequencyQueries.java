package net.ins.edu.algorithms.hackerrank.dictsandmaps;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class FrequencyQueries {

    static List<Integer> freqQuery(List<List<Integer>> queries) {
        Map<Integer, Integer> store = new HashMap<>();
        Map<Integer, Integer> frequencies = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        queries.forEach(q -> {
            int operation = q.get(0), value = q.get(1);
            switch (operation) {
                case 1: {
                    Integer currFreq = store.getOrDefault(value, 0);
                    Integer newFreq = currFreq + 1;
                    store.put(value, newFreq);
                    frequencies.put(newFreq, frequencies.getOrDefault(newFreq, 0) + 1);
                    frequencies.put(currFreq, frequencies.getOrDefault(currFreq, 1) - 1);
                    break;
                }
                case 2: {
                    Integer currFreq = store.getOrDefault(value, 0);
                    Integer newFreq = currFreq - 1;
                    if (currFreq > 0) {
                        store.put(value, newFreq);
                        frequencies.put(newFreq, frequencies.getOrDefault(newFreq, 0) + 1);
                        frequencies.put(currFreq, frequencies.getOrDefault(currFreq, 1) - 1);
                    }
                    break;
                }
                case 3:
                    result.add(frequencies.getOrDefault(value, 0) > 0 ? 1 : 0);
                    break;
            }
        });
        return result;
    }

    public static void main(String[] args) throws IOException {
//        List<List<Integer>> input = List.of(
//                List.of(1, 5),
//                List.of(1, 6),
//                List.of(3, 2),
//                List.of(1, 10),
//                List.of(1, 10),
//                List.of(1, 6),
//                List.of(2, 5),
//                List.of(3, 2)
//        );
//
//        System.out.println(FrequencyQueries.freqQuery(input));

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(FrequencyQueries.class.getClassLoader().getResourceAsStream("dictionaries_and_hasmaps-frequency-queries.txt")));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("out.txt"));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> queries = new ArrayList<>();

        IntStream.range(0, q).forEach(i -> {
            try {
                queries.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        List<Integer> ans = freqQuery(queries);

        bufferedWriter.write(
                ans.stream()
                        .map(Object::toString)
                        .collect(joining("\n"))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
