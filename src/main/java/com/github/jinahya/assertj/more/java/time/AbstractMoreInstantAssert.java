package com.github.jinahya.assertj.more.java.time;

import org.assertj.core.api.AbstractInstantAssert;

import java.time.Instant;

public abstract class AbstractMoreInstantAssert<SELF extends AbstractMoreInstantAssert<SELF>>
        extends AbstractInstantAssert<SELF>
        implements MoreInstantAssert<SELF> {

    protected AbstractMoreInstantAssert(final Instant actual, final Class<SELF> selfType) {
        super(actual, selfType);
    }
}
