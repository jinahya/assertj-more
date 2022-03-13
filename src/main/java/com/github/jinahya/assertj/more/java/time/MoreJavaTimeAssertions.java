package com.github.jinahya.assertj.more.java.time;

import com.github.jinahya.assertj.more.AbstractMoreAssertions;

import java.time.Clock;
import java.time.Duration;

public class MoreJavaTimeAssertions
        extends AbstractMoreAssertions {

    public static MoreClockAssert<?, Clock> assertMore(final Clock actual) {
        return new DefaultMoreClockAssert(actual);
    }

    public static AbstractDurationAssert<?> assertMore(final Duration actual) {
        return new DurationAssert(actual);
    }

    protected MoreJavaTimeAssertions() {
        super();
    }
}
