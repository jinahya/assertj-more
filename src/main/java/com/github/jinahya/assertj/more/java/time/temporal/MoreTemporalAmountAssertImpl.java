package com.github.jinahya.assertj.more.java.time.temporal;

import java.time.temporal.TemporalAmount;

class MoreTemporalAmountAssertImpl
        extends AbstractMoreTemporalAmountAssert<MoreTemporalAmountAssertImpl, TemporalAmount> {

    MoreTemporalAmountAssertImpl(final TemporalAmount actual) {
        super(actual, MoreTemporalAmountAssertImpl.class);
    }
}
