package com.github.jinahya.assertj.more.java.time;

import com.github.jinahya.assertj.more.hidden.ForAssert;
import com.github.jinahya.assertj.more.java.time.chrono.MoreChronoLocalDateTimeAssert;
import com.github.jinahya.assertj.more.java.time.temporal.MoreTemporalAssert;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAmount;
import java.time.temporal.TemporalField;
import java.time.temporal.TemporalUnit;

public interface MoreLocalDateTimeAssert<S extends MoreLocalDateTimeAssert<S>>
        extends MoreJavaTimeAssert<S, LocalDateTime>,
                MoreChronoLocalDateTimeAssert<S, LocalDateTime, LocalDate>,
                MoreTemporalAssert<S, LocalDateTime> {

    @Override
    default MoreLocalDateTimeAssert<?> extractingMinus(final long amountToSubtract, final TemporalUnit unit) {
        return ForAssert.applyNonNullActual1(
                isNotNull(),
                a -> MoreJavaTimeAssertions.assertMore(a.minus(amountToSubtract, unit))
        );
    }

    @Override
    default MoreLocalDateTimeAssert<?> extractingMinus(final TemporalAmount amount) {
        return ForAssert.applyNonNullActual1(
                isNotNull(),
                a -> MoreJavaTimeAssertions.assertMore(a.minus(amount))
        );
    }

    @Override
    default MoreLocalDateTimeAssert<?> extractingPlus(final long amountToAdd, final TemporalUnit unit) {
        return ForAssert.applyNonNullActual1(
                isNotNull(),
                a -> MoreJavaTimeAssertions.assertMore(a.plus(amountToAdd, unit))
        );
    }

    @Override
    default MoreLocalDateTimeAssert<?> extractingPlus(final TemporalAmount amount) {
        return ForAssert.applyNonNullActual1(
                isNotNull(),
                a -> MoreJavaTimeAssertions.assertMore(a.plus(amount))
        );
    }

    @Override
    default MoreLocalDateTimeAssert<?> with(final TemporalAdjuster adjuster) {
        return ForAssert.applyNonNullActual1(
                isNotNull(),
                a -> MoreJavaTimeAssertions.assertMore(a.with(adjuster))
        );
    }

    @Override
    default MoreLocalDateTimeAssert<?> with(final TemporalField field, final long newValue) {
        return ForAssert.applyNonNullActual1(
                isNotNull(),
                a -> MoreJavaTimeAssertions.assertMore(a.with(field, newValue))
        );
    }
}
