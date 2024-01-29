package org.example;

import java.util.HashSet;

public class Main {
    public static boolean isValidSudoku(char[][] board) {
        HashSet<Character> set;
        for (int i = 0; i < 9; i++) {
            set = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                char digit = board[i][j];
                if (digit != '.') {
                    if (!set.add(digit)) return false;
                }
            }
        }

        for (int i = 0; i < 9; i++) {
            set = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                char digit = board[j][i];
                if (digit != '.') {
                    if (!set.add(digit)) return false;
                }
            }
        }

        for (int row_offset = 0; row_offset < 3; row_offset++) {
            for (int col_offset = 0; col_offset < 3; col_offset++) {
                set = new HashSet<>();
                for (int i = row_offset * 3; i < row_offset * 3 + 3; i++) {
                    for (int j = col_offset * 3; j < col_offset * 3 + 3; j++) {
                        char digit = board[i][j];
                        if (digit != '.') {
                            if (!set.add(digit)) return false;
                        }
                    }
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(isValidSudoku(new char[][] {
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        }));
    }
}