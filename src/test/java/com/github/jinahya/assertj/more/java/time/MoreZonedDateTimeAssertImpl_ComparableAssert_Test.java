package com.github.jinahya.assertj.more.java.time;

import org.assertj.core.api.Assertions;
import org.assertj.core.api.ComparableAssert;
import org.assertj.core.api.GenericComparableAssert;
import org.junit.jupiter.api.Test;

import java.time.ZonedDateTime;
import java.time.chrono.ChronoZonedDateTime;

class MoreZonedDateTimeAssertImpl_ComparableAssert_Test
        extends MoreJavaTimeAssertTest<MoreZonedDateTimeAssertImpl, ZonedDateTime> {

    MoreZonedDateTimeAssertImpl_ComparableAssert_Test() {
        super(MoreZonedDateTimeAssertImpl.class, ZonedDateTime.class);
    }

    @Test
    void isBetween__() {
        final ZonedDateTime actual = ZonedDateTime.now();
        final ComparableAssert<?, ChronoZonedDateTime<?>> core = new GenericComparableAssert<>(actual);
        core.isBetween(actual, actual);
        final ComparableAssert<?, ChronoZonedDateTime<?>> more = assertInstance(actual);
        Assertions.assertThat(more.isBetween(actual, actual))
                .isSameAs(more);
    }

    @Test
    void isEqualByComparingTo__() {
        final ZonedDateTime actual = ZonedDateTime.now();
        final ComparableAssert<?, ChronoZonedDateTime<?>> core = new GenericComparableAssert<>(actual);
        core.isEqualByComparingTo(ZonedDateTime.from(actual));
        final ComparableAssert<?, ChronoZonedDateTime<?>> more = assertInstance(actual);
        Assertions.assertThat(more.isEqualByComparingTo(ZonedDateTime.from(actual)))
                .isSameAs(more);
    }
}