package com.seolla.dynamic_programming;

import static java.lang.Math.max;

public class LongestCommonSubstringAlgorithm {
    public int[][] find(String horizontal, String vertical) {
        int[][] grid = new int[vertical.length()][horizontal.length()];
        for (int i = 0; i < vertical.length(); i++) {
            char verticalChar = vertical.charAt(i);
            for (int j = 0; j < horizontal.length(); j++) {
                char horizontalChar = horizontal.charAt(j);
                grid[i][j] = getCommonNumberOfChars(verticalChar, horizontalChar, grid, i, j);
            }
        }
        return grid;
    }

    private int getCommonNumberOfChars(char verticalChar, char horizontalChar, int[][] grid, int i, int j) {
        boolean match = verticalChar == horizontalChar;
        int value;

        if (i != 0 && j != 0) {
            if (match) {
                value = grid[i - 1][j - 1] + 1;
            } else {
                value = max(grid[i - 1][j], grid[i][j - 1]);
            }
        } else if (i == 0 && j != 0) {
            value = match ? grid[i][j - 1] + 1 : grid[i][j - 1];
        } else if (i != 0) {
            value = match ? grid[i - 1][j] + 1 : grid[i - 1][j];
        } else {
            value = match ? 1 : 0;
        }
        return value;
    }
}
