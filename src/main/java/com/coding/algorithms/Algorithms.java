/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.coding.algorithms;

/**
 *
 * @author ziad
 */
public final class Algorithms {

    //O(n^2) Time Complexity. 
    public static boolean isPermutation(String a, String b) {

        if (a.length() != b.length()) {
            return false;
        }

        int[] characterArray = new int[128];

        for (int i = 0; i < a.length(); i++) {
            characterArray[a.charAt(i)]++;
        }

        for (int i = 0; i < b.length(); i++) {
            characterArray[b.charAt(i)]--;
            if (characterArray[b.charAt(i)] < 0) {
                return false;
            }
        }
        return true;
    }

    //O(n) Time Complexity
    public static boolean isUnique(String a) {
        if (a.length() > 128) {
            return false;
        }

        boolean[] letters = new boolean[128];

        for (int i = 0; i < a.length(); i++) {

            int letter = a.charAt(i);
            if (letters[letter]) {
                return false;
            }
            letters[letter] = true;
        }
        return true;
    }

    public static boolean isOneAway(String a, String b) {
        if (a.length() == b.length()) {
            return editReplace(a, b);
        } else {
            if (a.length() + 1 == b.length()) {
                return editInsert(a, b);
            }

            if (a.length() - 1 == b.length()) {
                return editInsert(b, a);
            }
        }

        return false;

    }

    private static boolean editInsert(String a, String b) {
        int index1 = 0;
        int index2 = 0;
        while (index1 < a.length() && index2 < b.length()) {
            if (a.charAt(index1) != b.charAt(index2)) {
                if (index1 != index2) {
                    return false;
                }
                index2++;
            } else {
                index1++;
                index2++;
            }
        }
        return true;
    }

    private static boolean editReplace(String a, String b) {
        boolean isFound = false;

        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                if (isFound) {
                    return false;
                }
                isFound = true;
            }
        }
        return true;
    }

    public static int maxProfits(int[] prices) {

        int profits = 0;

        for (int i = 0; i < prices.length; i++) {
            for (int j = 0; j < prices.length; j++) {
                int potentialProfit = prices[j] - prices[i];
                if (potentialProfit > profits) {
                    profits = potentialProfit;
                }
            }
        }

        return profits;

    }

    public static boolean isPalindrome(String s) {

        int[] phraseToArray = buildCharTable(s);
        return checkMaxOdd(phraseToArray);

    }

    private static boolean checkMaxOdd(int[] chars) {
        boolean foundOdd = false;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] % 2 == 1) {
                if (foundOdd) {
                    return false;
                }
                foundOdd = true;
            }
        }
        return true;
    }

    private static int getCharNumber(Character c) {
        int a = Character.getNumericValue('a');
        int z = Character.getNumericValue('z');
        int val = Character.getNumericValue(c);

        if (z >= val && val >= a) {
            return val - a;
        }

        return -1;

    }

    private static int[] buildCharTable(String phrase) {
        int[] charTable = new int[Character.getNumericValue('z')
                - Character.getNumericValue('a') + 1];
        for (char c : phrase.toCharArray()) {
            int x = getCharNumber(c);
            if (x != -1) {
                charTable[x]++;
            }
        }

        return charTable;

    }

}
