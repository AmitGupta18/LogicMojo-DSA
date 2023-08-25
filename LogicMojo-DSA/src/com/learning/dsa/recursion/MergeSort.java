package com.learning.dsa.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeSort {
    public static void main(String[] args) {
        System.out.println(sort(5, Arrays.asList(5, 2, 7, 1, 3)));
    }
    public static List<Integer> sort(int n, List<Integer> nums) {
        // Write your code here
        if (n == 1) {
            return nums;
        }
        int i = 0;
        List<Integer> leftArr = new ArrayList<>();
        List<Integer> rightArr = new ArrayList<>();
        while(i < n) {
            if (i < n/2) {
                leftArr.add(nums.get(i++));
            } else {
                rightArr.add(nums.get(i++));
            }
        }
        List<Integer> left = sort(leftArr.size(), leftArr);
        List<Integer> right = sort(rightArr.size(), rightArr);
        return merge(left, right);
    }

    private static List<Integer> merge(List<Integer> arr1, List<Integer> arr2) {
        int i=0;
        int j=0;
        List<Integer> result = new ArrayList<>();

        while (i < arr1.size() && j < arr2.size()) {
            if (arr1.get(i) < arr2.get(j)) {
                result.add(arr1.get(i++));
            } else {
                result.add(arr2.get(j++));
            }
        }

        while (i < arr1.size()) {
            result.add(arr1.get(i++));
        }

        while (j < arr2.size()) {
            result.add(arr2.get(j++));
        }

        return result;
    }
}
