package com.github.jinahya.assertj.more.time.temporal;

import java.time.temporal.TemporalAccessor;

public class DefaultTemporalAccessorAssert
        extends AbstractTemporalAccessorAssert<DefaultTemporalAccessorAssert, TemporalAccessor> {

    public static AbstractTemporalAccessorAssert<?, TemporalAccessor> assertMore(final TemporalAccessor actual) {
        return new DefaultTemporalAccessorAssert(actual);
    }

    public DefaultTemporalAccessorAssert(final TemporalAccessor actual) {
        super(actual, DefaultTemporalAccessorAssert.class);
    }
}
