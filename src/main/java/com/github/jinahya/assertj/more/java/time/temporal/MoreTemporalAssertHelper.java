package com.github.jinahya.assertj.more.java.time.temporal;

import com.github.jinahya.assertj.more.hidden.ForAssert;
import org.assertj.core.api.AbstractBooleanAssert;
import org.assertj.core.api.Assert;
import org.assertj.core.api.Assertions;

import java.time.temporal.Temporal;
import java.time.temporal.TemporalUnit;
import java.util.function.Function;

/**
 * An abstract class for verifying instances of {@link Temporal} interface.
 *
 * @param <SELF>   self type parameter
 * @param <ACTUAL> actual type parameter
 * @author Jin Kwon &lt;onacit_at_gmail.com&gt;
 */
final class MoreTemporalAssertHelper {

    // -------------------------------------------------------------------------------------- isSupported(TemporalUnit)Z
    static <SELF extends Assert<SELF, ACTUAL>, ACTUAL extends Temporal, R> R isSupported(
            final TemporalUnit unit,
            final SELF self,
            final Function<? super SELF, ? extends Function<? super Boolean, ? extends R>> function) {
        return function.apply(ForAssert.invokeIsNotNull(self))
                .apply(ForAssert.getActual(self).isSupported(unit));
    }

    static <SELF extends Assert<SELF, ACTUAL>, ACTUAL extends Temporal, R> R extractingIsSupported(
            final TemporalUnit unit,
            final SELF self,
            final Function<? super SELF, ? extends Function<? super AbstractBooleanAssert<?>, ? extends R>> function) {
        return isSupported(unit, self, s -> r -> function.apply(s).apply(Assertions.assertThat(r)));
    }

    // ----------------------------------------------------------------------------------- minus(J,TemporalUnit)Temporal
    static <SELF extends Assert<SELF, ACTUAL>, ACTUAL extends Temporal, R> R minus(
            final long amountToSubtract, final TemporalUnit unit,
            final SELF self,
            final Function<? super SELF, ? extends Function<? super Temporal, ? extends R>> function) {
        return function.apply(ForAssert.invokeIsNotNull(self))
                .apply(ForAssert.getActual(self).minus(amountToSubtract, unit));
    }

//    public MoreTemporalAssertHelper<?, Temporal> extractingMinus(final long amountToSubtract, final TemporalUnit unit) {
//        return minus(amountToSubtract, unit, s -> DefaultMoreTemporalAssert::new);
//    }
//
//    // ----------------------------------------------------------------------------------- minus(TemporalAmount)Temporal
//    protected <R> R minus(final TemporalAmount amount,
//                          final Function<? super SELF, ? extends Function<? super Temporal, ? extends R>> function) {
//        Objects.requireNonNull(amount, "amount is null");
//        Objects.requireNonNull(function, "function is null");
//        return function.apply(isNotNull())
//                .apply(actual.minus(amount));
//    }
//
//    public <A extends Assert<A, Temporal>> A extractingMinusApplying(
//            final TemporalAmount amount, final Function<? super Temporal, ? extends A> function) {
//        Objects.requireNonNull(function, "function is null");
//        return minus(amount, s -> function);
//    }
//
//    public <A extends Assert<A, Temporal>> A extractingMinusCreating(
//            final TemporalAmount amount, final AssertFactory<? super Temporal, ? extends A> factory) {
//        Objects.requireNonNull(factory, "factory is null");
//        return extractingMinusApplying(amount, factory::createAssert);
//    }
//
//    public MoreTemporalAssertHelper<?, Temporal> extractingMinus(final TemporalAmount amount) {
//        return extractingMinusCreating(amount, DefaultMoreTemporalAssert::new);
//    }
//
//    // ----------------------------------------------------------------------------------- plus(J,TemporalUnit)Temporal
//    protected <R> R plus(final long amountToSubtract, final TemporalUnit unit,
//                         final Function<? super SELF, ? extends Function<? super Temporal, ? extends R>> function) {
//        return function.apply(isNotNull())
//                .apply(actual.plus(amountToSubtract, unit));
//    }
//
//    public MoreTemporalAssertHelper<?, Temporal> extractingPlus(final long amountToSubtract, final TemporalUnit unit) {
//        return plus(amountToSubtract, unit, s -> DefaultMoreTemporalAssert::new);
//    }
//
//    // ----------------------------------------------------------------------------------- plus(TemporalAmount)Temporal
//    protected <R> R plus(final TemporalAmount amount,
//                         final Function<? super SELF, ? extends Function<? super Temporal, ? extends R>> function) {
//        Objects.requireNonNull(amount, "amount is null");
//        Objects.requireNonNull(function, "function is null");
//        return function.apply(isNotNull())
//                .apply(actual.plus(amount));
//    }
//
//    public <A extends Assert<A, Temporal>> A extractingPlusApplying(
//            final TemporalAmount amount, final Function<? super Temporal, ? extends A> function) {
//        Objects.requireNonNull(function, "function is null");
//        return plus(amount, s -> function);
//    }
//
//    public <A extends Assert<A, Temporal>> A extractingPlusCreating(
//            final TemporalAmount amount, final AssertFactory<? super Temporal, ? extends A> factory) {
//        Objects.requireNonNull(factory, "factory is null");
//        return extractingPlusApplying(amount, factory::createAssert);
//    }
//
//    public MoreTemporalAssertHelper<?, Temporal> extractingPlus(final TemporalAmount amount) {
//        return extractingPlusCreating(amount, DefaultMoreTemporalAssert::new);
//    }
//
//    // ----------------------------------------------------------------------------------- until(Temporal,TemporalUnit)J
//    protected <R> R until(final Temporal endExclusive, final TemporalUnit unit,
//                          final Function<? super SELF, ? extends LongFunction<? extends R>> function) {
//        return function.apply(isNotNull())
//                .apply(actual.until(endExclusive, unit));
//    }
//
//    public AbstractLongAssert<?> extractingUntil(final Temporal endExclusive, final TemporalUnit unit) {
//        return until(endExclusive, unit, s -> Assertions::assertThat);
//    }

    private MoreTemporalAssertHelper() {
        throw new AssertionError("instantiation is not allowed");
    }
}
