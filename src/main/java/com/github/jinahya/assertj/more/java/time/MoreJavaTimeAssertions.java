package com.github.jinahya.assertj.more.java.time;

import com.github.jinahya.assertj.more.AbstractMoreAssertions;

import java.time.Clock;
import java.time.Duration;
import java.time.Instant;
import java.time.Period;

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

    public static AbstractMorePeriodAssert<?> assertMore(final Period actual) {
        return new MorePeriodAssertImpl(actual);
    }

    protected MoreJavaTimeAssertions() {
        super();
    }
}
