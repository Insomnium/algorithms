package net.ins.edu.algorithms.hackerrank.java.basics;


import java.io.IOException;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;


class Result {
    public static String findDay(int month, int day, int year) {
        return LocalDate.of(year, month, day).getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.getDefault()).toUpperCase();
    }
}


public class JavaDateAndTime {
    public static void main(String[] args) throws IOException {
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//
//        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

//        int month = Integer.parseInt(firstMultipleInput[0]);
//
//        int day = Integer.parseInt(firstMultipleInput[1]);
//
//        int year = Integer.parseInt(firstMultipleInput[2]);

//        String res = Result.findDay(month, day, year);

//        bufferedWriter.write(res);
//        bufferedWriter.newLine();
//
//        bufferedReader.close();
//        bufferedWriter.close();

        System.out.println(Result.findDay(8, 5, 2015));
    }
}