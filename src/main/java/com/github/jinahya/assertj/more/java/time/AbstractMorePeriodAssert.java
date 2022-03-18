package com.github.jinahya.assertj.more.java.time;

import org.assertj.core.api.AbstractPeriodAssert;

import java.time.Period;

public abstract class AbstractMorePeriodAssert<S extends AbstractMorePeriodAssert<S>>
        extends AbstractPeriodAssert<S>
        implements MorePeriodAssert<S> {

    protected AbstractMorePeriodAssert(final Period actual, final Class<S> selfType) {
        super(actual, selfType);
    }
}
