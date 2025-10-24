package com.team2.solutions.strings;

import java.util.*;

public class StringSolutions {
    public boolean isPalindrome(String s) {

        String toRemove = "[:,.@!#$%^&*()_\\[\\]\\\"\\\'{}\\-\\?\\;\\\\` ]";
        String newString = s.replaceAll(toRemove, "").trim().toLowerCase();
        String rev = new StringBuilder(newString).reverse().toString();
        return newString.equals(rev);

    }
    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        int left = 0;
        Map<Character, Integer> lastSeen = new HashMap<>();

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            if (lastSeen.containsKey(c) && lastSeen.get(c) >= left) {
                left = lastSeen.get(c) + 1;

            }
            maxLength = Math.max(maxLength, right - left + 1);
            lastSeen.put(c, right);

        }
        return maxLength;

    }
    public String longestCommonPrefix(String[] strs) {
        String prefix = strs[0];
        if (strs.length == 0 || strs == null){
            return "";
        }
        strs.toString();
        for (String s: Arrays.copyOfRange(strs, 1,strs.length)){
            while (!s.startsWith(prefix)){
                prefix = prefix.substring(0, prefix.length() - 1);
            }
            if (prefix.length() == 0 || prefix == null){
                return "";
            }
        }
        return prefix;
    }
    public int romanToInt(String s) {
        int total = 0;
        char[]romNumArray = s.toCharArray();
        Integer currentValue;
        int processedNumber = 0;
        HashMap<Character, Integer> romanNumMap = new HashMap<>();
        romanNumMap.put('I', 1);
        romanNumMap.put('V', 5);
        romanNumMap.put('X', 10);
        romanNumMap.put('L', 50);
        romanNumMap.put('C', 100);
        romanNumMap.put('D', 500);
        romanNumMap.put('M', 1000);



        for (int i = s.length() - 1; i >= 0; i--) {
            currentValue = romanNumMap.get(romNumArray[i]);
            if (currentValue < processedNumber) {
                total -= currentValue;
            } else {
                total += currentValue;
            }
            processedNumber = currentValue;

        }
        return total;

    }
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if (s == null || s.length() == 0 || words == null || words.length == 0)
            return result;
        int wordLen = words[0].length();
        int wordCount = words.length;
        int totalLen = wordLen * wordCount;

        if (s.length() < totalLen) return result;
        Map<String, Integer> wordFreq = new HashMap<>();

        for (String w : words) wordFreq.put(w, wordFreq.getOrDefault(w, 0) + 1);
        for (int i = 0; i < wordLen; i++) {
            int left = i, right = i, count = 0;
            Map<String, Integer> currentFreq = new HashMap<>();

            while (right + wordLen <= s.length()) {
                String word = s.substring(right, right + wordLen);
                right += wordLen;

                if (wordFreq.containsKey(word)) {
                    currentFreq.put(word, currentFreq.getOrDefault(word, 0) + 1);
                    count++;

                    while (currentFreq.get(word) > wordFreq.get(word)) {
                        String leftWord = s.substring(left, left + wordLen);
                        currentFreq.put(leftWord, currentFreq.get(leftWord) - 1);
                        left += wordLen;
                        count--;
                    }
                    if (count == wordCount) result.add(left);
                } else {
                    currentFreq.clear();
                    count = 0;
                    left = right;
                }
            }
        }
        return result;
    }


}
