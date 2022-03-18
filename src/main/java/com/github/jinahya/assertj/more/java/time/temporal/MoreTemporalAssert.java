package com.github.jinahya.assertj.more.java.time.temporal;

import com.github.jinahya.assertj.more.hidden.ForAssert;
import org.assertj.core.api.AbstractLongAssert;
import org.assertj.core.api.Assertions;

import java.time.temporal.Temporal;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAmount;
import java.time.temporal.TemporalField;
import java.time.temporal.TemporalUnit;

/**
 * An abstract class for verifying instances of {@link Temporal} interface.
 *
 * @param <S> self type parameter
 * @param <A> actual type parameter
 * @author Jin Kwon &lt;onacit_at_gmail.com&gt;
 */
public interface MoreTemporalAssert<S extends MoreTemporalAssert<S, A>, A extends Temporal>
        extends MoreTemporalAccessorAssert<S, A> {

    // -------------------------------------------------------------------------------------- isSupported(TemporalUnit)Z
    default S supports(final TemporalUnit unit) {
        return MoreTemporalAssertHelper.extractingIsSupported(unit, (S) this, s -> a -> {
            a.isTrue();
            return s;
        });
    }

    default S doesNotSupport(final TemporalUnit unit) {
        return MoreTemporalAssertHelper.extractingIsSupported(unit, (S) this, s -> a -> {
            a.isFalse();
            return s;
        });
    }

    MoreTemporalAssert<?, A> extractingMinus(long amountToSubtract, TemporalUnit unit);

    MoreTemporalAssert<?, A> extractingMinus(TemporalAmount amount);

    MoreTemporalAssert<?, A> extractingPlus(long amountToAdd, TemporalUnit unit);

    MoreTemporalAssert<?, A> extractingPlus(TemporalAmount amount);

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
    default AbstractLongAssert<?> extractingUntil(Temporal endExclusive, TemporalUnit unit) {
        return ForAssert.applyNonNullActual1(
                isNotNull(),
                a -> Assertions.assertThat(a.until(endExclusive, unit))
        );
    }

    MoreTemporalAssert<?, ? extends Temporal> with(TemporalAdjuster adjuster);

    MoreTemporalAssert<?, ? extends Temporal> with(TemporalField field, long newValue);
}
