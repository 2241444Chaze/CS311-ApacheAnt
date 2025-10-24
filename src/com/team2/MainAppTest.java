package com.team2;

import com.team2.solutions.arrays.ArraySolutions;
import com.team2.solutions.lists.LinkedListSolutions;
import com.team2.solutions.math.MathSolutions;
import com.team2.solutions.strings.StringSolutions;
import com.team2.solutions.util.ListNode;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;

public class MainAppTest {


    // === ARRAY SOLUTIONS ========================================

    @Test
    void testFindMedianSortedArrays() {
        ArraySolutions arr = new ArraySolutions();
        int[] nums1 = {1, 3};
        int[] nums2 = {2, 4};
        double result = arr.findMedianSortedArrays(nums1, nums2);
        assertEquals(2.5, result, "Median of [1,3] and [2,4] should be 2.5");
    }

    @Test
    void testPlusOne() {
        ArraySolutions arr = new ArraySolutions();
        int[] digits = {9, 9, 9};
        int[] result = arr.plusOne(digits);
        assertArrayEquals(new int[]{1, 0, 0, 0}, result, "999 + 1 should be [1,0,0,0]");
    }

    @Test
    void testRemoveElement() {
        ArraySolutions arr = new ArraySolutions();
        int[] nums = {3, 2, 2, 3};
        int val = 3;
        int len = arr.removeElement(nums, val);
        assertEquals(2, len, "New length after removing 3 should be 2");
        assertArrayEquals(new int[]{2, 2}, Arrays.copyOf(nums, len));
    }

    @Test
    void testTwoSum() {
        ArraySolutions arr = new ArraySolutions();
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] result = arr.twoSum(nums, target);
        assertArrayEquals(new int[]{0, 1}, result, "Indices that sum to 9 should be [0,1]");
    }

    @Test
    void testSearchRange() {
        ArraySolutions arr = new ArraySolutions();
        int[] nums = {5, 7, 7, 8, 8, 10};
        int target = 8;
        int[] result = arr.searchRange(nums, target);
        assertArrayEquals(new int[]{3, 4}, result, "Target 8 should be found at [3,4]");
    }

    @Test
    void testCanJump() {
        ArraySolutions arr = new ArraySolutions();
        int[] nums = {2, 3, 1, 1, 4};
        assertTrue(arr.canJump(nums), "Array [2,3,1,1,4] should be jumpable");
    }

    @Test
    void testMaxArea() {
        ArraySolutions arr = new ArraySolutions();
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        int result = arr.maxArea(height);
        assertEquals(49, result, "Max area for given heights should be 49");
    }

    @Test
    void testRemoveDuplicates() {
        ArraySolutions arr = new ArraySolutions();
        int[] nums = {1, 1, 2, 2, 3};
        int len = arr.removeDuplicates(nums);
        assertEquals(3, len);
        assertArrayEquals(new int[]{1, 2, 3}, Arrays.copyOf(nums, len));
    }

    @Test
    void testNumSubmat() {
        ArraySolutions arr = new ArraySolutions();
        int[][] mat = {
                {1, 0, 1},
                {1, 1, 0},
                {1, 1, 0}
        };
        int result = arr.numSubmat(mat);
        assertEquals(13, result, "Number of submatrices with all ones should be 13");
    }



    // === LINKED LIST SOLUTIONS ==================================

    @Test
    void testAddTwoNumbers() {
        LinkedListSolutions ll = new LinkedListSolutions();

        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));

        ListNode result = ll.addTwoNumbers(l1, l2);

        assertEquals(7, result.val);
        assertEquals(0, result.next.val);
        assertEquals(8, result.next.next.val);
        assertNull(result.next.next.next, "List should end after 3 nodes");
    }

    @Test
    void testMergeKLists() {
        LinkedListSolutions ll = new LinkedListSolutions();

        ListNode a1 = new ListNode(1, new ListNode(4, new ListNode(5)));
        ListNode a2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        ListNode a3 = new ListNode(2, new ListNode(6));

        ListNode[] lists = {a1, a2, a3};
        ListNode result = ll.mergeKLists(lists);

        // Expected merged list: 1 → 1 → 2 → 3 → 4 → 4 → 5 → 6
        assertEquals(1, result.val);
        assertEquals(1, result.next.val);
        assertEquals(2, result.next.next.val);
        assertEquals(3, result.next.next.next.val);
        assertEquals(4, result.next.next.next.next.val);
        assertEquals(4, result.next.next.next.next.next.val);
        assertEquals(5, result.next.next.next.next.next.next.val);
        assertEquals(6, result.next.next.next.next.next.next.next.val);
        assertNull(result.next.next.next.next.next.next.next.next, "List should end after 8 nodes");
    }



    // === MATH SOLUTIONS =========================================

    @Test
    void testIsPalindromeNumber() {
        MathSolutions math = new MathSolutions();
        assertTrue(math.isPalindrome(121));
        assertFalse(math.isPalindrome(-121));
        assertFalse(math.isPalindrome(123));
    }

    @Test
    void testIsPowerOfFour() {
        MathSolutions math = new MathSolutions();
        assertTrue(math.isPowerOfFour(1));
        assertTrue(math.isPowerOfFour(4));
        assertTrue(math.isPowerOfFour(16));
        assertFalse(math.isPowerOfFour(5));
        assertFalse(math.isPowerOfFour(8));
    }

    @Test
    void testNextBeautifulNumber() {
        MathSolutions math = new MathSolutions();
        assertEquals(22, math.nextBeautifulNumber(1));
        assertEquals(22, math.nextBeautifulNumber(9));
        assertEquals(122, math.nextBeautifulNumber(22));
        assertEquals(1333, math.nextBeautifulNumber(120));
    }



    // === STRING SOLUTIONS =======================================

    @Test
    void testIsPalindromeString() {
        StringSolutions s = new StringSolutions();
        assertTrue(s.isPalindrome("racecar"));
        assertFalse(s.isPalindrome("hello"));
        assertTrue(s.isPalindrome("madam"));
    }

    @Test
    void testLengthOfLongestSubstring() {
        StringSolutions s = new StringSolutions();
        assertEquals(3, s.lengthOfLongestSubstring("abcabcbb"));
        assertEquals(1, s.lengthOfLongestSubstring("bbbbb"));
        assertEquals(3, s.lengthOfLongestSubstring("pwwkew"));
    }

    @Test
    void testLongestCommonPrefix() {
        StringSolutions s = new StringSolutions();
        assertEquals("fl", s.longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
        assertEquals("", s.longestCommonPrefix(new String[]{"dog", "racecar", "car"}));
        assertEquals("inter", s.longestCommonPrefix(new String[]{"interview", "internet", "internal"}));
    }

    @Test
    void testRomanToInt() {
        StringSolutions s = new StringSolutions();
        assertEquals(3, s.romanToInt("III"));
        assertEquals(58, s.romanToInt("LVIII"));
        assertEquals(1994, s.romanToInt("MCMXCIV"));
    }

    @Test
    void testFindSubstring() {
        StringSolutions s = new StringSolutions();
        String str = "barfoothefoobarman";
        String[] words = {"foo", "bar"};
        assertEquals(Arrays.asList(0, 9), s.findSubstring(str, words));
    }
}
