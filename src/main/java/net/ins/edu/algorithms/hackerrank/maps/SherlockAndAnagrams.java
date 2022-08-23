package net.ins.edu.algorithms.hackerrank.maps;

/**
 * <a href="https://www.hackerrank.com/challenges/sherlock-and-anagrams/problem?isFullScreen=true&h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=dictionaries-hashmaps">Sherlock And Anagrams</a>
 */
public class SherlockAndAnagrams {

    public static int sherlockAndAnagrams(String s) {
        // Write your code here
        return -1; // TODO: implement
    }

    private static boolean areAnagrams(String left, String right) {
        return left.equals(new StringBuilder(right).reverse().toString());
    }

    public static void main(String[] args) {
        System.out.println(SherlockAndAnagrams.sherlockAndAnagrams("abba")); // 4: [a, a], [b, b], [ab, ba], [abb, bba]
    }

}
