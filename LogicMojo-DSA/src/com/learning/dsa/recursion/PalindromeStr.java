package com.learning.dsa.recursion;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class PalindromeStr {
    public static void main(String[] args) {
        String str1 = "xyz";
        Optional<String> str2 = Optional.ofNullable(str1).map(s -> s.toLowerCase());
        System.out.println(str2.orElse("abc"));
        /*String str = "abcba";
        System.out.println(checkPalindrome(str, 0, str.length()-1));*/
    }

    private static boolean checkPalindrome(String str, int start, int end) {
        if (start >= end) {
            return true;
        }
        if (str.charAt(start++) != str.charAt(end--)) {
            return false;
        }
        return checkPalindrome(str, start, end);
    }
}
