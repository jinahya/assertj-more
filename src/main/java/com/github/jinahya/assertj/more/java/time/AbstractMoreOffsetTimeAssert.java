package com.github.jinahya.assertj.more.java.time;

import org.assertj.core.api.AbstractOffsetTimeAssert;
import org.assertj.core.api.ComparableAssert;
import org.assertj.core.api.GenericComparableAssert;

import java.time.OffsetTime;

public abstract class AbstractMoreOffsetTimeAssert<S extends AbstractMoreOffsetTimeAssert<S>>
        extends AbstractOffsetTimeAssert<S>
        implements MoreOffsetTimeAssert<S> {

    protected AbstractMoreOffsetTimeAssert(final OffsetTime actual, final Class<S> selfType) {
        super(actual, selfType);
        comparableAssertDelegate = new GenericComparableAssert<>(actual);
    }

    private final ComparableAssert<?, OffsetTime> comparableAssertDelegate;
}
