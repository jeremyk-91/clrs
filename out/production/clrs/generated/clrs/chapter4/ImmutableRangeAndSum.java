package clrs.chapter4;

import com.google.common.base.MoreObjects;
import com.google.common.collect.Range;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.Var;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.Immutable;
import javax.annotation.concurrent.NotThreadSafe;
import org.immutables.value.Generated;

/**
 * Immutable implementation of {@link MaximumSubarray.RangeAndSum}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code ImmutableRangeAndSum.builder()}.
 */
@Generated(from = "MaximumSubarray.RangeAndSum", generator = "Immutables")
@SuppressWarnings({"all"})
@ParametersAreNonnullByDefault
@javax.annotation.processing.Generated("org.immutables.processor.ProxyProcessor")
@Immutable
@CheckReturnValue
final class ImmutableRangeAndSum implements MaximumSubarray.RangeAndSum {
  private final Range<Integer> indices;
  private final int sum;

  private ImmutableRangeAndSum(Range<Integer> indices, int sum) {
    this.indices = indices;
    this.sum = sum;
  }

  /**
   * @return The value of the {@code indices} attribute
   */
  @Override
  public Range<Integer> indices() {
    return indices;
  }

  /**
   * @return The value of the {@code sum} attribute
   */
  @Override
  public int sum() {
    return sum;
  }

  /**
   * Copy the current immutable object by setting a value for the {@link MaximumSubarray.RangeAndSum#indices() indices} attribute.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for indices
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableRangeAndSum withIndices(Range<Integer> value) {
    if (this.indices == value) return this;
    Range<Integer> newValue = Objects.requireNonNull(value, "indices");
    return new ImmutableRangeAndSum(newValue, this.sum);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link MaximumSubarray.RangeAndSum#sum() sum} attribute.
   * A value equality check is used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for sum
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableRangeAndSum withSum(int value) {
    if (this.sum == value) return this;
    return new ImmutableRangeAndSum(this.indices, value);
  }

  /**
   * This instance is equal to all instances of {@code ImmutableRangeAndSum} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(@Nullable Object another) {
    if (this == another) return true;
    return another instanceof ImmutableRangeAndSum
        && equalTo((ImmutableRangeAndSum) another);
  }

  private boolean equalTo(ImmutableRangeAndSum another) {
    return indices.equals(another.indices)
        && sum == another.sum;
  }

  /**
   * Computes a hash code from attributes: {@code indices}, {@code sum}.
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    @Var int h = 5381;
    h += (h << 5) + indices.hashCode();
    h += (h << 5) + sum;
    return h;
  }

  /**
   * Prints the immutable value {@code RangeAndSum} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return MoreObjects.toStringHelper("RangeAndSum")
        .omitNullValues()
        .add("indices", indices)
        .add("sum", sum)
        .toString();
  }

  /**
   * Creates an immutable copy of a {@link MaximumSubarray.RangeAndSum} value.
   * Uses accessors to get values to initialize the new immutable instance.
   * If an instance is already immutable, it is returned as is.
   * @param instance The instance to copy
   * @return A copied immutable RangeAndSum instance
   */
  public static ImmutableRangeAndSum copyOf(MaximumSubarray.RangeAndSum instance) {
    if (instance instanceof ImmutableRangeAndSum) {
      return (ImmutableRangeAndSum) instance;
    }
    return ImmutableRangeAndSum.builder()
        .from(instance)
        .build();
  }

  /**
   * Creates a builder for {@link ImmutableRangeAndSum ImmutableRangeAndSum}.
   * <pre>
   * ImmutableRangeAndSum.builder()
   *    .indices(com.google.common.collect.Range&amp;lt;Integer&amp;gt;) // required {@link MaximumSubarray.RangeAndSum#indices() indices}
   *    .sum(int) // required {@link MaximumSubarray.RangeAndSum#sum() sum}
   *    .build();
   * </pre>
   * @return A new ImmutableRangeAndSum builder
   */
  public static ImmutableRangeAndSum.Builder builder() {
    return new ImmutableRangeAndSum.Builder();
  }

  /**
   * Builds instances of type {@link ImmutableRangeAndSum ImmutableRangeAndSum}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  @Generated(from = "MaximumSubarray.RangeAndSum", generator = "Immutables")
  @NotThreadSafe
  public static final class Builder {
    private static final long INIT_BIT_INDICES = 0x1L;
    private static final long INIT_BIT_SUM = 0x2L;
    private long initBits = 0x3L;

    private @Nullable Range<Integer> indices;
    private int sum;

    private Builder() {
    }

    /**
     * Fill a builder with attribute values from the provided {@code RangeAndSum} instance.
     * Regular attribute values will be replaced with those from the given instance.
     * Absent optional values will not replace present values.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder from(MaximumSubarray.RangeAndSum instance) {
      Objects.requireNonNull(instance, "instance");
      indices(instance.indices());
      sum(instance.sum());
      return this;
    }

    /**
     * Initializes the value for the {@link MaximumSubarray.RangeAndSum#indices() indices} attribute.
     * @param indices The value for indices 
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder indices(Range<Integer> indices) {
      this.indices = Objects.requireNonNull(indices, "indices");
      initBits &= ~INIT_BIT_INDICES;
      return this;
    }

    /**
     * Initializes the value for the {@link MaximumSubarray.RangeAndSum#sum() sum} attribute.
     * @param sum The value for sum 
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder sum(int sum) {
      this.sum = sum;
      initBits &= ~INIT_BIT_SUM;
      return this;
    }

    /**
     * Builds a new {@link ImmutableRangeAndSum ImmutableRangeAndSum}.
     * @return An immutable instance of RangeAndSum
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public ImmutableRangeAndSum build() {
      if (initBits != 0) {
        throw new IllegalStateException(formatRequiredAttributesMessage());
      }
      return new ImmutableRangeAndSum(indices, sum);
    }

    private String formatRequiredAttributesMessage() {
      List<String> attributes = new ArrayList<>();
      if ((initBits & INIT_BIT_INDICES) != 0) attributes.add("indices");
      if ((initBits & INIT_BIT_SUM) != 0) attributes.add("sum");
      return "Cannot build RangeAndSum, some of required attributes are not set " + attributes;
    }
  }
}
