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
import java.time.temporal.TemporalAmount;
import java.time.temporal.TemporalUnit;
import java.util.Objects;
import java.util.function.Consumer;

public interface MoreLocalDateAssert<S extends MoreLocalDateAssert<S>>
        extends MoreJavaTimeAssert<S, LocalDate>,
                MoreChronoLocalDateAssert<S, LocalDate> {

    default AbstractMoreLocalDateTimeAssert<?> extractingAtStartOfDay() {
        return ForAssert.applyNonNullActual1(
                isNotNull(),
                a -> MoreJavaTimeAssertions.assertMore(a.atStartOfDay())
        );
    }

    default AbstractMoreZonedDateTimeAssert<?> extractingAtStartOfDay(final ZoneId zone) {
        return ForAssert.applyNonNullActual1(
                isNotNull(),
                a -> MoreJavaTimeAssertions.assertMore(a.atStartOfDay(zone))
        );
    }

    default AbstractMoreLocalDateTimeAssert<?> extractingAtTime(final int hour, final int minute, final int second) {
        return ForAssert.applyNonNullActual1(
                isNotNull(),
                a -> MoreJavaTimeAssertions.assertMore(a.atTime(hour, minute, second))
        );
    }

    default AbstractMoreLocalDateTimeAssert<?> extractingAtTime(final int hour, final int minute, final int second,
                                                                int nanoOfSecond) {
        return ForAssert.applyNonNullActual1(
                isNotNull(),
                a -> MoreJavaTimeAssertions.assertMore(a.atTime(hour, minute, second, nanoOfSecond))
        );
    }

    @Override
    default AbstractMoreLocalDateTimeAssert<?> extractingAtTime(final LocalTime time) {
        return ForAssert.applyNonNullActual1(
                isNotNull(),
                a -> MoreJavaTimeAssertions.assertMore(a.atTime(time))
        );
    }

    default AbstractMoreOffsetDateTimeAssert<?> extractingAtTime(final OffsetTime time) {
        return ForAssert.applyNonNullActual1(
                isNotNull(),
                a -> MoreJavaTimeAssertions.assertMore(a.atTime(time))
        );
    }

    // ------------------------------------------------------------------------------------------------ getDayOfMonth()I
    default AbstractIntegerAssert<?> extractingDayOfMonth() {
        return ForAssert.applyNonNullActual1(
                isNotNull(),
                a -> Assertions.assertThat(a.getDayOfMonth())
        );
    }

    default S hasDayOfMonth(final int expected) {
        return ForAssert.applyNonNullActual2(
                isNotNull(),
                s -> a -> {
                    Assertions.assertThat(a.getDayOfMonth())
                            .isEqualTo(expected);
                    return s;
                }
        );
    }

    // ----------------------------------------------------------------------------------------- getDayOfWeek()DayOfWeek
    default AbstractComparableAssert<?, DayOfWeek> extractingDayOfWeek() {
        return ForAssert.applyNonNullActual1(
                isNotNull(),
                a -> Assertions.assertThat(a.getDayOfWeek())
        );
    }

    default S hasDayOfWeek(final DayOfWeek expected) {
        return ForAssert.applyNonNullActual2(
                isNotNull(),
                s -> a -> {
                    Assertions.assertThat(a.getDayOfWeek())
                            .isEqualTo(expected);
                    return s;
                }
        );
    }

    // ------------------------------------------------------------------------------------------------- getDayOfYear()I
    default AbstractIntegerAssert<?> extractingDayOfYear() {
        return ForAssert.applyNonNullActual1(
                isNotNull(),
                a -> Assertions.assertThat(a.getDayOfYear())
        );
    }

    default S hasDayOfYear(final int expected) {
        return ForAssert.applyNonNullActual2(
                isNotNull(),
                s -> a -> {
                    Assertions.assertThat(a.getDayOfYear())
                            .isEqualTo(expected);
                    return s;
                }
        );
    }

    // ----------------------------------------------------------------------------------------------------- getMonth()I
    default AbstractComparableAssert<?, Month> extractingMonth() {
        return ForAssert.applyNonNullActual1(
                isNotNull(),
                a -> Assertions.assertThat(a.getMonth())
        );
    }

    default S hasMonth(final Month expected) {
        return ForAssert.applyNonNullActual2(
                isNotNull(),
                s -> a -> {
                    Assertions.assertThat(a.getMonth())
                            .isEqualTo(expected);
                    return s;
                }
        );
    }

    // ------------------------------------------------------------------------------------------------ getMonthValue()I
    default AbstractIntegerAssert<?> extractingMonthValue() {
        return ForAssert.applyNonNullActual1(
                isNotNull(),
                a -> Assertions.assertThat(a.getMonthValue())
        );
    }

    default S hasMonthValue(final int expected) {
        return ForAssert.applyNonNullActual2(
                isNotNull(),
                s -> a -> {
                    Assertions.assertThat(a.getMonthValue())
                            .isEqualTo(expected);
                    return s;
                }
        );
    }

    // ------------------------------------------------------------------------------------------------------ getYear()I
    default AbstractIntegerAssert<?> extractingYear() {
        return ForAssert.applyNonNullActual1(
                isNotNull(),
                a -> Assertions.assertThat(a.getYear())
        );
    }

    default S hasYear(final int expected) {
        return ForAssert.applyNonNullActual2(
                isNotNull(),
                s -> a -> {
                    Assertions.assertThat(a.getYear())
                            .isEqualTo(expected);
                    return s;
                }
        );
    }

    @Override
    default AbstractMoreLocalDateAssert<?> extractingMinus(long amountToSubtract, TemporalUnit unit) {
        return ForAssert.applyNonNullActual1(
                isNotNull(),
                a -> MoreJavaTimeAssertions.assertMore(a.minus(amountToSubtract, unit))
        );
    }

    @Override
    default AbstractMoreLocalDateAssert<?> extractingMinus(final TemporalAmount amount) {
        return ForAssert.applyNonNullActual1(
                isNotNull(),
                a -> MoreJavaTimeAssertions.assertMore(a.minus(amount))
        );
    }

    @Override
    default AbstractMoreLocalDateAssert<?> extractingPlus(long amountToAdd, TemporalUnit unit) {
        return ForAssert.applyNonNullActual1(
                isNotNull(),
                a -> MoreJavaTimeAssertions.assertMore(a.plus(amountToAdd, unit))
        );
    }

    @Override
    default AbstractMoreLocalDateAssert<?> extractingPlus(final TemporalAmount amount) {
        return ForAssert.applyNonNullActual1(
                isNotNull(),
                a -> MoreJavaTimeAssertions.assertMore(a.plus(amount))
        );
    }

    // ------------------------------------------------------------------------------------------- minusDays(I)LocalDate
    default AbstractMoreLocalDateAssert<?> extractingMinusDays(final int daysToSubtract) {
        return ForAssert.applyNonNullActual1(
                isNotNull(),
                a -> MoreJavaTimeAssertions.assertMore(a.minusDays(daysToSubtract))
        );
    }

    // ----------------------------------------------------------------------------------------- minusMonths(I)LocalDate
    default AbstractMoreLocalDateAssert<?> extractingMinusMonths(final int monthsToSubtract) {
        return ForAssert.applyNonNullActual1(
                isNotNull(),
                a -> MoreJavaTimeAssertions.assertMore(a.minusMonths(monthsToSubtract))
        );
    }

    // ------------------------------------------------------------------------------------------ minusWeeks(I)LocalDate
    default AbstractMoreLocalDateAssert<?> extractingMinusWeeks(final int weeksToSubtract) {
        return ForAssert.applyNonNullActual1(
                isNotNull(),
                a -> MoreJavaTimeAssertions.assertMore(a.minusWeeks(weeksToSubtract))
        );
    }

    // ------------------------------------------------------------------------------------------ minusYears(I)LocalDate
    default AbstractMoreLocalDateAssert<?> extractingMinusYears(final int yearsToSubtract) {
        return ForAssert.applyNonNullActual1(
                isNotNull(),
                a -> MoreJavaTimeAssertions.assertMore(a.minusYears(yearsToSubtract))
        );
    }

    // -------------------------------------------------------------------------------------- LocalDate#getDayOfMonth()I

    // -------------------------------------------------------------------------------------- LocalDate#getDayOfYear()I

    // --------------------------------------------------------------------------------------- LocalDate#getDayOfWeek()I

    @Override
    default AbstractMorePeriodAssert<?> extractingUntil(final ChronoLocalDate endDateExclusive) {
        return ForAssert.applyNonNullActual1(
                isNotNull(),
                a -> MoreJavaTimeAssertions.assertMore(a.until(endDateExclusive))
        );
    }

    // ------------------------------------------------------------------------------------- withYear(int year)LocalDate
    default AbstractMoreLocalDateAssert<?> extractingWithYear(final int year) {
        @SuppressWarnings({"unchecked"})
        final S self = (S) this;
        final LocalDate withYear = ForAssert.assertActualIsNotNullAndApply(self, a -> a.withYear(year));
        return new MoreLocalDateAssertImpl(withYear);
    }

    @SuppressWarnings({"unchecked"})
    default S withYearSatisfies(final int year, final Consumer<? super LocalDate> consumer) {
        Objects.requireNonNull(consumer, "consumer is null");
        extractingWithYear(year)
                .satisfies(consumer);
        return (S) this;
    }

    // ----------------------------------------------------------------------------------- withMonth(int month)LocalDate
    default AbstractMoreLocalDateAssert<?> extractingWithMonth(final int month) {
        @SuppressWarnings({"unchecked"})
        final S self = (S) this;
        final LocalDate withMonth = ForAssert.assertActualIsNotNullAndApply(self, a -> a.withMonth(month));
        return new MoreLocalDateAssertImpl(withMonth);
    }

    @SuppressWarnings({"unchecked"})
    default S withMonthSatisfies(final int month, final Consumer<? super LocalDate> consumer) {
        Objects.requireNonNull(consumer, "consumer is null");
        extractingWithMonth(month)
                .satisfies(consumer);
        return (S) this;
    }

    // ----------------------------------------------------------------------------------- withDayOfMonth(int dayOfMonth)LocalDate
    default AbstractMoreLocalDateAssert<?> extractingWithDayOfMonth(final int dayOfMonth) {
        @SuppressWarnings({"unchecked"})
        final S self = (S) this;
        final LocalDate actual = ForAssert.assertActualIsNotNullAndApply(self, a -> a.withDayOfMonth(dayOfMonth));
        return new MoreLocalDateAssertImpl(actual);
    }

    @SuppressWarnings({"unchecked"})
    default S withDayOfMonthSatisfies(final int dayOfMonth, final Consumer<? super LocalDate> consumer) {
        Objects.requireNonNull(consumer, "consumer is null");
        extractingWithDayOfMonth(dayOfMonth)
                .satisfies(consumer);
        return (S) this;
    }

    // --------------------------------------------------------------------------- withDayOfYear(int dayOfYear)LocalDate
    default AbstractMoreLocalDateAssert<?> extractingWithDayOfYear(final int dayOfYear) {
        @SuppressWarnings({"unchecked"})
        final S self = (S) this;
        final LocalDate actual = ForAssert.assertActualIsNotNullAndApply(self, a -> a.withDayOfYear(dayOfYear));
        return new MoreLocalDateAssertImpl(actual);
    }

    @SuppressWarnings({"unchecked"})
    default S withDayOfYearSatisfies(final int dayOfYear, final Consumer<? super LocalDate> consumer) {
        Objects.requireNonNull(consumer, "consumer is null");
        extractingWithDayOfYear(dayOfYear)
                .satisfies(consumer);
        return (S) this;
    }

    // ------------------------------------------------------------------------------------------- plusYears(I)LocalDate
    default AbstractMoreLocalDateAssert<?> extractingPlusYears(final int yearsToAdd) {
        @SuppressWarnings({"unchecked"})
        final S self = (S) this;
        final LocalDate actual = ForAssert.assertActualIsNotNullAndApply(self, a -> a.plusYears(yearsToAdd));
        return new MoreLocalDateAssertImpl(actual);
    }

    @SuppressWarnings({"unchecked"})
    default S plusYearsSatisfies(final int yearsToAdd, final Consumer<? super LocalDate> consumer) {
        Objects.requireNonNull(consumer, "consumer is null");
        extractingPlusYears(yearsToAdd)
                .satisfies(consumer);
        return (S) this;
    }

    // ------------------------------------------------------------------------------------------ plusMonths(I)LocalDate
    default AbstractMoreLocalDateAssert<?> extractingPlusMonths(final int monthsToAdd) {
        @SuppressWarnings({"unchecked"})
        final S self = (S) this;
        final LocalDate actual = ForAssert.assertActualIsNotNullAndApply(self, a -> a.plusMonths(monthsToAdd));
        return new MoreLocalDateAssertImpl(actual);
    }

    @SuppressWarnings({"unchecked"})
    default S plusMonthsSatisfies(final int monthsToAdd, final Consumer<? super LocalDate> consumer) {
        Objects.requireNonNull(consumer, "consumer is null");
        extractingPlusMonths(monthsToAdd)
                .satisfies(consumer);
        return (S) this;
    }

    // ------------------------------------------------------------------------------------------- plusWeeks(I)LocalDate
    default AbstractMoreLocalDateAssert<?> extractingPlusWeeks(final int weeksToAdd) {
        @SuppressWarnings({"unchecked"})
        final S self = (S) this;
        final LocalDate actual = ForAssert.assertActualIsNotNullAndApply(self, a -> a.plusWeeks(weeksToAdd));
        return new MoreLocalDateAssertImpl(actual);
    }

    @SuppressWarnings({"unchecked"})
    default S plusWeeksSatisfies(final int weeksToAdd, final Consumer<? super LocalDate> consumer) {
        Objects.requireNonNull(consumer, "consumer is null");
        extractingPlusWeeks(weeksToAdd)
                .satisfies(consumer);
        return (S) this;
    }

    // -------------------------------------------------------------------------------------------- plusDays(I)LocalDate
    default AbstractMoreLocalDateAssert<?> extractingPlusDays(final int daysToAdd) {
        @SuppressWarnings({"unchecked"})
        final S self = (S) this;
        final LocalDate actual = ForAssert.assertActualIsNotNullAndApply(self, a -> a.plusDays(daysToAdd));
        return new MoreLocalDateAssertImpl(actual);
    }

    @SuppressWarnings({"unchecked"})
    default S plusDaysSatisfies(final int daysToAdd, final Consumer<? super LocalDate> consumer) {
        Objects.requireNonNull(consumer, "consumer is null");
        extractingPlusDays(daysToAdd)
                .satisfies(consumer);
        return (S) this;
    }
}
