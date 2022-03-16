package com.github.jinahya.assertj.more.java.time.chrono;

import org.assertj.core.api.AbstractAssert;

import java.time.chrono.ChronoPeriod;

public abstract class AbstractMoreChronoPeriodAssert<
        S extends AbstractMoreChronoPeriodAssert<S, A>,
        A extends ChronoPeriod>
        extends AbstractAssert<S, A>
        implements MoreChronoPeriodAssert<S, A> {

    protected AbstractMoreChronoPeriodAssert(final A actual, final Class<S> selfType) {
        super(actual, selfType);
    }
}
