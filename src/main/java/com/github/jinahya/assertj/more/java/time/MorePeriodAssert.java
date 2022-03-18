package com.github.jinahya.assertj.more.java.time;

import com.github.jinahya.assertj.more.hidden.ForAssert;
import com.github.jinahya.assertj.more.java.time.chrono.MoreChronoPeriodAssert;

import java.time.Period;
import java.time.temporal.TemporalAmount;

public interface MorePeriodAssert<S extends MorePeriodAssert<S>>
        extends MoreJavaTimeAssert<S, Period>,
                MoreChronoPeriodAssert<S, Period> {

    @Override
    default AbstractMorePeriodAssert<?> extractingPlus(final TemporalAmount amountToAdd) {
        return ForAssert.applyNonNullActual1(
                isNotNull(),
                a -> MoreJavaTimeAssertions.assertMore(a.plus(amountToAdd))
        );
    }

    @Override
    default AbstractMorePeriodAssert<?> extractingMinus(final TemporalAmount amountToSubtract) {
        return ForAssert.applyNonNullActual1(
                isNotNull(),
                a -> MoreJavaTimeAssertions.assertMore(a.plus(amountToSubtract))
        );
    }

    @Override
    default AbstractMorePeriodAssert<?> extractingMultipliedBy(final int scalar) {
        return ForAssert.applyNonNullActual1(
                isNotNull(),
                a -> MoreJavaTimeAssertions.assertMore(a.multipliedBy(scalar))
        );
    }

    @Override
    default AbstractMorePeriodAssert<?> extractingNegated() {
        return ForAssert.applyNonNullActual1(
                isNotNull(),
                a -> MoreJavaTimeAssertions.assertMore(a.negated())
        );
    }

    @Override
    default AbstractMorePeriodAssert<?> extractingNormalized() {
        return ForAssert.applyNonNullActual1(
                isNotNull(),
                a -> MoreJavaTimeAssertions.assertMore(a.normalized())
        );
    }
}
