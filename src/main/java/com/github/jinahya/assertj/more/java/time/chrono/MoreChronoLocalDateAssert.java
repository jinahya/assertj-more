package com.github.jinahya.assertj.more.java.time.chrono;

import com.github.jinahya.assertj.more.hidden.ForAssert;
import com.github.jinahya.assertj.more.java.time.temporal.MoreTemporalAdjusterAssert;
import com.github.jinahya.assertj.more.java.time.temporal.MoreTemporalAssert;
import org.assertj.core.api.AbstractBooleanAssert;
import org.assertj.core.api.AbstractIntegerAssert;
import org.assertj.core.api.AbstractLongAssert;
import org.assertj.core.api.AbstractStringAssert;
import org.assertj.core.api.Assert;
import org.assertj.core.api.Assertions;

import java.time.LocalTime;
import java.time.chrono.ChronoLocalDate;
import java.time.chrono.ChronoLocalDateTime;
import java.time.chrono.ChronoPeriod;
import java.time.chrono.Chronology;
import java.time.chrono.Era;
import java.time.format.DateTimeFormatter;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

/**
 * An interface for verifying values of {@link ChronoLocalDate} interface.
 *
 * @param <S> self type parameter
 * @param <A> actual type parameter
 * @author Jin Kwon &lt;onacit_at_gmail.com&gt;
 */
