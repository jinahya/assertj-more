package com.github.jinahya.assertj.more.java.time;

import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.stream.Stream;

@Slf4j
class MoreInstantAssertImpl_ExtractingAtOffset_Test
        extends MoreInstantAssertImplTest {

    private static Stream<ZoneId> zoneIdStream() {
        return MoreJavaTimeTests.zoneIdStream();
    }

    @MethodSource({"zoneIdStream"})
    @ParameterizedTest
    void extractingAtOffset__(final ZoneId zone) {
        final Instant actual = Instant.now();
        final MoreInstantAssert<?> more = assertInstance(actual);
        final ZoneOffset offset = zone.getRules().getOffset(actual);
        Assertions.assertThat(more.extractingAtOffset(offset))
                .isNotNull();
    }
}