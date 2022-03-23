package com.github.jinahya.assertj.more.java.time.temporal;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import java.time.temporal.ChronoField;
import java.time.temporal.TemporalField;
import java.time.temporal.ValueRange;

class MoreValueRangeAssertImplTest
        extends MoreJavaTimeTemporalAssertTest<MoreValueRangeAssertImpl, ValueRange> {

    MoreValueRangeAssertImplTest() {
        super(MoreValueRangeAssertImpl.class, ValueRange.class);
    }

    @Nested
    class ChronoFieldTest {

        void extractingCheckValidIntValue(final ValueRange actual, final long value, final TemporalField field) {
            final MoreValueRangeAssert<?> more = assertInstance(actual);
            if (actual.isValidIntValue(value)) {
                Assertions.assertThatCode(() -> {
                            more.extractingCheckValidIntValue(value, field)
                                    .isEqualTo((int) value);
                        })
                        .doesNotThrowAnyException();
            } else {
                Assertions.assertThatThrownBy(() -> {
                            more.extractingCheckValidIntValue(value, field);
                        })
                        .isInstanceOf(AssertionError.class);
            }
        }

        @EnumSource(ChronoField.class)
        @ParameterizedTest
        void extractingCheckValidIntValue__(final TemporalField field) {
            final ValueRange actual = field.range();
            for (long v = -10L; v < 10L; v++) {
                extractingCheckValidIntValue(actual, v, field);
            }
            extractingCheckValidIntValue(actual, actual.getMinimum(), field);
            extractingCheckValidIntValue(actual, actual.getSmallestMaximum(), field);
            extractingCheckValidIntValue(actual, actual.getLargestMinimum(), field);
            extractingCheckValidIntValue(actual, actual.getMaximum(), field);
        }

        void checksAsValidIntValue(final ValueRange actual, final long value, final TemporalField field) {
            final MoreValueRangeAssert<?> more = assertInstance(actual);
            if (actual.isValidIntValue(value)) {
                Assertions.assertThatCode(() -> {
                            more.checksAsValidIntValue(value, field);
                        })
                        .doesNotThrowAnyException();
            } else {
                Assertions.assertThatThrownBy(() -> {
                            more.checksAsValidIntValue(value, field);
                        })
                        .isInstanceOf(AssertionError.class);
            }
        }

        @EnumSource(ChronoField.class)
        @ParameterizedTest
        void checksAsValidIntValue__(final TemporalField field) {
            final ValueRange actual = field.range();
            for (long v = -10L; v < 10L; v++) {
                checksAsValidIntValue(actual, v, field);
            }
            checksAsValidIntValue(actual, actual.getMinimum(), field);
            checksAsValidIntValue(actual, actual.getSmallestMaximum(), field);
            checksAsValidIntValue(actual, actual.getLargestMinimum(), field);
            checksAsValidIntValue(actual, actual.getMaximum(), field);
        }

        void doesNotCheckAsValidIntValue(final ValueRange actual, final long value, final TemporalField field) {
            final MoreValueRangeAssert<?> more = assertInstance(actual);
            if (actual.isValidIntValue(value)) {
                Assertions.assertThatThrownBy(() -> {
                            more.doesNotCheckAsValidIntValue(value, field);
                        })
                        .isInstanceOf(AssertionError.class);
            } else {
                Assertions.assertThatCode(() -> {
                            more.doesNotCheckAsValidIntValue(value, field);
                        })
                        .doesNotThrowAnyException();
            }
        }

        @EnumSource(ChronoField.class)
        @ParameterizedTest
        void doesNotCheckAsValidIntValue__(final TemporalField field) {
            final ValueRange actual = field.range();
            for (long v = -10L; v < 10L; v++) {
                doesNotCheckAsValidIntValue(actual, v, field);
            }
            doesNotCheckAsValidIntValue(actual, actual.getMinimum(), field);
            doesNotCheckAsValidIntValue(actual, actual.getSmallestMaximum(), field);
            doesNotCheckAsValidIntValue(actual, actual.getLargestMinimum(), field);
            doesNotCheckAsValidIntValue(actual, actual.getMaximum(), field);
        }

        void extractingCheckValidValue(final ValueRange actual, final long value, final TemporalField field) {
            final MoreValueRangeAssert<?> more = assertInstance(actual);
            if (actual.isValidValue(value)) {
                Assertions.assertThatCode(() -> {
                            more.extractingCheckValidValue(value, field)
                                    .isEqualTo(value);
                        })
                        .doesNotThrowAnyException();
            } else {
                Assertions.assertThatThrownBy(() -> {
                            more.extractingCheckValidValue(value, field);
                        })
                        .isInstanceOf(AssertionError.class);
            }
        }

        @EnumSource(ChronoField.class)
        @ParameterizedTest
        void extractingCheckValidValue__(final TemporalField field) {
            final ValueRange actual = field.range();
            for (long v = -10L; v < 10L; v++) {
                extractingCheckValidValue(actual, v, field);
            }
            extractingCheckValidValue(actual, actual.getMinimum(), field);
            extractingCheckValidValue(actual, actual.getSmallestMaximum(), field);
            extractingCheckValidValue(actual, actual.getLargestMinimum(), field);
            extractingCheckValidValue(actual, actual.getMaximum(), field);
        }

        void checksAsValidValue(final ValueRange actual, final long value, final TemporalField field) {
            final MoreValueRangeAssert<?> more = assertInstance(actual);
            if (actual.isValidValue(value)) {
                Assertions.assertThatCode(() -> {
                            more.checksAsValidValue(value, field);
                        })
                        .doesNotThrowAnyException();
            } else {
                Assertions.assertThatThrownBy(() -> {
                            more.checksAsValidValue(value, field);
                        })
                        .isInstanceOf(AssertionError.class);
            }
        }

        @EnumSource(ChronoField.class)
        @ParameterizedTest
        void checksAsValidValue__(final TemporalField field) {
            final ValueRange actual = field.range();
            for (long v = -10L; v < 10L; v++) {
                checksAsValidValue(actual, v, field);
            }
            checksAsValidValue(actual, actual.getMinimum(), field);
            checksAsValidValue(actual, actual.getSmallestMaximum(), field);
            checksAsValidValue(actual, actual.getLargestMinimum(), field);
            checksAsValidValue(actual, actual.getMaximum(), field);
        }

        void doesNotCheckAsValidValue(final ValueRange actual, final long value, final TemporalField field) {
            final MoreValueRangeAssert<?> more = assertInstance(actual);
            if (actual.isValidValue(value)) {
                Assertions.assertThatThrownBy(() -> {
                            more.doesNotCheckAsValidValue(value, field);
                        })
                        .isInstanceOf(AssertionError.class);
            } else {
                Assertions.assertThatCode(() -> {
                            more.doesNotCheckAsValidValue(value, field);
                        })
                        .doesNotThrowAnyException();
            }
        }

        @EnumSource(ChronoField.class)
        @ParameterizedTest
        void doesNotCheckAsValidValue__(final TemporalField field) {
            final ValueRange actual = field.range();
            for (long v = -10L; v < 10L; v++) {
                doesNotCheckAsValidValue(actual, v, field);
            }
            doesNotCheckAsValidValue(actual, actual.getMinimum(), field);
            doesNotCheckAsValidValue(actual, actual.getSmallestMaximum(), field);
            doesNotCheckAsValidValue(actual, actual.getLargestMinimum(), field);
            doesNotCheckAsValidValue(actual, actual.getMaximum(), field);
        }

        @EnumSource(ChronoField.class)
        @ParameterizedTest
        void hasLargestMinimum__(final TemporalField field) {
            final ValueRange actual = field.range();
            final MoreValueRangeAssert<?> more = assertInstance(actual);
            final long expected = actual.getLargestMinimum();
            more.hasLargestMinimum(expected);
        }

        @EnumSource(ChronoField.class)
        @ParameterizedTest
        void maxMaximum__(final TemporalField field) {
            final ValueRange actual = field.range();
            final MoreValueRangeAssert<?> more = assertInstance(actual);
            final long expected = actual.getMaximum();
            more.hasMaximum(expected);
        }

        @EnumSource(ChronoField.class)
        @ParameterizedTest
        void hasMinimum__(final TemporalField field) {
            final ValueRange actual = field.range();
            final MoreValueRangeAssert<?> more = assertInstance(actual);
            final long expected = actual.getMinimum();
            more.hasMinimum(expected);
        }

        @EnumSource(ChronoField.class)
        @ParameterizedTest
        void hasSmallestMaximum__(final TemporalField field) {
            final ValueRange actual = field.range();
            final MoreValueRangeAssert<?> more = assertInstance(actual);
            final long expected = actual.getSmallestMaximum();
            more.hasSmallestMaximum(expected);
        }

        @EnumSource(ChronoField.class)
        @ParameterizedTest
        void isFixed__(final TemporalField field) {
            final ValueRange actual = field.range();
            final MoreValueRangeAssert<?> more = assertInstance(actual);
            final boolean expected = actual.isFixed();
            if (expected) {
                more.isFixed();
            } else {
                Assertions.assertThatThrownBy(more::isFixed)
                        .isInstanceOf(AssertionError.class);
            }
        }

        @EnumSource(ChronoField.class)
        @ParameterizedTest
        void isNotFixed__(final TemporalField field) {
            final ValueRange actual = field.range();
            final MoreValueRangeAssert<?> more = assertInstance(actual);
            final boolean expected = actual.isFixed();
            if (expected) {
                Assertions.assertThatThrownBy(more::isNotFixed)
                        .isInstanceOf(AssertionError.class);
            } else {
                more.isNotFixed();
            }
        }
    }
}