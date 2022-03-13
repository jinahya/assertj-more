package com.github.jinahya.assertj.more.java.time.temporal;

import java.time.temporal.Temporal;

class MoreTemporalAssertImpl
        extends AbstractMoreTemporalAssert<MoreTemporalAssertImpl> {

    MoreTemporalAssertImpl(final Temporal actual) {
        super(actual, MoreTemporalAssertImpl.class);
    }

    @Override
    protected Temporal parse(String temporalAsString) {
        throw new UnsupportedOperationException("unsupported");
    }
}
