package com.leet.code.problems;

import java.util.*;

public class SlidingWindow {

    public static void main(String[] args) {
        SlidingWindow slidingWindow = new SlidingWindow();
        System.out.println("Max length is : " + slidingWindow.lengthOfLongestSubstring("abcda"));
        System.out.println("Max length is : " + slidingWindow.lengthOfLongestSubstring_slidingWindow("abcda"));
        System.out.println("Max length with two distinct chars " + slidingWindow.lengthOfLongestSubstringWithDistinctChars2_slidingWindow("AAAAACBBBBFFFFIJKLLLLKKKKKK"));
        System.out.println("Min length is : " + slidingWindow.lengthOfShortestSubArrayWithSumGreaterThan8());
    }

    public int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        int length=1;
        for(int i=0; i< chars.length; i++) {
            String currentStr = s.substring(i, i + 1);
            for (int j=i+1; j< chars.length; j++) {

                if (!currentStr.contains(String.valueOf(chars[j]))) {
                    currentStr = s.substring(i, j+1);
                    if (length < currentStr.length()) {
                        length = currentStr.length();
                    }
                } else {
                    break;
                }
            }
        }
        return length;
    }

    public int lengthOfLongestSubstring_slidingWindow(String s) {
        char[] chars = s.toCharArray();
        int length=1;
        int i=0, j=0;
        Set<Character> cache = new HashSet<>();

        while(i <  chars.length) {
            if (cache.contains(chars[i])) {
                cache.remove(s.charAt(j));
                j++;
            } else {
                cache.add(chars[i]);
                if (i-j + 1 > length) {
                    length = i-j + 1;
                }
                i++;
            }
        }

        return length;
    }

    public int lengthOfLongestSubstringWithDistinctChars2_slidingWindow(String s) {
        char[] chars = s.toCharArray();
        int length=1;
        int i=0, j=0;
        Map<Character, Integer> cache = new HashMap<>();

        while(i <  chars.length) {

            if (cache.size() > 2) {
                Integer charCount = cache.get(s.charAt(j));
                cache.put(s.charAt(j), charCount - 1);
                if (cache.get(s.charAt(j)) == 0) {
                    cache.remove(s.charAt(j));
                }
                j++;
            } else {
                if (cache.containsKey(chars[i])) {
                    cache.put(chars[i], cache.get(chars[i]) + 1);
                } else {
                    cache.put(chars[i], 1);
                }
                if (cache.size() <= 2)
                    length = Math.max(length, i-j+1);
                i++;
            }

        }

        return length;
    }

    public int lengthOfShortestSubArrayWithSumGreaterThan8() {
        int length = Integer.MAX_VALUE;
        int[] input = {1,2,8,3,0,6};
        int i=0, j=0;

        while(i < input.length) {
            if (sum(Arrays.copyOfRange(input, j, i+1)) > 8) {
                length = Math.min(length, i-j+1);
                j++;
            } else {
                i++;
            }
        }

        return length;
    }

    private int sum(int[] input) {
        int sum =0 ;
       for (int i = 0; i< input.length; i++) {
           sum = sum + input[i];
       }
        return sum;
    }

}
