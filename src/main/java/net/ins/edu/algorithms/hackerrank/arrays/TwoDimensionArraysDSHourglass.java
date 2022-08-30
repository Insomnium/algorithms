package net.ins.edu.algorithms.hackerrank.arrays;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TwoDimensionArraysDSHourglass {

    private static final int HOURGLASS_WIDTH = 3;
    private static final int HOURGLASS_HEIGHT = 3;
    private static final int HOURGLASS_MID_Y_LAYER_NUM = 2;
    private static final int HOURGLASS_MID_X_LAYER_NUM = 2;

    public static void main(String[] args) {
//        var list = List.of(
//                List.of(-9, -9, -9, 1, 1, 1),
//                List.of(0, -9, 0, 4, 3, 2),
//                List.of(-9, -9, -9, 1, 2, 3),
//                List.of(0, 0, 8, 6, 6, 0),
//                List.of(0, 0, 0, -2, 0, 0),
//                List.of(0, 0, 1, 2, 4, 0)
//        );
        var list = List.of(
                List.of(-1, -1, 0, -9, -2, -2),
                List.of(-2, -1, -6, -8, -2, -5),
                List.of(-1, -1, -1, -2, -3, -4),
                List.of(-1, -9, -2, -4, -4, -5),
                List.of(-7, -3, -3, -2, -9, -9),
                List.of(-1, -3, -1, -2, -4, -5)
        );
        System.out.println(maxHourglassSum(list));
    }

    private static int maxHourglassSum(List<List<Integer>> list) {
        if (list.isEmpty()) throw new IllegalArgumentException("List can not be empty");
        var yMax = list.size();
        var xMax = list.get(0).size();
        var maxHourglassSum = Integer.MIN_VALUE;
        for (int yy = 0; yy < yMax; yy++) {
            for (int xx = 0; xx < xMax; xx++) {
                var hourglass = extractHourglass(list, xx, yy);
                if (!hourglass.isEmpty()) {
                    maxHourglassSum = Math.max(maxHourglassSum, hourglass.stream().mapToInt(Integer::intValue).sum());
                }
            }
        }
        return maxHourglassSum;
    }

    @NotNull
    private static List<Integer> extractHourglass(List<List<Integer>> list, int x, int y) {
        if (y + HOURGLASS_MID_Y_LAYER_NUM >= list.size() || x + HOURGLASS_MID_X_LAYER_NUM >= list.get(0).size())
            return Collections.emptyList();

        var result = new ArrayList<Integer>();
        int yCnt = 1;
        for (int yy = y; yy < HOURGLASS_HEIGHT + y; yy++) {
            var yLayer = list.get(yy);
            int xCnt = 1;
            for (int xx = x; xx < HOURGLASS_WIDTH + x; xx++) {
                var value = yLayer.get(xx);
                if (yCnt == HOURGLASS_MID_Y_LAYER_NUM) {
                    if (xCnt == HOURGLASS_MID_X_LAYER_NUM) {
                        result.add(value);
                    }
                } else {
                    result.add(value);
                }
                xCnt++;
            }
            yCnt++;
        }
        return result;
    }
}
