package com.learning.dsa.recursion;

import java.util.Arrays;
import java.util.List;

public class QuickSort {
    public static void main(String[] args) {
        System.out.println(sort(Arrays.asList(5, 2, 7, 1, 3), 0, 4));
    }
    public static List<Integer> sort(List<Integer> nums, int low, int high) {
        if (low < high) {
            int pivotIdx = partition(nums, low, high);
            sort(nums, low, pivotIdx-1);
            sort(nums, pivotIdx+1, high);
        }
        return nums;
    }

    private static int partition(List<Integer> arr, int low, int high) {
        int pivot = arr.get(0);
        int right = high;

        for (int i = high; i > low; i--) {
            if (arr.get(i) > pivot) {
                swap(i, right--, arr);
            }
        }
        swap(low, right, arr);
        return right;
    }

    private static void swap(int left, int right, List<Integer> arr) {
        int temp = arr.get(right);
        arr.set(right, arr.get(left));
        arr.set(left, temp);
    }
}
