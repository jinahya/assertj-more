package com.github.jinahya.assertj.more.java.time.temporal;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;

class MoreTemporalUnitAssertImplTest
        extends MoreJavaTimeTemporalAssertTest<MoreTemporalUnitAssertImpl, TemporalUnit> {

    MoreTemporalUnitAssertImplTest() {
        super(MoreTemporalUnitAssertImpl.class, TemporalUnit.class);
    }

    @Nested
    class ChronoUnitTest {

        @EnumSource(ChronoUnit.class)
        @ParameterizedTest
        void extractingDuration__(final ChronoUnit actual) {
            final Duration expected = actual.getDuration();
            assertInstance(actual).extractingDuration()
                    .isEqualTo(expected);
        }

        @EnumSource(ChronoUnit.class)
        @ParameterizedTest
        void isDateBased__(final ChronoUnit actual) {
            final boolean expected = actual.isDateBased();
            if (expected) {
                assertInstance(actual)
                        .isDateBased();
            } else {
                assertInstance(actual)
                        .isNotDateBased();
            }
        }

        @EnumSource(ChronoUnit.class)
        @ParameterizedTest
        void isDurationEstimated__(final ChronoUnit actual) {
            final boolean expected = actual.isDurationEstimated();
            if (expected) {
                assertInstance(actual)
                        .isDurationEstimated();
            } else {
                assertInstance(actual)
                        .isDurationNotEstimated();
            }
        }
    }

    @EnumSource(ChronoUnit.class)
    @ParameterizedTest
    void isSupportedBy__(final ChronoUnit actual) {
        MoreJavaTimeTemporalTests.temporalStream().forEach(temporal -> {
            final boolean expected = actual.isSupportedBy(temporal);
            if (expected) {
                assertInstance(actual)
                        .isSupportedBy(temporal);
            } else {
                assertInstance(actual)
                        .isNotSupportedBy(temporal);
            }
        });
    }

    @EnumSource(ChronoUnit.class)
    @ParameterizedTest
    void isTimeBased__(final ChronoUnit actual) {
        final boolean expected = actual.isTimeBased();
        if (expected) {
            assertInstance(actual)
                    .isTimeBased();
        } else {
            assertInstance(actual)
                    .isNotTimeBased();
        }
    }
}