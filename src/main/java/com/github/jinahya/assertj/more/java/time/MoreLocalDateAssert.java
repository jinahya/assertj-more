package com.github.jinahya.assertj.more.java.time;

import com.github.jinahya.assertj.more.hidden.ForAssert;
import com.github.jinahya.assertj.more.java.time.chrono.MoreChronoLocalDateAssert;
import org.assertj.core.api.AbstractComparableAssert;
import org.assertj.core.api.AbstractIntegerAssert;
import org.assertj.core.api.Assertions;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.time.OffsetTime;
import java.time.ZoneId;
import java.time.chrono.ChronoLocalDate;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAmount;
import java.time.temporal.TemporalField;
import java.time.temporal.TemporalUnit;

public interface MoreLocalDateAssert<S extends MoreLocalDateAssert<S>>
        extends MoreJavaTimeAssert<S, LocalDate>,
                MoreChronoLocalDateAssert<S, LocalDate> {

    /**
     * Returns a new assertion instance for verifying the result of
     * {@link LocalDate#atStartOfDay() actual.atStartOfDay()}.
     *
     * @return a new assertion of {@link java.time.LocalDateTime}.
     * @see LocalDate#atStartOfDay()
     */
    default AbstractMoreLocalDateTimeAssert<?> extractingAtStartOfDay() {
        return ForAssert.applyActual2(
                isNotNull(),
                s -> a -> MoreJavaTimeAssertions.assertMore(a.atStartOfDay())
        );
    }

    /**
     * Returns a new assertion instance for verifying the result of
     * {@link LocalDate#atStartOfDay(ZoneId) actual.atStartOfDay(zone)}.
     *
     * @param zone the argument.
     * @return a new assertion of {@link java.time.LocalDateTime}.
     * @see LocalDate#atStartOfDay(ZoneId)
     */
    default AbstractMoreZonedDateTimeAssert<?> extractingAtStartOfDay(final ZoneId zone) {
        return ForAssert.applyActual2(
                isNotNull(),
                s -> a -> MoreJavaTimeAssertions.assertMore(a.atStartOfDay(zone))
        );
    }

    /**
     * Returns a new assertion instance for verifying the result of
     * {@link LocalDate#atTime(int, int, int) actual.atTime(hour, minute, second)}
     *
     * @param hour   the hour.
     * @param minute the minute.
     * @param second the second
     * @return a new assertion of {@link java.time.LocalDateTime}.
     * @see LocalDate#atTime(int, int, int)
     */
    default AbstractMoreLocalDateTimeAssert<?> extractingAtTime(final int hour, final int minute, final int second) {
        return ForAssert.applyActual2(
                isNotNull(),
                s -> a -> MoreJavaTimeAssertions.assertMore(a.atTime(hour, minute, second))
        );
    }

    /**
     * Returns a new assertion instance for verifying the result of
     * {@link LocalDate#atTime(int, int, int, int) actual.atTime(hour, minute, second, nanoOfSecond)}
     *
     * @param hour         a value for the {@code hour} argument.
     * @param minute       a value for the {@code minute} argument.
     * @param second       a value for the {@code second} argument.
     * @param nanoOfSecond a value for the {@code nanoOfSecond}.
     * @return a new assertion of {@link java.time.LocalDateTime}.
     * @see LocalDate#atTime(int, int, int, int)
     */
    default AbstractMoreLocalDateTimeAssert<?> extractingAtTime(final int hour, final int minute, final int second,
                                                                int nanoOfSecond) {
        return ForAssert.applyActual2(
                isNotNull(),
                s -> a -> MoreJavaTimeAssertions.assertMore(a.atTime(hour, minute, second, nanoOfSecond))
        );
    }

    @Override
    default AbstractMoreLocalDateTimeAssert<?> extractingAtTime(final LocalTime time) {
        return ForAssert.applyActual2(
                isNotNull(),
                s -> a -> MoreJavaTimeAssertions.assertMore(a.atTime(time))
        );
    }

    default AbstractMoreOffsetDateTimeAssert<?> extractingAtTime(final OffsetTime time) {
        return ForAssert.applyActual2(
                isNotNull(),
                s -> a -> MoreJavaTimeAssertions.assertMore(a.atTime(time))
        );
    }

    default AbstractIntegerAssert<?> extractingDayOfMonth() {
        return ForAssert.applyActual2(
                isNotNull(),
                s -> a -> Assertions.assertThat(a.getDayOfMonth())
        );
    }

    @SuppressWarnings({"unchecked"})
    default S hasDayOfMonth(final int expected) {
        extractingDayOfMonth()
                .isEqualTo(expected);
        return (S) this;
    }

    default AbstractComparableAssert<?, DayOfWeek> extractingDayOfWeek() {
        return ForAssert.applyActual2(
                isNotNull(),
                s -> a -> (AbstractComparableAssert<?, DayOfWeek>) Assertions.assertThat(a.getDayOfWeek())
        );
    }

    @SuppressWarnings({"unchecked"})
    default S hasDayOfWeek(final DayOfWeek expected) {
        extractingDayOfWeek()
                .isSameAs(expected);
        return (S) this;
    }

    default AbstractIntegerAssert<?> extractingDayOfYear() {
        return ForAssert.applyActual2(
                isNotNull(),
                s -> a -> Assertions.assertThat(a.getDayOfYear())
        );
    }

    @SuppressWarnings({"unchecked"})
    default S hasDayOfYear(final int expected) {
        extractingDayOfYear()
                .isEqualTo(expected);
        return (S) this;
    }

    default AbstractComparableAssert<?, Month> extractingMonth() {
        return ForAssert.applyActual2(
                isNotNull(),
                s -> a -> (AbstractComparableAssert<?, Month>) Assertions.assertThat(a.getMonth())

        );
    }

    @SuppressWarnings({"unchecked"})
    default S hasMonth(final Month expected) {
        extractingMonth()
                .isSameAs(expected);
        return (S) this;
    }

    default AbstractIntegerAssert<?> extractingMonthValue() {
        return ForAssert.applyActual2(
                isNotNull(),
                s -> a -> Assertions.assertThat(a.getMonthValue())
        );
    }

    @SuppressWarnings({"unchecked"})
    default S hasMonthValue(final int expected) {
        extractingMonthValue()
                .isEqualTo(expected);
        return (S) this;
    }

    default AbstractIntegerAssert<?> extractingYear() {
        return ForAssert.applyActual2(
                isNotNull(),
                s -> a -> Assertions.assertThat(a.getYear())
        );
    }

    @SuppressWarnings({"unchecked"})
    default S hasYear(final int expected) {
        extractingYear()
                .isEqualTo(expected);
        return (S) this;
    }

    @Override
    default AbstractMoreLocalDateAssert<?> extractingMinus(long amountToSubtract, TemporalUnit unit) {
        return ForAssert.applyActual2(
                isNotNull(),
                s -> a -> {
                    final LocalDate[] results = new LocalDate[1];
                    Assertions.assertThatCode(() -> results[0] = a.minus(amountToSubtract, unit))
                            .doesNotThrowAnyException();
                    return MoreJavaTimeAssertions.assertMore(results[0]);
                }
        );
    }

    @Override
    default AbstractMoreLocalDateAssert<?> extractingMinus(final TemporalAmount amount) {
        return ForAssert.applyActual2(
                isNotNull(),
                s -> a -> {
                    final LocalDate[] results = new LocalDate[1];
                    Assertions.assertThatCode(() -> results[0] = a.minus(amount))
                            .doesNotThrowAnyException();
                    return MoreJavaTimeAssertions.assertMore(results[0]);
                }
        );
    }

    @Override
    default AbstractMoreLocalDateAssert<?> extractingPlus(long amountToAdd, TemporalUnit unit) {
        return ForAssert.applyActual2(
                isNotNull(),
                s -> a -> MoreJavaTimeAssertions.assertMore(a.plus(amountToAdd, unit))
        );
    }

    @Override
    default AbstractMoreLocalDateAssert<?> extractingPlus(final TemporalAmount amount) {
        return ForAssert.applyActual2(
                isNotNull(),
                s -> a -> MoreJavaTimeAssertions.assertMore(a.plus(amount))
        );
    }

    default AbstractMoreLocalDateAssert<?> extractingMinusDays(final int daysToSubtract) {
        return ForAssert.applyActual2(
                isNotNull(),
                s -> a -> MoreJavaTimeAssertions.assertMore(a.minusDays(daysToSubtract))
        );
    }

    default AbstractMoreLocalDateAssert<?> extractingMinusMonths(final int monthsToSubtract) {
        return ForAssert.applyActual2(
                isNotNull(),
                s -> a -> MoreJavaTimeAssertions.assertMore(a.minusMonths(monthsToSubtract))
        );
    }

    default AbstractMoreLocalDateAssert<?> extractingMinusWeeks(final int weeksToSubtract) {
        return ForAssert.applyActual2(
                isNotNull(),
                s -> a -> MoreJavaTimeAssertions.assertMore(a.minusWeeks(weeksToSubtract))
        );
    }

    default AbstractMoreLocalDateAssert<?> extractingMinusYears(final int yearsToSubtract) {
        return ForAssert.applyActual2(
                isNotNull(),
                s -> a -> MoreJavaTimeAssertions.assertMore(a.minusYears(yearsToSubtract))
        );
    }

    default AbstractMoreLocalDateAssert<?> extractingWithYear(final int year) {
        return ForAssert.applyActual2(
                isNotNull(),
                s -> a -> MoreJavaTimeAssertions.assertMore(a.withYear(year))
        );
    }

    default AbstractMoreLocalDateAssert<?> extractingWithMonth(final int month) {
        return ForAssert.applyActual2(
                isNotNull(),
                s -> a -> MoreJavaTimeAssertions.assertMore(a.withMonth(month))
        );
    }

    default AbstractMoreLocalDateAssert<?> extractingWithDayOfMonth(final int dayOfMonth) {
        return ForAssert.applyActual2(
                isNotNull(),
                s -> a -> MoreJavaTimeAssertions.assertMore(a.withDayOfMonth(dayOfMonth))
        );
    }

    default AbstractMoreLocalDateAssert<?> extractingWithDayOfYear(final int dayOfYear) {
        return ForAssert.applyActual2(
                isNotNull(),
                s -> a -> MoreJavaTimeAssertions.assertMore(a.withDayOfYear(dayOfYear))
        );
    }

    default AbstractMoreLocalDateAssert<?> extractingPlusYears(final int yearsToAdd) {
        return ForAssert.applyActual2(
                isNotNull(),
                s -> a -> MoreJavaTimeAssertions.assertMore(a.plusYears(yearsToAdd))
        );
    }

    default AbstractMoreLocalDateAssert<?> extractingPlusMonths(final int monthsToAdd) {
        return ForAssert.applyActual2(
                isNotNull(),
                s -> a -> MoreJavaTimeAssertions.assertMore(a.plusMonths(monthsToAdd))
        );
    }

    default AbstractMoreLocalDateAssert<?> extractingPlusWeeks(final int weeksToAdd) {
        return ForAssert.applyActual2(
                isNotNull(),
                s -> a -> MoreJavaTimeAssertions.assertMore(a.plusWeeks(weeksToAdd))
        );
    }

    default AbstractMoreLocalDateAssert<?> extractingPlusDays(final int daysToAdd) {
        return ForAssert.applyActual2(
                isNotNull(),
                s -> a -> MoreJavaTimeAssertions.assertMore(a.plusDays(daysToAdd))
        );
    }

    @Override
    default AbstractMorePeriodAssert<?> extractingUntil(final ChronoLocalDate endDateExclusive) {
        return ForAssert.applyActual2(
                isNotNull(),
                s -> a -> MoreJavaTimeAssertions.assertMore(a.until(endDateExclusive))
        );
    }

    @Override
    default AbstractMoreLocalDateAssert<?> extractingWith(final TemporalAdjuster adjuster) {
        return ForAssert.applyActual2(
                isNotNull(),
                s -> a -> MoreJavaTimeAssertions.assertMore(a.with(adjuster))
        );
    }

    @Override
    default AbstractMoreLocalDateAssert<?> extractingWith(final TemporalField field, final long newValue) {
        return ForAssert.applyActual2(
                isNotNull(),
                s -> a -> MoreJavaTimeAssertions.assertMore(a.with(field, newValue))
        );
    }
}
