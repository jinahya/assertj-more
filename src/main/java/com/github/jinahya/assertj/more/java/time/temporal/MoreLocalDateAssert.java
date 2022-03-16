package com.github.jinahya.assertj.more.java.time.temporal;

import com.github.jinahya.assertj.more.hidden.ForAssert;
import com.github.jinahya.assertj.more.java.time.AbstractMoreOffsetDateTimeAssert;
import com.github.jinahya.assertj.more.java.time.MoreJavaTimeAssertions;
import com.github.jinahya.assertj.more.java.time.chrono.MoreChronoLocalDateAssert;
import com.github.jinahya.assertj.more.java.time.chrono.MoreChronoLocalDateAssertHelper;
import org.assertj.core.api.AbstractComparableAssert;
import org.assertj.core.api.AbstractIntegerAssert;
import org.assertj.core.api.Assertions;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.OffsetDateTime;
import java.time.OffsetTime;
import java.util.Objects;
import java.util.function.Consumer;

public interface MoreLocalDateAssert<S extends MoreLocalDateAssert<S>>
        extends MoreJavaTimeTemporalAssert<S, LocalDate>,
                MoreChronoLocalDateAssert<S, LocalDate> {

    @Override
    default AbstractMoreLocalDateTimeAssert<?> extractingAtTime(final LocalTime localTime) {
        @SuppressWarnings({"unchecked"})
        final S self = (S) this;
        return MoreChronoLocalDateAssertHelper.atTime(
                localTime, self, s -> r -> new MoreLocalDateTimeAssertImpl((LocalDateTime) r));
    }

    default AbstractMoreLocalDateTimeAssert<?> extractingAtTime(final int hour, final int minute, final int second) {
        @SuppressWarnings({"unchecked"})
        final S self = (S) this;
        final LocalDateTime actual = ForAssert.assertActualIsNotNullAndApply(self, a -> a.atTime(hour, minute, second));
        return new MoreLocalDateTimeAssertImpl(actual);
    }

    default AbstractMoreLocalDateTimeAssert<?> extractingAtTime(final int hour, final int minute, final int second,
                                                                int nanoOfSecond) {
        @SuppressWarnings({"unchecked"})
        final S self = (S) this;
        final LocalDateTime actual = ForAssert.assertActualIsNotNullAndApply(
                self, a -> a.atTime(hour, minute, second, nanoOfSecond));
        return new MoreLocalDateTimeAssertImpl(actual);
    }

    default AbstractMoreOffsetDateTimeAssert<?> extractingAtTime(final OffsetTime time) {
        @SuppressWarnings({"unchecked"})
        final S self = (S) this;
        final OffsetDateTime actual = ForAssert.assertActualIsNotNullAndApply(self, a -> a.atTime(time));
        return MoreJavaTimeAssertions.assertMore(actual);
    }

    default AbstractMoreLocalDateTimeAssert<?> extractingAtStartOfDay() {
        @SuppressWarnings({"unchecked"})
        final S self = (S) this;
        final LocalDateTime actual = ForAssert.assertActualIsNotNullAndApply(self, LocalDate::atStartOfDay);
        return new MoreLocalDateTimeAssertImpl(actual);
    }

//    default AbstractMoreLocalDateTimeAssert<?> extractingAtStartOfDay(final ZoneId zone) {
//        @SuppressWarnings({"unchecked"})
//        final S self = (S) this;
//        final ZonedDateTime actual = ForAssert.assertActualIsNotNullAndApply(self, a -> a.atStartOfDay(zone));
//        return new MoreLocalDateTimeAssertImpl(actual);
//    }

    // -------------------------------------------------------------------------------------------- LocalDate#getYear()I
    default AbstractIntegerAssert<?> extractingYear() {
        @SuppressWarnings({"unchecked"})
        final S self = (S) this;
        return MoreLocalDateAssertHelper.getYear(self, s -> Assertions::assertThat);
    }

    default S hasYear(final int expected) {
        @SuppressWarnings({"unchecked"})
        final S self = (S) this;
        return MoreLocalDateAssertHelper.getYear(self, s -> r -> {
            Assertions.assertThat(r).isEqualTo(expected);
            return s;
        });
    }

    // -------------------------------------------------------------------------------------- LocalDate#getMonthValue()I
    default AbstractIntegerAssert<?> extractingMonthValue() {
        @SuppressWarnings({"unchecked"})
        final S self = (S) this;
        return MoreLocalDateAssertHelper.getMonthValue(self, s -> Assertions::assertThat);
    }

    default S hasMonthValue(final int expected) {
        @SuppressWarnings({"unchecked"})
        final S self = (S) this;
        extractingMonthValue().isEqualTo(expected);
        return self;
    }

    // ------------------------------------------------------------------------------------------- LocalDate#getMonth()I
    default AbstractComparableAssert<?, Month> extractingMonth() {
        @SuppressWarnings({"unchecked"})
        final S self = (S) this;
        return MoreLocalDateAssertHelper.getMonth(self, s -> r -> Assertions.<Month>assertThat(r));
    }

    default S hasMonth(final Month expected) {
        @SuppressWarnings({"unchecked"})
        final S self = (S) this;
        extractingMonth().isEqualTo(expected);
        return self;
    }

    // -------------------------------------------------------------------------------------- LocalDate#getDayOfMonth()I
    default AbstractIntegerAssert<?> extractingDayOfMonth() {
        @SuppressWarnings({"unchecked"})
        final S self = (S) this;
        return MoreLocalDateAssertHelper.getDayOfMonth(self, s -> Assertions::assertThat);
    }

    default S hasDayOfMonth(final int expected) {
        @SuppressWarnings({"unchecked"})
        final S self = (S) this;
        extractingDayOfMonth().isEqualTo(expected);
        return self;
    }

    // -------------------------------------------------------------------------------------- LocalDate#getDayOfYear()I
    default AbstractIntegerAssert<?> extractingDayOfYear() {
        @SuppressWarnings({"unchecked"})
        final S self = (S) this;
        final int dayOfYear = ForAssert.assertActualIsNotNullAndApply(self, LocalDate::getDayOfYear);
        return Assertions.assertThat(dayOfYear);
    }

    @SuppressWarnings({"unchecked"})
    default S hasDayOfYear(final int expected) {
        extractingDayOfYear().isEqualTo(expected);
        return (S) this;
    }

    // --------------------------------------------------------------------------------------- LocalDate#getDayOfWeek()I
    default AbstractComparableAssert<?, DayOfWeek> extractingDayOfWeek() {
        @SuppressWarnings({"unchecked"})
        final S self = (S) this;
        final DayOfWeek dayOfWeek = ForAssert.assertActualIsNotNullAndApply(self, LocalDate::getDayOfWeek);
        return Assertions.assertThat(dayOfWeek);
    }

    @SuppressWarnings({"unchecked"})
    default S hasDayOfWeek(final DayOfWeek expected) {
        extractingDayOfWeek().isEqualTo(expected);
        return (S) this;
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

    // ------------------------------------------------------------------------------------------ minusYears(I)LocalDate
    default AbstractMoreLocalDateAssert<?> extractingMinusYears(final int yearsToAdd) {
        @SuppressWarnings({"unchecked"})
        final S self = (S) this;
        final LocalDate actual = ForAssert.assertActualIsNotNullAndApply(self, a -> a.minusYears(yearsToAdd));
        return new MoreLocalDateAssertImpl(actual);
    }

    @SuppressWarnings({"unchecked"})
    default S minusYearsSatisfies(final int yearsToAdd, final Consumer<? super LocalDate> consumer) {
        Objects.requireNonNull(consumer, "consumer is null");
        extractingMinusYears(yearsToAdd)
                .satisfies(consumer);
        return (S) this;
    }

    // ----------------------------------------------------------------------------------------- minusMonths(I)LocalDate
    default AbstractMoreLocalDateAssert<?> extractingMinusMonths(final int monthsToAdd) {
        @SuppressWarnings({"unchecked"})
        final S self = (S) this;
        final LocalDate actual = ForAssert.assertActualIsNotNullAndApply(self, a -> a.minusMonths(monthsToAdd));
        return new MoreLocalDateAssertImpl(actual);
    }

    @SuppressWarnings({"unchecked"})
    default S minusMonthsSatisfies(final int monthsToAdd, final Consumer<? super LocalDate> consumer) {
        Objects.requireNonNull(consumer, "consumer is null");
        extractingMinusMonths(monthsToAdd)
                .satisfies(consumer);
        return (S) this;
    }

    // ------------------------------------------------------------------------------------------ minusWeeks(I)LocalDate
    default AbstractMoreLocalDateAssert<?> extractingMinusWeeks(final int weeksToAdd) {
        @SuppressWarnings({"unchecked"})
        final S self = (S) this;
        final LocalDate actual = ForAssert.assertActualIsNotNullAndApply(self, a -> a.minusWeeks(weeksToAdd));
        return new MoreLocalDateAssertImpl(actual);
    }

    @SuppressWarnings({"unchecked"})
    default S minusWeeksSatisfies(final int weeksToAdd, final Consumer<? super LocalDate> consumer) {
        Objects.requireNonNull(consumer, "consumer is null");
        extractingMinusWeeks(weeksToAdd)
                .satisfies(consumer);
        return (S) this;
    }

    // ------------------------------------------------------------------------------------------- minusDays(I)LocalDate
    default AbstractMoreLocalDateAssert<?> extractingMinusDays(final int daysToAdd) {
        @SuppressWarnings({"unchecked"})
        final S self = (S) this;
        final LocalDate actual = ForAssert.assertActualIsNotNullAndApply(self, a -> a.minusDays(daysToAdd));
        return new MoreLocalDateAssertImpl(actual);
    }

    @SuppressWarnings({"unchecked"})
    default S minusDaysSatisfies(final int daysToAdd, final Consumer<? super LocalDate> consumer) {
        Objects.requireNonNull(consumer, "consumer is null");
        extractingMinusDays(daysToAdd)
                .satisfies(consumer);
        return (S) this;
    }
}
