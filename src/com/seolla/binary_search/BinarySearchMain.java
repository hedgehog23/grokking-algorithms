package com.seolla.binary_search;

import java.util.stream.IntStream;

public class BinarySearchMain {

    public static void main(String[] args) {
        int[] sortedArr0 = IntStream.range(1, 2).toArray();
        assert search(32, sortedArr0) == -1;
        int[] sortedArr1 = IntStream.range(1, 50).toArray();
        assert search(32, sortedArr1) == 31;
        int[] sortedArr2 = IntStream.range(1, 102).toArray();
        assert search(101, sortedArr2) == 100;
        int[] sortedArr3 = IntStream.range(5, 102).toArray();
        assert search(4, sortedArr3) == -1;
        int[] sortedArr4 = IntStream.range(3, 900).toArray();
        assert search(3, sortedArr4) == 0;
    }

    private static int search(int search, int[] sortedArr) {
        int low = 0;
        int high = sortedArr.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            int guess = sortedArr[mid];

            if (guess == search) {
                return mid;
            }

            if (guess > search) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return -1;
    }
}
