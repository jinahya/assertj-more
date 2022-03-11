package com.github.jinahya.assertj.extended.time.temporal;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalAccessor;
import java.util.stream.Stream;

class DefaultTemporalAccessorAssert_Has_Test
        extends AbstractTemporalAccessorAssertTest<DefaultTemporalAccessorAssert, TemporalAccessor> {

    private static Stream<TemporalAccessor> temporalAccessors() {
        return Stream.of(
                LocalDate.now(),
                LocalTime.now()
        );
    }

    DefaultTemporalAccessorAssert_Has_Test() {
        super(DefaultTemporalAccessorAssert.class, TemporalAccessor.class);
    }

    @DisplayName("has(..) with LocalDate")
    @Nested
    class HasWithLocalDateTest {

        @Test
        void has_DoesNotThrow_LocalDateYear() {
            final var now = LocalDate.now();
            final var expected = now.getYear();
            DefaultTemporalAccessorAssert_Has_Test.super.has_DoesNotThrow_(now, ChronoField.YEAR, expected);
        }

        @Test
        void has_DoesThrow_LocalDateYear() {
            final var now = LocalDate.now();
            final var expected = now.plusYears(1L).getYear();
            DefaultTemporalAccessorAssert_Has_Test.super.has_DoesThrow_(now, ChronoField.YEAR, expected);
        }
    }
}