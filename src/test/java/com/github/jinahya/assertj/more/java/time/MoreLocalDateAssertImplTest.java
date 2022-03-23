package com.github.jinahya.assertj.more.java.time;

import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.OffsetTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAmount;
import java.time.temporal.TemporalUnit;

@Slf4j
class MoreLocalDateAssertImplTest
        extends MoreJavaTimeAssertTest<MoreLocalDateAssertImpl, LocalDate> {

    MoreLocalDateAssertImplTest() {
        super(MoreLocalDateAssertImpl.class, LocalDate.class);
    }

    @Test
    void extractingAtStartOfDay__() {
        final LocalDate actual = LocalDate.now();
        final MoreLocalDateAssert<?> more = assertInstance(actual);
        Assertions.assertThat(more.extractingAtStartOfDay())
                .isNotNull();
    }

    @MethodSource({"java.time.ZoneId#getAvailableZoneIds"})
    @ParameterizedTest
    void extractingAtStartOfDay__(final String zoneId) {
        final LocalDate actual = LocalDate.now();
        final MoreLocalDateAssert<?> more = assertInstance(actual);
        Assertions.assertThat(more.extractingAtStartOfDay(ZoneId.of(zoneId)))
                .isNotNull();
    }

    @Test
    void extractingAtTime__() {
        final LocalDate actual = LocalDate.now();
        final MoreLocalDateAssert<?> more = assertInstance(actual);
        final LocalTime time = LocalTime.now().withNano(0);
        Assertions.assertThat(more.extractingAtTime(
                        time.getHour(), time.getMinute(), time.getSecond()))
                .isNotNull()
                .satisfies(r -> {
                    r.isEqualTo(actual.atTime(time));
                });
    }

    @Test
    void extractingAtTime__WithNano() {
        final LocalDate actual = LocalDate.now();
        final MoreLocalDateAssert<?> more = assertInstance(actual);
        final LocalTime time = LocalTime.now();
        Assertions.assertThat(more.extractingAtTime(
                        time.getHour(), time.getMinute(), time.getSecond(), time.getNano()))
                .isNotNull()
                .satisfies(r -> {
                    r.isEqualTo(actual.atTime(time));
                });
    }

    @Test
    void extractingAtTime__WithTime() {
        final LocalDate actual = LocalDate.now();
        final MoreLocalDateAssert<?> more = assertInstance(actual);
        final LocalTime time = LocalTime.now();
        Assertions.assertThat(more.extractingAtTime(time))
                .isNotNull()
                .satisfies(r -> {
                    r.isEqualTo(actual.atTime(time));
                });
    }

    @Test
    void extractingAtTime__WithOffsetTime() {
        final LocalDate actual = LocalDate.now();
        final MoreLocalDateAssert<?> more = assertInstance(actual);
        final OffsetTime time = OffsetTime.now();
        Assertions.assertThat(more.extractingAtTime(time))
                .isNotNull()
                .satisfies(r -> {
                    r.isEqualTo(actual.atTime(time));
                });
    }

    @Test
    void hasDayOfMonth__() {
        final LocalDate actual = LocalDate.now();
        final MoreLocalDateAssert<?> more = assertInstance(actual);
        more.hasDayOfMonth(actual.getDayOfMonth());
    }

    @Test
    void hasDayOfWeek__() {
        final LocalDate actual = LocalDate.now();
        final MoreLocalDateAssert<?> more = assertInstance(actual);
        more.hasDayOfWeek(actual.getDayOfWeek());
    }

    @Test
    void hasDayOfYear__() {
        final LocalDate actual = LocalDate.now();
        final MoreLocalDateAssert<?> more = assertInstance(actual);
        more.hasDayOfYear(actual.getDayOfYear());
    }

    @Test
    void hasMonth__() {
        final LocalDate actual = LocalDate.now();
        final MoreLocalDateAssert<?> more = assertInstance(actual);
        more.hasMonth(actual.getMonth());
    }

    @Test
    void hasMonthValue__() {
        final LocalDate actual = LocalDate.now();
        final MoreLocalDateAssert<?> more = assertInstance(actual);
        more.hasMonthValue(actual.getMonthValue());
    }

    @Test
    void hasYear__() {
        final LocalDate actual = LocalDate.now();
        final MoreLocalDateAssert<?> more = assertInstance(actual);
        more.hasYear(actual.getYear());
    }

    @EnumSource(ChronoUnit.class)
    @ParameterizedTest
    void extractingMinus__(final TemporalUnit unit) {
        final LocalDate actual = LocalDate.now();
        if (!actual.isSupported(unit)) {
            return;
        }
        final MoreLocalDateAssert<?> more = assertInstance(actual);
        for (int amountToSubtract = -1; amountToSubtract < 2; amountToSubtract++) {
            final LocalDate expected;
            try {
                expected = actual.minus(amountToSubtract, unit);
            } catch (final DateTimeException dte) {
                continue;
            }
            Assertions.assertThat(more.extractingMinus(amountToSubtract, unit))
                    .isNotNull()
                    .satisfies(r -> {
                        r.isEqualTo(expected);
                    });
        }
    }

    private void extractingMinus__WithAmount(final TemporalUnit unit, final TemporalAmount amount) {
        final LocalDate actual = LocalDate.now();
        if (!actual.isSupported(unit)) {
            log.debug("not supported: {}", unit);
            return;
        }
        final MoreLocalDateAssert<?> more = assertInstance(actual);
        final LocalDate expected;
        try {
            expected = actual.minus(amount);
        } catch (final DateTimeException dte) {
            log.debug("minus({})", amount, dte);
            return;
        }
        Assertions.assertThat(more.extractingMinus(amount))
                .isNotNull()
                .satisfies(r -> {
                    r.isEqualTo(expected);
                });
    }

    @MethodSource({"com.github.jinahya.assertj.more.java.time.MoreJavaTimeTests#periodStream"})
    @ParameterizedTest
    void extractingMinus__WithAmount(final TemporalAmount amount) {
        final LocalDate actual = LocalDate.now();
        for (final TemporalUnit unit : amount.getUnits()) {
            if (!actual.isSupported(unit)) {
                return;
            }
        }
        final MoreLocalDateAssert<?> more = assertInstance(actual);
        final LocalDate expected;
        try {
            expected = actual.minus(amount);
        } catch (final DateTimeException dte) {
            log.error("failed to get [{}].minus([{}])", actual, amount, dte);
            return;
        }
        Assertions.assertThat(more.extractingMinus(amount))
                .isNotNull()
                .satisfies(r -> {
                    r.isEqualTo(expected);
                });
    }
}