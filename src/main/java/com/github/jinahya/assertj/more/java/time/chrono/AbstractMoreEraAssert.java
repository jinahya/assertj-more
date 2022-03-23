package com.github.jinahya.assertj.more.java.time.chrono;

import org.assertj.core.api.AbstractAssert;

import java.time.chrono.Era;

public abstract class AbstractMoreEraAssert<S extends AbstractMoreEraAssert<S, ACTUAL>, ACTUAL extends Era>
        extends AbstractAssert<S, ACTUAL>
        implements MoreEraAssert<S, ACTUAL> {

    protected AbstractMoreEraAssert(final ACTUAL actual, final Class<S> selfType) {
        super(actual, selfType);
    }
}
