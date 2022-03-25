package com.github.jinahya.assertj.more.java.time;

import com.github.jinahya.assertj.more.AbstractMoreAssertions;

import java.time.Clock;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.OffsetTime;
import java.time.Period;
import java.time.ZonedDateTime;

public class MoreJavaTimeAssertions
        extends AbstractMoreAssertions {

    public static AbstractMoreClockAssert<?, Clock> assertMore(final Clock actual) {
        return new MoreClockAssertImpl(actual);
    }

    public static AbstractMoreDurationAssert<?> assertMore(final Duration actual) {
        return new MoreDurationAssertImpl(actual);
    }

    public static AbstractMoreInstantAssert<?> assertMore(final Instant actual) {
        return new MoreInstantAssertImpl(actual);
    }

    public static AbstractMoreLocalDateAssert<?> assertMore(final LocalDate actual) {
        return new MoreLocalDateAssertImpl(actual);
    }

    public static AbstractMoreLocalDateTimeAssert<?> assertMore(final LocalDateTime actual) {
        return new MoreLocalDateTimeAssertImpl(actual);
    }

    public static AbstractMoreLocalTimeAssert<?> assertMore(final LocalTime actual) {
        return new MoreLocalTimeAssertImpl(actual);
    }

    public static AbstractMoreOffsetDateTimeAssert<?> assertMore(final OffsetDateTime actual) {
        return new MoreOffsetDateTimeAssertImpl(actual);
    }

    public static AbstractMoreOffsetTimeAssert<?> assertMore(final OffsetTime actual) {
        return new MoreOffsetTimeAssertImpl(actual);
    }

    public static AbstractMorePeriodAssert<?> assertMore(final Period actual) {
        return new MorePeriodAssertImpl(actual);
    }

    public static AbstractMoreZonedDateTimeAssert<?> assertMore(final ZonedDateTime actual) {
        return new MoreZonedDateTimeAssertImpl(actual);
    }

    protected MoreJavaTimeAssertions() {
        super();
    }
}
