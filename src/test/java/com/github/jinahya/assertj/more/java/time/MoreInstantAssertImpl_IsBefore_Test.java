package com.github.jinahya.assertj.more.java.time;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

class MoreInstantAssertImpl_IsBefore_Test
        extends MoreInstantAssertImplTest {

    @Test
    void isBefore__() {
        final Instant actual = Instant.now();
        final MoreInstantAssert<?> more = assertInstance(actual);
        final Instant otherInstant = actual.plus(1L, ChronoUnit.NANOS);
        more.isBefore(otherInstant);
    }

    @Test
    void isBefore_Fail_OtherInstanceIsSame() {
        final Instant actual = Instant.now();
        final MoreInstantAssert<?> more = assertInstance(actual);
        final Instant otherInstant = Instant.from(actual);
        Assertions.assertThatThrownBy(() -> {
                    more.isBefore(otherInstant);
                })
                .isInstanceOf(AssertionError.class);
    }

    @Test
    void isBefore_Fail_OtherInstanceIsBeforeActual() {
        final Instant actual = Instant.now();
        final MoreInstantAssert<?> more = assertInstance(actual);
        final Instant otherInstant = actual.minus(1L, ChronoUnit.NANOS);
        Assertions.assertThatThrownBy(() -> {
                    more.isBefore(otherInstant);
                })
                .isInstanceOf(AssertionError.class);
    }
}