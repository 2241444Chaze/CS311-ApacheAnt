package com.team2.solutions.math;

public class MathSolutions {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        int org = x;
        int rev = 0;
        while (x != 0) {
            int digit = x % 10;
            rev = rev * 10 + digit;
            x /= 10;
        }
        return org == rev;
    }

    public boolean isPowerOfFour(int n) {
        if (n <= 0) {
            return false;
        }
        while (n % 4 == 0) {
            n /= 4;
        }
        return n == 1;

    }

    public int nextBeautifulNumber(int n) {
        for (int num = n + 1; ; num++) {
            if (isBalanced(num)) return num;
        }
    }

    private boolean isBalanced(int x) {
        int[] count = new int[10];
        char[] arr = String.valueOf(x).toCharArray();
        for (char c : arr) {
            count[c - '0']++;
        }
        for (int i = 0; i < 10; i++) {
            if (count[i] != 0 && count[i] != i)
                return false;
        }
        return true;
    }
}

