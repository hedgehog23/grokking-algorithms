package com.seolla.recursion;

import java.util.Arrays;

/**
 * @author sergeylapko
 */
public class RecursionMain {
    public static void main(String[] args) {
//        System.out.println(factorial(5));
//        System.out.println(fibonacci(50));
        System.out.println(size(new int[]{1, 2, 3, 4}));
    }

    public static void countdown(int i) {
        if (i > 0) {
            System.out.println(i);
            countdown(i - 1);
        }
    }

    public static int factorial(int i) {
        if (i > 1) {
            return i * factorial(i - 1);
        } else {
            return 1;
        }
    }

    public static int fibonacci(int i) {
        if (i == 0) {
            return 0;
        } else if (i == 1) {
            return 1;
        } else {
            return fibonacci(i - 1) + fibonacci(i - 2);
        }
    }

    public static int sum(int[] arr) {
        if (arr.length == 0) {
             return 0;
        } else if (arr.length == 1) {
            return arr[0];
        } else {
            return arr[0] + sum(Arrays.copyOfRange(arr, 1, arr.length));
        }
    }

    public static int size(int[] arr) {
        if (arr.length == 0) {
            return 0;
        } else {
            return 1 + size(Arrays.copyOfRange(arr, 1, arr.length));
        }
    }
}
