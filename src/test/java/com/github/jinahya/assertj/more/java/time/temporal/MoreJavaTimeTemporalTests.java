package com.github.jinahya.assertj.more.java.time.temporal;

import com.github.jinahya.assertj.more.java.time.MoreJavaTimeTests;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.OffsetTime;
import java.time.Year;
import java.time.YearMonth;
import java.time.ZonedDateTime;
import java.time.chrono.HijrahDate;
import java.time.chrono.JapaneseDate;
import java.time.chrono.MinguoDate;
import java.time.chrono.ThaiBuddhistDate;
import java.time.temporal.ChronoField;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAmount;
import java.time.temporal.ValueRange;
import java.util.Arrays;
import java.util.stream.Stream;

public final class MoreJavaTimeTemporalTests {

    public static Stream<Temporal> temporalStream() {
        return Stream.of(
                HijrahDate.now(),
                Instant.now(),
                JapaneseDate.now(),
                LocalDate.now(),
                LocalDateTime.now(),
                LocalTime.now(),
                MinguoDate.now(),
                OffsetDateTime.now(),
                OffsetTime.now(),
                ThaiBuddhistDate.now(),
                Year.now(),
                YearMonth.now(),
                ZonedDateTime.now()
        );
    }

    public static Stream<ValueRange> valueRangeStream() {
        return Arrays.stream(ChronoField.values()).map(ChronoField::range);
    }

    public static Stream<TemporalAmount> temporalAmountStream() {
        return Stream.concat(
                MoreJavaTimeTests.durationStream(),
                MoreJavaTimeTests.periodStream()
        );
    }

    private MoreJavaTimeTemporalTests() {
        throw new AssertionError("instantiation is not allowed");
    }
}