package com.leet.code.problems;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public static void main(String[] args) {
        TwoSum twoSum = new TwoSum();
        int[] indices = twoSum.twoSumIndices(17);
        System.out.println("Indices are {}" + indices);
    }

    public int[] twoSumIndices(int target) {
        int[] input = { 1,5,4,6,8,9};
        Map<Integer, Integer> cache = new HashMap<>();
        for (int i=0; i < input.length; i++) {
            if (cache.containsKey(target - input[i])) {
                return new int[]{cache.get(target - input[i]), i};
            } else {
                cache.put(input[i], i);
            }
        }
        return null;
    }
}
