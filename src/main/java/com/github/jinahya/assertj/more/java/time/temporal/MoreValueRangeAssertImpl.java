package com.github.jinahya.assertj.more.java.time.temporal;

import org.assertj.core.api.AbstractAssert;

import java.time.temporal.ValueRange;

class MoreValueRangeAssertImpl
        extends AbstractAssert<MoreValueRangeAssertImpl, ValueRange>
        implements MoreValueRangeAssert<MoreValueRangeAssertImpl> {

    MoreValueRangeAssertImpl(final ValueRange actual) {
        super(actual, MoreValueRangeAssertImpl.class);
    }
}
