package net.ins.edu.algorithms.leetcode.strings;

/**
 * <a href="https://leetcode.com/explore/interview/card/top-interview-questions-easy/127/strings/880/">Reverse Integer</a>
 */
public class ReverseInteger {

    public int reverse(int x) {
        var xStr = String.valueOf(x);
        var aux = x < 0 ? xStr.substring(1) : xStr;

        var resultBuilder = new StringBuilder(x < 0 ? "-" : "");
        var auxArray = aux.toCharArray();
        for (int i = auxArray.length - 1; i >= 0 ; i--) {
            resultBuilder.append(auxArray[i]);
        }

        try {
            return Integer.parseInt(resultBuilder.toString());
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    public static void main(String[] args) {
        System.out.println(new ReverseInteger().reverse(123));
        System.out.println(new ReverseInteger().reverse(-123));
        System.out.println(new ReverseInteger().reverse(120));
    }
}
