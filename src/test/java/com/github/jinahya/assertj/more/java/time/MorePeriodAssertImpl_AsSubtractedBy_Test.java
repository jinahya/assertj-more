package com.github.jinahya.assertj.more.java.time;

import org.junit.jupiter.api.Test;

import java.time.Period;
import java.time.temporal.TemporalAmount;

class MorePeriodAssertImpl_AsSubtractedBy_Test
        extends MoreJavaTimeAssertTest<MorePeriodAssertImpl, Period> {

    MorePeriodAssertImpl_AsSubtractedBy_Test() {
        super(MorePeriodAssertImpl.class, Period.class);
    }

    @Test
    void asAddedBy__() {
        final Period actual = Period.of(0, 0, 0);
        final TemporalAmount amountToSubtract = Period.ofYears(1);
        final MorePeriodAssert<?> more = MoreJavaTimeAssertions.assertMore(actual);
        more.asSubtractedBy(amountToSubtract)
                .isEqualTo(actual.minus(amountToSubtract));
    }
}