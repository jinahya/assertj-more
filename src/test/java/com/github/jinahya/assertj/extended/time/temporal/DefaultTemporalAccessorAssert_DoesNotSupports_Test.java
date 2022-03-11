package com.github.jinahya.assertj.extended.time.temporal;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.TemporalAccessor;
import java.util.stream.Stream;

class DefaultTemporalAccessorAssert_DoesNotSupports_Test
        extends AbstractTemporalAccessorAssertTest<DefaultTemporalAccessorAssert, TemporalAccessor> {

    private static Stream<TemporalAccessor> temporalAccessors() {
        return Stream.of(
                LocalDate.now(),
                LocalTime.now()
        );
    }

    DefaultTemporalAccessorAssert_DoesNotSupports_Test() {
        super(DefaultTemporalAccessorAssert.class, TemporalAccessor.class);
    }

    @MethodSource({"temporalAccessors"})
    @ParameterizedTest
    @Override
    void doesNotSupport_DoesNotThrow_(final TemporalAccessor actual) {
        super.doesNotSupport_DoesNotThrow_(actual);
    }

    @MethodSource({"temporalAccessors"})
    @ParameterizedTest
    @Override
    void doesNotSupport_DoesThrow_(final TemporalAccessor actual) {
        super.doesNotSupport_DoesThrow_(actual);
    }
}