package com.github.jinahya.assertj.more.java.time;

import com.github.jinahya.assertj.more.hidden.ForAssert;
import com.github.jinahya.assertj.more.java.time.chrono.MoreChronoZonedDateTimeAssert;

import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAmount;
import java.time.temporal.TemporalField;
import java.time.temporal.TemporalUnit;

public interface MoreZonedDateTimeAssert<S extends MoreZonedDateTimeAssert<S>>
        extends MoreJavaTimeAssert<S, ZonedDateTime>,
                MoreChronoZonedDateTimeAssert<S, ZonedDateTime, LocalDate> {

    @Override
    default MoreZonedDateTimeAssert<?> extractingMinus(final long amountToSubtract, final TemporalUnit unit) {
        return ForAssert.applyNonNullActual1(
                isNotNull(),
                a -> MoreJavaTimeAssertions.assertMore(a.minus(amountToSubtract, unit))
        );
    }

    @Override
    default MoreZonedDateTimeAssert<?> extractingMinus(final TemporalAmount amount) {
        return ForAssert.applyNonNullActual1(
                isNotNull(),
                a -> MoreJavaTimeAssertions.assertMore(a.minus(amount))
        );
    }

    @Override
    default MoreZonedDateTimeAssert<?> extractingPlus(final long amountToAdd, final TemporalUnit unit) {
        return ForAssert.applyNonNullActual1(
                isNotNull(),
                a -> MoreJavaTimeAssertions.assertMore(a.plus(amountToAdd, unit))
        );
    }

    @Override
    default MoreZonedDateTimeAssert<?> extractingPlus(final TemporalAmount amount) {
        return ForAssert.applyNonNullActual1(
                isNotNull(),
                a -> MoreJavaTimeAssertions.assertMore(a.plus(amount))
        );
    }

    @Override
    default MoreZonedDateTimeAssert<?> extractingWith(final TemporalAdjuster adjuster) {
        return ForAssert.applyNonNullActual1(
                isNotNull(),
                a -> MoreJavaTimeAssertions.assertMore(a.with(adjuster))
        );
    }

    @Override
    default MoreZonedDateTimeAssert<?> extractingWith(final TemporalField field, final long newValue) {
        return ForAssert.applyNonNullActual1(
                isNotNull(),
                a -> MoreJavaTimeAssertions.assertMore(a.with(field, newValue))
        );
    }
}
