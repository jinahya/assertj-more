package com.github.jinahya.assertj.more.java.time;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.Period;
import java.time.chrono.IsoChronology;

class MorePeriodAssertImplTest
        extends MoreJavaTimeAssertTest<MorePeriodAssertImpl, Period> {

    MorePeriodAssertImplTest() {
        super(MorePeriodAssertImpl.class, Period.class);
    }

    @Test
    void extractingChronology__() {
        final Period actual = Period.of(0, 0, 0);
        final IsoChronology expected = actual.getChronology();
        MoreJavaTimeAssertions.assertMore(actual)
                .extractingChronology()
                .isSameAs(expected);
    }

    @Test
    void isZero__() {
        final Period actual = Period.of(0, 0, 0);
        final AbstractMorePeriodAssert<?> more = MoreJavaTimeAssertions.assertMore(actual);
        Assertions.assertThatCode(more::isZero)
                .doesNotThrowAnyException();
        Assertions.assertThatThrownBy(more::isNotZero)
                .isInstanceOf(AssertionError.class);
    }

    @Test
    void isNotZero__() {
        final Period actual = Period.of(0, 0, 1);
        final AbstractMorePeriodAssert<?> more = MoreJavaTimeAssertions.assertMore(actual);
        Assertions.assertThatCode(more::isNotZero)
                .doesNotThrowAnyException();
        Assertions.assertThatThrownBy(more::isZero)
                .isInstanceOf(AssertionError.class);
    }
}