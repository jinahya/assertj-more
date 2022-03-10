package com.github.jinahya.assertj.extended.time.temporal;

import org.assertj.core.api.AbstractLongAssert;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.InstanceOfAssertFactories;

import java.time.temporal.Temporal;
import java.time.temporal.TemporalAmount;
import java.time.temporal.TemporalUnit;
import java.util.Objects;
import java.util.function.Consumer;

public abstract class AbstractTemporalAssert<
        SELF extends AbstractTemporalAssert<SELF, ACTUAL>,
        ACTUAL extends Temporal
        >
        extends AbstractTemporalAccessorAssert<SELF, ACTUAL> {

    protected AbstractTemporalAssert(final ACTUAL actual, final Class<?> selfType) {
        super(actual, selfType);
    }

    public SELF isSupported(final TemporalUnit unit) {
        return isNotNull()
                .satisfies(a -> {
                    Assertions.assertThat(a.isSupported(unit))
                            .isTrue()
                    ;
                })
                ;
    }

    public AbstractTemporalAssert<?, Temporal> extractingSubtractedWith(final long amountToSubtract,
                                                                        final TemporalUnit unit) {
        return isNotNull()
                .extracting(a -> a.minus(amountToSubtract, unit), DefaultTemporalAssert::new);
    }

    public SELF satisfiesSubtractedWith(final long amountToSubtract, final TemporalUnit unit,
                                        final Consumer<? super Temporal> consumer) {
        Objects.requireNonNull(consumer, "consumer is null");
        return isNotNull()
                .satisfies(a -> {
                    consumer.accept(a.minus(amountToSubtract, unit));
                })
                ;
    }

    public AbstractTemporalAssert<?, Temporal> extractingSubtractedWith(final TemporalAmount amount) {
        return isNotNull()
                .extracting(a -> a.minus(amount), DefaultTemporalAssert::new);
    }

    public SELF satisfiesSubtractedWith(final TemporalAmount amount, final Consumer<? super Temporal> consumer) {
        Objects.requireNonNull(consumer, "consumer is null");
        return isNotNull()
                .satisfies(a -> {
                    consumer.accept(a.minus(amount));
                })
                ;
    }

    public AbstractTemporalAssert<?, Temporal> extractingAddedWith(final long amountToAdd, final TemporalUnit unit) {
        return isNotNull()
                .extracting(a -> a.plus(amountToAdd, unit), DefaultTemporalAssert::new);
    }

    public SELF satisfiesAddedWith(final long amountToSubtract, final TemporalUnit unit,
                                   final Consumer<? super Temporal> consumer) {
        Objects.requireNonNull(consumer, "consumer is null");
        return isNotNull()
                .satisfies(a -> {
                    consumer.accept(a.plus(amountToSubtract, unit));
                })
                ;
    }

    public AbstractTemporalAssert<?, Temporal> extractingAddedWith(final TemporalAmount amount) {
        return isNotNull()
                .extracting(a -> a.plus(amount), DefaultTemporalAssert::new);
    }

    public SELF satisfiesAddedWith(final TemporalAmount amount, final Consumer<? super Temporal> consumer) {
        Objects.requireNonNull(consumer, "consumer is null");
        return isNotNull()
                .satisfies(a -> {
                    consumer.accept(a.plus(amount));
                })
                ;
    }

    public AbstractLongAssert<?> extractingAmountUntil(final Temporal endExclusive, final TemporalUnit unit) {
        return isNotNull()
                .extracting(a -> a.until(endExclusive, unit), InstanceOfAssertFactories.LONG);
    }
}
