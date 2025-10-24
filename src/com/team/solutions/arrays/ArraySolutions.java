package com.team.solutions.arrays;

import java.util.Arrays;

public class ArraySolutions {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int[] merged = new int[n + m];
        int k = 0;
        for (int i = 0; i < n; i++) {
            merged[k++] = nums1[i];
        }

        for (int i = 0; i < m; i++) {
            merged[k++] = nums2[i];
        }
        Arrays.sort(merged);
        int total = merged.length;
        if (total % 2 == 1) {
            return (double) merged[total / 2];
        } else {
            int mid1 = merged[total / 2 - 1];
            int mid2 = merged[total / 2];
            return ((double) mid1 + (double) mid2) / 2.0;

        }
    }
    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] + 1 != 10) {
                digits[i] += 1;
                return digits;

            }
            digits[i] = 0;

        }
        int[] newDigits = new int[digits.length + 1];
        newDigits[0] = 1;
        return newDigits;
    }
    public int removeElement(int[] nums, int val) {
        int arrayCount = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != val) {
                nums[arrayCount] = nums[i];
                arrayCount++;
            }
        }
        return arrayCount;

    }
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};

                }
            }
        }
        return null;
    }
    public int[] searchRange(int[] nums, int target) {
        int[] pos = new int[]{-1, -1};
        if (nums.length == 0) {
            return pos;
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                pos[0] = i;
                break;
            }
        }

        if (pos[0] == -1) {
            return pos;
        }

        for (int j = nums.length - 1; j >= 0; j--) {
            if (nums[j] == target) {
                pos[1] = j;
                break;
            }
        }
        return pos;
    }
    public boolean canJump(int[] nums) {
        int reachable = 0;
        for(int i = 0; i < nums.length; i ++) {
            if(i > reachable) return false;
            reachable = Math.max(reachable, i + nums[i]);
        }
        return true;

    }
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int MaximumWater = 0;
        while (left < right) {
            int MinimumHeight = Math.min(height[left], height[right]);
            int width = right - left;
            int area = MinimumHeight * width;
            MaximumWater = Math.max(MaximumWater, area);
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return MaximumWater;
    }
    public int removeDuplicates(int[] nums) {
        int i = 0;
        int n = nums.length;
        for (int j = 1; j < n; j++) {
            if (nums[i] != nums[j]) {
                nums[i+1] = nums[j];
                i++;
            }
        }
        return i + 1;

    }
    public int numSubmat(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int[] h = new int[n];
        int cnt = 0;

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                h[j] = mat[i][j] == 1 ? h[j] + 1 : 0;

            }
            for(int j=0; j<n; j++) {
                int mn = h[j];
                for(int k=j; k>=0 && mn>0; k--) {
                    mn = Math.min(mn, h[k]);
                    cnt += mn;
                }
            }
        }
        return cnt;

    }



}
