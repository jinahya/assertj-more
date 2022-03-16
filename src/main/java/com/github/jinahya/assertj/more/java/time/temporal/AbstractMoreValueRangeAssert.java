package com.github.jinahya.assertj.more.java.time.temporal;

import org.assertj.core.api.AbstractAssert;

import java.time.temporal.ValueRange;

public abstract class AbstractMoreValueRangeAssert<S extends AbstractMoreValueRangeAssert<S>>
        extends AbstractAssert<S, ValueRange>
        implements MoreValueRangeAssert<S> {

    protected AbstractMoreValueRangeAssert(final ValueRange actual, final Class<S> selfType) {
        super(actual, selfType);
    }
}
