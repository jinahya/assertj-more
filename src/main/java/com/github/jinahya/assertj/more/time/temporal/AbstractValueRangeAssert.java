package com.github.jinahya.assertj.more.time.temporal;

import org.assertj.core.api.AbstractAssert;
import org.assertj.core.api.AbstractIntegerAssert;
import org.assertj.core.api.AbstractLongAssert;
import org.assertj.core.api.Assertions;

import java.time.temporal.TemporalField;
import java.time.temporal.ValueRange;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.function.LongFunction;
import java.util.function.ToLongBiFunction;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * An abstract assert class for verifying values of {@link ValueRange}.
 *
 * @param <SELF> self type parameter.
 * @author Jin Kwon &lt;onacit_at_gmail.com&gt;
 */
public class AbstractValueRangeAssert<SELF extends AbstractValueRangeAssert<SELF>>
        extends AbstractAssert<SELF, ValueRange> {

    /**
     * Creates a new instance with specified actual value and self type.
     *
     * @param actual   the actual value to verify.
     * @param selfType the self type.
     */
    protected AbstractValueRangeAssert(final ValueRange actual, final Class<SELF> selfType) {
        super(actual, selfType);
    }

    // --------------------------------------------------------------------------- checkValidIntValue(J, TemporalField)I
    protected <R> R checkValidIntValue(final long value, final TemporalField field,
                                       final Function<? super SELF, ? extends IntFunction<? extends R>> function) {
        Objects.requireNonNull(function, "function is null");
        return function.apply(isNotNull())
                .apply(actual.checkValidIntValue(value, field));
    }

    public AbstractIntegerAssert<?> extractingValidIntValueOf(final long value, final TemporalField field) {
        return checkValidIntValue(value, field, s -> Assertions::assertThat);
    }

    // --------------------------------------------------------------------------- checkValidIntValue(J, TemporalField)J
    protected <R> R checkValidValue(final long value, final TemporalField field,
                                    final Function<? super SELF, ? extends LongFunction<? extends R>> function) {
        Objects.requireNonNull(function, "function is null");
        return function.apply(isNotNull())
                .apply(actual.checkValidValue(value, field));
    }

    public AbstractLongAssert<?> extractingValidValueOf(final long value, final TemporalField field) {
        return checkValidValue(value, field, s -> Assertions::assertThat);
    }

    public SELF checkValidValue(
            final Consumer<? super ToLongBiFunction<? super Long, ? super TemporalField>> consumer) {
        Objects.requireNonNull(consumer, "consumer is null");
        return isNotNull()
                .satisfies(a -> {
                    final ToLongBiFunction<Long, TemporalField> f = a::checkValidValue;
                    consumer.accept(f);
                });
    }

    // -------------------------------------------------------------------------------------------- getLargestMinimum()J
    public SELF hasLargestMinimum(final long expected) {
        return isNotNull()
                .satisfies(a -> {
                    assertThat(a.getLargestMinimum())
                            .isEqualTo(expected);
                });
    }

    // --------------------------------------------------------------------------------------------------- getMaximum()J
    public SELF hasMaximum(final long expected) {
        return isNotNull()
                .satisfies(a -> {
                    assertThat(a.getMaximum())
                            .isEqualTo(expected);
                });
    }

    // --------------------------------------------------------------------------------------------------- getMinimum()J
    public SELF hasMinimum(final long expected) {
        return isNotNull()
                .satisfies(a -> {
                    assertThat(a.getMinimum())
                            .isEqualTo(expected);
                });
    }

    // ------------------------------------------------------------------------------------------- getSmallestMaximum()J
    public SELF hasSmallestMaximum(final long expected) {
        return isNotNull()
                .satisfies(a -> {
                    assertThat(a.getSmallestMaximum())
                            .isEqualTo(expected);
                });
    }

    // ------------------------------------------------------------------------------------------------------ isFixed()Z
    protected SELF isFixed(final boolean expected) {
        return isNotNull()
                .satisfies(a -> {
                    assertThat(a.isFixed())
                            .isEqualTo(expected);
                });
    }

    public SELF isFixed() {
        return isFixed(true);
    }

    public SELF isNotFixed() {
        return isFixed(false);
    }

    // --------------------------------------------------------------------------------------------------- isIntValue()Z
    protected SELF isIntValue(final boolean expected) {
        return isNotNull()
                .satisfies(a -> {
                    assertThat(a.isIntValue())
                            .isEqualTo(expected);
                });
    }

    public SELF isIntValue() {
        return isIntValue(true);
    }

    public SELF allValuesFitInInt() {
        return isIntValue(true);
    }

    public SELF notAllValuesFitInInt() {
        return isIntValue(true);
    }

    // --------------------------------------------------------------------------------------------- isValidIntValue(I)Z

    public SELF isValidIntValue(final long value) {
        return isNotNull()
                .satisfies(a -> {
                    assertThat(a.isValidIntValue(value))
                            .isTrue();
                });
    }

    /**
     * Asserts that the {@link #actual} checks given value as a valid int value.
     *
     * @param value the value to check.
     * @return {@link #myself}.
     * @see #isValidIntValue(long)
     */
    public SELF checksAsValidIntValue(final long value) {
        return isValidIntValue(value);
    }

    // ------------------------------------------------------------------------------------------------ isValidValue(L)Z
    public SELF isValidValue(final long value) {
        return isNotNull()
                .satisfies(a -> {
                    assertThat(a.isValidValue(value))
                            .isTrue();
                });
    }

    public SELF checksAsValidValue(final long value) {
        return isValidValue(value);
    }
}
