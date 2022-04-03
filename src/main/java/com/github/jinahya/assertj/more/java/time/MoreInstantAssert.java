package com.github.jinahya.assertj.more.java.time;

import com.github.jinahya.assertj.more.api.MoreAssertions;
import com.github.jinahya.assertj.more.hidden.ForAssert;
import com.github.jinahya.assertj.more.java.time.temporal.MoreTemporalAdjusterAssert;
import com.github.jinahya.assertj.more.java.time.temporal.MoreTemporalAssert;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.ComparableAssert;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAmount;
import java.time.temporal.TemporalField;
import java.time.temporal.TemporalUnit;
import java.util.Objects;

public interface MoreInstantAssert<S extends MoreInstantAssert<S>>
        extends ComparableAssert<S, Instant>,
                MoreJavaTimeAssert<S, Instant>,
                MoreTemporalAssert<S, Instant>,
                MoreTemporalAdjusterAssert<S, Instant> {

    default AbstractMoreOffsetDateTimeAssert<?> extractingAtOffset(final ZoneOffset offset) {
        Objects.requireNonNull(offset, "offset is null");
        return ForAssert.applyActual2(
                isNotNull(),
                s -> a -> MoreAssertions.assertThatCodeDoesNotThrowAnyExceptionAndApplyResult(
                        () -> a.atOffset(offset),
                        MoreJavaTimeAssertions::assertMore
                )
        );
    }

    default AbstractMoreZonedDateTimeAssert<?> extractingAtZone(final ZoneId zone) {
        Objects.requireNonNull(zone, "zone is null");
        return ForAssert.applyActual2(
                isNotNull(),
                s -> a -> MoreAssertions.assertThatCodeDoesNotThrowAnyExceptionAndApplyResult(
                        () -> a.atZone(zone),
                        MoreJavaTimeAssertions::assertMore
                )
        );
    }

    @SuppressWarnings({"unchecked"})
    default S hasEpochSecond(final long expected) {
        MoreInstantAssertHelper.extractingEpochSecond((S) this)
                .isEqualTo(expected);
        return (S) this;
    }

    @SuppressWarnings({"unchecked"})
    default S hasNano(final int expected) {
        MoreInstantAssertHelper.extractingNano((S) this)
                .isEqualTo(expected);
        return (S) this;
    }

    @SuppressWarnings({"unchecked"})
    default S isAfter(final Instant otherInstant) {
        MoreInstantAssertHelper.extractingIsAfter((S) this, otherInstant)
                .isTrue();
        return (S) this;
    }

    @SuppressWarnings({"unchecked"})
    default S isNotAfter(final Instant otherInstant) {
        MoreInstantAssertHelper.extractingIsAfter((S) this, otherInstant)
                .isFalse();
        return (S) this;
    }

    @SuppressWarnings({"unchecked"})
    default S isBefore(final Instant otherInstant) {
        MoreInstantAssertHelper.extractingIsBefore((S) this, otherInstant)
                .isTrue();
        return (S) this;
    }

    @SuppressWarnings({"unchecked"})
    default S isNotBefore(final Instant otherInstant) {
        MoreInstantAssertHelper.extractingIsBefore((S) this, otherInstant)
                .isFalse();
        return (S) this;
    }

    @Override
    default AbstractMoreInstantAssert<?> extractingMinus(final long amountToSubtract, final TemporalUnit unit) {
        Objects.requireNonNull(unit, "unit is null");
        return ForAssert.applyActual2(
                isNotNull(),
                s -> a -> MoreAssertions.assertThatCodeDoesNotThrowAnyExceptionAndApplyResult(
                        () -> a.minus(amountToSubtract, unit),
                        MoreJavaTimeAssertions::assertMore
                )
        );
    }

    @Override
    default AbstractMoreInstantAssert<?> extractingMinus(final TemporalAmount amount) {
        Objects.requireNonNull(amount, "amount is null");
        return ForAssert.applyActual2(
                isNotNull(),
                s -> a -> MoreAssertions.assertThatCodeDoesNotThrowAnyExceptionAndApplyResult(
                        () -> a.minus(amount),
                        MoreJavaTimeAssertions::assertMore
                )
        );
    }

    default AbstractMoreInstantAssert<?> extractingMinusMillis(final long millisToSubtract) {
        return ForAssert.applyActual2(
                isNotNull(),
                s -> a -> MoreAssertions.assertThatCodeDoesNotThrowAnyExceptionAndApplyResult(
                        () -> a.minusMillis(millisToSubtract),
                        MoreJavaTimeAssertions::assertMore
                )
        );
    }

    default AbstractMoreInstantAssert<?> extractingMinusNanos(final long nanosToSubtract) {
        return ForAssert.applyActual2(
                isNotNull(),
                s -> a -> MoreAssertions.assertThatCodeDoesNotThrowAnyExceptionAndApplyResult(
                        () -> a.minusNanos(nanosToSubtract),
                        MoreJavaTimeAssertions::assertMore
                )
        );
    }

    default AbstractMoreInstantAssert<?> extractingMinusSeconds(final long secondsToSubtract) {
        return ForAssert.applyActual2(
                isNotNull(),
                s -> a -> MoreAssertions.assertThatCodeDoesNotThrowAnyExceptionAndApplyResult(
                        () -> a.minusSeconds(secondsToSubtract),
                        MoreJavaTimeAssertions::assertMore
                )
        );
    }

    @Override
    default AbstractMoreInstantAssert<?> extractingPlus(final long amountToAdd, final TemporalUnit unit) {
        Objects.requireNonNull(unit, "unit is null");
        return ForAssert.applyActual2(
                isNotNull(),
                s -> a -> MoreAssertions.assertThatCodeDoesNotThrowAnyExceptionAndApplyResult(
                        () -> a.plus(amountToAdd, unit),
                        MoreJavaTimeAssertions::assertMore
                )
        );
    }

    @Override
    default AbstractMoreInstantAssert<?> extractingPlus(final TemporalAmount amount) {
        Objects.requireNonNull(amount, "amount is null");
        return ForAssert.applyActual2(
                isNotNull(),
                s -> a -> MoreAssertions.assertThatCodeDoesNotThrowAnyExceptionAndApplyResult(
                        () -> a.plus(amount),
                        MoreJavaTimeAssertions::assertMore
                )
        );
    }

    default AbstractMoreInstantAssert<?> extractingPlusMillis(final long millisToAdd) {
        return ForAssert.applyActual2(
                isNotNull(),
                s -> a -> MoreAssertions.assertThatCodeDoesNotThrowAnyExceptionAndApplyResult(
                        () -> a.plusMillis(millisToAdd),
                        MoreJavaTimeAssertions::assertMore
                )
        );
    }

    default AbstractMoreInstantAssert<?> extractingPlusNanos(final long nanosToAdd) {
        return ForAssert.applyActual2(
                isNotNull(),
                s -> a -> MoreAssertions.assertThatCodeDoesNotThrowAnyExceptionAndApplyResult(
                        () -> a.plusNanos(nanosToAdd),
                        MoreJavaTimeAssertions::assertMore
                )
        );
    }

    default MoreInstantAssert<?> extractingPlusSeconds(final long secondsToAdd) {
        return ForAssert.applyActual2(
                isNotNull(),
                s -> a -> MoreAssertions.assertThatCodeDoesNotThrowAnyExceptionAndApplyResult(
                        () -> a.plusSeconds(secondsToAdd),
                        MoreJavaTimeAssertions::assertMore
                )
        );
    }

    /**
     * Verifies that the result of {@link Instant#toEpochMilli()} method, invoked on the {@code actual}, is equal to
     * specified value.
     *
     * @param expected the expected value of {@code actual.toEpochMilli()}.
     * @return this assertion object.
     */
    default S hasEpochMilli(final long expected) {
        return ForAssert.applyActual2(
                isNotNull(),
                s -> a -> MoreAssertions.assertThatCodeDoesNotThrowAnyExceptionAndApplyResult(
                        a::toEpochMilli,
                        r -> {
                            Assertions.assertThat(r).isEqualTo(expected);
                            return s;
                        }
                )
        );
    }

    default AbstractMoreInstantAssert<?> extractingTruncatedTo(final TemporalUnit unit) {
        Objects.requireNonNull(unit, "unit is null");
        return ForAssert.applyActual2(
                isNotNull(),
                s -> a -> MoreAssertions.assertThatCodeDoesNotThrowAnyExceptionAndApplyResult(
                        () -> a.truncatedTo(unit),
                        MoreJavaTimeAssertions::assertMore
                )
        );
    }

    @Override
    default AbstractMoreInstantAssert<?> extractingWith(final TemporalAdjuster adjuster) {
        Objects.requireNonNull(adjuster, "adjuster is null");
        return ForAssert.applyActual2(
                isNotNull(),
                s -> a -> MoreAssertions.assertThatCodeDoesNotThrowAnyExceptionAndApplyResult(
                        () -> a.with(adjuster),
                        MoreJavaTimeAssertions::assertMore
                )
        );
    }

    @Override
    default AbstractMoreInstantAssert<?> extractingWith(final TemporalField field, final long newValue) {
        Objects.requireNonNull(field, "field is null");
        return ForAssert.applyActual2(
                isNotNull(),
                s -> a -> MoreAssertions.assertThatCodeDoesNotThrowAnyExceptionAndApplyResult(
                        () -> a.with(field, newValue),
                        MoreJavaTimeAssertions::assertMore
                )
        );
    }
}
