package com.github.jinahya.assertj.more.java.time;

import org.junit.jupiter.api.Test;

import java.time.Instant;

class MoreInstantAssertImpl_HasEpochMilli_Test
        extends MoreInstantAssertImplTest {

    @Test
    void hasEpochMilli__() {
        final Instant actual = Instant.now();
        final MoreInstantAssert<?> more = assertInstance(actual);
        final long expected = actual.toEpochMilli();
        more.hasEpochMilli(expected);
    }
}