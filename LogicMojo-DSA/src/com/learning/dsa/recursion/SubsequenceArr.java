package com.learning.dsa.recursion;

import java.util.ArrayList;

public class SubsequenceArr {
    public static void main(String[] args) {
        int[] arr1 = new int[] {4, 6, 7, 8};
        printSubsequences(arr1, new ArrayList<>(), 0);

        int[] arr2 = new int[] {5, 3, 7, 4, 8, 1, 11};
        printSubsequencesAddUpToTarget(arr2, new ArrayList<>(), 0, 12, 0);

        int[] arr3 = new int[] {1, -5, 11, 4, 2};
        printFirstSubsequencesAddUpToTarget(arr3, new ArrayList<>(), 0, 7, 0);
    }

    private static void printSubsequences(int[] arr, ArrayList<Integer> bag, int i) {
        if (i == arr.length) {
            System.out.println(bag);
            return;
        }
        bag.add(arr[i]);
        printSubsequences(arr, bag, i+1);
        // remove last index
        bag.remove(bag.size() - 1);
        printSubsequences(arr, bag, i+1);
    }

    private static void printSubsequencesAddUpToTarget(int[] arr, ArrayList<Integer> bag, int i, int target, int sum) {
        if (sum > target || i == arr.length) {
            return;
        }
        if (sum == target) {
            System.out.println(bag);
            return;
        }
        /*if (i == arr.length){

            return;
        }*/

        bag.add(arr[i]);
        printSubsequencesAddUpToTarget(arr, bag, i+1, target, sum+arr[i]);
        // remove last index
        bag.remove(bag.size() - 1);
        printSubsequencesAddUpToTarget(arr, bag, i+1, target, sum);
    }

    private static boolean printFirstSubsequencesAddUpToTarget(int[] arr, ArrayList<Integer> bag, int i, int target, int sum) {
        if (sum > target) {
            return false;
        }
        if (i == arr.length){
            if (sum == target) {
                System.out.println(bag);
                return true;
            }
            return false;
        }

        bag.add(arr[i]);
        if (printFirstSubsequencesAddUpToTarget(arr, bag, i+1, target, sum+arr[i])) {
            return true;
        }

        // remove last index
        bag.remove(bag.size() - 1);
        return printFirstSubsequencesAddUpToTarget(arr, bag, i+1, target, sum);
    }
}
