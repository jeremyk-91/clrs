package clrs.chapter4;

import com.google.common.collect.Range;
import org.immutables.value.Value;

import java.util.Comparator;
import java.util.stream.Stream;

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

    public static Range<Integer> byDivideAndConquer(int[] array) {
        return byDivideAndConquerRecursion(array, 0, array.length - 1).indices();
    }

    /**
     * Returns the maximum sub-array within the provided array - between the provided bounds.
     */
    private static RangeAndSum byDivideAndConquerRecursion(int[] array, int startInclusive, int endInclusive) {
        if (startInclusive == endInclusive) {
            return ImmutableRangeAndSum.builder()
                    .indices(Range.closed(startInclusive, startInclusive))
                    .sum(array[startInclusive])
                    .build();
        }
        int midpoint = (startInclusive + endInclusive) / 2;
        RangeAndSum leftHandSide = byDivideAndConquerRecursion(array, startInclusive, midpoint);
        RangeAndSum rightHandSide = byDivideAndConquerRecursion(array, midpoint + 1, endInclusive);
        RangeAndSum crossingValues = findMaximumCrossingSubarray(array, startInclusive, midpoint, endInclusive);

        return Stream.of(leftHandSide, rightHandSide, crossingValues)
                .max(Comparator.comparingInt(RangeAndSum::sum))
                .orElseThrow();
    }

    private static RangeAndSum findMaximumCrossingSubarray(int[] array, int startInclusive, int pivot, int endInclusive) {
        int leftSum = Integer.MIN_VALUE;
        int maxLeft = -1;
        int sum = 0;
        for (int i = pivot; i >= startInclusive; i--) {
            sum = sum + array[i];
            if (sum > leftSum) {
                leftSum = sum;
                maxLeft = i;
            }
        }

        int rightSum = Integer.MIN_VALUE;
        int maxRight = -1;
        sum = 0;
        for (int j = pivot + 1; j <= endInclusive; j++) {
            sum = sum + array[j];
            if (sum > rightSum) {
                rightSum = sum;
                maxRight = j;
            }
        }
        return ImmutableRangeAndSum.builder()
                .sum(leftSum + rightSum)
                .indices(Range.closed(maxLeft, maxRight))
                .build();
    }

    @Value.Immutable
    interface RangeAndSum {
        Range<Integer> indices();
        int sum();
    }
}
