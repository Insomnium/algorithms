package net.ins.edu.algorithms.hackerrank.maps;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * <a href="https://www.hackerrank.com/challenges/ctci-ransom-note/problem?isFullScreen=true&h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=dictionaries-hashmaps">CTCI Ransom Note</a>
 */
public class CTCIRansomNote {

    public static void checkMagazine(List<String> magazine, List<String> note) {
        var source = groupByWord(magazine);
        var target = groupByWord(note);

        for (Map.Entry<String, Long> desiredCapacity : target.entrySet()) {
            if (!source.containsKey(desiredCapacity.getKey()) || source.get(desiredCapacity.getKey()) < desiredCapacity.getValue()) {
                System.out.println("No");
                return;
            }
        }

        System.out.println("Yes");
    }

    private static Map<String, Long> groupByWord(List<String> magazine) {
        return magazine.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    public static void main(String[] args) {
        CTCIRansomNote.checkMagazine(
                Arrays.stream("give me one grand today night and one tomorrow".split(" ")).toList(),
                Arrays.stream("give one grand today one tomorrow".split(" ")).toList()
        ); // Yes

        CTCIRansomNote.checkMagazine(
                Arrays.stream("two times three is not four".split(" ")).toList(),
                Arrays.stream("two times two is four".split(" ")).toList()
        ); // No
    }
}
