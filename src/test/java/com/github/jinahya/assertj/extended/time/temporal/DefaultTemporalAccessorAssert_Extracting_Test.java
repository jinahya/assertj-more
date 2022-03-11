package com.github.jinahya.assertj.extended.time.temporal;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.TemporalAccessor;
import java.util.stream.Stream;

class DefaultTemporalAccessorAssert_Extracting_Test
        extends AbstractTemporalAccessorAssertTest<DefaultTemporalAccessorAssert, TemporalAccessor> {

    private static Stream<TemporalAccessor> temporalAccessors() {
        return Stream.of(
                LocalDate.now(),
                LocalTime.now()
        );
    }

    DefaultTemporalAccessorAssert_Extracting_Test() {
        super(DefaultTemporalAccessorAssert.class, TemporalAccessor.class);
    }

    @MethodSource({"temporalAccessors"})
    @ParameterizedTest
    void extracting__(final TemporalAccessor actual) {
        super.extracting__(actual);
    }
}