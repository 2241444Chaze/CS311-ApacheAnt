package com.team2;

import com.team2.solutions.arrays.ArraySolutions;
import com.team2.solutions.lists.LinkedListSolutions;
import com.team2.solutions.math.MathSolutions;
import com.team2.solutions.strings.StringSolutions;
import com.team2.solutions.util.ListNode;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MainAppTest {

    // --- ARRAYS SOLUTIONS TESTS ---
    @Test
    void testFindMedianSortedArrays() {
        ArraySolutions arr = new ArraySolutions();
        int[] nums1 = {1, 3};
        int[] nums2 = {2};
        double result = arr.findMedianSortedArrays(nums1, nums2);
        assertEquals(2.0, result, "Median of [1,3] and [2] should be 2.0");
    }

    @Test
    void testPlusOne() {
        ArraySolutions arr = new ArraySolutions();
        int[] input = {9, 9, 9};
        int[] result = arr.plusOne(input);
        assertArrayEquals(new int[]{1, 0, 0, 0}, result, "Plus one should add a digit");
    }

    @Test
    void testRemoveElement() {
        ArraySolutions arr = new ArraySolutions();
        int[] nums = {3, 2, 2, 3};
        int val = 3;
        int newLength = arr.removeElement(nums, val);
        assertEquals(2, newLength, "Array should have 2 elements left after removing 3");
    }

    @Test
    void testTwoSum() {
        ArraySolutions arr = new ArraySolutions();
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] result = arr.twoSum(nums, target);
        assertArrayEquals(new int[]{0, 1}, result, "Indices [0,1] sum to 9");
    }

    @Test
    void testSearchRange() {
        ArraySolutions arr = new ArraySolutions();
        int[] nums = {5, 7, 7, 8, 8, 10};
        int[] result = arr.searchRange(nums, 8);
        assertArrayEquals(new int[]{3, 4}, result, "Target 8 starts at index 3 and ends at 4");
    }

    @Test
    void testCanJump() {
        ArraySolutions arr = new ArraySolutions();
        int[] nums = {2, 3, 1, 1, 4};
        assertTrue(arr.canJump(nums), "You should be able to reach the end");
    }

    @Test
    void testMaxArea() {
        ArraySolutions arr = new ArraySolutions();
        int[] height = {1,8,6,2,5,4,8,3,7};
        int result = arr.maxArea(height);
        assertEquals(49, result, "Max area should be 49");
    }

    @Test
    void testRemoveDuplicates() {
        ArraySolutions arr = new ArraySolutions();
        int[] nums = {1,1,2};
        int result = arr.removeDuplicates(nums);
        assertEquals(2, result, "After removing duplicates, length should be 2");
    }

    @Test
    void testNumSubmat() {
        ArraySolutions arr = new ArraySolutions();
        int[][] mat = {
                {1,0,1},
                {1,1,0},
                {1,1,0}
        };
        int result = arr.numSubmat(mat);
        assertEquals(13, result, "There should be 13 submatrices with all ones");
    }

    // --- LINKED LIST TESTS ---
    @Test
    void testAddTwoNumbers() {
        LinkedListSolutions listSol = new LinkedListSolutions();

        // l1 = [2,4,3]
        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        // l2 = [5,6,4]
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));

        ListNode result = listSol.addTwoNumbers(l1, l2);

        // expected = [7,0,8]
        assertEquals(7, result.val);
        assertEquals(0, result.next.val);
        assertEquals(8, result.next.next.val);
        assertNull(result.next.next.next, "Result should end after 3 nodes");
    }

    @Test
    void testMergeKLists() {
        LinkedListSolutions listSol = new LinkedListSolutions();

        // list1 = [1,4,5]
        ListNode list1 = new ListNode(1, new ListNode(4, new ListNode(5)));
        // list2 = [1,3,4]
        ListNode list2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        // list3 = [2,6]
        ListNode list3 = new ListNode(2, new ListNode(6));

        ListNode[] lists = new ListNode[]{list1, list2, list3};

        ListNode merged = listSol.mergeKLists(lists);

        // Check merged order
        int[] expected = {1, 1, 2, 3, 4, 4, 5, 6};
        for (int val : expected) {
            assertNotNull(merged, "List ended early");
            assertEquals(val, merged.val);
            merged = merged.next;
        }
        assertNull(merged, "Merged list should end properly");
    }

    // --- MATH SOLUTIONS TESTS ---
    @Test
    void testIsPalindrome() {
        MathSolutions math = new MathSolutions();

        assertTrue(math.isPalindrome(121), "121 should be a palindrome");
        assertFalse(math.isPalindrome(-121), "Negative numbers are not palindromes");
        assertFalse(math.isPalindrome(10), "10 reversed is 01, not the same");
    }

    @Test
    void testIsPowerOfFour() {
        MathSolutions math = new MathSolutions();

        assertTrue(math.isPowerOfFour(16), "16 is 4^2, should be true");
        assertTrue(math.isPowerOfFour(1), "1 is 4^0, should be true");
        assertFalse(math.isPowerOfFour(8), "8 is not a power of four");
        assertFalse(math.isPowerOfFour(0), "0 is not a power of four");
        assertFalse(math.isPowerOfFour(-4), "Negative numbers are not powers of four");
    }

    @Test
    void testNextBeautifulNumber() {
        MathSolutions math = new MathSolutions();

        // The smallest beautiful numbers are:
        // 22 (two 2's), 1333 (one 1 and three 3's), 3133, etc.
        int result = math.nextBeautifulNumber(21);
        assertEquals(22, result, "After 21, the next beautiful number is 22");

        int result2 = math.nextBeautifulNumber(22);
        assertEquals(122, result2, "After 22, next beautiful number is 122");
    }

    // --- STRING SOLUTIONS TESTS ---
    @Test
    void testIsPalindromeString() {
        StringSolutions sol = new StringSolutions();

        assertTrue(sol.isPalindrome("A man, a plan, a canal: Panama"), "Should be palindrome ignoring punctuation");
        assertTrue(sol.isPalindrome("RaceCar"), "Should be palindrome ignoring case");
        assertFalse(sol.isPalindrome("Hello"), "Not a palindrome");
    }

    @Test
    void testLengthOfLongestSubstring() {
        StringSolutions sol = new StringSolutions();

        assertEquals(3, sol.lengthOfLongestSubstring("abcabcbb"), "Longest substring without repeats is 'abc'");
        assertEquals(1, sol.lengthOfLongestSubstring("bbbbb"), "All characters same, max length = 1");
        assertEquals(3, sol.lengthOfLongestSubstring("pwwkew"), "Answer should be 'wke'");
        assertEquals(0, sol.lengthOfLongestSubstring(""), "Empty string gives length 0");
    }

    @Test
    void testLongestCommonPrefix() {
        StringSolutions sol = new StringSolutions();

        assertEquals("fl", sol.longestCommonPrefix(new String[]{"flower", "flow", "flight"}), "Common prefix should be 'fl'");
        assertEquals("", sol.longestCommonPrefix(new String[]{"dog", "racecar", "car"}), "No common prefix");
    }

    @Test
    void testRomanToInt() {
        StringSolutions sol = new StringSolutions();

        assertEquals(3, sol.romanToInt("III"), "III = 3");
        assertEquals(58, sol.romanToInt("LVIII"), "LVIII = 58");
        assertEquals(1994, sol.romanToInt("MCMXCIV"), "MCMXCIV = 1994");
    }

    @Test
    void testFindSubstring() {
        StringSolutions sol = new StringSolutions();

        List<Integer> result = sol.findSubstring("barfoothefoobarman", new String[]{"foo", "bar"});
        assertEquals(List.of(0, 9), result, "Expected starting indices [0, 9]");

        List<Integer> result2 = sol.findSubstring("wordgoodgoodgoodbestword", new String[]{"word","good","best","word"});
        assertTrue(result2.isEmpty(), "No valid concatenation found");
    }

}
