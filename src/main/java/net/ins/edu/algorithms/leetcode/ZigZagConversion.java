package net.ins.edu.algorithms.leetcode;

/**
 * <a href="https://leetcode.com/problems/zigzag-conversion/">Zigzag Conversion</a>
 */
public class ZigZagConversion {

    public String convert(String s, int numRows) {
        if (numRows <= 1) return s;

        var matrix = new char[numRows][s.length()];
        int cnt = 0;
        int pdi = numRows - 1; // previous diagonal index
        char[] chars = s.toCharArray();
        var fullColumn = true;
        var done = false;

        for (int x = 0; ; ) {

            for (int y = 0; y < numRows; y++) {

                if (fullColumn) {
                    matrix[y][x] = chars[cnt++];
                } else {
                    if (y == pdi - 1) {
                        matrix[y][x] = chars[cnt++];
                        pdi--;
                    }
                }

                if (y >= numRows - 1) {
                    x++;
                    fullColumn = pdi <= 1;
                    if (fullColumn) {
                        pdi = numRows - 1;
                    }
                }

                if (cnt >= chars.length) {
                    done = true;
                    break;
                }
            }

            if (done) break;
        }

        return readMatrix(matrix);
    }

    private String readMatrix(char[][] matrix) {
        var builder = new StringBuilder();
        for (char[] arr : matrix) {
            for (char c : arr) {
//                System.out.print(c == 0 ? ' ' : c);
                if (c != 0) {
                    builder.append(c);
                }
            }
//            System.out.println();
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        System.out.println(new ZigZagConversion().convert("PAYPALISHIRING", 3));
        System.out.println(new ZigZagConversion().convert("PAYPALISHIRING", 4));
        System.out.println(new ZigZagConversion().convert("PAYPALISHIRING", 2));
        System.out.println(new ZigZagConversion().convert("PAYPALISHIRING", 1));
        System.out.println(new ZigZagConversion().convert("AB", 1));
        System.out.println(new ZigZagConversion().convert("A", 2));
    }
}
