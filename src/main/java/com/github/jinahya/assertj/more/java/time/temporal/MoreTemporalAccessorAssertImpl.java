package com.github.jinahya.assertj.more.java.time.temporal;

import java.time.temporal.TemporalAccessor;

class MoreTemporalAccessorAssertImpl
        extends AbstractMoreTemporalAccessorAssert<MoreTemporalAccessorAssertImpl> {

    MoreTemporalAccessorAssertImpl(final TemporalAccessor actual) {
        super(actual, MoreTemporalAccessorAssertImpl.class);
    }
}
