package com.github.jinahya.assertj.extended.time.temporal;

import java.time.temporal.Temporal;

public class DefaultTemporalAssert
        extends AbstractTemporalAssert<DefaultTemporalAssert, Temporal> {

    public static AbstractTemporalAccessorAssert<?, Temporal> assertThatTemporal(final Temporal actual) {
        return new DefaultTemporalAssert(actual);
    }

    public DefaultTemporalAssert(final Temporal actual) {
        super(actual, DefaultTemporalAssert.class);
    }
}
