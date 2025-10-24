package com.team2;

import java.util.Arrays;
import java.util.Scanner;

import com.team2.solutions.arrays.ArraySolutions;
import com.team2.solutions.lists.LinkedListSolutions;
import com.team2.solutions.math.MathSolutions;
import com.team2.solutions.strings.StringSolutions;
import com.team2.solutions.util.ListNode;

public class MainApp {
    private ArraySolutions arraySolutions = new ArraySolutions();
    private LinkedListSolutions linkedListSolutions = new LinkedListSolutions();
    private MathSolutions mathSolutions = new MathSolutions();
    private StringSolutions stringSolutions = new StringSolutions();

    public static void main(String[] args) {
        MainApp app = new MainApp();
        app.run();
    }

    public void run() {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n=== TEAM 2 PROJECT MAIN MENU ===");
            System.out.println("1. Array Solutions");
            System.out.println("2. Linked List Solutions");
            System.out.println("3. Math Solutions");
            System.out.println("4. String Solutions");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1 -> arraySolutionsMenu(sc);
                case 2 -> linkedListSolutionsMenu(sc);
                case 3 -> mathSolutionsMenu(sc);
                case 4 -> stringSolutionsMenu(sc);
                case 5 -> System.out.println("Exiting program. Goodbye!");
                default -> System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 5);

