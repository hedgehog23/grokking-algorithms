package com.seolla.sort;

import java.util.Arrays;

/**
 * @author sergeylapko
 */
public class SelectionSortMain {
    public static void main(String[] args) {
        int[] array0 = new int[]{156, 141, 35, 94, 88, 61, 111};
        sortAsc(array0);
        System.out.println(Arrays.toString(array0));

        int[] array1 = new int[]{5, 3, 6, 2, 10};
        sortAsc(array1);
        System.out.println(Arrays.toString(array1));
    }

    public static void sortAsc(int[] input) {
        for (int i = 0; i < input.length - 1; i++) {
            int low = input[i];
            int index = i;
            for (int j = i + 1; j < input.length; j++) {
                int test = input[j];
                if (test < low) {
                    low = test;
                    index = j;
                }
            }
            input[index] = input[i];
            input[i] = low;
        }
    }
}
