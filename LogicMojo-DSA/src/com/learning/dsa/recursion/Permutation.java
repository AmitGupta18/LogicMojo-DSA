package com.learning.dsa.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutation {
    public static void main(String[] args) {
        int n = 3;
        System.out.println(createPermutation(new ArrayList<>(List.of(1, 2, 3))));
    }

    private static List<List<Integer>> createPermutation(List<Integer> nums) {
        if (1 == nums.size()) {
           return new ArrayList<>(List.of(new ArrayList<>(nums)));
        }

        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i<nums.size(); i++) {
            // pop out 1st element
            // since this item will be added at the end, each iteration will pop out new item
            int popped = nums.remove(0);
            List<List<Integer>> perms = createPermutation(nums);

            for (List<Integer> perm: perms) {
                // Add popped out element to permutation on backtrack
                perm.add(popped);
            }

            result.addAll(new ArrayList<>(perms));
            // Add popped out elem at end, so that next item will be popped out in next iteration
            nums.add(popped);
        }
        return result;
    }
}
