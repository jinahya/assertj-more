package com.github.jinahya.assertj.more.java.time;

import java.time.Period;

class MorePeriodAssertImpl
        extends AbstractMorePeriodAssert<MorePeriodAssertImpl> {

    MorePeriodAssertImpl(final Period actual) {
        super(actual, MorePeriodAssertImpl.class);
    }
}
