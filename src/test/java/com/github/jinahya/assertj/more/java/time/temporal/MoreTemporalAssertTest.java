package com.github.jinahya.assertj.more.java.time.temporal;

import org.assertj.core.api.Assertions;

import java.time.temporal.Temporal;
import java.time.temporal.TemporalUnit;

abstract class MoreTemporalAssertTest<S extends MoreTemporalAssert<S, A>, A extends Temporal>
        extends MoreJavaTimeTemporalAssertTest<S, A> {

    protected MoreTemporalAssertTest(final Class<S> assertClass, final Class<A> actualClass) {
        super(assertClass, actualClass);
    }

    protected void supports__(final A actual, final TemporalUnit unit) {
        final S expected = assertInstance(actual);
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