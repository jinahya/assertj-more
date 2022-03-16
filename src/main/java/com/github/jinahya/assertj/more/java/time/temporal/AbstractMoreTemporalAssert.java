package com.github.jinahya.assertj.more.java.time.temporal;

import java.time.temporal.Temporal;

public abstract class AbstractMoreTemporalAssert<SELF extends AbstractMoreTemporalAssert<SELF>>
        extends org.assertj.core.api.AbstractTemporalAssert<SELF, Temporal>
        implements MoreTemporalAssert<SELF, Temporal> {

    protected AbstractMoreTemporalAssert(final Temporal actual, final Class<SELF> selfType) {
        super(actual, selfType);
    }
}
