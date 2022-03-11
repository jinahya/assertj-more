package com.github.jinahya.assertj.more.time.temporal;

import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;

import java.time.temporal.ChronoField;
import java.time.temporal.TemporalAccessor;
import java.time.temporal.TemporalField;
import java.time.temporal.UnsupportedTemporalTypeException;
import java.util.Objects;

@Slf4j
abstract class AbstractTemporalAccessorAssertTest<
        ASSERT extends AbstractTemporalAccessorAssert<ASSERT, ACTUAL>,
        ACTUAL extends TemporalAccessor> {

    protected AbstractTemporalAccessorAssertTest(final Class<ASSERT> assertClass, final Class<ACTUAL> actualClass) {
        super();
        this.assertClass = Objects.requireNonNull(assertClass, "assertClass is null");
        this.actualClass = Objects.requireNonNull(actualClass, "actualClass is null");
    }

    protected ASSERT assertInstance(final ACTUAL actual) {
        try {
            final var constructor = assertClass.getConstructor(actualClass);
            if (!constructor.canAccess(null)) {
                constructor.setAccessible(true);
            }
            return constructor.newInstance(actual);
        } catch (final ReflectiveOperationException roe) {
            throw new RuntimeException(roe);
        }
    }

    void extracting__(final ACTUAL actual) {
        log.debug("actual: {}", actual);
        final var assertion = assertInstance(actual);
        for (final var field : ChronoField.values()) {
            if (!actual.isSupported(field)) {
                continue;
            }
            try {
                assertion.extracting(field).satisfies(v -> {
                    log.debug("{}: {}", field, v);
                });
            } catch (final UnsupportedTemporalTypeException utte) {
            }
        }
    }

    void has_DoesNotThrow_(final ACTUAL actual, final TemporalField field, final int expected) {
        log.debug("actual: {}", actual);
        final var assertion = assertInstance(actual);
        Assertions.assertThatCode(() -> {
                    assertion.has(field, expected);
                })
                .doesNotThrowAnyException();
        Assertions.assertThat(assertion.has(field, expected))
                .isSameAs(assertion);
    }

    void has_DoesThrow_(final ACTUAL actual, final TemporalField field, final int expected) {
        log.debug("actual: {}", actual);
        final var assertion = assertInstance(actual);
        Assertions.assertThatThrownBy(() -> {
                    assertion.has(field, expected);
                })
                .isInstanceOf(AssertionError.class);
    }

    void extractingLong__(final ACTUAL actual) {
        log.debug("actual: {}", actual);
        final var assertion = assertInstance(actual);
        for (final var field : ChronoField.values()) {
            if (!actual.isSupported(field)) {
                continue;
            }
            try {
                assertion.extractingLong(field).satisfies(v -> {
                    log.debug("{}: {}", field, v);
                });
            } catch (final UnsupportedTemporalTypeException utte) {
            }
        }
    }

    void hasLong_DoesNotThrow_(final ACTUAL actual, final TemporalField field, final long expected) {
        log.debug("actual: {}", actual);
        final var assertion = assertInstance(actual);
        Assertions.assertThatCode(() -> {
                    assertion.hasLong(field, expected);
                })
                .doesNotThrowAnyException();
        Assertions.assertThat(assertion.hasLong(field, expected))
                .isSameAs(assertion);
    }

    void hasLong_DoesThrow_(final ACTUAL actual, final TemporalField field, final long expected) {
        log.debug("actual: {}", actual);
        final var assertion = assertInstance(actual);
        Assertions.assertThatThrownBy(() -> {
                    assertion.hasLong(field, expected);
                })
                .isInstanceOf(AssertionError.class);
    }

    void supports_DoesNotThrow_(final ACTUAL actual) {
        log.debug("actual: {}", actual);
        final var assertion = assertInstance(actual);
        for (final var field : ChronoField.values()) {
            if (!actual.isSupported(field)) {
                continue;
            }
            Assertions.assertThatCode(() -> {
                        assertion.supports(field);
                    })
                    .doesNotThrowAnyException();
            Assertions.assertThat(assertion.supports(field))
                    .isSameAs(assertion);
        }
    }

    void supports_DoesThrow_(final ACTUAL actual) {
        log.debug("actual: {}", actual);
        final var assertion = assertInstance(actual);
        for (final var field : ChronoField.values()) {
            if (actual.isSupported(field)) {
                continue;
            }
            assert !actual.isSupported(field);
            Assertions.assertThatThrownBy(() -> {
                        assertion.supports(field);
                    })
                    .isInstanceOf(AssertionError.class);
        }
    }

    void doesNotSupport_DoesNotThrow_(final ACTUAL actual) {
        log.debug("actual: {}", actual);
        final var assertion = assertInstance(actual);
        for (final var field : ChronoField.values()) {
            if (actual.isSupported(field)) {
                continue;
            }
            Assertions.assertThatCode(() -> {
                        assertion.doesNotSupport(field);
                    })
                    .doesNotThrowAnyException();
            Assertions.assertThat(assertion.doesNotSupport(field))
                    .isSameAs(assertion);
        }
    }

    void doesNotSupport_DoesThrow_(final ACTUAL actual) {
        log.debug("actual: {}", actual);
        final var assertion = assertInstance(actual);
        for (final var field : ChronoField.values()) {
            if (!actual.isSupported(field)) {
                continue;
            }
            Assertions.assertThatThrownBy(() -> {
                        assertion.doesNotSupport(field);
                    })
                    .isInstanceOf(AssertionError.class);
        }
    }

    protected final Class<ASSERT> assertClass;

    protected final Class<ACTUAL> actualClass;
}