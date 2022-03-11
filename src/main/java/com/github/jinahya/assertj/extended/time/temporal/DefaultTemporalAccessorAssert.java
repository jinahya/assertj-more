package com.github.jinahya.assertj.extended.time.temporal;

import java.time.temporal.TemporalAccessor;

public class DefaultTemporalAccessorAssert
        extends AbstractTemporalAccessorAssert<DefaultTemporalAccessorAssert, TemporalAccessor> {

    public static AbstractTemporalAccessorAssert<?, TemporalAccessor> assertThat(final TemporalAccessor actual) {
        return new DefaultTemporalAccessorAssert(actual);
    }

    public DefaultTemporalAccessorAssert(final TemporalAccessor actual) {
        super(actual, DefaultTemporalAccessorAssert.class);
    }
}
