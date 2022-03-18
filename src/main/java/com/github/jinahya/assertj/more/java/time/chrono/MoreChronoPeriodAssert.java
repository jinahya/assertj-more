package com.github.jinahya.assertj.more.java.time.chrono;

import com.github.jinahya.assertj.more.hidden.ForAssert;
import com.github.jinahya.assertj.more.java.time.temporal.MoreTemporalAmountAssert;
import org.assertj.core.api.AbstractBooleanAssert;
import org.assertj.core.api.Assertions;

import java.time.chrono.ChronoPeriod;
import java.time.chrono.Chronology;
import java.time.temporal.TemporalAmount;

/**
 * An interface for verifying values of {@link ChronoPeriod} interface.
 *
 * @param <S> self type parameter
 * @param <A> actual type parameter
 * @author Jin Kwon &lt;onacit_at_gmail.com&gt;
 */
public interface MoreChronoPeriodAssert<S extends MoreChronoPeriodAssert<S, A>, A extends ChronoPeriod>
        extends MoreJavaTimeChronoAssert<S, A>,
                MoreTemporalAmountAssert<S, A> {

    default AbstractMoreChronologyAssert<?, Chronology> extractingChronology() {
        return ForAssert.applyNonNullActual1(
                isNotNull(),
                a -> MoreJavaTimeChronoAssertions.assertMore(a.getChronology())
        );
    }

    default AbstractBooleanAssert<?> extractingIsZero() {
        return ForAssert.applyNonNullActual1(
                isNotNull(),
                a -> Assertions.assertThat(a.isZero())
        );
    }

    default S isZero() {
        return ForAssert.applyNonNullActual2(
                isNotNull(),
                s -> a -> {
                    Assertions.assertThat(a.isZero()).isTrue();
                    return s;
                }
        );
    }

    default S isNotZero() {
        return ForAssert.applyNonNullActual2(
                isNotNull(),
                s -> a -> {
                    Assertions.assertThat(a.isZero()).isFalse();
                    return s;
                }
        );
    }

    default AbstractBooleanAssert<?> extractingIsNegative() {
        return ForAssert.applyNonNullActual1(
                isNotNull(),
                a -> Assertions.assertThat(a.isNegative())
        );
    }

    default S isNegative() {
        return ForAssert.applyNonNullActual2(
                isNotNull(),
                s -> a -> {
                    Assertions.assertThat(a.isNegative())
                            .isTrue();
                    return s;
                }
        );
    }

    default S isNotNegative() {
        return ForAssert.applyNonNullActual2(
                isNotNull(),
                s -> a -> {
                    Assertions.assertThat(a.isNegative())
                            .isFalse();
                    return s;
                }
        );
    }

    MoreChronoPeriodAssert<?, A> extractingPlus(TemporalAmount amountToAdd);

    MoreChronoPeriodAssert<?, A> extractingMinus(TemporalAmount amountToSubtract);

    MoreChronoPeriodAssert<?, A> extractingMultipliedBy(int scalar);

    MoreChronoPeriodAssert<?, A> extractingNegated();

    MoreChronoPeriodAssert<?, A> extractingNormalized();
}
