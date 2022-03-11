package com.github.jinahya.assertj.more.time.temporal;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.TemporalAccessor;
import java.util.stream.Stream;

class DefaultTemporalAccessorAssert_Supports_Test
        extends AbstractTemporalAccessorAssertTest<DefaultTemporalAccessorAssert, TemporalAccessor> {

    private static Stream<TemporalAccessor> temporalAccessors() {
        return Stream.of(
                LocalDate.now(),
                LocalTime.now()
        );
    }

    DefaultTemporalAccessorAssert_Supports_Test() {
        super(DefaultTemporalAccessorAssert.class, TemporalAccessor.class);
    }

    @MethodSource({"temporalAccessors"})
    @ParameterizedTest
    @Override
    void supports_DoesNotThrow_(final TemporalAccessor actual) {
        super.supports_DoesNotThrow_(actual);
    }

    @MethodSource({"temporalAccessors"})
    @ParameterizedTest
    @Override
    void supports_DoesThrow_(final TemporalAccessor actual) {
        super.supports_DoesThrow_(actual);
    }
}