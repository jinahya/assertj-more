package com.github.jinahya.assertj.more.java.time;

import org.assertj.core.api.AbstractPeriodAssert;

import java.time.Period;

public abstract class AbstractMorePeriodAssert<SELF extends AbstractMorePeriodAssert<SELF>>
        extends AbstractPeriodAssert<SELF>
        implements MorePeriodAssert<SELF> {

    protected AbstractMorePeriodAssert(final Period actual, final Class<SELF> selfType) {
        super(actual, selfType);
    }
}
