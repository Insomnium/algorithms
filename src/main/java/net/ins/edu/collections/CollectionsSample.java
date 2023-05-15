package net.ins.edu.collections;

import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Spliterator;
import java.util.stream.IntStream;

public class CollectionsSample {

    public static void main(String[] args) {

        var list = generateIntegersList(10);

        Spliterator<Integer> spliterator = list.spliterator();

        int size = 0;
        while (spliterator.tryAdvance(i -> {
            System.out.printf("Doing nothing with: %s\n", i);
        })) {
            size++;
        }
        System.out.println("The size was: " + size);

        var split1 = generateIntegersList(10).spliterator();
        var split2 = split1.trySplit();
        var split3 = split2.trySplit();
        System.out.printf("Sizes of spliterators are: %s, %s and %s\n", split1.estimateSize(), split2.estimateSize(),
                split3.estimateSize());
    }

    @NotNull
    private static List<Integer> generateIntegersList(int count) {
        return IntStream.range(0, count)
                .boxed()
                .toList();
    }
}