        sc.close();
    }

    private void arraySolutionsMenu(Scanner sc) {
        int option;
        do {
            System.out.println("\n--- ARRAY SOLUTIONS MENU ---");
            System.out.println("1. Find Median of Two Sorted Arrays");
            System.out.println("2. Plus One");
            System.out.println("3. Remove Element");
            System.out.println("4. Two Sum");
            System.out.println("5. Search Range");
            System.out.println("6. Can Jump");
            System.out.println("7. Max Area (Container with Most Water)");
            System.out.println("8. Remove Duplicates");
            System.out.println("9. Num Submat (Count Submatrices)");
            System.out.println("10. Back to Main Menu");
            System.out.print("Enter your choice: ");
            option = sc.nextInt();

            switch (option) {
                case 1 -> {
                    int[] nums1 = {1, 3};
                    int[] nums2 = {2, 4};
                    double median = arraySolutions.findMedianSortedArrays(nums1, nums2);
                    System.out.println("Median: " + median);
                }
                case 2 -> {
                    int[] digits = {9, 9, 9};
                    System.out.println("Result: " + Arrays.toString(arraySolutions.plusOne(digits)));
                }
                case 3 -> {
                    int[] nums = {3, 2, 2, 3};
                    int val = 3;
                    int len = arraySolutions.removeElement(nums, val);
                    System.out.println("New length: " + len + ", Array: " + Arrays.toString(Arrays.copyOf(nums, len)));
                }
                case 4 -> {
                    int[] nums = {2, 7, 11, 15};
                    int target = 9;
                    System.out.println("Indices: " + Arrays.toString(arraySolutions.twoSum(nums, target)));
                }
                case 5 -> {
                    int[] nums = {5, 7, 7, 8, 8, 10};
                    int target = 8;
                    System.out.println("Range: " + Arrays.toString(arraySolutions.searchRange(nums, target)));
                }
                case 6 -> {
                    int[] nums = {2, 3, 1, 1, 4};
                    System.out.println("Can Jump: " + arraySolutions.canJump(nums));
                }
                case 7 -> {
                    int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
                    System.out.println("Max Area: " + arraySolutions.maxArea(height));
                }
                case 8 -> {
                    int[] nums = {1, 1, 2, 2, 3};
                    int len = arraySolutions.removeDuplicates(nums);
                    System.out.println("New length: " + len + ", Array: " + Arrays.toString(Arrays.copyOf(nums, len)));
                }
                case 9 -> {
                    int[][] mat = {
                            {1, 0, 1},
                            {1, 1, 0},
                            {1, 1, 0}
                    };
                    System.out.println("Number of Submatrices: " + arraySolutions.numSubmat(mat));
                }
                case 10 -> System.out.println("Returning to main menu...");
                default -> System.out.println("Invalid choice.");
            }
        } while (option != 10);
    }

    private void linkedListSolutionsMenu(Scanner sc) {
        int option;
        do {
            System.out.println("\n--- LINKED LIST SOLUTIONS MENU ---");
            System.out.println("1. Add Two Numbers");
            System.out.println("2. Merge K Lists");
            System.out.println("3. Back to Main Menu");
            System.out.print("Enter your choice: ");
            option = sc.nextInt();

            switch (option) {
                case 1 -> {
                    System.out.println("\nTesting addTwoNumbers...");

                    ListNode l1 = new ListNode(2);
                    l1.next = new ListNode(4);
                    l1.next.next = new ListNode(3);

                    ListNode l2 = new ListNode(5);
                    l2.next = new ListNode(6);
                    l2.next.next = new ListNode(4);

                    ListNode expected = new ListNode(7);
                    expected.next = new ListNode(0);
                    expected.next.next = new ListNode(8);

                    ListNode actual = linkedListSolutions.addTwoNumbers(l1, l2);

                    if (isEqual(expected, actual)) {
                        System.out.println("addTwoNumbers test passed!");
                    } else {
                        System.out.println("addTwoNumbers test failed!");
                        System.out.print("Expected: ");
                        printList(expected);
                        System.out.print("Actual: ");
                        printList(actual);
                    }
                }

                case 2 -> {
                    System.out.println("\nTesting mergeKLists...");

                    ListNode a1 = new ListNode(1);
                    a1.next = new ListNode(4);
                    a1.next.next = new ListNode(5);

                    ListNode a2 = new ListNode(1);
                    a2.next = new ListNode(3);
                    a2.next.next = new ListNode(4);

                    ListNode a3 = new ListNode(2);
                    a3.next = new ListNode(6);

                    ListNode[] lists = {a1, a2, a3};

                    ListNode expected = new ListNode(1);
                    expected.next = new ListNode(1);
                    expected.next.next = new ListNode(2);
                    expected.next.next.next = new ListNode(3);
                    expected.next.next.next.next = new ListNode(4);
                    expected.next.next.next.next.next = new ListNode(4);
                    expected.next.next.next.next.next.next = new ListNode(5);
                    expected.next.next.next.next.next.next.next = new ListNode(6);

                    ListNode actual = linkedListSolutions.mergeKLists(lists);

                    if (isEqual(expected, actual)) {
                        System.out.println("mergeKLists test passed!");
                    } else {
                        System.out.println("mergeKLists test failed!");
                        System.out.print("Expected: ");
                        printList(expected);
                        System.out.print("Actual: ");
                        printList(actual);
                    }
                }

                case 3 -> System.out.println("Returning to main menu...");
                default -> System.out.println("Invalid choice.");
            }

        } while (option != 3);
    }

    private void mathSolutionsMenu(Scanner sc) {
        int option;
        do {
            System.out.println("\n--- MATH SOLUTIONS MENU ---");
            System.out.println("1. Is Palindrome Number");
            System.out.println("2. Is Power of Four");
            System.out.println("3. Next Beautiful Number");
            System.out.println("4. Back to Main Menu");
            System.out.print("Enter your choice: ");
            option = sc.nextInt();

            switch (option) {
                case 1 -> {
                    System.out.println("\nTesting isPalindrome...");
                    int num1 = 121;
                    int num2 = -121;
                    int num3 = 123;
                    System.out.println("Input: " + num1 + " → " + mathSolutions.isPalindrome(num1));
                    System.out.println("Input: " + num2 + " → " + mathSolutions.isPalindrome(num2));
                    System.out.println("Input: " + num3 + " → " + mathSolutions.isPalindrome(num3));
                }
                case 2 -> {
                    System.out.println("\nTesting isPowerOfFour...");
                    int[] nums = {1, 4, 16, 5, 8};
                    for (int n : nums) {
                        System.out.println("Input: " + n + " → " + mathSolutions.isPowerOfFour(n));
                    }
                }
                case 3 -> {
                    System.out.println("\nTesting nextBeautifulNumber...");
                    int[] inputs = {1, 9, 22, 120};
                    for (int n : inputs) {
                        System.out.println("Input: " + n + " → Next Beautiful: " + mathSolutions.nextBeautifulNumber(n));
                    }
                }
                case 4 -> System.out.println("Returning to main menu...");
                default -> System.out.println("Invalid choice.");
            }
        } while (option != 4);
    }

    private void stringSolutionsMenu(Scanner sc) {
        int option;
        do {
            System.out.println("\n--- STRING SOLUTIONS MENU ---");
            System.out.println("1. Is Palindrome");
            System.out.println("2. Length of Longest Substring Without Repeating Characters");
            System.out.println("3. Longest Common Prefix");
            System.out.println("4. Roman To Integer");
            System.out.println("5. Find Substring (Concatenation of Words)");
            System.out.println("6. Back to Main Menu");
            System.out.print("Enter your choice: ");
            option = sc.nextInt();

            switch (option) {
                case 1 -> {
                    System.out.println("\nTesting isPalindrome...");
                    String[] inputs = {"racecar", "hello", "madam"};
                    for (String s : inputs) {
                        System.out.println("Input: \"" + s + "\" → " + stringSolutions.isPalindrome(s));
                    }
                }
                case 2 -> {
                    System.out.println("\nTesting lengthOfLongestSubstring...");
                    String[] inputs = {"abcabcbb", "bbbbb", "pwwkew"};
                    for (String s : inputs) {
                        System.out.println("Input: \"" + s + "\" → " + stringSolutions.lengthOfLongestSubstring(s));
                    }
                }
                case 3 -> {
                    System.out.println("\nTesting longestCommonPrefix...");
                    String[][] testCases = {
                            {"flower", "flow", "flight"},
                            {"dog", "racecar", "car"},
                            {"interview", "internet", "internal"}
                    };
                    for (String[] strs : testCases) {
                        System.out.println("Input: " + Arrays.toString(strs) +
                                " → Prefix: " + stringSolutions.longestCommonPrefix(strs));
                    }
                }
                case 4 -> {
                    System.out.println("\nTesting romanToInt...");
                    String[] romans = {"III", "LVIII", "MCMXCIV"};
                    for (String roman : romans) {
                        System.out.println("Roman: " + roman + " → Integer: " + stringSolutions.romanToInt(roman));
                    }
                }
                case 5 -> {
                    System.out.println("\nTesting findSubstring...");
                    String s = "barfoothefoobarman";
                    String[] words = {"foo", "bar"};
                    System.out.println("Input: \"" + s + "\", Words: " + Arrays.toString(words) +
                            " → Indices: " + stringSolutions.findSubstring(s, words));
                }
                case 6 -> System.out.println("Returning to main menu...");
                default -> System.out.println("Invalid choice.");
            }
        } while (option != 6);
    }

    private boolean isEqual(ListNode a, ListNode b) {
        while (a != null && b != null) {
            if (a.val != b.val) return false;
            a = a.next;
            b = b.next;
        }
        return a == null && b == null;
    }

    private void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.val);
            if (node.next != null) System.out.print(" -> ");
            node = node.next;
        }
        System.out.println();
    }
}
