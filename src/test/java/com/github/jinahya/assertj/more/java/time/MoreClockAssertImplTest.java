package com.github.jinahya.assertj.more.java.time;

import java.time.Clock;
import java.time.ZoneId;
import java.util.stream.Stream;

class MoreClockAssertImplTest
        extends MoreJavaTimeAssertTest<MoreClockAssertImpl, Clock> {

    static Stream<Clock> clockStream() {
        return Stream.concat(
                Stream.of(
                        Clock.systemDefaultZone(),
                        Clock.systemUTC()
                ),
                ZoneId.getAvailableZoneIds().stream().map(ZoneId::of).map(Clock::system)
        );
    }

    MoreClockAssertImplTest() {
        super(MoreClockAssertImpl.class, Clock.class);
    }
}