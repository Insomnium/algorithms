package net.ins.edu.algorithms.strings;

import java.util.ArrayList;
import java.util.List;

public class StringPermutations {

    private List<String> permutations = new ArrayList<>();

    public List<String> findAll(String s) {
        find("", s);
        return permutations;
    }

    private void find(String fixedPerm, String word) {
        if (word.isEmpty()) {
            permutations.add(fixedPerm + word);
        } else {
            for (int i = 0; i < word.length(); i++) {
                find(fixedPerm + word.charAt(i), word.substring(0, i) + word.substring(i+1));
            }
        }
    }

    public static void main(String[] args) {
        List<String> result = new StringPermutations().findAll("123");
        System.out.println(result);
    }
}
