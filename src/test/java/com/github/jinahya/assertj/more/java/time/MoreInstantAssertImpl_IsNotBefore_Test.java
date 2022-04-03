package com.github.jinahya.assertj.more.java.time;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

class MoreInstantAssertImpl_IsNotBefore_Test
        extends MoreInstantAssertImplTest {

    @Test
    void isNotBefore__() {
        final Instant actual = Instant.now();
        final MoreInstantAssert<?> more = assertInstance(actual);
        final Instant otherInstant = actual.minus(1L, ChronoUnit.NANOS);
        more.isNotBefore(otherInstant);
    }

    @Test
    void isNotAfter_Succeed_OtherInstanceIsSame() {
        final Instant actual = Instant.now();
        final MoreInstantAssert<?> more = assertInstance(actual);
        final Instant otherInstant = Instant.from(actual);
        more.isNotBefore(otherInstant);
    }

    @Test
    void isNotAfter_Fail_OtherInstanceIsAfterActual() {
        final Instant actual = Instant.now();
        final MoreInstantAssert<?> more = assertInstance(actual);
        final Instant otherInstant = actual.plus(1L, ChronoUnit.NANOS);
        Assertions.assertThatThrownBy(() -> {
                    more.isNotBefore(otherInstant);
                })
                .isInstanceOf(AssertionError.class);
    }
}