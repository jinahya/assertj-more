package com.github.jinahya.assertj.more.java.time;

import org.assertj.core.api.AbstractOffsetDateTimeAssert;

import java.time.OffsetDateTime;

public abstract class AbstractMoreOffsetDateTimeAssert<S extends AbstractMoreOffsetDateTimeAssert<S>>
        extends AbstractOffsetDateTimeAssert<S>
        implements MoreOffsetDateTimeAssert<S> {

    protected AbstractMoreOffsetDateTimeAssert(final OffsetDateTime actual, final Class<S> selfType) {
        super(actual, selfType);
    }
}
