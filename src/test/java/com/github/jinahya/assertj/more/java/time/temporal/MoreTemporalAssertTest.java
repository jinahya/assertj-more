package com.github.jinahya.assertj.more.java.time.temporal;

import org.assertj.core.api.Assertions;

import java.time.temporal.Temporal;
import java.time.temporal.TemporalUnit;

abstract class MoreTemporalAssertTest<ASSERT extends MoreTemporalAssert<ASSERT, ACTUAL>, ACTUAL extends Temporal>
        extends MoreJavaTimeTemporalAssertTest<ASSERT, ACTUAL> {

    protected MoreTemporalAssertTest(final Class<ASSERT> assertClass, final Class<ACTUAL> actualClass) {
        super(assertClass, actualClass);
    }

    protected void supports__(final ACTUAL actual, final TemporalUnit unit) {
        final ASSERT expected = assertInstance(actual);
        if (!actual.isSupported(unit)) {
            return;
        }
        Assertions.assertThatCode(() -> {
                    expected.supports(unit);
                })
                .doesNotThrowAnyException();
        Assertions.assertThat(expected.supports(unit))
                .isSameAs(expected);
    }
}