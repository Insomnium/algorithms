package net.ins.edu.algorithms.hackerrank.java.basics;

import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class JavaDatatypes {

    public static void main(String[] args) throws IOException {
            Scanner scanner = new Scanner(System.in);
            scanner.nextLine(); // skip first line

            while(scanner.hasNext()) { // Long.MAX_VALUE = 9223372036854775807
                var next = scanner.nextLine();
                char[] charArray = next.toCharArray();
                long sign = 1;
                long buffer = 0;
                boolean longOverflow = false;
                for (char c : charArray) {
                    if (c == '-') {
                        sign = -1;
                        continue;
                    }
                    int i = Character.getNumericValue(c);
                    if (sign > 0 && (buffer > Long.MAX_VALUE / 10 || (buffer == Long.MAX_VALUE / 10 && i > 7))) {
                        buffer = Long.MAX_VALUE;
                        longOverflow = true;
                        break;
                    } else if (sign < 0 && (buffer < Long.MIN_VALUE / 10 || (buffer == Long.MIN_VALUE / 10 && i < -8))) {
                        buffer = Long.MIN_VALUE;
                        longOverflow = true;
                        break;
                    } else {
                        buffer = buffer * 10 + (i * sign);
                    }
                }

                List<String> fittingDataTypes = new ArrayList<>();
                if (buffer <= Byte.MAX_VALUE && buffer >= Byte.MIN_VALUE) {
                    fittingDataTypes.add("byte");
                }
                if (buffer <= Short.MAX_VALUE && buffer >= Short.MIN_VALUE) {
                    fittingDataTypes.add("short");
                }
                if (buffer <= Integer.MAX_VALUE && buffer >= Integer.MIN_VALUE) {
                    fittingDataTypes.add("int");
                }
                if (!longOverflow) {
                    fittingDataTypes.add("long");
                }

                if (fittingDataTypes.isEmpty()) {
                    System.out.printf("%s can't be fitted anywhere.\n", next);
                    continue;
                }

                System.out.printf("%s can be fitted in:\n", next);
                for (String fittingDataType : fittingDataTypes) {
                    System.out.printf("* %s\n", fittingDataType);
                }
            }

            scanner.close();
        }
}
