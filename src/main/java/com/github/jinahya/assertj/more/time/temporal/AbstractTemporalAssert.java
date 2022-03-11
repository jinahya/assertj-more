package com.github.jinahya.assertj.more.time.temporal;

import org.assertj.core.api.AbstractAssert;
import org.assertj.core.api.AbstractLongAssert;
import org.assertj.core.api.InstanceOfAssertFactories;

import java.time.temporal.Temporal;
import java.time.temporal.TemporalAmount;
import java.time.temporal.TemporalUnit;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Function;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * An abstract class for verifying instances of {@link Temporal} interface.
 *
 * @param <SELF>   self type parameter
 * @param <ACTUAL> actual type parameter
 * @author Jin Kwon &lt;onacit_at_gmail.com&gt;
 */
public abstract class AbstractTemporalAssert<
        SELF extends AbstractTemporalAssert<SELF, ACTUAL>,
        ACTUAL extends Temporal
        >
        extends AbstractAssert<SELF, ACTUAL> {

    /**
     * Creates a new instance with specified actual value and self type.
     *
     * @param actual   the actual value.
     * @param selfType the self type.
     */
    protected AbstractTemporalAssert(final ACTUAL actual, final Class<?> selfType) {
        super(actual, selfType);
    }

    // -------------------------------------------------------------------------------------- isSupported(TemporalUnit)Z
    protected <R> R isSupported(
            final TemporalUnit unit,
            final Function<? super SELF, ? extends Function<? super Boolean, ? extends R>> function) {
        return function.apply(isNotNull())
                .apply(actual.isSupported(unit));
    }

    /**
     * Asserts that specified unit is supported by the {@link #actual}.
     *
     * @param unit the unit.
     * @return {@link SELF}
     */
    public SELF supports(final TemporalUnit unit) {
        return isSupported(unit, s -> r -> {
            assertThat(r).isTrue();
            return s;
        });
    }

    /**
     * Asserts that specified unit is not supported by the {@link #actual}.
     *
     * @param unit the unit.
     * @return {@link SELF}.
     */
    public SELF doesNotSupport(final TemporalUnit unit) {
        return isSupported(unit, s -> r -> {
            assertThat(r).isFalse();
            return s;
        });
    }

    // ----------------------------------------------------------------------------------- minus(J,TemporalUnit)Temporal
    public AbstractTemporalAssert<?, Temporal> extractingMinus(final long amountToSubtract, final TemporalUnit unit) {
        return isNotNull()
                .extracting(a -> a.minus(amountToSubtract, unit), DefaultTemporalAssert::new);
    }

    public SELF satisfiesMinus(final long amountToSubtract, final TemporalUnit unit,
                               final Consumer<? super Temporal> consumer) {
        Objects.requireNonNull(consumer, "consumer is null");
        return isNotNull()
                .satisfies(a -> {
                    consumer.accept(a.minus(amountToSubtract, unit));
                });
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
                });
    }

    // ----------------------------------------------------------------------------------- minus(TemporalAmount)Temporal
    public AbstractTemporalAssert<?, Temporal> extractingMinus(final TemporalAmount amount) {
        return isNotNull()
                .extracting(a -> a.minus(amount), DefaultTemporalAssert::new);
    }

    public SELF satisfiesMinus(final TemporalAmount amount, final Consumer<? super Temporal> consumer) {
        Objects.requireNonNull(consumer, "consumer is null");
        return isNotNull()
                .satisfies(a -> {
                    consumer.accept(a.minus(amount));
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

    // ------------------------------------------------------------------------------------ plus(L,TemporalUnit)Temporal
    public AbstractTemporalAssert<?, Temporal> extractingPlus(final long amountToAdd, final TemporalUnit unit) {
        return isNotNull()
                .extracting(a -> a.plus(amountToAdd, unit), DefaultTemporalAssert::new);
    }

    public SELF satisfiesPlus(final long amountToSubtract, final TemporalUnit unit,
                              final Consumer<? super Temporal> consumer) {
        Objects.requireNonNull(consumer, "consumer is null");
        return isNotNull()
                .satisfies(a -> {
                    consumer.accept(a.plus(amountToSubtract, unit));
                });
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

    // ------------------------------------------------------------------------------------ plus(TemporalAmount)Temporal
    public AbstractTemporalAssert<?, Temporal> extractingPlus(final TemporalAmount amount) {
        return isNotNull()
                .extracting(a -> a.plus(amount), DefaultTemporalAssert::new);
    }

    public SELF satisfiesPlus(final TemporalAmount amount, final Consumer<? super Temporal> consumer) {
        Objects.requireNonNull(consumer, "consumer is null");
        return isNotNull()
                .satisfies(a -> {
                    consumer.accept(a.plus(amount));
                });
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

    // ----------------------------------------------------------------------------------- until(Temporal,TemporalUnit)J
    public AbstractLongAssert<?> extractingAmountUntil(final Temporal endExclusive, final TemporalUnit unit) {
        return isNotNull()
                .extracting(a -> a.until(endExclusive, unit), InstanceOfAssertFactories.LONG);
    }
}
