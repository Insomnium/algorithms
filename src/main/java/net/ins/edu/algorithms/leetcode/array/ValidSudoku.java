package net.ins.edu.algorithms.leetcode.array;

import java.util.HashSet;

public class ValidSudoku {

    private static final int BOX_DIM_SIZE = 3;
    private static final int BOARD_DIM_SIZE = 9;

    public boolean isValidSudoku(char[][] board) {
        return validateRows(board) && validateColumns(board) && validateBoxes(board);
    }

    private boolean validateRows(char[][] board) {
        for (char[] row : board) {
            int nonEmptyCellsCount = 0;
            var currRow = new HashSet<Character>();
            for (char c : row) {
                if (c != '.') {
                    currRow.add(c);
                    nonEmptyCellsCount++;
                }
            }
            if (nonEmptyCellsCount != currRow.size()) {
                return false;
            }
        }
        return true;
    }

    private boolean validateColumns(char[][] board) {
        for (int i = 0; i < BOARD_DIM_SIZE; i++) {
            var column = new HashSet<Character>();
            int nonEmptyCellsCount = 0;
            for (int j = 0; j < BOARD_DIM_SIZE; j++) {
                var c = board[j][i];
                if (c != '.') {
                    column.add(c);
                    nonEmptyCellsCount++;
                }
            }
            if (nonEmptyCellsCount != column.size()) {
                return false;
            }
        }
        return true;
    }

    private boolean validateBoxes(char[][] board) {
        for (int y = 0; y < BOARD_DIM_SIZE; y += BOX_DIM_SIZE) {
            for (int x = 0; x < BOARD_DIM_SIZE; x += BOX_DIM_SIZE) {
                if (!validateBox(board, y, x)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean validateBox(char[][] board, int fromY, int fromX) {
        var box = new HashSet<Character>();
        int nonEmptyCellsCount = 0;
        for (int y = fromY; y < fromY + BOX_DIM_SIZE; y++) {
            for (int x = fromX; x < fromX + BOX_DIM_SIZE; x++) {
                var c = board[y][x];
                if (c != '.') {
                    box.add(c);
                    nonEmptyCellsCount++;
                }
            }
        }

        return nonEmptyCellsCount == box.size();
    }

    public static void main(String[] args) {
        var board = new char[][] {
                new char[] { '5','3','.','.','7','.','.','.','.' },
                new char[] { '6','.','.','1','9','5','.','.','.' },
                new char[] { '.','9','8','.','.','.','.','6','.' },
                new char[] { '8','.','.','.','6','.','.','.','3' },
                new char[] { '4','.','.','8','.','3','.','.','1' },
                new char[] { '7','.','.','.','2','.','.','.','6' },
                new char[] { '.','6','.','.','.','.','2','8','.' },
                new char[] { '.','.','.','4','1','9','.','.','5' },
                new char[] { '.','.','.','.','8','.','.','7','9' }
        };
        System.out.println(new ValidSudoku().isValidSudoku(board));
    }
}
