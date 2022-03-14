package com.github.jinahya.assertj.more.java.time;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.Clock;
import java.time.ZoneId;

class MoreClockAssertImpl_HasZone_Test
        extends MoreJavaTimeAssertTest<MoreClockAssertImpl, Clock> {

    MoreClockAssertImpl_HasZone_Test() {
        super(MoreClockAssertImpl.class, Clock.class);
    }

    @Test
    void hasZone__() {
        final Clock actual = Clock.systemDefaultZone();
        final AbstractMoreClockAssert<?, Clock> more = assertInstance(actual);
        final ZoneId expected = actual.getZone();
        Assertions.assertThatCode(() -> {
                    more.hasZone(expected);
                })
                .doesNotThrowAnyException();
    }
}