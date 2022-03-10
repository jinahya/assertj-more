package com.github.jinahya.assertj.extended.time.temporal;

import org.assertj.core.api.AbstractAssert;
import org.assertj.core.api.Assertions;

import java.time.temporal.TemporalAccessor;
import java.time.temporal.TemporalField;
import java.time.temporal.TemporalQuery;
import java.time.temporal.ValueRange;
import java.util.Objects;
import java.util.function.Consumer;

public abstract class AbstractTemporalAccessorAssert<
        SELF extends AbstractTemporalAccessorAssert<SELF, ACTUAL>,
        ACTUAL extends TemporalAccessor
        >
        extends AbstractAssert<SELF, ACTUAL> {

    protected AbstractTemporalAccessorAssert(final ACTUAL actual, final Class<?> selfType) {
        super(actual, selfType);
    }

    public SELF has(final TemporalField field, final int expected) {
        return isNotNull()
                .satisfies(a -> {
                    Assertions.assertThat(a.get(field))
                            .isEqualTo(expected)
                    ;
                })
                ;
    }

    public SELF hasLong(final TemporalField field, final long expected) {
        return isNotNull()
                .satisfies(a -> {
                    Assertions.assertThat(a.getLong(field))
                            .isEqualTo(expected)
                    ;
                })
                ;
    }

    public SELF isSupported(final TemporalField field) {
        return isNotNull()
                .satisfies(a -> {
                    Assertions.assertThat(a.isSupported(field))
                            .isTrue()
                    ;
                })
                ;
    }

    public <R> SELF queryResultSatisfies(final TemporalQuery<R> query, final Consumer<? super R> consumer) {
        Objects.requireNonNull(consumer, "consumer is null");
        return isNotNull()
                .satisfies(a -> {
                    Assertions.assertThat(a.query(query))
                            .satisfies(consumer);
                })
                ;
    }

    public SELF rangeSatisfies(final TemporalField field, final Consumer<? super ValueRange> consumer) {
        Objects.requireNonNull(consumer, "consumer is null");
        return isNotNull()
                .satisfies(a -> {
                    Assertions.assertThat(a.range(field))
                            .satisfies(consumer);
                })
                ;
    }

    public ValueRangeAssert extractingRange(final TemporalField field) {
        return isNotNull()
                .extracting(a -> a.range(field), ValueRangeAssert::new)
                ;
    }
}
