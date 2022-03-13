package com.github.jinahya.assertj.more.java.time.temporal;

import org.assertj.core.api.AbstractAssert;

import java.time.temporal.TemporalAccessor;

public abstract class AbstractMoreTemporalAccessorAssert<SELF extends AbstractMoreTemporalAccessorAssert<SELF>>
        extends AbstractAssert<SELF, TemporalAccessor>
        implements MoreTemporalAccessorAssert<SELF, TemporalAccessor> {

    protected AbstractMoreTemporalAccessorAssert(final TemporalAccessor actual, final Class<SELF> selfType) {
        super(actual, selfType);
    }
}
