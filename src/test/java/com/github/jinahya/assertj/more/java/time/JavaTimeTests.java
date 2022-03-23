package com.github.jinahya.assertj.more.java.time;

import java.time.ZoneId;
import java.util.stream.Stream;

public final class JavaTimeTests {

    public static Stream<ZoneId> zoneIdStream() {
        return ZoneId.getAvailableZoneIds().stream().map(ZoneId::of);
    }

    private JavaTimeTests() {
        throw new AssertionError("instantiation is not allowed");
    }
}
