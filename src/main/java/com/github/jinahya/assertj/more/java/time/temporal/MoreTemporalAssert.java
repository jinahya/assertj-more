package com.github.jinahya.assertj.more.java.time.temporal;

import java.time.temporal.Temporal;
import java.time.temporal.TemporalUnit;

/**
 * An abstract class for verifying instances of {@link Temporal} interface.
 *
 * @param <SELF>   self type parameter
 * @param <ACTUAL> actual type parameter
 * @author Jin Kwon &lt;onacit_at_gmail.com&gt;
 */
public interface MoreTemporalAssert<
        SELF extends MoreTemporalAssert<SELF, ACTUAL>,
        ACTUAL extends Temporal>
        extends MoreTemporalAccessorAssert<SELF, ACTUAL> {

    // -------------------------------------------------------------------------------------- isSupported(TemporalUnit)Z
    default SELF supports(final TemporalUnit unit) {
        return MoreTemporalAssertHelper.extractingIsSupported(unit, (SELF) this, s -> a -> {
            a.isTrue();
            return s;
        });
    }

    default SELF doesNotSupport(final TemporalUnit unit) {
        return MoreTemporalAssertHelper.extractingIsSupported(unit, (SELF) this, s -> a -> {
            a.isFalse();
            return s;
        });
    }

    // ----------------------------------------------------------------------------------- minus(J,TemporalUnit)Temporal
//    default MoreTemporalAssert<?, Temporal> extractingMinus(final long amountToSubtract, final TemporalUnit unit) {
//        return MoreTemporalAssertHelper.minus(amountToSubtract, unit, (SELF) this, s -> DefaultMoreTemporalAssert::new);
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
//    public MoreTemporalAssert<?, Temporal> extractingMinus(final TemporalAmount amount) {
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
//    public MoreTemporalAssert<?, Temporal> extractingPlus(final long amountToSubtract, final TemporalUnit unit) {
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
//    public MoreTemporalAssert<?, Temporal> extractingPlus(final TemporalAmount amount) {
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
}
