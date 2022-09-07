package net.ins.edu.algorithms.hackerrank.warmup;

public class ReverseString {

    public String reverse(String s) {
        return new String(reverseRecursive(s.toCharArray(), 0, s.length()-1));
    }

    private String reverseIterative(String s) {
        var chars = s.toCharArray();
        var aux = new char[s.length()];
        int k = 0;
        for (int i = chars.length - 1; i >= 0; i--) {
            aux[k++] = chars[i];
        }
        return new String(aux);
    }

    private char[] reverseRecursive(char[] source, int i, int j) {
        if (i > j) {
            return source;
        }
        swap(source, i, j);
        return reverseRecursive(source, i+1, j-1);
    }

    private void swap(char[] chars, int i, int j) {
        char tmp = chars[i];
        chars[i] = chars[j];
        chars[j] = tmp;
    }

    public static void main(String[] args) {
        System.out.println(new ReverseString().reverse("Hello"));
    }
}