public interface MoreChronoLocalDateAssert<
        S extends MoreChronoLocalDateAssert<S, A>,
        A extends ChronoLocalDate>
        extends MoreJavaTimeChronoAssert<S, A>,
                MoreTemporalAssert<S, A>,
                MoreTemporalAdjusterAssert<S, A> {

    // --------------------------------------------------------------------------------------- getChronology()Chronology
    default AbstractMoreChronologyAssert<?, Chronology> extractingChronology() {
        return ForAssert.assertActualIsNotNullAndApply2(
                (S) this, s -> a -> MoreJavaTimeChronoAssertions.assertMore(a.getChronology()));
    }

    default S hasChronology(final Chronology expected) {
        return ForAssert.assertActualIsNotNullAndApply2((S) this, s -> a -> {
            assertThat(a.getChronology()).isEqualTo(expected);
            return s;
        });
    }

    // ----------------------------------------------------------------------------------------------------- getEra()Era
    default AbstractMoreEraAssert<?, Era> extractingEra() {
        return ForAssert.assertActualIsNotNullAndApply2(
                (S) this, s -> a -> MoreJavaTimeChronoAssertions.assertMore(a.getEra()));
    }

    default S hasEra(final Era expected) {
        return ForAssert.assertActualIsNotNullAndApply2((S) this, s -> a -> {
            assertThat(a.getEra()).isSameAs(expected);
            return s;
        });
    }

    // --------------------------------------------------------------------------------------------------- isLeapYear()Z
    default AbstractBooleanAssert<?> extractingLeapYear() {
        return ForAssert.assertActualIsNotNullAndApply2(
                (S) this, s -> a -> Assertions.assertThat(a.isLeapYear())
        );
    }

    default S isLeafYear(final Era expected) {
        return ForAssert.assertActualIsNotNullAndApply2((S) this, s -> a -> {
            assertThat(a.isLeapYear()).isTrue();
            return s;
        });
    }

    default S isNotLeafYear(final Era expected) {
        return ForAssert.assertActualIsNotNullAndApply2((S) this, s -> a -> {
            assertThat(a.isLeapYear()).isFalse();
            return s;
        });
    }

    // ------------------------------------------------------------------------------------------------ lengthOfMonth()I
    default AbstractIntegerAssert<?> extractingLengthOfMonth() {
        return ForAssert.assertActualIsNotNullAndApply2(
                (S) this, s -> a -> Assertions.assertThat(a.lengthOfMonth())
        );
    }

    default S hasLengthOfMonth(final int expected) {
        return ForAssert.assertActualIsNotNullAndApply2((S) this, s -> a -> {
            assertThat(a.lengthOfMonth()).isEqualTo(expected);
            return s;
        });
    }

    // ------------------------------------------------------------------------------------------------ lengthOfYear()I
    default AbstractIntegerAssert<?> extractingLengthOfYear() {
        return ForAssert.assertActualIsNotNullAndApply2(
                (S) this, s -> a -> Assertions.assertThat(a.lengthOfYear())
        );
    }

    default S hasLengthOfYear(final int expected) {
        return ForAssert.assertActualIsNotNullAndApply2((S) this, s -> a -> {
            assertThat(a.lengthOfYear()).isEqualTo(expected);
            return s;
        });
    }

    // ------------------------------------------------------------------------------ until(ChronoLocalDate)ChronoPeriod
    default AbstractMoreChronoPeriodAssert<?, ChronoPeriod> extractingUntil(final ChronoLocalDate endDateExclusive) {
        return ForAssert.assertActualIsNotNullAndApply2(
                (S) this, s -> a -> MoreJavaTimeChronoAssertions.assertMore(a.until(endDateExclusive))
        );
    }

    // --------------------------------------------------------------------------------- format(DateTimeFormatter)String
    default AbstractStringAssert<?> extractingFormat(final DateTimeFormatter formatter) {
        return ForAssert.assertActualIsNotNullAndApply2(
                (S) this, s -> a -> Assertions.assertThat(a.format(formatter))
        );
    }

    // ---------------------------------------------------------------------------- atTime(LocalTime)ChronoLocalDateTime
    Assert<?, ? extends ChronoLocalDateTime<?>> extractingAtTime(LocalTime localTime);

    // --------------------------------------------------------------------------------------------------- toEpochDay()J
    default AbstractLongAssert<?> extractingToEpochDay() {
        return ForAssert.assertActualIsNotNullAndApply2(
                (S) this, s -> a -> Assertions.assertThat(a.toEpochDay())
        );
    }

    default S toEpochDayIsEqualsTo(final long expected) {
        return ForAssert.assertActualIsNotNullAndApply2((S) this, s -> a -> {
            Assertions.assertThat(a.toEpochDay()).isEqualTo(expected);
            return s;
        });
    }

    default S hasEpochDay(final long expected) {
        return toEpochDayIsEqualsTo(expected);
    }

    // --------------------------------------------------------------------------------------- isAfter(ChronoLocalDate)Z
    default AbstractBooleanAssert<?> extractingIsAfter(final ChronoLocalDate other) {
        return ForAssert.assertActualIsNotNullAndApply2(
                (S) this, s -> a -> Assertions.assertThat(a.isAfter(other))
        );
    }

    default S isAfter(final ChronoLocalDate other) {
        return ForAssert.assertActualIsNotNullAndApply2(
                (S) this, s -> a -> {
                    Assertions.assertThat(a.isAfter(other)).isTrue();
                    return s;
                });
    }

    // -------------------------------------------------------------------------------------- isBefore(ChronoLocalDate)Z
    default AbstractBooleanAssert<?> extractingIsBefore(final ChronoLocalDate other) {
        return ForAssert.assertActualIsNotNullAndApply2(
                (S) this, s -> a -> Assertions.assertThat(a.isBefore(other))
        );
    }

    default S isBefore(final ChronoLocalDate other) {
        return ForAssert.assertActualIsNotNullAndApply2(
                (S) this, s -> a -> {
                    Assertions.assertThat(a.isBefore(other)).isTrue();
                    return s;
                });
    }

    // --------------------------------------------------------------------------------------- isEqual(ChronoLocalDate)Z
    default AbstractBooleanAssert<?> extractingIsEqual(final ChronoLocalDate other) {
        return ForAssert.assertActualIsNotNullAndApply2(
                (S) this, s -> a -> Assertions.assertThat(a.isEqual(other))
        );
    }

    default S isEqual(final ChronoLocalDate other) {
        return ForAssert.assertActualIsNotNullAndApply2(
                (S) this, s -> a -> {
                    Assertions.assertThat(a.isEqual(other)).isTrue();
                    return s;
                });
    }
}
