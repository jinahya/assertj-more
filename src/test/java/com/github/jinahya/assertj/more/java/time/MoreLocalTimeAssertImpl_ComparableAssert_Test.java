package com.github.jinahya.assertj.more.java.time;

import org.assertj.core.api.Assertions;
import org.assertj.core.api.ComparableAssert;
import org.junit.jupiter.api.Test;

import java.time.LocalTime;

class MoreLocalTimeAssertImpl_ComparableAssert_Test
        extends MoreJavaTimeAssertTest<MoreLocalTimeAssertImpl, LocalTime> {

    MoreLocalTimeAssertImpl_ComparableAssert_Test() {
        super(MoreLocalTimeAssertImpl.class, LocalTime.class);
    }

    @Test
    void isBetween__() {
        final LocalTime actual = LocalTime.now();
        final ComparableAssert<?, LocalTime> more = assertInstance(actual);
        more.isBetween(LocalTime.from(actual), LocalTime.from(actual));
    }

    @Test
    void isEqualByComparingTo__() {
        final LocalTime actual = LocalTime.now();
        final ComparableAssert<?, LocalTime> more = assertInstance(actual);
        more.isEqualByComparingTo(LocalTime.from(actual));
    }

    @Test
    void isGreaterThan__() {
        final LocalTime actual = LocalTime.now();
        final ComparableAssert<?, LocalTime> more = assertInstance(actual);
        more.isGreaterThan(actual.minusNanos(1L));
    }

    @Test
    void isGreaterThan_AssertionError_Same() {
        final LocalTime actual = LocalTime.now();
        final ComparableAssert<?, LocalTime> more = assertInstance(actual);
        Assertions.assertThatThrownBy(() -> more.isGreaterThan(LocalTime.from(actual)))
                .isInstanceOf(AssertionError.class);
    }

    @Test
    void isGreaterThanOrEqualTo__() {
        final LocalTime actual = LocalTime.now();
        final ComparableAssert<?, LocalTime> more = assertInstance(actual);
        more.isGreaterThanOrEqualTo(LocalTime.from(actual));
        more.isGreaterThanOrEqualTo(actual.minusNanos(1L));
    }

    @Test
    void isGreaterThanOrEqualTo_AssertionError_After() {
        final LocalTime actual = LocalTime.now();
        final ComparableAssert<?, LocalTime> more = assertInstance(actual);
        Assertions.assertThatThrownBy(() -> more.isGreaterThanOrEqualTo(actual.plusNanos(1L)))
                .isInstanceOf(AssertionError.class);
    }

    @Test
    void isLessThan__() {
        final LocalTime actual = LocalTime.now();
        final ComparableAssert<?, LocalTime> more = assertInstance(actual);
        more.isLessThan(actual.plusNanos(1L));
    }

    @Test
    void isLessThan_AssertionError_Same() {
        final LocalTime actual = LocalTime.now();
        final ComparableAssert<?, LocalTime> more = assertInstance(actual);
        Assertions.assertThatThrownBy(() -> more.isLessThan(LocalTime.from(actual)))
                .isInstanceOf(AssertionError.class);
    }

    @Test
    void isLessThanOrEqualTo__() {
        final LocalTime actual = LocalTime.now();
        final ComparableAssert<?, LocalTime> more = assertInstance(actual);
        more.isLessThanOrEqualTo(LocalTime.from(actual));
        more.isLessThanOrEqualTo(actual.plusNanos(1L));
    }

    @Test
    void isLessThanOrEqualTo_AssertionError_Before() {
        final LocalTime actual = LocalTime.now();
        final ComparableAssert<?, LocalTime> more = assertInstance(actual);
        Assertions.assertThatThrownBy(() -> more.isLessThanOrEqualTo(actual.minusNanos(1L)))
                .isInstanceOf(AssertionError.class);
    }

    @Test
    void isNotEqualByComparingTo__() {
        final LocalTime actual = LocalTime.now();
        final ComparableAssert<?, LocalTime> more = assertInstance(actual);
        more.isNotEqualByComparingTo(actual.minusNanos(1L));
        more.isNotEqualByComparingTo(actual.plusNanos(1L));
    }

    @Test
    void isStrictlyBetween__() {
        final LocalTime actual = LocalTime.now();
        final ComparableAssert<?, LocalTime> more = assertInstance(actual);
        more.isStrictlyBetween(actual.minusNanos(1L), actual.plusNanos(1L));
    }
}