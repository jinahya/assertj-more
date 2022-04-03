package com.github.jinahya.assertj.more.java.time;

import com.github.jinahya.assertj.more.api.MoreAssertions;
import com.github.jinahya.assertj.more.hidden.ForAssert;
import com.github.jinahya.assertj.more.java.time.temporal.MoreJavaTimeTemporalAssertions;
import com.github.jinahya.assertj.more.java.time.temporal.MoreTemporalAdjusterAssert;
import com.github.jinahya.assertj.more.java.time.temporal.MoreTemporalAssert;
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
import java.util.function.Consumer;

public interface MoreLocalTimeAssert<S extends MoreLocalTimeAssert<S>>
        extends MoreJavaTimeAssert<S, LocalTime>,
                ComparableAssert<S, LocalTime>,
                MoreTemporalAssert<S, LocalTime>,
                MoreTemporalAdjusterAssert<S, LocalTime> {

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
                s -> a -> MoreAssertions.assertThatCodeDoesNotThrowAnyExceptionAndApplyResult(
                        () -> a.format(formatter),
                        Assertions::assertThat
                )
        );
    }

    /**
     * Asserts that the result of {@link LocalTime#getHour()} method, invoked on the {@code actual}, is equal to
     * specified value.
     *
     * @param expected the expected value of {@code actual.getHour()}.
     * @return this assertion object.
     */
    default S hasHour(final int expected) {
        return ForAssert.applyActual2(
                isNotNull(),
                s -> a -> {
                    Assertions.assertThat(a.getHour())
                            .isEqualTo(expected);
                    return s;
                }
        );
    }

    /**
     * Asserts that the result of {@link LocalTime#getMinute()} method, invoked on the {@code actual}, is equal to
     * specified value.
     *
     * @param expected the expected value of {@code actual.getMinute()}.
     * @return this assertion object.
     */
    default S hasMinute(final int expected) {
        return ForAssert.applyActual2(
                isNotNull(),
                s -> a -> {
                    Assertions.assertThat(a.getMinute())
                            .isEqualTo(expected);
                    return s;
                }
        );
    }

    default S hasNano(final int expected) {
        return ForAssert.applyActual2(
                isNotNull(),
                s -> a -> {
                    Assertions.assertThat(a.getNano())
                            .isEqualTo(expected);
                    return s;
                }
        );
    }

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

    /**
     * Verifies that the result of {@link LocalTime#isAfter(LocalTime)} method, invoked on the {@code actual} with
     * specified argument, is {@code false}.
     *
     * @param other a value for {@code other} argument.
     * @return this assertion object.
     * @see LocalTime#isAfter(LocalTime)
     * @see org.assertj.core.api.AbstractLocalTimeAssert#isAfter(LocalTime)
     */
    default S isNotAfter(final LocalTime other) {
        Objects.requireNonNull(other, "other is null");
        return ForAssert.applyActual2(
                isNotNull(),
                s -> a -> {
                    Assertions.assertThat(a.isAfter(other))
                            .isFalse();
                    return s;
                }
        );
    }

    default S isNotBefore(final LocalTime other) {
        Objects.requireNonNull(other, "other is null");
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
    default AbstractMoreLocalTimeAssert<?> extractingMinus(final TemporalAmount amount) {
        Objects.requireNonNull(amount, "amount is null");
        return ForAssert.applyActual2(
                isNotNull(),
                s -> a -> MoreAssertions.assertThatCodeDoesNotThrowAnyExceptionAndApplyResult(
                        () -> a.minus(amount),
                        MoreJavaTimeAssertions::assertMore
                )
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
                s -> a -> MoreAssertions.assertThatCodeDoesNotThrowAnyExceptionAndApplyResult(
                        () -> a.plus(amountToSubtract, unit),
                        MoreJavaTimeAssertions::assertMore
                )
        );
    }

    @Override
    default AbstractMoreLocalTimeAssert<?> extractingPlus(final TemporalAmount amount) {
        return ForAssert.applyActual2(
                isNotNull(),
                s -> a -> MoreAssertions.assertThatCodeDoesNotThrowAnyExceptionAndApplyResult(
                        () -> a.plus(amount),
                        MoreJavaTimeAssertions::assertMore
                )
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

    /**
     * Returns an assertion object for verifying the result of {@link LocalTime#truncatedTo(TemporalUnit)} method,
     * invoked on the {@code actual} with specified argument.
     *
     * @param unit a value for {@code unit} argument.
     * @return an assertion object for verifying {@code actual.truncatedTo(unit)}.
     * @see #truncatedToSatisfies(TemporalUnit, Consumer)
     */
    default AbstractMoreLocalTimeAssert<?> extractingTruncatedTo(final TemporalUnit unit) {
        Objects.requireNonNull(unit, "unit is null");
        return ForAssert.applyActual2(
                isNotNull(),
                s -> a -> MoreAssertions.assertThatCodeDoesNotThrowAnyExceptionAndApplyResult(
                        () -> a.truncatedTo(unit),
                        MoreJavaTimeAssertions::assertMore
                )
        );
    }

    /**
     * Verifies the result of {@link LocalTime#truncatedTo(TemporalUnit)} method, invoked on the {@code actual} with
     * specified argument, by accepting the result to specified consumer.
     *
     * @param unit     a value for the {@code unit} argument.
     * @param consumer the consumer accepts the {@code actual} and the result of {@code actual.truncatedTo(unit)}.
     * @return this assertion object.
     * @see #extractingTruncatedTo(TemporalUnit)
     */
    @SuppressWarnings({"unchecked"})
    default S truncatedToSatisfies(final TemporalUnit unit,
                                   final Consumer<? super AbstractMoreLocalTimeAssert<?>> consumer) {
        Objects.requireNonNull(unit, "unit is null");
        Objects.requireNonNull(consumer, "consumer is null");
        consumer.accept(extractingTruncatedTo(unit));
        return (S) this;
    }

    @Override
    default AbstractMoreLocalTimeAssert<?> extractingWith(final TemporalAdjuster adjuster) {
        return ForAssert.applyActual2(
                isNotNull(),
                s -> a -> MoreAssertions.assertThatCodeDoesNotThrowAnyExceptionAndApplyResult(
                        () -> a.with(adjuster),
                        MoreJavaTimeAssertions::assertMore
                )
        );
    }

//    default S withSatisfies(final TemporalAdjuster adjuster,
//                            final Consumer<? super AbstractMoreLocalTimeAssert<?>> consumer) {
//        return ForAssert.applyActual2(
//                isNotNull(),
//                s -> a -> MoreAssertions.assertThatCodeDoesNotThrowAnyExceptionAndApplyResult(
//                        () -> a.with(adjuster),
//                        r -> {
//                            consumer.accept(MoreJavaTimeTemporalAssertions.assertMore(r));
//                            return s;
//                        }
//                )
//        );
//    }

    @Override
    default AbstractMoreLocalTimeAssert<?> extractingWith(TemporalField field, long newValue) {
        return ForAssert.applyActual2(
                isNotNull(),
                s -> a -> MoreAssertions.assertThatCodeDoesNotThrowAnyExceptionAndApplyResult(
                        () -> a.with(field, newValue),
                        MoreJavaTimeAssertions::assertMore
                )
        );
    }

    default AbstractMoreLocalTimeAssert<?> extractingWithHour(final int hour) {
        return ForAssert.applyActual2(
                isNotNull(),
                s -> a -> MoreAssertions.assertThatCodeDoesNotThrowAnyExceptionAndApplyResult(
                        () -> a.withHour(hour),
                        MoreJavaTimeAssertions::assertMore
                )
        );
    }

    default AbstractMoreLocalTimeAssert<?> extractingWithMinute(final int minute) {
        return ForAssert.applyActual2(
                isNotNull(),
                s -> a -> MoreAssertions.assertThatCodeDoesNotThrowAnyExceptionAndApplyResult(
                        () -> a.withMinute(minute),
                        MoreJavaTimeAssertions::assertMore
                )
        );
    }

    default AbstractMoreLocalTimeAssert<?> extractingWithNano(final int nanoOfSecond) {
        return ForAssert.applyActual2(
                isNotNull(),
                s -> a -> MoreAssertions.assertThatCodeDoesNotThrowAnyExceptionAndApplyResult(
                        () -> a.withNano(nanoOfSecond),
                        MoreJavaTimeAssertions::assertMore
                )
        );
    }

    default AbstractMoreLocalTimeAssert<?> extractingWithSecond(final int second) {
        return ForAssert.applyActual2(
                isNotNull(),
                s -> a -> MoreAssertions.assertThatCodeDoesNotThrowAnyExceptionAndApplyResult(
                        () -> a.withSecond(second),
                        MoreJavaTimeAssertions::assertMore
                )
        );
    }
}
