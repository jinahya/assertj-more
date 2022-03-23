package com.github.jinahya.assertj.more.java.time.temporal;

import java.time.temporal.Temporal;

public abstract class AbstractMoreTemporalAssert<S extends AbstractMoreTemporalAssert<S, A>, A extends Temporal>
        extends AbstractTemporalAssert<S, A>
        implements MoreTemporalAssert<S, A> {

    protected AbstractMoreTemporalAssert(final A actual, final Class<S> selfType) {
        super(actual, selfType);
    }
}
