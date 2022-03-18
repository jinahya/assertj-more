package com.github.jinahya.assertj.more.java.time;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.time.Clock;
import java.time.ZoneId;

class MoreClockAssertImpl_ExtractingZone_Test
        extends MoreClockAssertImplTest {

    @MethodSource({"clockStream"})
    @ParameterizedTest
    void extractingZone__(final Clock actual) {
        final MoreClockAssert<?, Clock> more = assertInstance(actual);
        final ZoneId expected = actual.getZone();
        more.extractingZone().isEqualTo(expected);
    }
}