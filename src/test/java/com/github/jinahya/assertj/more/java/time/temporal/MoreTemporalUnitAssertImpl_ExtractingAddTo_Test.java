package com.github.jinahya.assertj.more.java.time.temporal;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import java.time.DateTimeException;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;

class MoreTemporalUnitAssertImpl_ExtractingAddTo_Test
        extends MoreTemporalUnitAssertImplTest {

    @EnumSource(ChronoUnit.class)
    @ParameterizedTest
    void extractingAddTo__(final TemporalUnit actual) {
        MoreJavaTimeTemporalTests.temporalStream()
                .filter(actual::isSupportedBy)
                .forEach(t -> {
                    for (long amount = -1L; amount < 2; amount++) {
                        try {
                            actual.addTo(t, amount);
                        } catch (final DateTimeException dte) {
                            continue;
                        }
                        assertInstance(actual)
                                .extractingAddTo(t, amount, MoreJavaTimeTemporalAssertions::assertMore)
                        ;
                    }
                });
    }
}