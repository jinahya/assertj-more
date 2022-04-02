package com.github.jinahya.assertj.more.java.time;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

class MoreInstantAssertImpl_IsNotAfter_Test
        extends MoreInstantAssertImplTest {

    @Test
    void isNotAfter__() {
        final Instant actual = Instant.now();
        final MoreInstantAssert<?> more = assertInstance(actual);
        final Instant otherInstant = actual.plus(1L, ChronoUnit.NANOS);
        more.isNotAfter(otherInstant);
    }

    @Test
    void isNotAfter_Succeed_OtherInstanceIsSame() {
        final Instant actual = Instant.now();
        final MoreInstantAssert<?> more = assertInstance(actual);
        final Instant otherInstant = Instant.from(actual);
        more.isNotAfter(otherInstant);
    }

    @Test
    void isNotAfter_Fail_OtherInstanceIsBeforeActual() {
        final Instant actual = Instant.now();
        final MoreInstantAssert<?> more = assertInstance(actual);
        final Instant otherInstant = actual.minus(1L, ChronoUnit.NANOS);
        Assertions.assertThatThrownBy(() -> {
                    more.isNotAfter(otherInstant);
                })
                .isInstanceOf(AssertionError.class);
    }
}