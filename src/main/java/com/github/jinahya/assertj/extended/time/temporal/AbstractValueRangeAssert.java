package com.github.jinahya.assertj.extended.time.temporal;

import org.assertj.core.api.AbstractAssert;
import org.assertj.core.api.Assertions;

import java.time.temporal.TemporalField;
import java.time.temporal.ValueRange;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.ToIntBiFunction;
import java.util.function.ToLongBiFunction;

public class AbstractValueRangeAssert<SELF extends AbstractValueRangeAssert<SELF>>
        extends AbstractAssert<SELF, ValueRange> {

    protected AbstractValueRangeAssert(final ValueRange actual, final Class<SELF> selfType) {
        super(actual, selfType);
    }

    // --------------------------------------------------------------------------- checkValidIntValue(J, TemporalField)I
    public SELF checkValidIntValue(
            final Consumer<? super ToIntBiFunction<? super Long, ? super TemporalField>> consumer) {
        Objects.requireNonNull(consumer, "consumer is null");
        return isNotNull()
                .satisfies(a -> {
                    final ToIntBiFunction<Long, TemporalField> f = a::checkValidIntValue;
                    consumer.accept(f);
                });
    }

    // --------------------------------------------------------------------------- checkValidIntValue(J, TemporalField)J
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
                    Assertions.assertThat(a.getLargestMinimum())
                            .isEqualTo(expected);
                });
    }

    // --------------------------------------------------------------------------------------------------- getMaximum()J
    public SELF hasMaximum(final long expected) {
        return isNotNull()
                .satisfies(a -> {
                    Assertions.assertThat(a.getMaximum())
                            .isEqualTo(expected);
                });
    }

    // --------------------------------------------------------------------------------------------------- getMinimum()J
    public SELF hasMinimum(final long expected) {
        return isNotNull()
                .satisfies(a -> {
                    Assertions.assertThat(a.getMinimum())
                            .isEqualTo(expected);
                });
    }

    // ------------------------------------------------------------------------------------------- getSmallestMaximum()J
    public SELF hasSmallestMaximum(final long expected) {
        return isNotNull()
                .satisfies(a -> {
                    Assertions.assertThat(a.getSmallestMaximum())
                            .isEqualTo(expected);
                });
    }

    // ------------------------------------------------------------------------------------------------------ isFixed()Z
    protected SELF isFixed(final boolean expected) {
        return isNotNull()
                .satisfies(a -> {
                    Assertions.assertThat(a.isFixed())
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
                    Assertions.assertThat(a.isIntValue())
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
                    Assertions.assertThat(a.isValidIntValue(value))
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
                    Assertions.assertThat(a.isValidValue(value))
                            .isTrue();
                });
    }

    public SELF checksAsValidValue(final long value) {
        return isValidValue(value);
    }
}
