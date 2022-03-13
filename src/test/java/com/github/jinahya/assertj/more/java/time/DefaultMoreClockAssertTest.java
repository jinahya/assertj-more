package com.github.jinahya.assertj.more.java.time;

import org.junit.jupiter.api.Test;

import java.time.Clock;

class DefaultMoreClockAssertTest
        extends MoreJavaTimeAssertTest<DefaultMoreClockAssert, Clock> {

    DefaultMoreClockAssertTest() {
        super(DefaultMoreClockAssert.class, Clock.class);
    }

    @Test
    void hasZone__() {
        final Clock actual = Clock.systemDefaultZone();
        assertInstance(actual)
                .hasZone(actual.getZone());
    }
}