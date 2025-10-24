package com.team;

import com.team.math.Calculator;
import com.team.utils.StringUtils;

/**
 * The main entry point for the team's project.
 */
public class MainApp {

    /**
     * The main method that runs the application.
     */
    public static void main(String[] args) {
        System.out.println("--- Running Main Project Application ---");

        // 1. Using the Calculator class
        int sum = Calculator.add(5, 10);
        System.out.println("Result from Calculator: 5 + 10 = " + sum);

        // 2. Using the StringUtils class
        String reversedText = StringUtils.reverse("Java Ant");
        System.out.println("Result from StringUtils: " + reversedText);

        System.out.println("\n--- Main Application Finished ---");
    }
}

