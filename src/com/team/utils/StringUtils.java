package com.team.utils;

/**
 * A simple utility class for string manipulation.
 * (Placeholder for Team Member B's solution)
 */
public class StringUtils {

    /**
     * Reverses a given string.
     * @return The reversed string.
     */
    public static String reverse(String text) {
        return new StringBuilder(text).reverse().toString();
    }

    /**
     * A main method for testing just this class.
     * You can run this with the "run-file" Ant task.
     */
    public static void main(String[] args) {
        System.out.println("--- Testing StringUtils ---");
        String original = "Test String";
        String reversed = reverse(original);
        System.out.println("Original: " + original);
        System.out.println("Reversed: " + reversed);
    }
}

