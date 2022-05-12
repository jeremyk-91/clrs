package clrs.chapter4;

import com.google.common.collect.Range;

public final class MaximumSubarray {
    private MaximumSubarray() {
        // No
    }

    public static Range<Integer> byBruteForce(int[] array) {
        int maximalSum = Integer.MIN_VALUE;
        Range<Integer> maximalSubarray = Range.closed(0, 0);

        for (int i = 0; i < array.length; i++) {
            int sum = 0;
            for (int j = i; j < array.length; j++) {
                sum += array[j];
                if (sum > maximalSum) {
                    maximalSum = sum;
                    maximalSubarray = Range.closed(i, j);
                }
            }
        }
        return maximalSubarray;
    }
}
