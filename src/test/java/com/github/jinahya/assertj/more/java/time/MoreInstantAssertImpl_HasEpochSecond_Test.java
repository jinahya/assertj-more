package com.github.jinahya.assertj.more.java.time;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.Instant;

class MoreInstantAssertImpl_HasEpochSecond_Test
        extends MoreJavaTimeAssertTest<MoreInstantAssertImpl, Instant> {

    MoreInstantAssertImpl_HasEpochSecond_Test() {
        super(MoreInstantAssertImpl.class, Instant.class);
    }

    @Test
    void hasEpochSecond__() {
        final Instant actual = Instant.now();
        final AbstractMoreInstantAssert<?> more = assertInstance(actual);
        final long expected = actual.getEpochSecond();
        Assertions.assertThatCode(() -> {
                    more.hasEpochSecond(expected);
                })
                .doesNotThrowAnyException();
    }
}