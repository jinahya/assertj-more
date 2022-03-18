package com.github.jinahya.assertj.more.java.time.chrono;

import com.github.jinahya.assertj.more.hidden.ForAssert;
import com.github.jinahya.assertj.more.java.time.temporal.MoreTemporalAdjusterAssert;
import com.github.jinahya.assertj.more.java.time.temporal.MoreTemporalAssert;
import org.assertj.core.api.AbstractBooleanAssert;
import org.assertj.core.api.AbstractIntegerAssert;
import org.assertj.core.api.AbstractLongAssert;
import org.assertj.core.api.AbstractStringAssert;
import org.assertj.core.api.Assertions;

import java.time.LocalTime;
import java.time.chrono.ChronoLocalDate;
import java.time.chrono.ChronoLocalDateTime;
import java.time.chrono.ChronoPeriod;
import java.time.chrono.Chronology;
import java.time.chrono.Era;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAmount;
import java.time.temporal.TemporalField;
import java.time.temporal.TemporalUnit;

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

    MoreChronoLocalDateTimeAssert<?, ? extends ChronoLocalDateTime<?>, ?> extractingAtTime(LocalTime localTime);

    default AbstractStringAssert<?> extractingFormat(final DateTimeFormatter formatter) {
        return ForAssert.applyNonNullActual1(
                isNotNull(),
                a -> Assertions.assertThat(a.format(formatter))
        );
    }

    default AbstractMoreChronologyAssert<?, Chronology> extractingChronology() {
        return ForAssert.applyNonNullActual1(
                isNotNull(),
                a -> MoreJavaTimeChronoAssertions.assertMore(a.getChronology())
        );
    }

    default S hasChronology(final Chronology expected) {
        return ForAssert.applyNonNullActual2(
                isNotNull(),
                s -> a -> {
                    assertThat(a.getChronology())
                            .isEqualTo(expected);
                    return s;
                }
        );
    }

    default AbstractMoreEraAssert<?, Era> extractingEra() {
        return ForAssert.applyNonNullActual1(
                isNotNull(),
                a -> MoreJavaTimeChronoAssertions.assertMore(a.getEra())
        );
    }

    default S hasEra(final Era expected) {
        return ForAssert.applyNonNullActual2(
                isNotNull(),
                s -> a -> {
                    assertThat(a.getEra())
                            .isEqualTo(expected);
                    return s;
                }
        );
    }

    default AbstractBooleanAssert<?> extractingIsAfter(final ChronoLocalDate other) {
        return ForAssert.applyNonNullActual1(
                isNotNull(),
                a -> Assertions.assertThat(a.isAfter(other))
        );
    }

    default S isAfter(final ChronoLocalDate other) {
        return ForAssert.applyNonNullActual2(
                isNotNull(),
                s -> a -> {
                    assertThat(a.isAfter(other)).isTrue();
                    return s;
                }
        );
    }

    default S isNotAfter(final ChronoLocalDate other) {
        return ForAssert.applyNonNullActual2(
                isNotNull(),
                s -> a -> {
                    assertThat(a.isAfter(other)).isFalse();
                    return s;
                }
        );
    }

    default AbstractBooleanAssert<?> extractingIsBefore(final ChronoLocalDate other) {
        return ForAssert.applyNonNullActual1(
                isNotNull(),
                a -> Assertions.assertThat(a.isBefore(other))
        );
    }

    default S isBefore(final ChronoLocalDate other) {
        return ForAssert.applyNonNullActual2(
                isNotNull(),
                s -> a -> {
                    assertThat(a.isBefore(other)).isTrue();
                    return s;
                }
        );
    }

    default S isNotBefore(final ChronoLocalDate other) {
        return ForAssert.applyNonNullActual2(
                isNotNull(),
                s -> a -> {
                    assertThat(a.isBefore(other)).isFalse();
                    return s;
                }
        );
    }

    default AbstractBooleanAssert<?> extractingIsEqual(final ChronoLocalDate other) {
        return ForAssert.applyNonNullActual1(
                isNotNull(),
                a -> Assertions.assertThat(a.isEqual(other))
        );
    }

    default S isEqual(final ChronoLocalDate other) {
        return ForAssert.applyNonNullActual2(
                isNotNull(),
                s -> a -> {
                    assertThat(a.isEqual(other)).isTrue();
                    return s;
                }
        );
    }

    default S isNotEqual(final ChronoLocalDate other) {
        return ForAssert.applyNonNullActual2(
                isNotNull(),
                s -> a -> {
                    assertThat(a.isEqual(other)).isFalse();
                    return s;
                }
        );
    }

    default AbstractBooleanAssert<?> extractingIsLeapYear() {
        return ForAssert.applyNonNullActual1(
                isNotNull(),
                a -> Assertions.assertThat(a.isLeapYear())
        );
    }

    default S isLeapYear() {
        return ForAssert.applyNonNullActual2(
                isNotNull(),
                s -> a -> {
                    assertThat(a.isLeapYear()).isTrue();
                    return s;
                }
        );
    }

    default S isNotLeapYear() {
        return ForAssert.applyNonNullActual2(
                isNotNull(),
                s -> a -> {
                    Assertions.assertThat(a.isLeapYear()).isFalse();
                    return s;
                }
        );
    }

    default AbstractIntegerAssert<?> extractingLengthOfMonth() {
        return ForAssert.applyNonNullActual1(
                isNotNull(),
                a -> Assertions.assertThat(a.lengthOfMonth())
        );
    }

    default S hasLengthOfMonth(final int expected) {
        return ForAssert.applyNonNullActual2(
                isNotNull(),
                s -> a -> {
                    Assertions.assertThat(a.lengthOfMonth())
                            .isEqualTo(expected);
                    return s;
                }
        );
    }

    default AbstractIntegerAssert<?> extractingLengthOfYear() {
        return ForAssert.applyNonNullActual1(
                isNotNull(),
                a -> Assertions.assertThat(a.lengthOfYear())
        );
    }

    default S hasLengthOfYear(final int expected) {
        return ForAssert.applyNonNullActual2(
                isNotNull(),
                s -> a -> {
                    Assertions.assertThat(a.lengthOfYear())
                            .isEqualTo(expected);
                    return s;
                }
        );
    }

    @Override
    MoreChronoLocalDateAssert<?, A> extractingMinus(long amountToSubtract, TemporalUnit unit);

    @Override
    MoreChronoLocalDateAssert<?, A> extractingMinus(TemporalAmount amount);

    @Override
    MoreChronoLocalDateAssert<?, A> extractingPlus(long amountToAdd, TemporalUnit unit);

    @Override
    MoreChronoLocalDateAssert<?, A> extractingPlus(TemporalAmount amount);

    default AbstractLongAssert<?> extractingToEpochDay() {
        return ForAssert.applyNonNullActual1(
                isNotNull(),
                a -> Assertions.assertThat(a.toEpochDay())
        );
    }

    default S toEpochDayIsEqualsTo(final long expected) {
        return ForAssert.applyNonNullActual2(
                isNotNull(),
                s -> a -> {
                    Assertions.assertThat(a.toEpochDay())
                            .isEqualTo(expected);
                    return s;
                }
        );
    }

    default S hasEpochDay(final long expected) {
        return toEpochDayIsEqualsTo(expected);
    }

    MoreChronoPeriodAssert<?, ? extends ChronoPeriod> extractingUntil(ChronoLocalDate endDateExclusive);

    @Override
    MoreChronoLocalDateAssert<?, ? extends ChronoLocalDate> with(TemporalAdjuster adjuster);

    @Override
    MoreChronoLocalDateAssert<?, ? extends ChronoLocalDate> with(TemporalField field, long newValue);
}
