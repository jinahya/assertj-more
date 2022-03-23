package com.github.jinahya.assertj.more.java.time;

import com.github.jinahya.assertj.more.hidden.ForAssert;
import com.github.jinahya.assertj.more.java.time.temporal.MoreTemporalAdjusterAssert;
import com.github.jinahya.assertj.more.java.time.temporal.MoreTemporalAssert;
import org.assertj.core.api.AbstractLongAssert;
import org.assertj.core.api.Assertions;

import java.time.Instant;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAmount;
import java.time.temporal.TemporalField;
import java.time.temporal.TemporalUnit;

public interface MoreInstantAssert<S extends MoreInstantAssert<S>>
        extends MoreJavaTimeAssert<S, Instant>,
                MoreTemporalAssert<S, Instant>,
                MoreTemporalAdjusterAssert<S, Instant> {

    // ----------------------------------------------------------------------------------------------- getEpochSecond()J
    default AbstractLongAssert<?> extractingEpochSecond() {
        return MoreInstantAssertHelper.getEpochSecond((S) this, s -> Assertions::assertThat);
    }

    default S hasEpochSecond(final long expected) {
        return MoreInstantAssertHelper.getEpochSecond((S) this, s -> r -> {
            Assertions.assertThat(r).isEqualTo(expected);
            return s;
        });
    }

    @Override
    default MoreInstantAssert<?> extractingMinus(final long amountToSubtract, final TemporalUnit unit) {
        return ForAssert.applyNonNullActual1(
                isNotNull(),
                a -> MoreJavaTimeAssertions.assertMore(a.minus(amountToSubtract, unit))
        );
    }

    @Override
    default MoreInstantAssert<?> extractingMinus(final TemporalAmount amount) {
        return ForAssert.applyNonNullActual1(
                isNotNull(),
                a -> MoreJavaTimeAssertions.assertMore(a.minus(amount))
        );
    }

    @Override
    default MoreInstantAssert<?> extractingPlus(final long amountToAdd, final TemporalUnit unit) {
        return ForAssert.applyNonNullActual1(
                isNotNull(),
                a -> MoreJavaTimeAssertions.assertMore(a.plus(amountToAdd, unit))
        );
    }

    @Override
    default MoreInstantAssert<?> extractingPlus(final TemporalAmount amount) {
        return ForAssert.applyNonNullActual1(
                isNotNull(),
                a -> MoreJavaTimeAssertions.assertMore(a.plus(amount))
        );
    }

    @Override
    default MoreInstantAssert<?> with(final TemporalAdjuster adjuster) {
        return ForAssert.applyNonNullActual1(
                isNotNull(),
                a -> MoreJavaTimeAssertions.assertMore(a.with(adjuster))
        );
    }

    @Override
    default MoreInstantAssert<?> with(final TemporalField field, final long newValue) {
        return ForAssert.applyNonNullActual1(
                isNotNull(),
                a -> MoreJavaTimeAssertions.assertMore(a.with(field, newValue))
        );
    }
}
