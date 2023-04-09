package com.company;

import java.util.Arrays;
import java.util.List;

public class ArrayProblems {
    public static boolean isValidSubsequence(List<Integer> array, List<Integer> sequence) {
        int arrI = 0, seqI = 0;
        while (arrI < array.size() && seqI < sequence.size()) {
            if (array.get(arrI) == sequence.get(seqI)) {
                seqI += 1;
            }
            arrI += 1;
        }
        return seqI == sequence.size();
    }

    public static boolean isValidSubsequence2(List<Integer> array, List<Integer> sequence) {
        int seqI = 0;

        for (int num : array) {
            if (seqI == sequence.size()) {
                return true;
            }

            if (sequence.get(seqI) == num) {
                seqI += 1;
            }
        }

        return seqI == sequence.size();
    }

    public static int[] twoNumberSum(int[] array, int targetSum) {
        Arrays.sort(array);
        int left = 0, right = array.length - 1;
        while (left != right) {
            int sum = array[left] + array[right];
            if (sum == targetSum) {
                int[] result = {array[left], array[right]};
                return result;
            } else if (targetSum < sum) {
                right -= 1;
            } else {
                left += 1 ;
            }
        }

        return new int[0];
    }

    public static int[] sortedSquaredArray(int[] array) {
        // Time = O(n * log(n))
        return Arrays.stream(array).map(num -> num * num).sorted().toArray();
    }

    public static int[] sortedSquaredArray2(int[] array) {
        // Time = O(n) - more optimal
        int[] result = Arrays.stream(array).map(num -> 0).toArray();
        int start = 0, end = array.length - 1;

        for (int i = array.length-1; i >= 0 ; i--) {
            if (Math.abs(array[start]) > Math.abs(array[end])) {
                result[i] = array[start] * array[start];
                start += 1;
            } else {
                result[i] = array[end] * array[end];
                end -= 1;
            }
        }

        return result;
    }

}
