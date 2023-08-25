package com.learning.dsa.recursion;

import java.util.Arrays;

public class ReverseArray {
    public static void main(String[] args) {
        int[] arr = new int[] {5,4,8,1,6, 7};
        reverse(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    private static void reverse(int[] arr, int startIdx, int endIdx) {
        if (startIdx >= endIdx) {
            return;
        }
        swap(arr, startIdx++, endIdx--);
        reverse(arr, startIdx, endIdx);
    }

    private static void swap(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}
