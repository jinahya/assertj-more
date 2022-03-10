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

    public SELF checkValidIntValue(
            final Consumer<? super ToIntBiFunction<? super Long, ? super TemporalField>> consumer) {
        Objects.requireNonNull(consumer, "consumer is null");
        return isNotNull()
                .satisfies(a -> {
                    final ToIntBiFunction<Long, TemporalField> f = a::checkValidIntValue;
                    consumer.accept(f);
                });
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

    public SELF hasLargestMinimum(final long expected) {
        return isNotNull()
                .satisfies(a -> {
                    Assertions.assertThat(a.getLargestMinimum())
                            .isEqualTo(expected);
                });
    }

    public SELF hasMaximum(final long expected) {
        return isNotNull()
                .satisfies(a -> {
                    Assertions.assertThat(a.getMaximum())
                            .isEqualTo(expected);
                });
    }

    public SELF hasMinimum(final long expected) {
        return isNotNull()
                .satisfies(a -> {
                    Assertions.assertThat(a.getMinimum())
                            .isEqualTo(expected);
                });
    }

    public SELF hasSmallestMaximum(final long expected) {
        return isNotNull()
                .satisfies(a -> {
                    Assertions.assertThat(a.getSmallestMaximum())
                            .isEqualTo(expected);
                });
    }

    public SELF isFixed(final boolean expected) {
        return isNotNull()
                .satisfies(a -> {
                    Assertions.assertThat(a.isFixed())
                            .isEqualTo(expected);
                });
    }

    public SELF isIntValue() {
        return isNotNull()
                .satisfies(a -> {
                    Assertions.assertThat(a.isIntValue())
                            .isTrue();
                });
    }

    public SELF isValidIntValue(final long expected) {
        return isNotNull()
                .satisfies(a -> {
                    Assertions.assertThat(a.isValidIntValue(expected))
                            .isTrue();
                });
    }

    public SELF isValidValue(final long expected) {
        return isNotNull()
                .satisfies(a -> {
                    Assertions.assertThat(a.isValidValue(expected))
                            .isTrue();
                });
    }
}
