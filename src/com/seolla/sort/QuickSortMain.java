package com.seolla.sort;

import java.util.ArrayList;
import java.util.List;

public class QuickSortMain {
    public static void main(String[] args) {
        System.out.println(sort(List.of(10, 5, 2, 3)));
    }

    private static List<Integer> sort(List<Integer> arr) {
        if (arr.size() < 2) {
            return arr;
        } else {
            List<Integer> less = new ArrayList<>();
            List<Integer> greater = new ArrayList<>();
            int pivot = arr.get(0);
            for (int i = 1; i < arr.size(); i++) {
                if (arr.get(i) < pivot) {
                    less.add(arr.get(i));
                } else {
                    greater.add(arr.get(i));
                }
            }

            List<Integer> lessSorted = sort(less);
            List<Integer> greaterSorted = sort(greater);
            List<Integer> sortedArr = new ArrayList<>(lessSorted);
            sortedArr.add(pivot);
            sortedArr.addAll(greaterSorted);
            return sortedArr;
        }
    }
}
