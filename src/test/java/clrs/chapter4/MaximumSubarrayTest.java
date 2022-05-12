package clrs.chapter4;

import com.google.common.collect.Range;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.function.Function;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(Parameterized.class)
public class MaximumSubarrayTest {
    @Parameterized.Parameters(name = "{0}")
    public static Collection<Object[]> parameters() {
        return Arrays.asList(new Object[][] {
                { "Brute Force", (Function<int[], Range<Integer>>) MaximumSubarray::byBruteForce}
        });
    }

    @Parameterized.Parameter(0)
    public String name;

    @Parameterized.Parameter(1)
    public Function<int[], Range<Integer>> evaluator;

    @Test
    public void bookExample() {
        int[] example = {1, -4, 3, -4};
        assertThat(evaluator.apply(example)).isEqualTo(Range.closed(2, 2));
    }

    @Test
    public void singleElementAtArrayStart() {
        int[] values = {3, -4, 1, -4};
        assertThat(evaluator.apply(values)).isEqualTo(Range.closed(0, 0));
    }

    @Test
    public void singleElementAtArrayEnd() {
        int[] values = {-4, 1, -4, 3};
        assertThat(evaluator.apply(values)).isEqualTo(Range.closed(3, 3));
    }

    @Test
    public void entireArray() {
        int[] values = {100, -1, 100};
        assertThat(evaluator.apply(values)).isEqualTo(Range.closed(0, 2));
    }

    @Test
    public void largerBookExample() {
        int[] values = {13, -3, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15, -4, 7};
        assertThat(evaluator.apply(values)).isEqualTo(Range.closed(7, 10));
    }
}