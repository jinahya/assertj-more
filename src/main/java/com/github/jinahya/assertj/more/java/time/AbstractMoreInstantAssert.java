package com.github.jinahya.assertj.more.java.time;

import org.assertj.core.api.AbstractInstantAssert;

import java.time.Instant;

public abstract class AbstractMoreInstantAssert<S extends AbstractMoreInstantAssert<S>>
        extends AbstractInstantAssert<S>
        implements MoreInstantAssert<S> {

    protected AbstractMoreInstantAssert(final Instant actual, final Class<S> selfType) {
        super(actual, selfType);
    }
}
