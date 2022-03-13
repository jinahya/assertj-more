package com.github.jinahya.assertj.more.java.time.temporal;

import org.assertj.core.api.AbstractAssert;
import org.assertj.core.api.AbstractLongAssert;
import org.assertj.core.api.Assert;
import org.assertj.core.api.AssertFactory;
import org.assertj.core.api.Assertions;

import java.time.temporal.Temporal;
import java.time.temporal.TemporalAmount;
import java.time.temporal.TemporalUnit;
import java.util.Objects;
import java.util.function.Function;
import java.util.function.LongFunction;

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
    protected <R> R minus(final long amountToSubtract, final TemporalUnit unit,
                          final Function<? super SELF, ? extends Function<? super Temporal, ? extends R>> function) {
        return function.apply(isNotNull())
                .apply(actual.minus(amountToSubtract, unit));
    }

//    public AbstractTemporalAssert<?, Temporal> extractingMinus(final long amountToSubtract, final TemporalUnit unit) {
//        return minus(amountToSubtract, unit, s -> DefaultMoreTemporalAssert::new);
//    }

    // ----------------------------------------------------------------------------------- minus(TemporalAmount)Temporal
    protected <R> R minus(final TemporalAmount amount,
                          final Function<? super SELF, ? extends Function<? super Temporal, ? extends R>> function) {
        Objects.requireNonNull(amount, "amount is null");
        Objects.requireNonNull(function, "function is null");
        return function.apply(isNotNull())
                .apply(actual.minus(amount));
    }

    public <A extends Assert<A, Temporal>> A extractingMinusApplying(
            final TemporalAmount amount, final Function<? super Temporal, ? extends A> function) {
        Objects.requireNonNull(function, "function is null");
        return minus(amount, s -> function);
    }

    public <A extends Assert<A, Temporal>> A extractingMinusCreating(
            final TemporalAmount amount, final AssertFactory<? super Temporal, ? extends A> factory) {
        Objects.requireNonNull(factory, "factory is null");
        return extractingMinusApplying(amount, factory::createAssert);
    }

//    public AbstractTemporalAssert<?, Temporal> extractingMinus(final TemporalAmount amount) {
//        return extractingMinusCreating(amount, DefaultMoreTemporalAssert::new);
//    }

    // ----------------------------------------------------------------------------------- plus(J,TemporalUnit)Temporal
    protected <R> R plus(final long amountToSubtract, final TemporalUnit unit,
                         final Function<? super SELF, ? extends Function<? super Temporal, ? extends R>> function) {
        return function.apply(isNotNull())
                .apply(actual.plus(amountToSubtract, unit));
    }

//    public AbstractTemporalAssert<?, Temporal> extractingPlus(final long amountToSubtract, final TemporalUnit unit) {
//        return plus(amountToSubtract, unit, s -> DefaultMoreTemporalAssert::new);
//    }

    // ----------------------------------------------------------------------------------- plus(TemporalAmount)Temporal
    protected <R> R plus(final TemporalAmount amount,
                         final Function<? super SELF, ? extends Function<? super Temporal, ? extends R>> function) {
        Objects.requireNonNull(amount, "amount is null");
        Objects.requireNonNull(function, "function is null");
        return function.apply(isNotNull())
                .apply(actual.plus(amount));
    }

    public <A extends Assert<A, Temporal>> A extractingPlusApplying(
            final TemporalAmount amount, final Function<? super Temporal, ? extends A> function) {
        Objects.requireNonNull(function, "function is null");
        return plus(amount, s -> function);
    }

    public <A extends Assert<A, Temporal>> A extractingPlusCreating(
            final TemporalAmount amount, final AssertFactory<? super Temporal, ? extends A> factory) {
        Objects.requireNonNull(factory, "factory is null");
        return extractingPlusApplying(amount, factory::createAssert);
    }

//    public AbstractTemporalAssert<?, Temporal> extractingPlus(final TemporalAmount amount) {
//        return extractingPlusCreating(amount, DefaultMoreTemporalAssert::new);
//    }

    // ----------------------------------------------------------------------------------- until(Temporal,TemporalUnit)J
    protected <R> R until(final Temporal endExclusive, final TemporalUnit unit,
                          final Function<? super SELF, ? extends LongFunction<? extends R>> function) {
        return function.apply(isNotNull())
                .apply(actual.until(endExclusive, unit));
    }

    public AbstractLongAssert<?> extractingUntil(final Temporal endExclusive, final TemporalUnit unit) {
        return until(endExclusive, unit, s -> Assertions::assertThat);
    }
}
