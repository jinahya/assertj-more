package com.github.jinahya.assertj.more.java.time.temporal;

import org.assertj.core.api.AbstractAssert;

import java.time.temporal.TemporalAccessor;

public abstract class AbstractMoreTemporalAccessorAssert<S extends AbstractMoreTemporalAccessorAssert<S>>
        extends AbstractAssert<S, TemporalAccessor>
        implements MoreTemporalAccessorAssert<S, TemporalAccessor> {

    protected AbstractMoreTemporalAccessorAssert(final TemporalAccessor actual, final Class<S> selfType) {
        super(actual, selfType);
    }
}
