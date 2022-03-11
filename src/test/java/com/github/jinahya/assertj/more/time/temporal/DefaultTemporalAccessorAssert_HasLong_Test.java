package com.github.jinahya.assertj.more.time.temporal;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalAccessor;
import java.util.stream.Stream;

class DefaultTemporalAccessorAssert_HasLong_Test
        extends AbstractTemporalAccessorAssertTest<DefaultTemporalAccessorAssert, TemporalAccessor> {

    private static Stream<TemporalAccessor> temporalAccessors() {
        return Stream.of(
                LocalDate.now(),
                LocalTime.now()
        );
    }

    DefaultTemporalAccessorAssert_HasLong_Test() {
        super(DefaultTemporalAccessorAssert.class, TemporalAccessor.class);
    }

    @DisplayName("hasLong(..) with LocalTime")
    @Nested
    class HasWithLongLocalTimeTest {

        @Test
        void has_DoesNotThrow_LocalTimeNano() {
            final var now = LocalTime.now();
            final var expected = now.getNano();
            DefaultTemporalAccessorAssert_HasLong_Test.super.hasLong_DoesNotThrow_(now, ChronoField.NANO_OF_SECOND, expected);
        }

        @Test
        void has_DoesThrow_LocalTimeNano() {
            final var now = LocalTime.now();
            final var expected = now.plusNanos(1L).getNano();
            DefaultTemporalAccessorAssert_HasLong_Test.super.has_DoesThrow_(now, ChronoField.NANO_OF_SECOND, expected);
        }
    }
}