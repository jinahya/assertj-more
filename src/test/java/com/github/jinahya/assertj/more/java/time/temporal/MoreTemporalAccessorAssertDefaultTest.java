package com.github.jinahya.assertj.more.java.time.temporal;

import com.github.jinahya.assertj.more.java.time.MoreJavaTimeAssertions;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalAccessor;
import java.time.temporal.TemporalField;
import java.util.Objects;

@Slf4j
class MoreTemporalAccessorAssertDefaultTest {

    abstract class AbstractNestedTest<T extends TemporalAccessor> {

        abstract T getActual();

        abstract MoreTemporalAccessorAssert<?, T> getAssert(T actual);

        @EnumSource(ChronoField.class)
        @ParameterizedTest
        void has__(final TemporalField field) {
            final T actual = Objects.requireNonNull(getActual(), "getActual() is null");
            if (!actual.isSupported(field)) {
                return;
            }
            final MoreTemporalAccessorAssert<?, T> more = getAssert(actual);
            try {
                final int expected = actual.get(field);
                Assertions.assertThatCode(() -> {
                            Assertions.assertThat(more.has(field, expected))
                                    .isSameAs(more);
                        })
                        .doesNotThrowAnyException();
            } catch (final DateTimeException dte) {
            }
        }

        @EnumSource(ChronoField.class)
        @ParameterizedTest
        void hasLong__(final TemporalField field) {
            final T actual = Objects.requireNonNull(getActual(), "getActual() is null");
            if (!actual.isSupported(field)) {
                return;
            }
            final MoreTemporalAccessorAssert<?, T> more = getAssert(actual);
            try {
                final long expected = actual.getLong(field);
                Assertions.assertThatCode(() -> {
                            Assertions.assertThat(more.hasLong(field, expected))
                                    .isSameAs(more);
                        })
                        .doesNotThrowAnyException();
            } catch (final DateTimeException dte) {
            }
        }

        @EnumSource(ChronoField.class)
        @ParameterizedTest
        void supports__(final TemporalField field) {
            final T actual = Objects.requireNonNull(getActual(), "getActual() is null");
            if (!actual.isSupported(field)) {
                return;
            }
            final MoreTemporalAccessorAssert<?, T> more = getAssert(actual);
            Assertions.assertThatCode(() -> {
                        Assertions.assertThat(more.supports(field))
                                .isSameAs(more);
                    })
                    .doesNotThrowAnyException();
        }

        @EnumSource(ChronoField.class)
        @ParameterizedTest
        void doesNotSupport__(final TemporalField field) {
            final T actual = Objects.requireNonNull(getActual(), "getActual() is null");
            if (actual.isSupported(field)) {
                return;
            }
            final MoreTemporalAccessorAssert<?, T> more = getAssert(actual);
            Assertions.assertThatCode(() -> {
                        Assertions.assertThat(more.doesNotSupport(field))
                                .isSameAs(more);
                    })
                    .doesNotThrowAnyException();
        }

        @EnumSource(ChronoField.class)
        @ParameterizedTest
        void extractingQueryResult__WithType(final TemporalField field) {
            final T actual = Objects.requireNonNull(getActual(), "getActual() is null");
            if (!actual.isSupported(field)) {
                return;
            }
            final MoreTemporalAccessorAssert<?, T> more = getAssert(actual);
            try {
                actual.get(field);
                more.extractingQueryResult(temporal -> temporal.get(field), Integer.class)
                        .isEqualTo(actual.get(field));
            } catch (final DateTimeException dte) {
                actual.getLong(field);
                more.extractingQueryResult(temporal -> temporal.getLong(field), Long.class)
                        .isEqualTo(actual.getLong(field));
            }
        }

        @EnumSource(ChronoField.class)
        @ParameterizedTest
        void extractingQueryResult__WithoutType(final TemporalField field) {
            final T actual = Objects.requireNonNull(getActual(), "getActual() is null");
            if (!actual.isSupported(field)) {
                return;
            }
            final MoreTemporalAccessorAssert<?, T> more = getAssert(actual);
            try {
                actual.get(field);
                more.extractingQueryResult(temporal -> temporal.get(field))
                        .isEqualTo(actual.get(field));
            } catch (final DateTimeException dte) {
                actual.getLong(field);
                more.extractingQueryResult(temporal -> temporal.getLong(field))
                        .isEqualTo(actual.getLong(field));
            }
        }
    }

    @Nested
    class LocalDateTest
            extends AbstractNestedTest<LocalDate> {

        @Override
        LocalDate getActual() {
            return LocalDate.now();
        }

        @Override
        MoreTemporalAccessorAssert<?, LocalDate> getAssert(final LocalDate actual) {
            return MoreJavaTimeAssertions.assertMore(actual);
        }
    }

    @Nested
    class LocalTimeTest
            extends AbstractNestedTest<LocalTime> {

        @Override
        LocalTime getActual() {
            return LocalTime.now();
        }

        @Override
        MoreTemporalAccessorAssert<?, LocalTime> getAssert(final LocalTime actual) {
            return MoreJavaTimeAssertions.assertMore(actual);
        }
    }
}