package com.github.jinahya.assertj.more.java.time;

import com.github.jinahya.assertj.more.hidden.ForAssert;
import com.github.jinahya.assertj.more.java.time.temporal.MoreTemporalAdjusterAssert;
import com.github.jinahya.assertj.more.java.time.temporal.MoreTemporalAssert;
import org.assertj.core.api.AbstractIntegerAssert;
import org.assertj.core.api.AbstractStringAssert;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.ComparableAssert;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAmount;
import java.time.temporal.TemporalField;
import java.time.temporal.TemporalUnit;
import java.util.Objects;

public interface MoreLocalTimeAssert<S extends MoreLocalTimeAssert<S>>
        extends MoreJavaTimeAssert<S, LocalTime>,
                MoreTemporalAssert<S, LocalTime>,
                MoreTemporalAdjusterAssert<S, LocalTime>,
                ComparableAssert<S, LocalTime> {

    default AbstractMoreLocalDateTimeAssert<?> extractingAtDate(final LocalDate date) {
        Objects.requireNonNull(date, "date is null");
        return ForAssert.applyActual2(
                isNotNull(),
                s -> a -> MoreJavaTimeAssertions.assertMore(a.atDate(date))
        );
    }

    default AbstractMoreOffsetTimeAssert<?> extractingAtOffset(final ZoneOffset offset) {
        Objects.requireNonNull(offset, "offset is null");
        return ForAssert.applyActual2(
                isNotNull(),
                s -> a -> MoreJavaTimeAssertions.assertMore(a.atOffset(offset))
        );
    }

    default AbstractStringAssert<?> extractingFormat(final DateTimeFormatter formatter) {
        Objects.requireNonNull(formatter, "formatter is null");
        return ForAssert.applyActual2(
                isNotNull(),
                s -> a -> {
                    final String[] results = new String[1];
                    Assertions.assertThatCode(() -> {
                                results[0] = a.format(formatter);
                            })
                            .doesNotThrowAnyException();
                    return Assertions.assertThat(results[0]);
                }
        );
    }

    default AbstractIntegerAssert<?> extractingHour() {
        return ForAssert.applyActual2(
                isNotNull(),
                s -> a -> Assertions.assertThat(a.getHour())
        );
    }

    @SuppressWarnings({"unechcked"})
    default S hasHour(final int expected) {
        extractingHour()
                .isEqualTo(expected);
        return (S) this;
    }

    default AbstractIntegerAssert<?> extractingMinute() {
        return ForAssert.applyActual2(
                isNotNull(),
                s -> a -> Assertions.assertThat(a.getMinute())
        );
    }

    @SuppressWarnings({"unechcked"})
    default S hasMinute(final int expected) {
        extractingMinute()
                .isEqualTo(expected);
        return (S) this;
    }

    default AbstractIntegerAssert<?> extractingNano() {
        return ForAssert.applyActual2(
                isNotNull(),
                s -> a -> Assertions.assertThat(a.getNano())
        );
    }

    @SuppressWarnings({"unechcked"})
    default S hasNano(final int expected) {
        extractingNano()
                .isEqualTo(expected);
        return (S) this;
    }

    default AbstractIntegerAssert<?> extractingSecond() {
        return ForAssert.applyActual2(
                isNotNull(),
                s -> a -> Assertions.assertThat(a.getSecond())
        );
    }

    @SuppressWarnings({"unechcked"})
    default S hasSecond(final int expected) {
        return ForAssert.applyActual2(
                isNotNull(),
                s -> a -> {
                    Assertions.assertThat(a.getSecond())
                            .isEqualTo(expected);
                    return s;
                }
        );
    }

    @Deprecated // AbstractLocalTimeAssert#isAfter(LocalTime)
    default S isAfter(final LocalTime other) {
        return ForAssert.applyActual2(
                isNotNull(),
                s -> a -> {
                    Assertions.assertThat(a.isAfter(other))
                            .isTrue();
                    return s;
                }
        );
    }

    default S isNotAfter(final LocalTime other) {
        return ForAssert.applyActual2(
                isNotNull(),
                s -> a -> {
                    Assertions.assertThat(a.isAfter(other))
                            .isFalse();
                    return s;
                }
        );
    }

    @Deprecated // AbstractLocalTimeAssert#isBefore(LocalTime)
    default S isBefore(final LocalTime other) {
        return ForAssert.applyActual2(
                isNotNull(),
                s -> a -> {
                    Assertions.assertThat(a.isBefore(other))
                            .isTrue();
                    return s;
                }
        );
    }

    default S isNotBefore(final LocalTime other) {
        return ForAssert.applyActual2(
                isNotNull(),
                s -> a -> {
                    Assertions.assertThat(a.isBefore(other))
                            .isFalse();
                    return s;
                }
        );
    }

    @Override
    default AbstractMoreLocalTimeAssert<?> extractingMinus(final long amountToSubtract, final TemporalUnit unit) {
        return ForAssert.applyActual2(
                isNotNull(),
                s -> a -> MoreJavaTimeAssertions.assertMore(a.minus(amountToSubtract, unit))
        );
    }

    @Override
    default AbstractMoreLocalTimeAssert<?> extractingMinus(final TemporalAmount amount) {
        return ForAssert.applyActual2(
                isNotNull(),
                s -> a -> MoreJavaTimeAssertions.assertMore(a.minus(amount))
        );
    }

    default AbstractMoreLocalTimeAssert<?> extractingMinusHours(final long hoursToSubtract) {
        return ForAssert.applyActual2(
                isNotNull(),
                s -> a -> MoreJavaTimeAssertions.assertMore(a.minusHours(hoursToSubtract))
        );
    }

    default AbstractMoreLocalTimeAssert<?> extractingMinusMinutes(final long minutesToSubtract) {
        return ForAssert.applyActual2(
                isNotNull(),
                s -> a -> MoreJavaTimeAssertions.assertMore(a.minusMinutes(minutesToSubtract))
        );
    }

    default AbstractMoreLocalTimeAssert<?> extractingMinusNanos(final long nanosToSubtract) {
        return ForAssert.applyActual2(
                isNotNull(),
                s -> a -> MoreJavaTimeAssertions.assertMore(a.minusNanos(nanosToSubtract))
        );
    }

    default AbstractMoreLocalTimeAssert<?> extractingMinusSeconds(final long secondsToSubtract) {
        return ForAssert.applyActual2(
                isNotNull(),
                s -> a -> MoreJavaTimeAssertions.assertMore(a.minusSeconds(secondsToSubtract))
        );
    }

    @Override
    default AbstractMoreLocalTimeAssert<?> extractingPlus(final long amountToSubtract, final TemporalUnit unit) {
        return ForAssert.applyActual2(
                isNotNull(),
                s -> a -> MoreJavaTimeAssertions.assertMore(a.plus(amountToSubtract, unit))
        );
    }

    @Override
    default AbstractMoreLocalTimeAssert<?> extractingPlus(final TemporalAmount amount) {
        return ForAssert.applyActual2(
                isNotNull(),
                s -> a -> MoreJavaTimeAssertions.assertMore(a.plus(amount))
        );
    }

    default AbstractMoreLocalTimeAssert<?> extractingPlusHours(final long hoursToSubtract) {
        return ForAssert.applyActual2(
                isNotNull(),
                s -> a -> MoreJavaTimeAssertions.assertMore(a.plusHours(hoursToSubtract))
        );
    }

    default AbstractMoreLocalTimeAssert<?> extractingPlusMinutes(final long minutesToSubtract) {
        return ForAssert.applyActual2(
                isNotNull(),
                s -> a -> MoreJavaTimeAssertions.assertMore(a.plusMinutes(minutesToSubtract))
        );
    }

    default AbstractMoreLocalTimeAssert<?> extractingPlusNanos(final long nanosToSubtract) {
        return ForAssert.applyActual2(
                isNotNull(),
                s -> a -> MoreJavaTimeAssertions.assertMore(a.plusNanos(nanosToSubtract))
        );
    }

    default AbstractMoreLocalTimeAssert<?> extractingPlusSeconds(final long secondsToSubtract) {
        return ForAssert.applyActual2(
                isNotNull(),
                s -> a -> MoreJavaTimeAssertions.assertMore(a.plusSeconds(secondsToSubtract))
        );
    }

    default S hasNanoOfDay(final long expected) {
        return ForAssert.applyActual2(
                isNotNull(),
                s -> a -> {
                    Assertions.assertThat(a.toNanoOfDay())
                            .isEqualTo(expected);
                    return s;
                }
        );
    }

    default S hasSecondOfDay(final int expected) {
        return ForAssert.applyActual2(
                isNotNull(),
                s -> a -> {
                    Assertions.assertThat(a.toSecondOfDay())
                            .isEqualTo(expected);
                    return s;
                }
        );
    }

    default AbstractMoreLocalTimeAssert<?> extractingTruncatedTo(final TemporalUnit unit) {
        return ForAssert.applyActual2(
                isNotNull(),
                s -> a -> {
                    final LocalTime[] results = new LocalTime[1];
                    Assertions.assertThatCode(() -> {
                                results[0] = a.truncatedTo(unit);
                            })
                            .doesNotThrowAnyException();
                    return MoreJavaTimeAssertions.assertMore(results[0]);
                }
        );
    }

    @Override
    default AbstractMoreLocalTimeAssert<?> with(TemporalAdjuster adjuster) {
        return ForAssert.applyActual2(
                isNotNull(),
                s -> a -> MoreJavaTimeAssertions.assertMore(a.with(adjuster))
        );
    }

    @Override
    default AbstractMoreLocalTimeAssert<?> with(TemporalField field, long newValue) {
        return ForAssert.applyActual2(
                isNotNull(),
                s -> a -> MoreJavaTimeAssertions.assertMore(a.with(field, newValue))
        );
    }

    default AbstractMoreLocalTimeAssert<?> extractingWithHour(final int hour) {
        return ForAssert.applyActual2(
                isNotNull(),
                s -> a -> MoreJavaTimeAssertions.assertMore(a.withHour(hour))
        );
    }

    default AbstractMoreLocalTimeAssert<?> extractingWithMinute(final int minute) {
        return ForAssert.applyActual2(
                isNotNull(),
                s -> a -> MoreJavaTimeAssertions.assertMore(a.withMinute(minute))
        );
    }

    default AbstractMoreLocalTimeAssert<?> extractingWithNano(final int nanoOfSecond) {
        return ForAssert.applyActual2(
                isNotNull(),
                s -> a -> MoreJavaTimeAssertions.assertMore(a.withNano(nanoOfSecond))
        );
    }

    default AbstractMoreLocalTimeAssert<?> extractingWithSecond(final int second) {
        return ForAssert.applyActual2(
                isNotNull(),
                s -> a -> MoreJavaTimeAssertions.assertMore(a.withSecond(second))
        );
    }
}
