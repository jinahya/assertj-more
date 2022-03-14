package com.github.jinahya.assertj.more.java.time.chrono;

import org.assertj.core.api.AbstractAssert;

import java.time.chrono.Era;

public abstract class AbstractMoreEraAssert<SELF extends AbstractMoreEraAssert<SELF, ACTUAL>, ACTUAL extends Era>
        extends AbstractAssert<SELF, ACTUAL>
        implements MoreEraAssert<SELF, ACTUAL> {

    protected AbstractMoreEraAssert(final ACTUAL actual, final Class<SELF> selfType) {
        super(actual, selfType);
    }
}
