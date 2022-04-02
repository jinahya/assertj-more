package com.github.jinahya.assertj.more.java.time;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.time.Instant;
import java.time.ZoneId;
import java.util.stream.Stream;

class MoreInstantAssertImpl_ExtractingAtZone_Test
        extends MoreInstantAssertImplTest {

    private static Stream<ZoneId> zoneIdStream() {
        return MoreJavaTimeTests.zoneIdStream();
    }

    @MethodSource({"zoneIdStream"})
    @ParameterizedTest
    void extractingAtOffset__(final ZoneId zone) {
        final Instant actual = Instant.now();
        final MoreInstantAssert<?> more = assertInstance(actual);
        Assertions.assertThat(more.extractingAtZone(zone))
                .isNotNull();
    }
}